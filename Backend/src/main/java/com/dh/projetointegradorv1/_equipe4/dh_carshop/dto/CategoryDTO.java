package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
public class CategoryDTO {
    private Integer id;
    private String qualificacao;
    private String descricao;
    @JsonProperty("url_imagem")
    private String urlImagem;
}
