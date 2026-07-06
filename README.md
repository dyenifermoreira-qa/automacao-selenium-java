# 🚀 Automação Híbrida de Testes: Web (Selenium) & API (RestAssured)

Este repositório contém um projeto completo e estruturado de automação de testes, cobrindo validações de front-end (UI) e de backend (API). A arquitetura foi desenvolvida seguindo as melhores práticas de mercado, focando em alta manutenibilidade, legibilidade e reutilização de código.

---

## Tecnologias e Ferramentas Utilizadas

* **Linguagem:** Java 17
* **Automação Web:** Selenium WebDriver (v4.22.0)
* **Automação de API:** RestAssured
* **Orquestrador de Testes:** JUnit 5
* **Gerenciador de Dependências:** Maven
* **Gerenciador de Binários:** WebDriverManager (mitiga falhas de atualização de driver local)
* **Asserções:** Hamcrest & JUnit Assertions

---

## Arquitetura do Projeto

### Automação Web (Front-end)
Para a camada visual, foi aplicado o padrão de projeto **Page Objects (POM)**. Esse padrão separa a lógica de interação com a página (elementos e métodos) da estrutura real dos testes, garantindo que alterações no layout do sistema não quebrem os scripts de teste diretamente.
* **Aplicação Alvo:** [SauceDemo](https://saucedemo.com)
* **Cenários Validados:**
  * Login realizado com sucesso.
  * Validação de mensagens de erro para credenciais inválidas.

### Automação de API (Backend)
Testes focados em serviços, garantindo a integridade dos dados trafegados no backend, tempos de resposta e validação de contratos de API.
* **API Alvo:** [ReqRes API](https://reqres.in)
* **Cenários Validados:**
  * Busca de usuário via requisição `GET` (Validação de status 200 e dados do payload).
  * Criação de usuário via requisição `POST` (Validação de status 201 e persistência dos dados enviados).

---

## Como Executar o Projeto

1. Certifique-se de ter o **Java 17** e o **Maven** instalados na sua máquina.
2. Clone este repositório:
   ```bash
   git clone https://github.com
   ```
3. Acesse a pasta do projeto e execute os testes pelo terminal:
   ```bash
   mvn test
   ```
