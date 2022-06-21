-- Categorias
INSERT INTO categories (qualificacao, descricao)
VALUES ("Econômico", "Carros com baixo consumo");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Compacto", "Carros com tamanho compacto");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Confort", "Carros com amplo espaço interno");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Luxo", "Carros de luxo");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Esportivo", "Carros esportivos");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Hatch", "Carros com formato hatch");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Sedan", "Carros com formato sedan");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Pickup", "Carros com carroceria");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Elétrico", "Carros movidos a energia elétrica");
INSERT INTO categories (qualificacao, descricao)
VALUES ("Minivan", "Carros a partir de 6 lugares");

-- Images
INSERT INTO images (titulo, url)
VALUES ("Imagem 1", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem 2", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem 3", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 1", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 2", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 3", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 4", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 5", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 6", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 7", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 8", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 9", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Categoria 10", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Feature 1", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Feature 2", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Feature 3", "url.com");
INSERT INTO images (titulo, url)
VALUES ("Imagem Feature 4", "url.com");

-- Cities
INSERT INTO cities (nome, estado)
VALUES ("Curitiba", "PR");
INSERT INTO cities (nome, estado)
VALUES ("São Caetano do Sul", "SP");
INSERT INTO cities (nome, estado)
VALUES ("São Luís", "MA");
INSERT INTO cities (nome, estado)
VALUES ("São Paulo", "SP");
INSERT INTO cities (nome, estado)
VALUES ("Sorocaba", "SP");

-- Products
INSERT INTO products (nome, descricao, id_cidade)
VALUES ("Produto 1", "Descrição do produto 1", 1);
INSERT INTO products (nome, descricao, id_cidade)
VALUES ("Produto 2", "Descrição do produto 2", 2);
INSERT INTO products (nome, descricao, id_cidade)
VALUES ("Produto 3", "Descrição do produto 3", 3);
INSERT INTO products (nome, descricao, id_cidade)
VALUES ("Produto 4", "Descrição do produto 4", 4);
INSERT INTO products (nome, descricao, id_cidade)
VALUES ("Produto 5", "Descrição do produto 5", 5);
INSERT INTO products (nome, descricao, id_cidade)
VALUES ("Produto 6", "Descrição do produto 6", 1);

-- Images_Categories
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (1, 4);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (2, 5);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (3, 6);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (4, 7);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (5, 8);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (6, 9);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (7, 10);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (8, 11);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (9, 12);
INSERT INTO images_categories (id_categoria, id_imagem)
VALUES (10, 13);

-- Categories_Products
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (1, 1);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (2, 2);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (2, 3);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (3, 4);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (4, 5);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (5, 6);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (5, 7);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (6, 8);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (6, 9);
INSERT INTO categories_products (id_produto, id_categoria)
VALUES (6, 10);

-- Images_Products
INSERT INTO images_products (id_produto, id_imagem)
VALUES (1, 1);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (1, 2);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (2, 1);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (2, 3);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (3, 2);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (3, 3);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (4, 1);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (5, 2);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (6, 1);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (6, 2);
INSERT INTO images_products (id_produto, id_imagem)
VALUES (6, 3);

-- Features
INSERT INTO features (nome)
VALUES ("Feature 1");
INSERT INTO features (nome)
VALUES ("Feature 2");
INSERT INTO features (nome)
VALUES ("Feature 3");
INSERT INTO features (nome)
VALUES ("Feature 4");

-- Images_Features
INSERT INTO images_features (id_caracteristica, id_imagem)
VALUES (1, 14);
INSERT INTO images_features (id_caracteristica, id_imagem)
VALUES (2, 15);
INSERT INTO images_features (id_caracteristica, id_imagem)
VALUES (3, 16);
INSERT INTO images_features (id_caracteristica, id_imagem)
VALUES (4, 17);

-- Features_Products
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (1, 2);
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (1, 4);
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (2, 1);
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (2, 3);
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (3, 4);
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (4, 3);
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (5, 2);
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (5, 1);
INSERT INTO features_products (id_produto, id_caracteristica)
VALUES (6, 1);

-- Users
INSERT INTO users (nome, sobrenome, email, senha)
VALUES ("John", "Doe", "johndoe@mail.com", "qwerty");
INSERT INTO users (nome, sobrenome, email, senha)
VALUES ("Jane", "Doe", "janedoe@mail.com", "password");
INSERT INTO users (nome, sobrenome, email, senha)
VALUES ("Admin", "User", "admin@dhcarshop.com", "strongPassword");