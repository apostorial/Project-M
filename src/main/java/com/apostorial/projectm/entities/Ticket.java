package com.apostorial.projectm.entities;

import com.apostorial.projectm.enums.PaymentStatus;
import com.apostorial.projectm.enums.TicketStatus;
import com.apostorial.projectm.enums.TicketTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document @Data @NoArgsConstructor @AllArgsConstructor
public class Ticket {
    @Id
    private String id;
    private String name;
    private String service;
    private BigDecimal price;
    private int eta;
    private TicketTime time;
    private TicketStatus status;
    private PaymentStatus paymentStatus;
    @DBRef
    private Studio studio;
}
