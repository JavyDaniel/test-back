package com.back.testJava.models;

import com.back.testJava.enums.Estado;
import com.back.testJava.enums.Gravedad;
import com.back.testJava.enums.Incidencia;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data @NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "fecha", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha;
    // responsable
    @Column(name = "equipoResponsable")
    private String equipoResponsable;
    @Enumerated(EnumType.STRING)
    @Column(name = "incidencia", nullable = false)
    private Incidencia incidencia;
    @Enumerated(EnumType.STRING)
    @Column(name = "gravedad", nullable = false)
    private Gravedad gravedad;
    @Column(name = "versionSoftware")
    private String versionSoftware;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private Estado estado;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "archivado", nullable = false)
    private Boolean archivado;

}
