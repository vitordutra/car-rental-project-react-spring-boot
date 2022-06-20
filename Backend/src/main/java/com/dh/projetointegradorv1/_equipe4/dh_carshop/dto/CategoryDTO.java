package com.dh.projetointegradorv1._equipe4.dh_carshop.dto;

import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter @Setter @NoArgsConstructor
public class CategoryDTO {
    private Integer id;
    private String qualificacao;
    private String descricao;
    private String url_imagem;
    private List<ProductDTO> produtos = new ArrayList<>();

    public CategoryDTO(Integer id, String qualificacao, String descricao, String url_image) {
        this.id = id;
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url_imagem = url_imagem;
    }

    public CategoryDTO(Category entity) {
        id = entity.getId();
        qualificacao = entity.getQualificacao();;
        descricao = entity.getDescricao();
        url_imagem = entity.getUrl_imagem();
    }

    public CategoryDTO(Category entity, Set<Product> products) {
        this(entity);
        products.forEach(product -> this.produtos.add(new ProductDTO(product)));
    }
}
