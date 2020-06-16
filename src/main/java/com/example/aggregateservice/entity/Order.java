package com.example.aggregateservice.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Order {
	
	@JsonProperty
	Long orderId;
	
	@JsonProperty
	BigDecimal orderAmount;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@JsonProperty
	Date oderDate = new Date();
	
	
}
