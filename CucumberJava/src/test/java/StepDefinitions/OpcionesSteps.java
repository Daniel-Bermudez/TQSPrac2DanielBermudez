package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpcionesSteps {
	
	WebDriver driver = null;
	
	@Given("abrir navegador Opciones")
	public void abrir_navegador_Opciones() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("entrar en la pagina web Opciones")
	public void entrar_en_la_pagina_web_Opciones() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("Opciones Opciones")
	public void opciones_Opciones() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id=\"acco\"]")).click();
	}

	@And("IniciarSesion Opciones")
	public void iniciarsesion_Opciones() {
		driver.findElement(By.xpath("//p[@class= 'acc-text']/a")).click();
	}

	@And("Registrarse o IniciarSesion Opciones")
	public void registrarse_o_IniciarSesion_Opciones() {
		driver.findElement(By.xpath("//div[@class= 'toggle-menu']/button[@data-action='toggle-recover-form-login']")).click();
	}

	@When("introducir correo y password existentes Opciones")
	public void introducir_correo_y_password_existentes_Opciones() {
		driver.findElement(By.xpath("//div[@class='form-item']//input[@placeholder='EMAIL*']")).sendKeys("danieltqs1234@hotmail.com");
	    driver.findElement(By.xpath("//div[@class='form-item']//input[@placeholder='CONTRASEÑA*']")).sendKeys("DanielTQS1234");
	}

	@And("clicar a Iniciar Sesion  Opciones")
	public void clicar_a_Iniciar_Sesion_Opciones() {
		driver.findElement(By.xpath("//form[@action=\"/account/login\"]/button")).click();
	}

	@And("clicar Salir")
	public void clicar_Salir() {
		driver.findElement(By.xpath("//a[@href='/account/logout']")).click();	
	}

	@And("Opciones Mis pedidos")
	public void opciones_Mis_pedidos() {
		driver.findElement(By.xpath("//a[@href='/account?view=all_orders']")).click();		
	}

	@And("Opciones Mi Cuenta")
	public void opciones_Mi_Cuenta() {
		driver.findElement(By.xpath("//a[@href='/account']")).click();   
	}

	
	@Then("comprobar que estamos Opciones login")
	public void comprobar_que_estamos_Opciones_login() throws InterruptedException {
		
		Thread.sleep(2000);
		
		String Name = driver.findElement(By.xpath("//div[@class='bubble']/p[1]")).getText(); 
		Assert.assertEquals(Name, "Hola, Daniel");	
		System.out.println("Comprobar que estamos opciones login bien");
	}
	
	@Then("comprobar que ya no estamos Opciones")
	public void comprobar_que_ya_no_estamos_Opciones() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id=\"acco\"]")).click();
		String NoLogin = driver.findElement(By.xpath("//div[@class='bubble']/a")).getText();
		

		System.out.println("Aquiii "+NoLogin);
		Assert.assertEquals(NoLogin, "INICIAR SESIÓN");	
		System.out.println("Comprobar que ya no estamos opciones bien");
		
	    driver.close();
	    driver.quit();
	}
	
	@Then("comprobar que estamos en mis pedidos")
	public void comprobar_que_estamos_en_mis_pedidos() throws InterruptedException {
		Thread.sleep(2000);
		
		String Pedidos = driver.findElement(By.xpath("//h1[@class='section-title']")).getText(); 
		
		Assert.assertEquals(Pedidos, "MIS PEDIDOS");	
		System.out.println("Comprobar que estamos en mis pedidos bien");
				
	    driver.close();
	    driver.quit();
	}
	
	@Then("comprobar que estamos en Mi cuenta")
	public void comprobar_que_estamos_en_Mi_cuenta() throws InterruptedException {
		Thread.sleep(2000);
		
		String Welcome = driver.findElement(By.xpath("//p[@class='welcome']/span[1]")).getText(); 
		Assert.assertEquals(Welcome, "Hola,");	
		System.out.println("Comprobar que estamos en mi cuenta login bien");
		
	    driver.close();
	    driver.quit();
	}

}
