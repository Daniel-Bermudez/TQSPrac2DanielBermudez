Feature: Test Probar opciones Mi cuenta, Pedidos, Salir

  Scenario: Salir cuenta (Primero haremos login)
    Given abrir navegador Opciones
    And entrar en la pagina web Opciones
    And Opciones Opciones
    And IniciarSesion Opciones
    And Registrarse o IniciarSesion Opciones
    When introducir correo y password existentes Opciones
    And clicar a Iniciar Sesion  Opciones
    And Opciones Opciones
    Then comprobar que estamos Opciones login
    And clicar Salir
    And Opciones Opciones
    Then comprobar que ya no estamos Opciones

  Scenario: Mis pedidos (Primero haremos login, No tienes pedidos todavia)
    Given abrir navegador Opciones
    And entrar en la pagina web Opciones
    And Opciones Opciones
    And IniciarSesion Opciones
    And Registrarse o IniciarSesion Opciones
    When introducir correo y password existentes Opciones
    And clicar a Iniciar Sesion  Opciones
    And Opciones Opciones
    And Opciones Mis pedidos
    Then comprobar que estamos en mis pedidos


  Scenario: Mi cuenta (Primero haremos login)
     Given abrir navegador Opciones
    And entrar en la pagina web Opciones
    And Opciones Opciones
    And IniciarSesion Opciones
    And Registrarse o IniciarSesion Opciones
    When introducir correo y password existentes Opciones
    And clicar a Iniciar Sesion  Opciones
    And Opciones Opciones
    And Opciones Mi Cuenta
    Then comprobar que estamos en Mi cuenta

