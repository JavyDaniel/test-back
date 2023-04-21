package com.back.testJava.services;

import com.back.testJava.dto.TicketDTO;
import com.back.testJava.exceptions.ResourceNotFoundException;
import com.back.testJava.models.Ticket;
import com.back.testJava.repositories.TicketRepository;
import com.back.testJava.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(ticket -> Helpers.modelMapper().map(ticket, TicketDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TicketDTO verTicketId(long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", id));
        return Helpers.modelMapper().map(ticket, TicketDTO.class);
    }

    @Override
    public TicketDTO actualizarTicket(TicketDTO ticketDTO, long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", id));

        ticket.setTitulo(ticketDTO.getTitulo());
        ticket.setEquipoResponsable(ticketDTO.getEquipoResponsable());
        ticket.setIncidencia(ticketDTO.getIncidencia());
        ticket.setGravedad(ticketDTO.getGravedad());
        ticket.setVersionSoftware(ticketDTO.getVersionSoftware());
        ticket.setDescripcion(ticketDTO.getDescripcion());
        ticket.setEstado(ticketDTO.getEstado());
        ticket.setImagen(ticketDTO.getImagen());

        Ticket ticketActualizado = ticketRepository.save(ticket);

        return Helpers.modelMapper().map(ticketActualizado, TicketDTO.class);
    }

    @Override
    public TicketDTO archivarTicket(boolean archivado, long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", id));

        ticket.setArchivado(archivado);

        Ticket ticketActualizado = ticketRepository.save(ticket);

        return Helpers.modelMapper().map(ticketActualizado, TicketDTO.class);
    }

    @Override
    public void eliminarTicket(long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", id));
        ticketRepository.delete(ticket);
    }
}
