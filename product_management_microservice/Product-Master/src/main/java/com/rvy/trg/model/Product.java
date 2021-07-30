package com.rvy.trg.model;

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
  private Integer productMasterId;
  private String productName;
  private String productBrand;
  private String productImage;
  private Integer storeId;
  private String productCategory;
  
  

}
