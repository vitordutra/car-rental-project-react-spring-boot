package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String descricao;
    private List<FeatureDto> caracteristicas = new ArrayList<>();
    private List<ImageDto> imagens = new ArrayList<>();
    private List<CategoryDto> categorias = new ArrayList<>();
    private CityDto cidade;

    public ProductDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public ProductDto(Product entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
    }

    public ProductDto(Product entity, Set<Feature> caracteristicas, Set<Image> imagens,
                      Set<Category> categorias, City cidade) {
        this(entity);
        caracteristicas.forEach(car -> this.caracteristicas.add(new FeatureDto(car)));
        imagens.forEach(img -> this.imagens.add(new ImageDto(img)));
        categorias.forEach(cat -> this.categorias.add(new CategoryDto(cat)));
        this.cidade = new CityDto(cidade);
    }

}
