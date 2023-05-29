# Generation-Loja-de-Games 
![image](https://github.com/DrikaDev/Generation-Loja-de-Games/assets/102387476/db333655-ee3c-4b73-9162-082bf6206e1b)

* Objetivo do Exercício *

Construir a Backend para uma Loja de Games com a capacidade de manipular os dados dos Produtos da loja.\
Os produtos deverão estar classificados por Categoria.

👉🏻 1º parte:

1) Criar o projeto no Spring seguindo as boas práticas;
2) Configurar o Banco de dados da aplicação no arquivo application.properties;
3) Fazer o CRUD completo do recurso Produto (6 métodos);
4) Fazer o CRUD completo do recurso Categoria (6 métodos);
5) Criar o Relacionamento do tipo One to Many entre as Classes Categoria e Produto;
6) Seguir as boas práticas estudadas sobre Spring (Model, Repository e Controller);
7) Testar toda a API utilizando o Insomnia.

<img width="842" alt="image" src="https://github.com/DrikaDev/Generation-Loja-de-Games/assets/102387476/870b9725-758f-41d6-a096-04ac0c6a4e74">

👉🏻 2º parte:

1) Inserção das dependências de segurança no POM;
2) Criação das classes Usuario e UsuarioLogin com seus respectivos atributos;
3) Na Interface UsuarioRepository adicionado o Método de busca específica:
  ●	findByUsuario() com a função de trazer um usuário específico pelo e-mail (conteúdo do atributo usuário, da Model Usuario).
4) Criação da Camada Security com as seguintes Classes:
  ●	BasicSecurityConfig
  ●	UserDetailsImpl
  ●	UserDetailsServiceImpl
  ●	JwtService
  ●	JwtAuthFilter
5) Criação da Classe UsuarioService na Service;
6) Implementação da Classe UsuarioService com os Métodos:
  ●	cadastrarUsuario()
  ●	atualizarUsuario()
  ●	autenticarUsuario()
7) Criação da Classe UsuarioController na Controller;
8) Criação dos seguintes métodos na Classe UsuarioController:
  ●	getAll() com a capacidade de listar todos os Usuários.
  ●	getById() com a função de trazer um único Usuário identificada pelo id.
  ●	post() com a função de gravar (persistir) um novo Usuário no banco de dados.
  ●	put() com a função de atualizar os dados de um Usuário.
  ●	logar() com a função de efetuar login na API.
