package com.back.testJava.controllers;

import com.back.testJava.dto.TicketDTO;
import com.back.testJava.enums.Estado;
import com.back.testJava.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/verTodos", method = RequestMethod.GET)
    public List<TicketDTO> verTickets() {
        return ticketService.verTickets();
    }

    @RequestMapping(value = "/verUno/{id}", method = RequestMethod.GET)
    public ResponseEntity<TicketDTO> verTicketId(@PathVariable long id) {
        return ResponseEntity.ok(ticketService.verTicketId(id));

    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ResponseEntity<TicketDTO> crearTicket(@RequestBody TicketDTO ticketDTO) {
        Date date = new Date();
        ticketDTO.setFecha(date);
        ticketDTO.setArchivado(false);
        return new ResponseEntity<TicketDTO>(ticketService.crearTicket(ticketDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TicketDTO> actualizarTicket(@PathVariable(name = "id") long id, @RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(ticketService.actualizarTicket(ticketDTO, id));
    }

    @RequestMapping(value = "/archivar/{id}/{archivado}", method = RequestMethod.PUT)
    public ResponseEntity<TicketDTO> archivarTicket(@PathVariable(name = "id") long id, @PathVariable(name = "archivado") boolean archivado) {
        return ResponseEntity.ok(ticketService.archivarTicket(archivado, id));
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarTicket(@PathVariable long id) {
        ticketService.eliminarTicket(id);
        return ResponseEntity.ok("Publicacion eliminada");
    }

    @RequestMapping(value = "/filtro/{estado}/{archivado}", method = RequestMethod.GET)
    public List<TicketDTO> filtroTicket(@PathVariable(name = "estado")String estado, @PathVariable(name = "archivado") boolean archivado) {
        return ticketService.filtroTicket( Estado.valueOf(estado), archivado);
    }

    @RequestMapping(value = "/filtroArchivados/{archivado}", method = RequestMethod.GET)
    public List<TicketDTO> filtroArchivados(@PathVariable(name = "archivado") boolean archivado) {
        return ticketService.filtroArchivados(archivado);
    }
}
