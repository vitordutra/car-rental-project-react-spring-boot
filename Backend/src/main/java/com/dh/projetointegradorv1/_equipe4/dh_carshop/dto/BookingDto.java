package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
public class BookingDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String inicioReserva;
    private String fimReserva;
    private Integer valorReserva;
    private ProductDto produto;
    private CityDto cidade;
    private UserDto usuario;

    public BookingDto(Integer id, LocalDate inicioReserva, LocalDate fimReserva) {
        this.id = id;
        this.inicioReserva = inicioReserva.format(DateTimeFormatter.ISO_DATE);
        this.fimReserva = fimReserva.format(DateTimeFormatter.ISO_DATE);
    }

    public BookingDto(Booking entity) {
        id = entity.getId();
        inicioReserva = entity.getInicioReserva().format(DateTimeFormatter.ISO_DATE);
        fimReserva = entity.getFimReserva().format(DateTimeFormatter.ISO_DATE);
    }

    public BookingDto(Booking entity, Product produto, City cidade, User usuario) {
        this(entity);
        this.produto = new ProductDto(produto);
        this.cidade = new CityDto(cidade);
        this.usuario = new UserDto(usuario);
    }

}
