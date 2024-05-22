package com.example.officesupplies.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.officesupplies.Entity.users;


@Repository
public interface userRepository extends JpaRepository<users, Long> {
	List<users> findByName(String name);
	
	@Query("SELECT e FROM users e WHERE e.userName = :userName AND e.password = :password")
	List<users> login(@Param("userName") String userName, @Param("password") String password);
	
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO users (user_name, password, name, status, create_date, update_date) " +
            "VALUES (:userName, :password, :name, :status, :createDate, :updateDate)", nativeQuery = true)
    void insertUsers(@Param("userName") String userName, @Param("password") String password, 
                        @Param("name") String name, @Param("status") String status,
                        @Param("createDate") LocalDateTime createDate, @Param("updateDate") LocalDateTime updateDate);
} 
