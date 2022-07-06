package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.ImageDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.CategoryService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.ImageService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.ProductService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryTest {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ImageService imageService;

    @Autowired
    ProductService productService;

    @Test
    void createCategory() {
        //cenário
        CategoryDto category = new CategoryDto();
        Category entity = new Category();

        // expectativas
        String titulo = "Econômico";
        String descricao = "Carros com baixo consumo";
        String descricaoAlterada = "Carros com alto consumo";
        String toStringOutput = "Categories{" +
                    "id=0, titulo='Econômico', " +
                    "descricao='Carros com baixo consumo', " +
                    "criado=null, " +
                    "atualizado=null" +
                "}";

        category.setImagem(getImagem());

        // teste de get e set de titulo
        category.setTitulo(titulo);
        Assertions.assertEquals(titulo, category.getTitulo());

        // teste de get e set de descricao
        category.setDescricao(descricao);
        Assertions.assertEquals(descricao, category.getDescricao());

        // create
        category = categoryService.createCategory(category);

        // aqui esta sendo testado a existencia do id e inclusive que foi salvo no banco porque tem um id
        Assertions.assertInstanceOf(java.lang.Integer.class, category.getId());

        // verificando que o callback antesDeSalvar rodou
        categoryService.copyToEntity(category, entity);
        Assertions.assertInstanceOf(java.time.OffsetDateTime.class, entity.getCriado());

        // mudando descricao
        category.setDescricao(descricaoAlterada);

        // update
        category = categoryService.updateCategoryById(category.getId(), category);

        // verificando que o callback antesDeAtualizar rodou
        categoryService.copyToEntity(category, entity);
        Assertions.assertInstanceOf(java.time.OffsetDateTime.class, entity.getAtualizado());

        // verificar agora instanciar ja com os valores
        category = new CategoryDto(titulo, descricao);

        // testando se o initializer Category() funfou
        Assertions.assertEquals(titulo, category.getTitulo());
        Assertions.assertEquals(descricao, category.getDescricao());

        category.setId(0);
        Assertions.assertEquals(0, category.getId());

        Assertions.assertEquals(toStringOutput, category.toString());
    }

    private ImageDto getImagem() {
        return imageService.findImageById(1);
    }
}
