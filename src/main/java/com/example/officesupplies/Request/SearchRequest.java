package com.example.officesupplies.Request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SearchRequest {
	public String query;
	public String name;
	public String type;
	public String itemDetail;
	public LocalDateTime orderDate;
	public String serial;
	public LocalDateTime createDate;
	public LocalDateTime updateDate;
	public String status;
	public Integer id;
	
	public String userName;
	public String password;
}
