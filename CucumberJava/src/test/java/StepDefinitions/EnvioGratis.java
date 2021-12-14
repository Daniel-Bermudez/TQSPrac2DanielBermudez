package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EnvioGratis {

	WebDriver driver = null;
	
	@Given("abrir navegador EG")
	public void abrir_navegador_EG() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("entrar en la pagina web EG")
	public void entrar_en_la_pagina_web_EG() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("Clicar Ropa")
	public void clicar_Ropa() {
		driver.findElement(By.xpath("//li[@class='link-navigation-element nav-link--megamenu']/a[@href='/collections/ropa']")).click();	
	}

	@And("Clicar primer producto")
	public void clicar_primer_producto() {
		driver.findElement(By.xpath("//div[@class='card'][1]")).click();
	}

	@And("Add al carrito EG")
	public void add_al_carrito_EG() {
		driver.findElement(By.xpath("//button[@class='button button-add']")).click();
	}

	@And("clicar incrementar")
	public void clicar_incrementar() throws InterruptedException {
		driver.findElement(By.xpath("//th[@class='btn_quantity maincart plus']//span[@class='icon']")).click();
		Thread.sleep(2000);
	}

	@Then("Comprobar que el envio es gratis")
	public void comprobar_que_el_envio_es_gratis() throws InterruptedException {
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//p[@class='EG_text']")).getText();
		System.out.println(name);
		
		Assert.assertEquals(name, "¡ENVÍO GRATIS!");
		driver.close();
	    driver.quit();	
	}

	@Then("Comprobar que el envio no es gratis")
	public void comprobar_que_el_envio_no_es_gratis() throws InterruptedException {
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//p[@class='EG_text']")).getText();
		System.out.println(name);
		
		String[] parts= name.split(" ");
		System.out.println(parts[0]);
		
		Assert.assertEquals(parts[0], "Faltan");
		
		driver.close();
	    driver.quit();
	}

	@Then("Comprobar aviso")
	public void comprobar_aviso() throws InterruptedException {
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//p[@class='EG_text']")).getText();
		System.out.println("tstgstgyh "+name);
		
		String[] parts= name.split(" ");
		System.out.println("fsfsfsf " +parts[1]);
		
		String price = driver.findElement(By.xpath("//div[@class='current-cart-price col3']")).getText();
		String[] parts2= price.split(" ");
		System.out.println("aaaaa" + parts2[0]);

		
		double Free = Double.valueOf(parts2[0].replace(",", ".")) + Double.valueOf(parts[1].replace(",", "."));
		System.out.println(Free);
		String a = String.format("%.2f", Free);
		System.out.println(a);
		Assert.assertEquals(a, "75,00");
		
		
		driver.close();
	    driver.quit();
	}
}
