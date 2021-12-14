Feature: Test Incrementar/Decrementar el mismo producto desde el carrito o borrarlo

  Scenario: Add 3 productos iguales al carrito y luego incrementar 1 desde carrito
    Given abrir navegador Carrito Inc/Dec
    And entrar en la pagina web Carrito Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And clicar Carrito Inc/Dec
    And Incrementar producto
    Then Comprobar Incremento

  Scenario: Add 3 productos iguales al carrito y luego decrementar 1 desde carrito
    Given abrir navegador Carrito Inc/Dec
    And entrar en la pagina web Carrito Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And clicar Carrito Inc/Dec
    And Decrementar producto
    Then Comprobar Decremento

  Scenario: Add 3 productos iguales al carrito y luego Borrarlo
    Given abrir navegador Carrito Inc/Dec
    And entrar en la pagina web Carrito Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And Categoria Inc/Dec
    And Producto1 Inc/Dec
    And LoQuiero Inc/Dec
    And clicar Carrito Inc/Dec
    And Borrar producto
    Then Comprobar Borrado
    
    
