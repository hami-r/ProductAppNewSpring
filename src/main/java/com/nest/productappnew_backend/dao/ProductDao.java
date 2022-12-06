package com.nest.productappnew_backend.dao;

import com.nest.productappnew_backend.model.ProductModel;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<ProductModel,Integer> {
}
