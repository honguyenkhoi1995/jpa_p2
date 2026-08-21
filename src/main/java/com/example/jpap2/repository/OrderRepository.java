package com.example.jpap2.repository;
import com.example.jpap2.entity.OrderEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("select o from OrderEntity o where o.createdAt between :from and :to order by o.createdAt desc")
    List<OrderEntity> findByDateRange(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
    List<OrderEntity> findTop5ByOrderByTotalAmountDesc();
}
