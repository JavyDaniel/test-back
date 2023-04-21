package com.back.testJava.services;

import com.back.testJava.dto.TicketDTO;
import com.back.testJava.enums.Estado;
import com.back.testJava.exceptions.ResourceNotFoundException;
import com.back.testJava.models.Ticket;
import com.back.testJava.repositories.TicketRepository;
import com.back.testJava.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//    @Override
//    public List<List<TicketDTO>> verTickets() {
//        List<Ticket> tickets = ticketRepository.findAll();
//        List<TicketDTO>  tt = tickets.stream().map(ticket -> Helpers.modelMapper().map(ticket, TicketDTO.class)).collect(Collectors.toList());
//
//        List<List<TicketDTO>> todos = new ArrayList<>();
//        List<TicketDTO> filtro = Helpers.filtro(tt, Estado.NUEVO);
//        todos.add(filtro);
//        filtro = Helpers.filtro(tt, Estado.EN_PROCESO);
//        todos.add(filtro);
//        filtro = Helpers.filtro(tt, Estado.ATENDIDO);
//        todos.add(filtro);
//
//        return todos;
//    }
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

    @Override
    public List<TicketDTO> filtroTicket(Enum<Estado> estado, boolean archivado) {
        List<Ticket> tickets = ticketRepository.findAllByEstadoAndArchivado(estado, archivado);
        return tickets.stream().map(ticket -> Helpers.modelMapper().map(ticket, TicketDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TicketDTO> filtroArchivados(boolean archivados) {
        List<Ticket> tickets = ticketRepository.findAllByArchivado(archivados);
        return tickets.stream().map(ticket -> Helpers.modelMapper().map(ticket, TicketDTO.class)).collect(Collectors.toList());
    }
}
