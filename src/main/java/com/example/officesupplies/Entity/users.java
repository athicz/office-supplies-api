package com.example.officesupplies.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "password")
    public String password;
    
    @Column(name = "name")
    public String name;
    
    @Column(name = "status")
    public String status;

    @Column(name = "create_date")
    public LocalDateTime createDate;

    @Column(name = "update_date")
    public LocalDateTime updateDate;
}
