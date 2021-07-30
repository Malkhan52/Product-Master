package com.rvy.trg.controller;


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

import com.rvy.trg.model.Product;

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
			new Product(1234, "Lenovo Ideapad","Lenovo","xyz",2341,"Electronics"),
			new Product(1289, "T-shirt","H&M","abc",2381,"Clothing"),
			new Product(2109, "SneakerX","Woodland","xyz",2141,"Footwear")
			);
	
//http://localhost:8081/pm/product/prod/1
	@ApiOperation(value = "Find product by id",
			consumes = "product master Id",
			produces = "Product object",
			response = Product.class,
			tags = "findProductById",
			notes = "http://localhost:8081/pd/product/prod/{id}")
	@GetMapping("/prod/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable("id") Integer id){
		//Product product = new Product(1234, "Lenovo Ideapad","Lenovo","xyz",2341,"Electronics");
		Product product = products.stream().filter((p)-> p.getProductMasterId().equals(id)).collect(Collectors.toList()).get(0);
		log.info("inside findProductById method of controller");
		return new ResponseEntity<>(product,HttpStatus.OK);		
	}
	
	///http://localhost:8081/pm/product/prod/fetchall
		@ApiOperation(value = " ",
				consumes = "",
				produces = "All the products",
				response = Product.class,
				tags = "getAllProductsMaster",
				notes = "http://localhost:8081/pd/product/prod/fetchall")
		@GetMapping("/prod/fetchall")
		public ResponseEntity<List<Product>> getAllProducts(){
			//Product product = new Product(1234, "Lenovo Ideapad","Lenovo","xyz",2341,"Electronics");
			//Product product = products.stream().filter((p)-> p.getProductMasterId().equals(id)).collect(Collectors.toList()).get(0);
			log.info("inside getAll products in controller");
			return new ResponseEntity<>(products,HttpStatus.OK);		
		}
	
	
	// http://localhost:8081/pm/product/prod
		@ApiOperation(value = "Add product to product master",
				consumes = "Product object",
				produces = "Product object",
				tags = "AddProduct",
				notes = "http://localhost:8081/pm/product/prod")
		@PostMapping("/prod")
		public ResponseEntity<Product> addProduct(@RequestBody Product product){
			log.info("inside addProduct method of controller");
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		
		// http://localhost:8081/pm/product/prod
		@ApiOperation(value = "Update order",
				consumes = "Product object",
				produces = "Product object",
				response =Product.class,
				tags = "updateProductMaster",
				notes = "http://localhost:8081/pm/product/prod")
		@PutMapping("/prod")
		public ResponseEntity<Product> updateProduct(@RequestBody Product product){
			log.info("inside update productmaster");
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		
		@ApiOperation(value = "Delete",
				consumes = "product Master Id",
				produces = "Product Object",
				response = Product.class,
				tags="Delete the product",
				notes ="http://localhost:8081/pm/product/prod")
		@DeleteMapping("/prod/{id}")
		public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id){
			log.info("inside deleteProduct from Product master");
			Product product = products.stream().filter((p)-> p.getProductMasterId().equals(id)).collect(Collectors.toList()).get(0);
			return new ResponseEntity<>(product,HttpStatus.OK);	
		}
		
		

	}
	
	

