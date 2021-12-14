Feature: Test Login a un usuario

  Scenario: Login a un usuario con un user y password existente
    Given abrir navegador login
    And entrar en la pagina web login
    And Opciones login
    And IniciarSesion login
    And Registrarse o IniciarSesion
    When introducir correo y password existentes
    And clicar a Iniciar Sesion
    Then Comprobar login correcto

  Scenario: Login a un usuario con un user y password nuevos
    Given abrir navegador login
    And entrar en la pagina web login
    And Opciones login
    And IniciarSesion login
    And Registrarse o IniciarSesion
    When introducir correo y password nuevos
    And clicar a Iniciar Sesion
    Then Comprobar login incorrecto

  Scenario: Login password olvidado
    Given abrir navegador login
    And entrar en la pagina web login
    And Opciones login
    And IniciarSesion login
    And Registrarse o IniciarSesion
    And clicar a password olvidada
    Then Comprobar pantalla escribe tu email
