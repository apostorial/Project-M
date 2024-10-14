package com.apostorial.projectm.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document @Data @NoArgsConstructor @AllArgsConstructor
public class Member {
    @Id
    private String id;
    private String name;
    @DBRef
    private Studio studio;
    private int percentage;
    private BigDecimal earnings;

    @JsonProperty("studio")
    public String getStudioForSerialization() {
        return studio.getId();
    }
}
