package com.ty.task2.dao;

import java.util.List;

import com.ty.task2.dto.ProductsInfo;

public interface ProductDAO {
	boolean createProductInfo(ProductsInfo info);
	List<ProductsInfo> getAllCustomerInfoPriceLessThanHundred();
	List<ProductsInfo> getAllCustomerInfoStartsWithA();
}
