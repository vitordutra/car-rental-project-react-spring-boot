package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Booking;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.City;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter @Setter @NoArgsConstructor
public class BookingDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private OffsetDateTime inicioReserva;
    private OffsetDateTime fimReserva;
    private Integer valorReserva;
    private ProductDto produto;
    private CityDto cidade;
    private UserDto usuario;

    public BookingDto(Integer id, OffsetDateTime inicioReserva, OffsetDateTime fimReserva) {
        this.id = id;
        this.inicioReserva = inicioReserva;
        this.fimReserva = fimReserva;
    }

    public BookingDto(Booking entity) {
        id = entity.getId();
        inicioReserva = entity.getInicioReserva();
        fimReserva = entity.getFimReserva();
    }

    public BookingDto(Booking entity, Product produto, City cidade, User usuario) {
        this(entity);
        this.produto = new ProductDto(produto);
        this.cidade = new CityDto(cidade);
        this.usuario = new UserDto(usuario);
        this.valorReserva = this.produto.getValorDiaria() * OffsetDateTime.timeLineOrder().compare(this.fimReserva, this.inicioReserva);
    }

}
