package com.project.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "payment")
public class Payment extends BaseEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "payment_type_id")
    private Integer payment_type_id;

    @Column(name = "payment_status")
    private String payment_status;
    
    @Column(name = "promo_id")
    private Integer promo_id;
    
    @Column(name = "restaurant_id")
    private Integer restaurant_id;
    
    @Column(name = "total")
    private Long total;

}
