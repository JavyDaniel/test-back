package com.back.testJava.repositories;

import com.back.testJava.enums.Estado;
import com.back.testJava.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByEstadoAndArchivado(Enum<Estado> estado, boolean archivado);
    List<Ticket> findAllByArchivado(boolean archivado);
}
