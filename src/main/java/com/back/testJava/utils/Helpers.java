package com.back.testJava.utils;

import com.back.testJava.dto.TicketDTO;
import com.back.testJava.enums.Estado;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Helpers {

    public static ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static List<TicketDTO> filtro (List<TicketDTO> lista, Enum<Estado> estadoEnum){

        return lista.stream()
                .filter(ticket -> ticket.getEstado() == estadoEnum )
                .collect(Collectors.toList());

    }
}
