Feature: Test Add Productos carrito

  Scenario: Add 3 productos iguales al carrito misma categoria
    Given abrir navegador Carrito 
    And entrar en la pagina web Carrito 
    And Categoria 
    And Producto1 
    And LoQuiero 
    And Categoria 
    And Producto1 
    And LoQuiero
    And Categoria
    And Producto1
    And LoQuiero
    And clicar Carrito 
    Then Comprobar productos carrito iguales
    
   Scenario: Add 3 productos diferentes al carrito misma categoria
    Given abrir navegador Carrito
    And entrar en la pagina web Carrito
    And Categoria
    And Producto1
    And LoQuiero
    And Categoria
    And Producto2
    And LoQuiero
    And Categoria
    And Producto3
    And LoQuiero
    And clicar Carrito
    Then Comprobar productos carrito distintos
    
   Scenario: Add 3 productos diferentes al carrito diferente categoria
    Given abrir navegador Carrito
    And entrar en la pagina web Carrito
    And Categoria
    And Producto1
    And LoQuiero
    And Categoria2
    And Producto2
    And LoQuiero
    And Categoria3
    And Producto3
    And LoQuiero
    And clicar Carrito
    Then Comprobar productos carrito distintos
    
