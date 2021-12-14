package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class IncDecProductoCarrito {
	
	WebDriver driver = null;
	
	@Given("abrir navegador Carrito Inc\\/Dec")
	public void abrir_navegador_Carrito_Inc_Dec() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("entrar en la pagina web Carrito Inc\\/Dec")
	public void entrar_en_la_pagina_web_Carrito_Inc_Dec() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("Categoria Inc\\/Dec")
	public void categoria_Inc_Dec() {
		driver.findElement(By.xpath("//li[@class='link-navigation-element nav-link--megamenu']/a[@href='/collections/ropa']")).click();
	}

	@And("Producto1 Inc\\/Dec")
	public void producto1_Inc_Dec() {
		driver.findElement(By.xpath("//h3//a[@href='/products/vestido-evase-wecre-rojo']")).click();
	}

	@And("LoQuiero Inc\\/Dec")
	public void loquiero_Inc_Dec() {
		driver.findElement(By.xpath("//button[@class='button button-add']")).click();
	}

	@And("clicar Carrito Inc\\/Dec")
	public void clicar_Carrito_Inc_Dec() throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='carrito valentina']")).click();
		Thread.sleep(2000);
	}

	@And("Incrementar producto")
	public void incrementar_producto() {
		driver.findElement(By.xpath("//th[@class='btn_quantity maincart plus']//span[@class='icon']")).click();
		
	}
	@And("Decrementar producto")
	public void decrementar_producto() {
		driver.findElement(By.xpath("//th[@class='btn_quantity maincart minus']//span[@class='icon']")).click();
	}
	
	@And("Borrar producto")
	public void borrar_producto() {
		driver.findElement(By.xpath("//a[@class='delete-product']")).click();
	}
	
	@Then("Comprobar Incremento")
	public void comprobar_incremento() throws InterruptedException {
		Thread.sleep(2000);
		String Cantidad = driver.findElement(By.xpath("//span[@class='dv_quantity']")).getText();
		System.out.println("Tiene: " + Cantidad + " productos iguales");
		Assert.assertEquals(Cantidad, "4");
		driver.close();
	    driver.quit();
	}
	
	@Then("Comprobar Decremento")
	public void comprobar_decremento() throws InterruptedException {
		Thread.sleep(2000);
		String Cantidad = driver.findElement(By.xpath("//span[@class='dv_quantity']")).getText();
		System.out.println("Tiene: " + Cantidad + " productos iguales");
		Assert.assertEquals(Cantidad, "2");
		driver.close();
	    driver.quit();
	}
	
	@Then("Comprobar Borrado")
	public void comprobar_Borrado() throws InterruptedException {
		Thread.sleep(2000);
		String Mensaje = driver.findElement(By.xpath("//h3[@class='section-title']")).getText();
		Assert.assertEquals(Mensaje, "TU CARRITO ESTÁ VACÍO");
		driver.close();
	    driver.quit();
		
	}
	

}
