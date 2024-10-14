package com.apostorial.projectm.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Document @Data @NoArgsConstructor @AllArgsConstructor
public class Studio {
    @Id
    private String id;
    private String name;
    private int percentage;
    private BigDecimal earnings;
    @DBRef
    private User user;
    @DBRef
    private List<Ticket> tickets;
    @DBRef
    private List<Member> members;

    @JsonProperty("tickets")
    public List<String> getTicketsForSerialization() {
        return tickets.stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
    }

    @JsonProperty("members")
    public List<String> getMembersForSerialization() {
        return members.stream()
                .map(Member::getId)
                .collect(Collectors.toList());
    }
}
