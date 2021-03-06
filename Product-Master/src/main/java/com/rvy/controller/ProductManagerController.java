package com.rvy.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvy.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@Api
@Slf4j
@RestController
@RequestMapping("/pms/v1")
public class ProductManagerController {
          List<Product> products = Arrays.asList(
			new Product(1234, "Lenovo Ideapad 330","Electronics","Laptop","Lenovo","image_link"),
			new Product(1235, "t-shirts","Clothing","Full-sleeve","H&M","image_link"),
			new Product(1236, "Lenovo Ideapad 320","Electronics","Laptop","Lenovo","image_link")
			);
	
//http://localhost:8081/rvy/api/pms/v1/product/1
	@ApiOperation(value = "Product by id",
			consumes = "product master Id",
			produces = "Product object",
			response = Product.class,
			tags = "Find product by id",
			notes = "http://localhost:8081/rvy/api/pms/v1/product/{id}")
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable("id") Integer id){
		//Product product = new Product(1234, "Lenovo Ideapad","Lenovo","xyz",2341,"Electronics");
		Product product = products.stream().filter((p)-> p.getProduct_master_id().equals(id)).collect(Collectors.toList()).get(0);
		log.info("inside findProductById method of controller");
		return new ResponseEntity<>(product,HttpStatus.OK);		
	}
	
	///http://localhost:8081/rvy/api/pms/v1/products
		@ApiOperation(value = "List of all products",
				consumes = "",
				produces = "All the products",
				response = Product.class,
				tags = "Get All Products",
				notes = "http://localhost:8081/rvy/api/pms/v1/products")
		@GetMapping("/products")
		public ResponseEntity<List<Product>> getAllProducts(){
			//Product product = new Product(1234, "Lenovo Ideapad","Lenovo","xyz",2341,"Electronics");
			//Product product = products.stream().filter((p)-> p.getProductMasterId().equals(id)).collect(Collectors.toList()).get(0);
			log.info("inside getAll products in controller");
			return new ResponseEntity<>(products,HttpStatus.OK);		
		}
	
	
	// http://localhost:8081/rvy/api/pms/v1/product
		@ApiOperation(value = "Add product to product master",
				consumes = "Product object",
				produces = "Product object",
				tags = "Add Product",
				notes = "http://localhost:8081/rvy/api/pms/v1/product")
		@PostMapping("/product")
		public ResponseEntity<Product> addProduct(@RequestBody Product product){
			log.info("inside addProduct method of controller");
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		
		// http://localhost:8081/rvy/api/pms/v1/product
		@ApiOperation(value = "Update order",
				consumes = "Product object",
				produces = "Product object",
				response =Product.class,
				tags = "Update Product Master",
				notes = "http://localhost:8081/rvy/api/pms/v1/product")
		@PutMapping("/product")
		public ResponseEntity<Product> updateProduct(@RequestBody Product product){
			log.info("inside update productmaster");
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		
		// http://localhost:8081/rvy/api/pms/v1/product/1
		@ApiOperation(value = "Delete",
				consumes = "product Master Id",
				produces = "Product Object",
				response = Product.class,
				tags="Delete A Product",
				notes ="http://localhost:8081/rvy/api/pms/v1/product/{id}")
		@DeleteMapping("/product/{id}")
		public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id){
			log.info("inside deleteProduct from Product master");
			Product product = products.stream().filter((p)-> p.getProduct_master_id().equals(id)).collect(Collectors.toList()).get(0);
			return new ResponseEntity<>(product,HttpStatus.OK);	
		}
		
		

	}
	
	

