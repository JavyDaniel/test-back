package com.back.testJava.dto;

import com.back.testJava.enums.Estado;
import com.back.testJava.enums.Gravedad;
import com.back.testJava.enums.Incidencia;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class TicketDTO {

    private Long id;
    private String titulo;
    private Date fecha;
    //responsable
    private String equipoResponsable;
    private Incidencia incidencia;
    private Gravedad gravedad;
    private String versionSoftware;
    private String descripcion;
    private Estado estado;
    private String imagen;
    private Boolean archivado;


}
