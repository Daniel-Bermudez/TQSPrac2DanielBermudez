Feature: Test Registrar a un usuario

  Scenario: Registrar a un usuario con un user y password existente con nombre y apellido
    Given abrir navegador 
    And entrar en la pagina web 
    And Opciones 
    And Registrarse 
    And Registrarse IniciarSesion 
    When introducir nombre y password existentes
    And clicar a aceptar 
    Then usuario puede navegar por la pagina de inicio cuenta existente

  Scenario: Registrar a un usuario con un user y password nuevo con nombre y apellido
    Given abrir navegador
    And entrar en la pagina web
    And Opciones
    And Registrarse
    And Registrarse IniciarSesion
    When introducir nombre y password
    And clicar a aceptar
    Then usuario puede navegar por la pagina de inicio cuenta nueva
    
   Scenario: Registrar a un usuario con un user y password nuevo sin nombre y apellido
    Given abrir navegador
    And entrar en la pagina web
    And Opciones
    And Registrarse
    And Registrarse IniciarSesion
    When introducir Correo y password
    And clicar a aceptar
    Then Comprobar si deja registrarse sin nombre
