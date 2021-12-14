Feature: Test envio gratis

  Scenario: Suman envio gratis
    Given abrir navegador EG
    And entrar en la pagina web EG
    And Clicar Ropa
    And Clicar primer producto
    And Add al carrito EG
    And clicar incrementar
    And clicar incrementar
    And clicar incrementar
    And clicar incrementar
    And clicar incrementar
    And clicar incrementar
    Then Comprobar que el envio es gratis

  Scenario: No suman envio gratis
    Given abrir navegador EG
    And entrar en la pagina web EG
    And Clicar Ropa
    And Clicar primer producto
    And Add al carrito EG
    And clicar incrementar
    Then Comprobar que el envio no es gratis

  Scenario: Testear aviso de cuanto nos falta para envio gratis
    Given abrir navegador EG
    And entrar en la pagina web EG
    And Clicar Ropa
    And Clicar primer producto
    And Add al carrito EG
    And clicar incrementar
    Then Comprobar aviso
