package com.example.ticketconcumer.kafka;

import com.example.ticketconcumer.entity.Ticket;
import com.example.ticketconcumer.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaConsumer {
    private TicketRepository ticketRepository;
    @KafkaListener(topics = "buyTicket", groupId = "ticket")
    public void getTicket(Ticket ticket) {
        log.info("getTicketKafka");
        ticketRepository.save(ticket);
    }
}
