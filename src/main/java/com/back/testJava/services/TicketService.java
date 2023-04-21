package com.back.testJava.services;

import com.back.testJava.dto.TicketDTO;

import java.util.List;

public interface TicketService {

    public TicketDTO crearTicket(TicketDTO ticketDTO);
    public List<TicketDTO> verTickets();
    public TicketDTO verTicketId();
    public TicketDTO actualizarTicket(TicketDTO ticketDTO, long id);
}
