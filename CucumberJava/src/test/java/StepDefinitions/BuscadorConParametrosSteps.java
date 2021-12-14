package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BuscadorConParametrosSteps {
	
	WebDriver driver = null;
	
	@Given("abrir navegador Parametro")
	public void abrir_navegador_Parametro() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("entrar en la pagina web Parametro")
	public void entrar_en_la_pagina_web_Parametro() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("Clicar Categoria")
	public void clicar_Categoria() {
		driver.findElement(By.xpath("//li[@class='link-navigation-element nav-link--megamenu']/a[@href='/collections/zapatos']")).click();	
	}

	@And("Clicar talla")
	public void clicar_talla() {
		driver.findElement(By.xpath("//div[@class='filter-desktop-container']//span[@data-id='size']")).click();
	}

	@And("Clicar Tipo Prenda")
	public void clicar_Tipo_Prenda() {
		driver.findElement(By.xpath("//div[@class='filter-desktop-container']//span[@data-id='type']")).click();
	}
	
	@And("Elegir talla")
	public void elegir_talla() {
		driver.findElement(By.xpath("//div[@id='options_tallas_desk']//label[4]")).click();
	}

	@And("Elegir Tipo Prenda")
	public void elegir_Tipo_Prenda() {
		driver.findElement(By.xpath("//div[@id='options_tipos_desk']//label[2]")).click();	
	}
	
	@And("Abrir producto1")
	public void abrir_producto1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='card'][1]")).click();	
	}
	
	@And("Especificar_talla")
	public void especificar_talla() {
		driver.findElement(By.xpath("//label[@for='swatch-0-38']")).click();
	}

	@And("Add al carro")
	public void a_adir_al_carro() {
		driver.findElement(By.xpath("//button[@class='button button-add']")).click();
	}
	
	@Then("Comprobar prendas se ajustan a la talla dada desde el carro incorrecto")
	public void comprobar_prendas_se_ajustan_a_la_talla_dada_desde_el_carro_incorrecto() throws InterruptedException {
		
		Thread.sleep(2000);
		String Talla = driver.findElement(By.xpath("//div[@class='cart-info']//div[2]//span")).getText();
		
		String[] parts= Talla.split(" ");
		String lastOne = parts[parts.length-1];
		System.out.println(lastOne);
		
		Assert.assertNotEquals(lastOne, "38");
		
		driver.close();
	    driver.quit();
		
	}
	@Then("Comprobar prendas se ajustan a la talla dada desde el carro")
	public void comprobar_prendas_se_ajustan_a_la_talla_dada_desde_el_carro() throws InterruptedException {
		
		Thread.sleep(2000);
		String Talla = driver.findElement(By.xpath("//div[@class='cart-info']//div[2]//span")).getText();
		
		String[] parts= Talla.split(" ");
		String lastOne = parts[parts.length-1];
		System.out.println(lastOne);
		
		Assert.assertEquals(lastOne, "38");
		
		driver.close();
	    driver.quit();
		
	}
	
	@Then("Comprobar prendas se ajustan al tipo de prenda dada desde el carro")
	public void comprobar_prendas_se_ajustan_al_tipo_de_prenda_dada_desde_el_carro() throws InterruptedException {
		
		Thread.sleep(2000);
		String Tipo = driver.findElement(By.xpath("//div[@class='cart-info']//div[2]//span")).getText();
		
		String[] parts= Tipo.split(" ");
		System.out.println(parts[0]);
		
		Assert.assertEquals(parts[0], "Deportivo");
		
		driver.close();
	    driver.quit();
	  
	    //div[@id="options_tipos_desk"]//input[@data-rel="deportivos"]
	}
}
