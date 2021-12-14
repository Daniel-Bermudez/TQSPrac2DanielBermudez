Feature: Utilizar el buscador de la pagina

  Scenario: Utilizar el buscador con palabras con coincidencia
    Given abrir navegador Carrito Buscador 
    And entrar en la pagina web Carrito Buscador 
    And clicar buscador 
    And escribir buscador
    And enter buscador 
    Then Comprobar Buscador
    
  Scenario: Utilizar el buscador con palabras sin coincidencia
    Given abrir navegador Carrito Buscador
    And entrar en la pagina web Carrito Buscador
    And clicar buscador
    And escribir buscador2
    And enter buscador
    Then Comprobar Buscador2
    
   Scenario: Utilizar el buscador vacio
    Given abrir navegador Carrito Buscador
    And entrar en la pagina web Carrito Buscador
    And clicar buscador
    And enter buscador
    Then Comprobar Buscador3