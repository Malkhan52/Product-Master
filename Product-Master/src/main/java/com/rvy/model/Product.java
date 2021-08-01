package com.rvy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
  private Integer product_master_id;
  private String name;
  private String category;
  private String type;
  private String brand;
  private String image;
//  private String productCategory;
  
  

}
