package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class CarritoAddSteps {
	
	WebDriver driver = null;
	
	@Given("abrir navegador Carrito")
	public void abrir_navegador_Carrito() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("entrar en la pagina web Carrito")
	public void entrar_en_la_pagina_web_Carrito() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("Categoria")
	public void categoria1() {
		driver.findElement(By.xpath("//li[@class='link-navigation-element nav-link--megamenu']/a[@href='/collections/ropa']")).click();	
	}
	@And("Categoria2")
	public void categoria2() {
		driver.findElement(By.xpath("//li[@class='link-navigation-element nav-link--megamenu']/a[@href='/collections/zapatos']")).click();	
	}
	@And("Categoria3")
	public void categoria3() {
		driver.findElement(By.xpath("//li[@class='link-navigation-element nav-link--megamenu']/a[@href='/collections/complementos']")).click();	
	}

	@And("Producto1")
	public void producto1() {
		//driver.findElement(By.xpath("//h3//a[@href='/products/vestido-evase-wecre-rojo']")).click();
		driver.findElement(By.xpath("//div[@class='card'][1]")).click();
	}

	@And("LoQuiero")
	public void loquiero1() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='button button-add']")).click();
	}
	
	@Given("Producto2")
	public void producto2() {
		//driver.findElement(By.xpath("//h3//a[@href='/products/abrigo-romer-negro']")).click();
		driver.findElement(By.xpath("//div[@class='card'][2]")).click();
	}

	@Given("Producto3")
	public void producto3() {
		//driver.findElement(By.xpath("//h3//a[@href='/products/abrigo-romer-kaki']")).click();
		driver.findElement(By.xpath("//div[@class='card'][3]")).click();
	}

	@And("clicar Carrito")
	public void clicar_Carrito() throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='carrito valentina']")).click();
		Thread.sleep(2000);
		
	}

	@Then("Comprobar productos carrito iguales")
	public void comprobar_productos_carrito_iguales() throws InterruptedException {
		Thread.sleep(2000);
		String Cantidad = driver.findElement(By.xpath("//span[@class='dv_quantity']")).getText();
		System.out.println("Tiene: " + Cantidad + " productos iguales");
		Assert.assertEquals(Cantidad, "3");
		driver.close();
	    driver.quit();
		
	}
	@Then("Comprobar productos carrito distintos")
	public void comprobar_productos_carrito_distintos() throws InterruptedException {
		Thread.sleep(2000);
		String Cantidad1 = driver.findElement(By.xpath("//div[@class='cart-content'][1]//span[@name='updates[]']")).getText();
		Assert.assertEquals(Cantidad1, "1");
		
		String Cantidad2 = driver.findElement(By.xpath("//div[@class='cart-content'][2]//span[@name='updates[]']")).getText();
		Assert.assertEquals(Cantidad2, "1");
		
		String Cantidad3 = driver.findElement(By.xpath("//div[@class='cart-content'][3]//span[@name='updates[]']")).getText();
		Assert.assertEquals(Cantidad3, "1");
		
		driver.close();
	    driver.quit();
		
		
		//div[@class="cart-content"][1]//span[@name="updates[]"]
	}

}
