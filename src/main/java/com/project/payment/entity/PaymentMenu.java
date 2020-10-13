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
@Entity(name = "payment_menu")
public class PaymentMenu extends BaseEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "invoice_id")
    private Integer invoice_id;

    @Column(name = "menu_id")
    private Integer menu_id;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "type")
    private String type;

}
