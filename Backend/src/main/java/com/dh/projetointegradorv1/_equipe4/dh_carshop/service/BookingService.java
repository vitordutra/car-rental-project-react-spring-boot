package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.BookingDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Booking;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.City;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.User;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.BookingRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.CityRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.UserRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public BookingDto createBooking(BookingDto dto) {
        Booking entity = new Booking();
        copyToEntity(dto, entity);
        entity = bookingRepository.save(entity);
        return new BookingDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BookingDto> listAllBookings() {
        List<BookingDto> listDto = new ArrayList<>();
        List<Booking> list = bookingRepository.findAll();
        for(Booking book : list) {
            BookingDto dto = new BookingDto(book);
            listDto.add(dto);
        }
        return listDto;
    }

    @Transactional(readOnly = true)
    public BookingDto findBookingById(Integer id) {
        Optional<Booking> obj = bookingRepository.findById(id);
        Booking entity = obj.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
        return new BookingDto(entity, entity.getProduto(), entity.getCidade(), entity.getUsuario());
    }

    public void copyToEntity(BookingDto dto, Booking entity) {
        entity.setInicioReserva(dto.getInicioReserva());
        entity.setFimReserva(dto.getFimReserva());
        Optional<Product> objProd = productRepository.findById(dto.getProduto().getId());
        Product product = objProd.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
        entity.setProduto(product);
        entity.setValorReserva(product.getValorDiaria() * OffsetDateTime.timeLineOrder().compare(dto.getFimReserva(), dto.getInicioReserva()));
        Optional<City> objCity = cityRepository.findById(dto.getCidade().getId());
        City city = objCity.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
        entity.setCidade(city);
        Optional<User> objUser = userRepository.findById(dto.getUsuario().getId());
        User user = objUser.orElseThrow(() -> new RecursoNaoEncontrado("ENTIDADE NÃO ENCONTRADA"));
        entity.setUsuario(user);
    }

}
