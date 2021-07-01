package com.hcl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String status;

    @OneToMany(mappedBy = "order" ,fetch=FetchType.LAZY)
    @JsonManagedReference
    Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonManagedReference
    User user;

    public Order(String status, User user){
        this.status = status;
        this.user = user;
    }
}
