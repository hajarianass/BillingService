package main.FeignServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
public class Product {
	private Long id;
	private String name;
	private double price;
}