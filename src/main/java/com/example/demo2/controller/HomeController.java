package com.example.demo2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo2.dao.OrderDAO;
import com.example.demo2.dao.ProdDAO;
import com.example.demo2.dao.Prodcatdao;
import com.example.demo2.dao.UsersDAO;
import com.example.demo2.entity.Order;
import com.example.demo2.entity.ProdCategory;
import com.example.demo2.entity.Product;
import com.example.demo2.entity.User;


@Controller
public class HomeController {
	
	@Autowired
	private ProdDAO productDao;
	@Autowired
	private UsersDAO usersdao;
	@Autowired
	private Prodcatdao productcatdao;
	@Autowired
	private OrderDAO orderdao;
	@GetMapping("/shop")
	public String shopping(Model theModel) {
		List<Product> products = productDao.getAllProducts();
		theModel.addAttribute("products",products);
		return "shopping";
	}
	
	@GetMapping("/")
	public String home(@CurrentSecurityContext(expression="authentication?.name")
    String username) {
		User theUser = usersdao.findByusername(username);
		if(theUser.getRole().equals("ROLE_ADMIN")) {
			return "redirect:/manageProducts";
		}
		return "redirect:/shop";
	}
	@GetMapping("/addproduct")
	public String addProd(Model theModel) {
		Product theProduct = new Product();
		List<ProdCategory> categories = productcatdao.getAll();
		List<String> categorynames = new ArrayList<String>();
		String tempname;
		for(ProdCategory i: categories) {
			tempname = i.getCategory();
			categorynames.add(tempname);
		}
		theModel.addAttribute("product",theProduct);
		theModel.addAttribute("categories",categorynames);
		return "addprod";
	}
	@PostMapping("/processaddprod")
	public String processaddprod(@RequestParam("prodcat") String prodcat, @ModelAttribute("product") Product theProduct) {
		System.out.println(prodcat);
		ProdCategory tempCat = productcatdao.getcategorybyname(prodcat);
		tempCat.add(theProduct);
		productDao.saveProduct(theProduct);
		System.out.println(theProduct.getProdcategory().getCategory());
		return "redirect:/manageProducts";
	}
	@GetMapping("/addcategory")
	public String addCategory(Model theModel) {
		ProdCategory prodcat = new ProdCategory();
		theModel.addAttribute("newcategory",prodcat);
		return "addcat";
	}
	@PostMapping("/processaddcategory")
	public String processaddcategory(@ModelAttribute("ProdCategory") ProdCategory theprodCategory) {
		productcatdao.save(theprodCategory);
		return "redirect:/manageProducts";
	}
	@GetMapping("/buyproduct")
	public String buyProduct(@CurrentSecurityContext(expression="authentication?.name")
    String username,@RequestParam("prodid") int prodid) {
		User theuser = usersdao.findByusername(username);
		Product theproduct = productDao.getById(prodid);
		Order theOrder = new Order();
		theOrder.setUser(theuser);
		theOrder.setProduct(theproduct);
		orderdao.save(theOrder);
		return "success";
	}
	@GetMapping("/manageProducts")
	public String manageProd(Model theModel) {
		List<Product> products = new ArrayList<Product>();
		products = productDao.getAllProducts();
		theModel.addAttribute("products", products);
		return "ManageProd";
	}
	@GetMapping("delete")
	public String deleteProd(@RequestParam("prodid") int theId) {
		Product theproduct = productDao.getById(theId);
		productDao.delete(theproduct);
		return "redirect:/manageProducts";
	}
	@GetMapping("recategorize")
	public String recategorize(@RequestParam("prodid") int theId, Model theModel) {
		List<ProdCategory> categories = new ArrayList<ProdCategory>();
		categories = productcatdao.getAll();
		theModel.addAttribute("categories",categories);
		theModel.addAttribute("productid", theId);
		return "recategorize";
	}
	@PostMapping("processrecategorize")
	public String processrecategorize(@RequestParam("prodcat") String prodcat,@RequestParam("productid") int theid) {
		Product theproduct = new Product();
		theproduct= productDao.getById(theid);
		ProdCategory prodCat = new ProdCategory();
		prodCat = productcatdao.getcategorybyname(prodcat);
		theproduct.setProdcategory(prodCat);
		productDao.saveProduct(theproduct);
		return "redirect:/manageProducts";
	}
	@GetMapping("report")
	public String getreport(Model theModel) {
		List<Order> orders = new ArrayList<Order>();
		orders = orderdao.findAll();
		theModel.addAttribute("orders", orders);
		return "report";
	}
	@GetMapping("register")
	public String registration() {
		return "register-form";
	}
	@PostMapping("processregistration")
	public String processregistration(@RequestParam("username") String username,@RequestParam("password") String password) {
		User theuser = new User();
		theuser.setUsername(username);
		String formattedpw = "{noop}" + password;
		theuser.setPassword(formattedpw);
		theuser.setActive(1);
		theuser.setRole("ROLE_CUSTOMER");
		System.out.println(theuser);
		usersdao.addUsers(theuser);
		return "success-registration";
	}
	@GetMapping("accessdenied")
	public String accessdenied() {
		return "access-denied";
	}
	@GetMapping("managecategories")
	public String managecategories(Model theModel) {
		List<ProdCategory> categories = productcatdao.getAll();
		theModel.addAttribute("categories", categories);
		return "managecategories";
	}
	@GetMapping("/deletecat")
	public String deletecat(@RequestParam("prodcatid") int prodcatid) {
		productcatdao.deletebyid(prodcatid);
		return "redirect:/manageProducts";
	}
	@GetMapping("getallusers")
	public String showAllusers(Model theModel) {
		List<User> users = usersdao.getall();
		theModel.addAttribute("users", users);
		return "userlist";
	}
	
	@GetMapping("reportsbycat")
	public String reportsbycat(Model theModel) {
		List<ProdCategory> categories = productcatdao.getAll();
		theModel.addAttribute("categories", categories);
		return "reportbycat";
	}
	@PostMapping("/processreportbycat")
	public String processreportbycat(@RequestParam("timeorder") int timeorder,@ModelAttribute("prodcat") String category,Model theModel) {
		List<Order> orderslist = new ArrayList<Order>();
		List<Order> orders = new ArrayList<Order>();
		if(timeorder==1) {
			orderslist = orderdao.findAll(Sort.by(Direction.ASC,"time"));
		}
		else {
			orderslist = orderdao.findAll(Sort.by(Direction.DESC,"time"));
		}
		for(Order i : orderslist) {
			if((i.getProduct().getProdcategory().getCategory().equals(category))) {
				orders.add(i);
			}
		}
		theModel.addAttribute("orders", orders);
		return "report";
	}
	@PostMapping("/getuserbyname")
	public String getuserbyname(@ModelAttribute("username") String username,Model theModel) {
		List<User> userslist = usersdao.getall();
		List<User> users = new ArrayList<User>();
		for(User i : userslist) {
			if(i.getUsername().contains(username)) {
				users.add(i);
			}
		}
		theModel.addAttribute("users", users);
		return "userlist";
	}
}
