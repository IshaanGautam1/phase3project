package com.example.demo2.dao;

import java.util.List;

import com.example.demo2.entity.ProdCategory;

public interface Prodcatdao {
 public List<ProdCategory> getAll();
 public ProdCategory getcategorybyname(String prodcat);
 public void save(ProdCategory prodcat);
 public void deletebyid(int id);
}
