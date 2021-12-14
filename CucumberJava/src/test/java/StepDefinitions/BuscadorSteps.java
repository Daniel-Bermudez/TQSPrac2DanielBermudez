package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BuscadorSteps {
	
	WebDriver driver = null;
	
	@Given("abrir navegador Carrito Buscador")
	public void abrir_navegador_Carrito_Buscador() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("entrar en la pagina web Carrito Buscador")
	public void entrar_en_la_pagina_web_Carrito_Buscador() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("clicar buscador")
	public void clicar_buscador() {
		driver.findElement(By.xpath("//div[@class='header-row-top']//input[@name='q']")).click();
	}

	@And("escribir buscador")
	public void escribir_buscador() {
		driver.findElement(By.xpath("//div[@class='header-row-top']//input[@name='q']")).sendKeys("Camiseta");
	}
	@And("escribir buscador2")
	public void escribir_buscador2() {
		driver.findElement(By.xpath("//div[@class='header-row-top']//input[@name='q']")).sendKeys("Ps5");
	}
	
	@And("enter buscador")
	public void enter_buscador() {
		//driver.findElement(By.xpath("//div[@class='header-row-top']//input[@name='q']")).submit();
		driver.findElement(By.xpath("//div[@class='hide-mobile show-tablet desktop-search-bar']//span[@class='icon']")).click();
		
	}

	@Then("Comprobar Buscador")
	public void comprobar_Buscador() throws InterruptedException {
		Thread.sleep(2000);
		String a = driver.findElement(By.xpath("//div[@class='snize-search-results-header']")).getText();
		System.out.println(a);
		
		String mystring = a;
		String arr[] = mystring.split(" ", 2);
		
		System.out.println(arr[0]);
		Assert.assertEquals(arr[0], "Mostrando");
		
		driver.close();
	    driver.quit();
	}
	@Then("Comprobar Buscador2")
	public void comprobar_Buscador2() throws InterruptedException {
		Thread.sleep(2000);
		String b = driver.findElement(By.xpath("//div[@class='snize-no-products-found-text']")).getText();
		
		System.out.println(b);
		
		String mystring = b;
		String arr[] = mystring.split(" ", 2);
		
		System.out.println(arr[0]);
		Assert.assertEquals(arr[0], "Buscaste");
		
		driver.close();
	    driver.quit();
	}
	@Then("Comprobar Buscador3")
	public void comprobar_Buscador3() throws InterruptedException {
		Thread.sleep(2000);
		String a = driver.findElement(By.xpath("//div[@class='snize-search-results-header']")).getText();
		System.out.println(a);
		
		String mystring = a;
		String arr[] = mystring.split(" ", 2);
		
		System.out.println(arr[0]);
		Assert.assertEquals(arr[0], "Mostrando");
		
		driver.close();
	    driver.quit();
	}
}
