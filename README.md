# 🚀 Projeto de Automação de Testes Web com Selenium WebDriver & Java

Este repositório contém um projeto completo de automação de testes de front-end (Web) estruturado com as melhores práticas do mercado, focado em alta manutenibilidade e confiabilidade de execução.

## 🛠️ Tecnologias e Ferramentas Utilizadas
* **Linguagem:** Java 17
* **Framework de Automação:** Selenium WebDriver (v4.22.0)
* **Orquestrador de Testes:** JUnit 5
* **Gerenciador de Dependências:** Maven
* **Gerenciador de Binários:** WebDriverManager (mitiga falhas de atualização de driver local)

## 📐 Arquitetura do Projeto
O projeto foi desenvolvido utilizando o padrão de arquitetura **Page Objects Pattern (POM)**. Esse modelo visa separar a lógica dos testes estruturais da manipulação direta dos elementos visuais da página Web, garantindo:
* Reutilização eficiente de código.
* Facilidade de manutenção caso o HTML da aplicação mude.
* Código limpo e legível.

```text
src/
├── main/java/pages/
│   ├── LoginPage.java      # Mapeamento e ações da tela de login
│   └── ProductsPage.java   # Mapeamento e ações da tela de produtos
└── test/java/tests/
    └── LoginTest.java      # Cenários de testes automatizados (Sucesso e Falha)
