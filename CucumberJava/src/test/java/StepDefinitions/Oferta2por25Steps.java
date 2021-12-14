package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Oferta2por25Steps {

	WebDriver driver = null;
	
	@Given("abrir navegador oferta")
	public void abrir_navegador_oferta() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("entrar en la pagina web oferta")
	public void entrar_en_la_pagina_web_oferta() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("Categoria oferta")
	public void categoria_oferta() {
		driver.findElement(By.xpath("//li[@class='link-navigation-element']/a[@href='/collections/promocion-2x25']")).click();	
	}

	@And("Producto1 oferta")
	public void producto1_oferta() {
		driver.findElement(By.xpath("//div[@class='card'][1]")).click();
	}

	@And("LoQuiero oferta")
	public void loquiero_oferta() {
		driver.findElement(By.xpath("//button[@class='button button-add']")).click();
	}

	@And("clicar Carrito oferta")
	public void clicar_Carrito_oferta() throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='carrito valentina']")).click();
		Thread.sleep(2000);
	}

	@And("Producto2 oferta")
	public void producto2_oferta() {
		driver.findElement(By.xpath("//div[@class='card'][2]")).click();
	}
	
	@Then("Comprobar si aplica la oferta mismo producto")
	public void comprobar_si_aplica_la_oferta_mismo_producto() throws InterruptedException {
		Thread.sleep(2000);
		
		String Precio = driver.findElement(By.xpath("//p[@class='total']")).getText();
		System.out.println(Precio);
		Assert.assertEquals(Precio, "Total: 25,00 €");
		
		driver.close();
	    driver.quit();
	}

	@Then("Comprobar si aplica la oferta misma categoria")
	public void comprobar_si_aplica_la_oferta_misma_categoria() throws InterruptedException {
		Thread.sleep(2000);
		
		String Precio = driver.findElement(By.xpath("//p[@class='total']")).getText();
		Assert.assertEquals(Precio, "Total: 25,00 €");
		
		driver.close();
	    driver.quit();
	}

	@Then("Comprobar si aplica la oferta al tener tres productos")
	public void comprobar_si_aplica_la_oferta_al_tener_tres_productos() throws InterruptedException {
		Thread.sleep(2000);
	
		String Precio = driver.findElement(By.xpath("//p[@class='total']")).getText();
		Assert.assertEquals(Precio, "Total: 50,00 €");
	
		driver.close();
	    driver.quit();
	}
}
