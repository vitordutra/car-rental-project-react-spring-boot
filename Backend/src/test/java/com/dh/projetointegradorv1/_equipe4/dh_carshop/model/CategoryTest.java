package com.dh.projetointegradorv1._equipe4.dh_carshop.model;

import com.dh.projetointegradorv1._equipe4.dh_carshop.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class CategoryTest {
    @Autowired
    CategoryService categoryService;

    @Test
    void createCategory() {
        //cenário
        Category category = new Category();

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
        Assertions.assertInstanceOf(java.time.OffsetDateTime.class, category.getCriado());

        // mudando descricao
        category.setDescricao(descricaoAlterada);

        // update
        category = categoryService.updateCategoryById(category, category.getId());

        // verificando que o callback antesDeAtualizar rodou
        Assertions.assertInstanceOf(java.time.OffsetDateTime.class, category.getAtualizado());

        // verificar agora instanciar ja com os valores
        category = new Category(titulo, descricao);

        // testando se o initializer Category() funfou
        Assertions.assertEquals(titulo, category.getTitulo());
        Assertions.assertEquals(descricao, category.getDescricao());

        category.setId(0);
        Assertions.assertEquals(0, category.getId());

        Assertions.assertEquals(toStringOutput, category.toString());
    }
}