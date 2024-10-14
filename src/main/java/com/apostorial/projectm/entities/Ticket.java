package com.apostorial.projectm.entities;

import com.apostorial.projectm.enums.PaymentStatus;
import com.apostorial.projectm.enums.TicketStatus;
import com.apostorial.projectm.enums.TicketTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document @Data @NoArgsConstructor @AllArgsConstructor
public class Ticket {
    @Id
    private String id;
    private String name;
    private String service;
    private BigDecimal price;
    private int eta;
    private TicketTime time;
    private LocalDate deadline;
    private TicketStatus status;
    private PaymentStatus paymentStatus;
    private Member member;
    @DBRef
    private Studio studio;
    private BigDecimal memberPayment = price.multiply(BigDecimal.valueOf(member.getPercentage()));
    private BigDecimal studioPayment = price.multiply(BigDecimal.valueOf(studio.getPercentage()));

    @JsonProperty("studio")
    public String getStudioForSerialization() {
        return studio.getId();
    }

    @JsonProperty("member")
    public String getMemberForSerialization() {
        return member.getId();
    }
}
