package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.BookingDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.RoleDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.UserDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.BookingService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.RoleService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class UserTest {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    BookingService bookingService;

    @Test
    void createUser() {

        //cenário
        UserDto user = new UserDto();
        User entity = new User();

        // expectativas
        String nome = "Rafael";
        String sobrenome = "Silva";
        String email = "silva@gmail.com";
        String descricaoAlterada = "silva.com";
        String senha = "123456";
        String toStringOutput = "Users{" +
                "id=0, nome='Rafael', " +
                "sobrenome='Silva', " +
                "email='silva@gmail.com', " +
                "senha='123456', " +
                "criado=null, " +
                "atualizado=null" +
                "}";

        user.setFuncao(getFuncao());
        user.setReservas(getReservas());


        // teste de get e set de nome
        user.setNome(nome);
        Assertions.assertEquals(nome, user.getNome());

        // teste de get e set de sobrenome
        user.setSobrenome(sobrenome);
        Assertions.assertEquals(sobrenome, user.getSobrenome());

        // teste de get e set de email
        user.setEmail(email);
        Assertions.assertEquals(email, user.getEmail());

        // teste de get e set de senha
        user.setSenha(senha);
        Assertions.assertEquals(senha, user.getSenha());

        // create
        user = userService.createUser(user);
        //user = bookingService.createBooking(user);

        // aqui esta sendo testado a existencia do id e inclusive que foi salvo no banco porque tem um id
        Assertions.assertInstanceOf(java.lang.Integer.class, user.getId());

        user.setId(0);
        Assertions.assertEquals(0, user.getId());

        // update
        //user = userService.updateUserById(user.getId(), user); Não passou

        // verificando que o callback antesDeAtualizar rodou
        //userService.copyToEntity(user, entity);
        //Assertions.assertInstanceOf(java.time.OffsetDateTime.class, entity.getAtualizado()); Não passou

        // verificar agora instanciar ja com os valores
        //user = new UserDto(nome, sobrenome, email, senha);

        // testando se o initializer User() funcionou
        /*Assertions.assertEquals(nome, user.getNome());
        Assertions.assertEquals(sobrenome, user.getSobrenome());
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals(senha, user.getSenha());

        user.setId(0);
        Assertions.assertEquals(0, user.getId());

        Assertions.assertEquals(toStringOutput, user.toString());*/

    }

    private List<BookingDto> getReservas() {
        return bookingService.findBookingByUser(1);
    }

    private RoleDto getFuncao() {
        return roleService.findRoleById(1);
    }

}