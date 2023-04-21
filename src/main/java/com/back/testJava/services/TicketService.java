package com.back.testJava.services;

import com.back.testJava.dto.TicketDTO;
import com.back.testJava.enums.Estado;

import java.util.List;

public interface TicketService {

    public TicketDTO crearTicket(TicketDTO ticketDTO);
    public List<TicketDTO> verTickets();
    public TicketDTO verTicketId(long id);
    public TicketDTO actualizarTicket(TicketDTO ticketDTO, long id);
    public TicketDTO archivarTicket(boolean archivado, long id);
    public void eliminarTicket(long id);

    public List<TicketDTO> filtroTicket(Enum<Estado> estado, boolean archivado);

    public List<TicketDTO> filtroArchivados(boolean archivados);
}
