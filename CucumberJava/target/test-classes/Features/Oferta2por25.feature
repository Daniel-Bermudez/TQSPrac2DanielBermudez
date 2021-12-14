Feature: Test Comprobar oferta dos por veinticinco 

  Scenario: Add dos productos iguales al carrito misma categoria
    Given abrir navegador oferta
    And entrar en la pagina web oferta
    And Categoria oferta
    And Producto1 oferta
    And LoQuiero oferta
    And Categoria oferta
    And Producto1 oferta
    And LoQuiero oferta
    And clicar Carrito oferta
    Then Comprobar si aplica la oferta mismo producto
    
   Scenario: Add dos productos diferentes al carrito misma categoria
    Given abrir navegador oferta
    And entrar en la pagina web oferta
     And Categoria oferta
    And Producto1 oferta
    And LoQuiero oferta
    And Categoria oferta
    And Producto2 oferta
    And LoQuiero oferta
    And clicar Carrito oferta
    Then Comprobar si aplica la oferta misma categoria
    
   Scenario: Add tres productos iguales al carrito misma categoria
    Given abrir navegador oferta
    And entrar en la pagina web oferta
    And Categoria oferta
    And Producto1 oferta
    And LoQuiero oferta
    And Categoria oferta
    And Producto1 oferta
    And LoQuiero oferta
    And Categoria oferta
    And Producto1 oferta
    And LoQuiero oferta
    And clicar Carrito oferta
    Then Comprobar si aplica la oferta al tener tres productos
