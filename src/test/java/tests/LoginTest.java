package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeEach
    public void setUp() {
        // Inicializa o ChromeDriver automaticamente
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Abre o navegador maximizado
        
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        
        loginPage.acessarAplicacao();
    }

    @Test
    public void deveRealizarLoginComSucesso() {
        // Executa o fluxo usando a massa padrão do site
        loginPage.realizarLogin("standard_user", "secret_sauce");

        // Validação: Verifica se fomos redirecionados para a tela de Produtos
        String tituloEsperado = "Products";
        assertEquals(tituloEsperado, productsPage.obterTituloDaPagina());
    }

    @Test
    public void deveExibirErroComIniciaisInvalidas() {
        // Executa o fluxo com usuário incorreto
        loginPage.realizarLogin("usuario_invalido", "senha_invalida");

        // Validação: Verifica se a mensagem de erro apropriada apareceu
        String mensagemErro = loginPage.obterMensagemErro();
        assertTrue(mensagemErro.contains("Username and password do not match any user in this service"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Fecha o navegador ao fim de cada teste
        }
    }
}
