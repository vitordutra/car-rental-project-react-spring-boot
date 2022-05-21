CREATE DATABASE dh_carshop;

USE dh_carshop;

CREATE TABLE categorias(
	id INT NOT NULL AUTO_INCREMENT,
    qualificacao VARCHAR(50),
    descricao VARCHAR(255),
    url_imagem VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Econômico", "Carros com baixo consumo", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1024px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Compacto", "Carros com tamanho compacto", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/2016_Smart_Fortwo_Passion_Automatic_1.0_Front.jpg/1024px-2016_Smart_Fortwo_Passion_Automatic_1.0_Front.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Confort", "Carros com amplo espaço interno", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Citroen_C4_%282020%29_IMG_4202.jpg/1024px-Citroen_C4_%282020%29_IMG_4202.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Luxo", "Carros de luxo", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Mercedes-Benz_S_500_%28W_222%29_%E2%80%93_Heckansicht%2C_6._April_2014%2C_Neuss.jpg/1024px-Mercedes-Benz_S_500_%28W_222%29_%E2%80%93_Heckansicht%2C_6._April_2014%2C_Neuss.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Esportivo", "Carros esportivos", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Porsche_911_No_1000000%2C_70_Years_Porsche_Sports_Car%2C_Berlin_%281X7A3888%29.jpg/1024px-Porsche_911_No_1000000%2C_70_Years_Porsche_Sports_Car%2C_Berlin_%281X7A3888%29.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Hatch", "Carros com formato hatch", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/2018_Honda_Jazz_%28GK5_MY18%29_VTi-S_hatchback_%282018-08-06%29_01.jpg/1024px-2018_Honda_Jazz_%28GK5_MY18%29_VTi-S_hatchback_%282018-08-06%29_01.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Sedan", "Carros com formato sedan", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/2013-2016_Toyota_Corolla_%28ZRE172R%29_SX_sedan_%282018-09-17%29_01.jpg/1024px-2013-2016_Toyota_Corolla_%28ZRE172R%29_SX_sedan_%282018-09-17%29_01.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Pickup", "Carros com carroceria", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Fiat_Strada_Adventure_1.3_JTD_Multijet_Lumberjack_%28IV%29_%E2%80%93_Heckansicht%2C_5._Oktober_2013%2C_M%C3%BCnster.jpg/1024px-Fiat_Strada_Adventure_1.3_JTD_Multijet_Lumberjack_%28IV%29_%E2%80%93_Heckansicht%2C_5._Oktober_2013%2C_M%C3%BCnster.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Elétrico", "Carros movidos a energia elétrica", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/2019_Tesla_Model_3_Performance_AWD_Front.jpg/1024px-2019_Tesla_Model_3_Performance_AWD_Front.jpg");
INSERT INTO categorias (qualificacao, descricao, url_imagem)
VALUES ("Minivan", "Carros a partir de 6 lugares", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/2021_Toyota_Sienna_XLE_Hybrid%2C_front_12.21.21.jpg/1024px-2021_Toyota_Sienna_XLE_Hybrid%2C_front_12.21.21.jpg");

SELECT * FROM categorias;