package br.com.rocketskills.petlov;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class Cadastro {

	@Test
	@DisplayName("Deve liberar o acesso para cadastrar um ponto de doação")
	void createPoint() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // REALIZA A ABERTURA DO NAVEGADOR

		driver.get("https://petlov.vercel.app/signup"); // ACESSA A PÁGINA

		WebElement title = driver.findElement(By.cssSelector("h1")); // BUSCA O ELEMENTO (TITULO H1)

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // ANALISA SE O ELEMENTO H1 ESTÁ VISIVEL
		wait.until(d -> title.isDisplayed());


		assertEquals("Cadastro de ponto de doação", title.getText(), "Verificando a tela de cadastro"); // VERIFICA SE O TEXTO ESTÁ COERENTE

		WebElement name = driver.findElement(By.cssSelector("input[placeholder='Nome do ponto de doação']"));
		name.sendKeys("Lucas Gabriel Pereira de Souza");

		WebElement email = driver.findElement(By.cssSelector("input[placeholder='E-mail']"));
		email.sendKeys("email_aleatorio@gmail.com");

		WebElement cep = driver.findElement(By.cssSelector("input[placeholder='CEP']"));
		cep.sendKeys("123456");

		WebElement numero_Casa = driver.findElement(By.cssSelector("input[placeholder='Número']"));
		numero_Casa.sendKeys("000");

		WebElement complemento = driver.findElement(By.cssSelector("input[placeholder='Complemento']"));
		complemento.sendKeys("Referência de casa");

		driver.findElement(By.xpath("//span[text()=\"Cachorros\"]/..")).click();
		

		driver.close(); // ENCERRA A CESSÃO DO NAVEGADOR
	}
}
