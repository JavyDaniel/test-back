package com.back.testJava.services;

import com.back.testJava.dto.TicketDTO;
import com.back.testJava.models.Ticket;
import com.back.testJava.repositories.TicketRepository;
import com.back.testJava.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketDTO crearTicket(TicketDTO ticketDTO){
        Ticket ticket = Helpers.modelMapper().map(ticketDTO, Ticket.class);
        Ticket nuevoTicket = ticketRepository.save(ticket);
        return Helpers.modelMapper().map(nuevoTicket, TicketDTO.class);
    }

    @Override
    public List<TicketDTO> verTickets() {
        return null;
    }

    @Override
    public TicketDTO verTicketId() {
        return null;
    }

    @Override
    public TicketDTO actualizarTicket(TicketDTO ticketDTO, long id) {
        return null;
    }
}
