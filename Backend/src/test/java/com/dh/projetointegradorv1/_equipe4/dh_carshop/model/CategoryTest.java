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
        String qualificacao = "Utilitario";
        String descricao = "Fusca azul";
        String descricaoAlterada = "Fuscão preto";
        String url_imagem = "url.com";
        String toStringOutput = "Categories{" +
                    "id=0, qualificacao='Utilitario', " +
                    "descricao='Fusca azul', " +
                    "url_imagem='url.com', " +
                    "criado=null, " +
                    "atualizado=null" +
                "}";

        // teste de get e set de qualificacao
        category.setQualificacao(qualificacao);
        Assertions.assertEquals(qualificacao, category.getQualificacao());

        // teste de get e set de descricao
        category.setDescricao(descricao);
        Assertions.assertEquals(descricao, category.getDescricao());

        // teste de get e set de Url_imagem
        category.setUrl_imagem(url_imagem);
        Assertions.assertEquals(url_imagem, category.getUrl_imagem());

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
        category = new Category(qualificacao, descricao, url_imagem);

        // testando se o initializer Category() funfou
        Assertions.assertEquals(qualificacao, category.getQualificacao());
        Assertions.assertEquals(descricao, category.getDescricao());
        Assertions.assertEquals(url_imagem, category.getUrl_imagem());

        category.setId(0);
        Assertions.assertEquals(0, category.getId());

        Assertions.assertEquals(toStringOutput, category.toString());
    }
}