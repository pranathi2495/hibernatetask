package com.ty.task2.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="products")
public class ProductsInfo implements Serializable {
	@Id
	private int productId;
	@Column
	private String productName;
	@Column
	private double price;
	@Column
	private String colour;
	@Column
	private double weight;
}
