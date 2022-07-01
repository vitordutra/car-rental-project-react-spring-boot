package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Feature;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Image;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
public class ImageDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;
    private String url;
    private List<ProductDto> produtos = new ArrayList<>();
    private CategoryDto categoria;
    private FeatureDto caracteristica;

    public ImageDto(Integer id, String titulo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
    }

    public ImageDto(Image entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        url = entity.getUrl();
    }

    public ImageDto(Image entity, Set<Product> produtos) {
        this(entity);
        produtos.forEach(prod -> this.produtos.add(new ProductDto(prod)));
    }

    public ImageDto(Image entity, Category categoria) {
        this(entity);
        this.categoria = new CategoryDto(categoria);
    }

    public ImageDto(Image entity, Feature caracteristica) {
        this(entity);
        this.caracteristica = new FeatureDto(caracteristica);
    }

}
