package com.apostorial.projectm.repositories;

import com.apostorial.projectm.entities.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    List<Ticket> findByStudioId(String studioId);
}
