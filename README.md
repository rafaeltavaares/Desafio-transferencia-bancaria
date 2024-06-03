# Desafio PicPay - Backend de Banco

## Descrição do Projeto

Este projeto é uma solução para um desafio de código proposto pelo PicPay. O objetivo do desafio é construir o backend de um banco que realiza transações entre contas e usuários. O projeto foi desenvolvido utilizando a linguagem Java e o framework Spring Boot, juntamente com várias bibliotecas que auxiliaram no desenvolvimento.

## Tecnologias Utilizadas

### Linguagem de Programação
- **Java**

### Framework
- **Spring Boot**

### Bibliotecas
- **Lombok**: Utilizada para reduzir o código boilerplate, gerando automaticamente getters, setters, construtores, entre outros, durante o runtime. Isso torna o código mais limpo e de fácil entendimento.
- **H2 Database**: Utilizada para configurar um banco de dados em memória, facilitando o desenvolvimento e testes do projeto.
- **Spring Web**: Fundamental para a criação e implementação da API REST do projeto.
- **Hibernate Validation**: Necessária para a implementação de validações no código, garantindo a integridade dos dados.

### Ferramenta de Gestão de Dependências
- **Maven**

## Funcionalidades

- Criação de contas de usuários
- Realização de transações entre contas
- Consulta de saldo
- Histórico de transações

## Como Executar o Projeto

1. **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```
2. **Navegue até o diretório do projeto:**
    ```bash
    cd seu-repositorio
    ```
3. **Execute o projeto utilizando Maven:**
    ```bash
    mvn spring-boot:run
    ```

O projeto estará disponível em `http://localhost:8080`.

## Endpoints

### Criação de Conta
- **POST** `/api/accounts`
    - **Descrição:** Cria uma nova conta de usuário.
    - **Parâmetros:**
        ```json
        {
      	"firstName" :"Primeiro nome",
      	"lastName" : "Ultimo nome",
      	"document" : "CPF/CNPJ",
      	"email" : "exemplo@gmail.com",
      	"password" : "senha",
      	"userType" : "COMMUM/MERCHANT",
      	"balance": valor em centavos
        }
        ```

### Realização de Transação
- **POST** `/api/transactions`
    - **Descrição:** Realiza uma transação entre duas contas.
    - **Parâmetros:**
        ```json
        {
        "amount" : valor,
        "sender_id" :ID do remetente,
        "receiver_id" : ID do receptor
        }
        ```

### Consulta de contas
- **GET** `/api/accounts`
    - **Descrição:** Retorna todas as contas.
  
### Histórico de Transações
- **GET** `/api/transactions/{accountID}/transaction`
    - **Descrição:** Consulta o histórico de transações de uma conta específica.
    - **Parâmetros:** ID da conta.
