package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = null;
	
	@Given("abrir navegador login")
	public void abrir_navegador_login() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	}

	@And("entrar en la pagina web login")
	public void entrar_en_la_pagina_web_login() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("Opciones login")
	public void Opciones_login() throws InterruptedException {
		 driver.findElement(By.xpath("//a[@id=\"acco\"]")).click();
	}
	
	@And("IniciarSesion login")
	public void iniciarsesion_login() {
		//driver.findElement(By.xpath("//div[@class= 'bubble']/a")).click();
		driver.findElement(By.xpath("//p[@class= 'acc-text']/a")).click();
	}

	@And("Registrarse o IniciarSesion")
	public void Registrarse_o_IniciarSesion() {
		driver.findElement(By.xpath("//div[@class= 'toggle-menu']/button[@data-action='toggle-recover-form-login']")).click();
	}
	@When("introducir correo y password existentes")
	public void introducir_correo_y_password_existentes() {
		driver.findElement(By.xpath("//div[@class='form-item']//input[@placeholder='EMAIL*']")).sendKeys("danieltqs1234@hotmail.com");
	    driver.findElement(By.xpath("//div[@class='form-item']//input[@placeholder='CONTRASEÑA*']")).sendKeys("DanielTQS1234");	
	}
	@When("introducir correo y password nuevos")
	public void introducir_correo_y_password_nuevos() {
		driver.findElement(By.xpath("//div[@class='form-item']//input[@placeholder='EMAIL*']")).sendKeys("danieltqs12349@hotmail.com");
	    driver.findElement(By.xpath("//div[@class='form-item']//input[@placeholder='CONTRASEÑA*']")).sendKeys("DanielTQS1234");	
	}
	@And("clicar a Iniciar Sesion")
	public void clicar_a_Iniciar_Sesion() {
		driver.findElement(By.xpath("//form[@action=\"/account/login\"]/button")).click();
	}
	
	@And("clicar a password olvidada")
	public void clicar_a_password_olvidada() {
		driver.findElement(By.xpath("//p[@id='pass-recover']")).click();
		
	}
	
	@Then("Comprobar login correcto")
	public void Comprobar_login_correcto() throws InterruptedException {
		Thread.sleep(2000);
		
		String a=driver.getCurrentUrl();
		System.out.println(a);
		Assert.assertEquals(a, "https://latiendadevalentina.com/account");
		System.out.println("Comprobación url completada correctamente");
		
		String b = driver.findElement(By.xpath("//p[@class=\"welcome\"]/span[2]")).getText();
		System.out.println(b);
		Assert.assertEquals(b, "Daniel TQS");
		System.out.println("Comprobacion mensaje bienvenida login completada Correctamente");
				
	    driver.close();
	    driver.quit();
	}
	@Then("Comprobar login incorrecto")
	public void Comprobar_login_incorrecto() throws InterruptedException {
		Thread.sleep(2000);
		
		String a=driver.getCurrentUrl();
		System.out.println(a);
		Assert.assertEquals(a, "https://latiendadevalentina.com/account/login");
		System.out.println("Ha completado el assert");
		
		 
		String X= driver.findElement(By.xpath("//form[@action='/account/login']/p[1]")).getText();
		System.out.println(X);
		Assert.assertEquals(X,"Correo electrónico o contraseña incorrectos.");
			
		
		System.out.println("Cierra navegador");
		
	    driver.close();
	    driver.quit();
	}
	
	@Then("Comprobar pantalla escribe tu email")
	public void Comprobar_pantalla_escribe_tu_email() throws InterruptedException {
		Thread.sleep(2000);
		
		String Mensaje= driver.findElement(By.xpath("//p[@class='form-text']")).getText();
		Assert.assertEquals(Mensaje,"Escribe tu email y te mandaremos un correo con las instrucciones a seguir para restablecer tu contraseña");
		
		
	    driver.close();
	    driver.quit();
	}
	
	
	
	/*
	@Test
	public void Login_cuenta_existente() throws InterruptedException {
		
		abrir_navegador_login();
		entrar_en_la_pagina_web_login();
		Opciones_login();
		iniciarsesion_login();
		Registrarse_o_IniciarSesion();
		introducir_correo_y_password_existentes();
		clicar_a_Iniciar_Sesion();
		
		String a = driver.getCurrentUrl();
		String b = driver.findElement(By.xpath("//p[@class=\"welcome\"]/span[2]")).getText();
		//System.out.println(a);
		
		Assert.assertEquals(b, "Daniel TQS");
		if(b == "Daniel TQS")
		{
			Assert.assertTrue("Login correcto", true);
		}
		Assert.assertEquals(a, "https://latiendadevalentina.com/account");
		
		
		usuario_puede_navegar_por_la_pagina_de_inicio_login_existente();
			
	}*/
}
