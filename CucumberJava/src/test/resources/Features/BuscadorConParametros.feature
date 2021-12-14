Feature: Test Concretar productos con parametros Tipo talla

  Scenario: Seleccionar productos concretos por talla incorrecta
    Given abrir navegador Parametro
    And entrar en la pagina web Parametro 
    And Clicar Categoria
    And Clicar talla
    And Elegir talla
    And Abrir producto1
    And Add al carro
    Then Comprobar prendas se ajustan a la talla dada desde el carro incorrecto
    
   Scenario: Seleccionar productos concretos por talla correcta
    Given abrir navegador Parametro
    And entrar en la pagina web Parametro 
    And Clicar Categoria
    And Clicar talla
    And Elegir talla
    And Abrir producto1
    And Especificar_talla
    And Add al carro
    Then Comprobar prendas se ajustan a la talla dada desde el carro
    
  Scenario: Seleccionar productos concretos por tipo de prenda
    Given abrir navegador Parametro 
    And entrar en la pagina web Parametro 
    And Clicar Categoria
    And Clicar Tipo Prenda
    And Elegir Tipo Prenda
    And Abrir producto1
    And Add al carro
    Then Comprobar prendas se ajustan al tipo de prenda dada desde el carro
    