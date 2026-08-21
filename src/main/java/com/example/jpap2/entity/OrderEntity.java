package com.example.jpap2.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name="orders")
public class OrderEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String customerName; private Double totalAmount; private LocalDateTime createdAt;
    public OrderEntity(){}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getCustomerName(){return customerName;} public void setCustomerName(String customerName){this.customerName=customerName;}
    public Double getTotalAmount(){return totalAmount;} public void setTotalAmount(Double totalAmount){this.totalAmount=totalAmount;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
}
