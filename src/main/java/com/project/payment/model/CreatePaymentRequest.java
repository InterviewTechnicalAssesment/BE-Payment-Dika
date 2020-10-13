package com.project.payment.model;

import javax.persistence.Column;

public class CreatePaymentRequest {

    @Column(name = "payment_status")
    private String payment_status;
    
    @Column(name = "promo_id")
    private Integer promo_id;
    
    @Column(name = "restaurant_id")
    private Integer restaurant_id;
    
    @Column(name = "total")
    private Long total;

}
