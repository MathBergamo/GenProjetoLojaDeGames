# GamesHub

Este projeto faz parte do curso "Desenvolvedor Java Full Stack" oferecido pela Generation Brasil, com o objetivo de proporcionar um ambiente de aprendizado para o desenvolvimento de aplicações web utilizando a linguagem Java e o framework Spring Boot. O projeto GamesHub simula uma loja virtual de games, com funcionalidades básicas de cadastro, busca, atualização e exclusão de produtos e categorias.

## Estrutura do Projeto

O projeto está organizado em pacotes que seguem as boas práticas de arquitetura de software e padrões do Spring Boot:

- **Controller**: Contém as classes que implementam os endpoints da API, direcionando as requisições HTTP para os serviços adequados. Neste projeto, temos os controladores `CategoriaController` e `ProdutoController`.

- **Models**: Aqui estão as classes que representam os objetos do domínio da aplicação, ou seja, as entidades que serão persistidas no banco de dados. No projeto, temos as classes `Categoria`, `Produto`, `Login`, e `Usuario`.

- **Repository**: Contém as interfaces que estendem o `JpaRepository` do Spring Data JPA, permitindo a realização de operações de persistência no banco de dados. No projeto, temos os repositórios `CategoriaRepository`, `ProdutoRepository`, e `UsuarioRepository`.

- **Service**: Neste pacote, estão as classes que implementam a lógica de negócio da aplicação. Os serviços `CategoriaService`, `ProdutoService`, e `UsuarioService` realizam operações como criar, atualizar, buscar e excluir produtos, categorias, e usuários.

- **Security**: Contém as classes relacionadas à segurança da aplicação, como autenticação e geração de tokens JWT. As classes `JwtService`, `JwtAuthFilter`, `UserDetailsImpl`, `UserDetailsServiceImpl`, e `BasicSecurityConfig` estão relacionadas à segurança.

- **Resources**: Este é o diretório onde você encontra os arquivos de configuração da aplicação, como o `application.properties` para configurações do banco de dados e outros recursos.

## Endpoints da API

### CategoriaController

- `GET /categoria/{id}`: Retorna uma categoria específica com base no ID.
- `GET /categoria`: Retorna todas as categorias cadastradas.
- `POST /categoria`: Cria uma nova categoria.
- `PUT /categoria/{id}`: Atualiza os dados de uma categoria com base no ID.
- `DELETE /categoria/{id}`: Exclui uma categoria com base no ID.
- `GET /categoria/ativos`: Retorna todas as categorias ativas.

### ProdutoController

- `GET /produto/{id}`: Retorna um produto específico com base no ID.
- `GET /produto`: Retorna todos os produtos cadastrados.
- `POST /produto`: Cria um novo produto.
- `PUT /produto/{id}`: Atualiza os dados de um produto com base no ID.
- `DELETE /produto/{id}`: Exclui um produto com base no ID.
- `GET /produto/distribuidores`: Retorna produtos com base no distribuidor (fluxo feito pelo RequestBody para aprendizado).
- `GET /produto/categoria/{categoria}`: Retorna produtos com base na categoria informada.

### UsuarioController

- **GET /usuarios/all**
  - **Descrição:** Retorna todos os usuários cadastrados.
  - **Resposta:**
    - Código de status 200 OK.
    - Lista de objetos `Usuario`.

- **GET /usuarios/{id}**
  - **Descrição:** Retorna um usuário específico com base no ID.
  - **Parâmetros:**
    - `id` (Path Variable): ID do usuário.
  - **Resposta:**
    - Código de status 200 OK se encontrado.
    - Código de status 404 Not Found se não encontrado.
    - Objeto `Usuario`.

- **POST /usuarios/logar**
  - **Descrição:** Autentica um usuário com base nas credenciais fornecidas.
  - **Corpo da Requisição:**
    - Objeto `Login` contendo credenciais do usuário.
  - **Resposta:**
    - Código de status 200 OK se autenticado com sucesso.
    - Código de status 401 Unauthorized se a autenticação falhar.
    - Objeto `Login` com token de autenticação.

- **POST /usuarios/cadastrar**
  - **Descrição:** Cria um novo usuário.
  - **Corpo da Requisição:**
    - Objeto `Usuario` contendo informações do novo usuário.
  - **Resposta:**
    - Código de status 201 Created se o usuário for criado com sucesso.
    - Código de status 400 Bad Request se houver erros nos dados fornecidos.
    - Objeto `Usuario` criado.

- **PUT /usuarios/atualizar**
  - **Descrição:** Atualiza os dados de um usuário com base no ID.
  - **Corpo da Requisição:**
    - Objeto `Usuario` contendo os dados atualizados.
  - **Resposta:**
    - Código de status 200 OK se atualizado com sucesso.
    - Código de status 404 Not Found se o usuário não for encontrado.
    - Objeto `Usuario` atualizado.

## Configuração do Projeto

O projeto utiliza o Spring Boot e o Spring Data JPA para simplificar o desenvolvimento. O banco de dados utilizado é o MySQL. Certifique-se de configurar corretamente o arquivo `application.properties` com as informações de acesso ao banco de dados.

## Executando o Projeto

Para executar o projeto, você pode utilizar a IDE de sua preferência ou a linha de comando. Certifique-se de que o ambiente de desenvolvimento Java está configurado corretamente.

Na linha de comando, você pode usar o Maven para executar o projeto:

```bash
mvn spring-boot:run
```
Isso iniciará a aplicação Spring Boot e ela estará acessível em http://localhost:8080.

Lembre-se de que este projeto é voltado para aprendizado e pode ser expandido com mais funcionalidades e melhorias. Aproveite a oportunidade para praticar e aprofundar seus conhecimentos em desenvolvimento Java 
