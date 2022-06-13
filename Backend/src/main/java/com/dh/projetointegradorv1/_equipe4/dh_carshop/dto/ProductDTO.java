package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ProductDTO {

    private Integer id;
    private String nome;
    private String descricao;

}
