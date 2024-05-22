package com.example.officesupplies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.officesupplies.Entity.supplies;
import com.example.officesupplies.Repository.suppliesRepository;
import com.example.officesupplies.Repository.userRepository;
import com.example.officesupplies.Request.SearchRequest;

import java.util.List;

@Service
public class suppliesService {

    @Autowired
    private suppliesRepository suppliesRepository;
    @Autowired
    private userRepository userRepository;
    

    public List<supplies> getAllItems() {
        return suppliesRepository.findAll();
    }
    
    public void insertSupplies(SearchRequest supplies) {
        suppliesRepository.insertSupplies(supplies.type, supplies.name, 
                                          supplies.orderDate, supplies.createDate,
                                          supplies.updateDate, supplies.itemDetail, 
                                          supplies.status, supplies.serial);
    }
    
    public void updateSupplies(SearchRequest supplies) {
        suppliesRepository.updateById(supplies.id, supplies.name, 
                                          supplies.type, supplies.orderDate,
                                          supplies.updateDate, supplies.serial, supplies.itemDetail);
    }
    
    public void create(SearchRequest user) {
    	userRepository.insertUsers(user.userName, user.password, 
    			user.name, user.status,
    			user.createDate, user.updateDate);
    }
    
}
