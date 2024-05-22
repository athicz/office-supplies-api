package com.example.officesupplies.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.officesupplies.Entity.supplies;


@Repository
public interface suppliesRepository extends JpaRepository<supplies, Long> {
	List<supplies> findByName(String name);
		
	@Query("SELECT e FROM supplies e WHERE e.name = COALESCE(:query, e.name)" + 
			"OR e.type = COALESCE(:query, e.type) OR CAST(e.id AS string) = CAST(COALESCE(:query, e.id) AS string)" +
			"OR ( CAST(e.orderDate AS string) LIKE CONCAT('%', CAST(COALESCE(:query, e.orderDate) AS string), '%') OR CAST(e.createDate AS string) LIKE CONCAT('%', CAST(COALESCE(:query, e.createDate) AS string), '%')) " +
			"OR e.serial = COALESCE(:query,e.serial) ORDER BY e.type,e.name")
    List<supplies> findByCustomQuery(@Param("query") String query);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO supplies (type, name, order_date, create_date, update_date, item_detail, status, serial_number) " +
            "VALUES (:type, :name, :orderDate, :createDate, :updateDate, :itemDetail, :status, :serial)", nativeQuery = true)
    void insertSupplies(@Param("type") String type, @Param("name") String name, 
                        @Param("orderDate") LocalDateTime orderDate, @Param("createDate") LocalDateTime createDate,
                        @Param("updateDate") LocalDateTime updateDate, @Param("itemDetail") String itemDetail,
                        @Param("status") String status, @Param("serial") String serial);
    
    @Modifying
    @Query("UPDATE supplies s SET s.name = :newName, s.type = :newType, s.orderDate = :newOrderDate, " +
            "s.updateDate = :newUpdateDate, s.serial = :newSerial, s.itemDetail = :newItemDetail WHERE s.id = :id")
    void updateById(@Param("id") Integer id, @Param("newName") String newName, @Param("newType") String newType,
                    @Param("newOrderDate") LocalDateTime newOrderDate, @Param("newUpdateDate") LocalDateTime newUpdateDate,
                    @Param("newSerial") String newSerial, @Param("newItemDetail") String newItemDetail);
}