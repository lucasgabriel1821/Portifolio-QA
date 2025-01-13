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

class Slogan {

	@Test
	@DisplayName("Deve exibir o slogan do site")
	void addsTwoNumbers() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // REALIZA A ABERTURA DO NAVEGADOR

		driver.get("https://petlov.vercel.app"); // ACESSA A PÁGINA

		WebElement title = driver.findElement(By.cssSelector("h1")); // BUSCA O ELEMENTO (TITULO H1)

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // ANALISA SE O ELEMENTO H1 ESTÁ VISIVEL
		wait.until(d -> title.isDisplayed());


		assertEquals("Conectando corações, mudando vidas!", title.getText(), "Verificando o Slogan"); // VERIFICA SE O TEXTO ESTÁ COERENTE 

		driver.close(); // ENCERRA A CESSÃO DO NAVEGADOR
	}
}
