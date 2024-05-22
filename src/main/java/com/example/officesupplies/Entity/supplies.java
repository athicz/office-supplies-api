package com.example.officesupplies.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class supplies {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name = "id")
	    public Long id;

	 	@Column(name = "type")
	 	public String type;
	 	
	 	@Column(name = "name")
	 	public String name;
 
	    @Column(name = "order_date")
	    public LocalDateTime orderDate;

	    @Column(name = "create_date")
	    public LocalDateTime createDate;

	    @Column(name = "update_date")
	    public LocalDateTime updateDate;

	    @Column(name = "item_detail", length = 1000)
	    public String itemDetail;

	    @Column(name = "status")
	    public String status;
	    
	    @Column(name = "serial_number")
	    public String serial;

}
