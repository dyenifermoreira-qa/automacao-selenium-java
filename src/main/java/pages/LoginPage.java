package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // 1. Mapeamento dos Elementos (Locators)
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // 2. Construtor da Página
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 3. Ações da Tela
    public void acessarAplicacao() {
        driver.get("https://www.saucedemo.com/");
    }

    public void preencherUsuario(String usuario) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        driver.findElement(passwordInput).sendKeys(senha);
    }

    public void clicarNoBotaoLogin() {
        driver.findElement(loginButton).click();
    }

    public void realizarLogin(String usuario, String senha) {
        preencherUsuario(usuario);
        preencherSenha(senha);
        clicarNoBotaoLogin();
    }

    public String obterMensagemErro() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}
