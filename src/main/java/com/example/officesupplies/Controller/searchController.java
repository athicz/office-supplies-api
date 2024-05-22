package com.example.officesupplies.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.officesupplies.Entity.supplies;
import com.example.officesupplies.Entity.users;
import com.example.officesupplies.Repository.suppliesRepository;
import com.example.officesupplies.Repository.userRepository;
import com.example.officesupplies.Request.SearchRequest;
import com.example.officesupplies.Service.suppliesService;

import java.util.List;

@RestController
@Transactional
public class searchController {

    @Autowired
    private suppliesService suppliesService;
    @Autowired
    private suppliesRepository suppliesRepository;
    @Autowired
    private userRepository userRepository;
    

    @GetMapping("/search")
    public @ResponseBody List<supplies> getAllItems() {
        return suppliesService.getAllItems();
    }
    
    @PostMapping("/searchAll")
    public List<supplies> searchEntities(@RequestBody SearchRequest request) {
        String query = request.query; // Get the search parameter from the request
        return suppliesRepository.findByCustomQuery(query);
    }
    
    @PostMapping("/addSupplies")
    public void createSupplies(@RequestBody SearchRequest supplies) {
        suppliesService.insertSupplies(supplies);
    }
    
    @PostMapping("/updateSupplies")
    public void updateSupplies(@RequestBody SearchRequest supplies) {
        suppliesService.updateSupplies(supplies);
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public List<users> login(@RequestBody SearchRequest user) {
    	return userRepository.login(user.userName,user.password);
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/create")
    public void create(@RequestBody SearchRequest user) {
    	suppliesService.create(user);
    }

}
