Feature: Test enlaces extras de Valentina

  Scenario: Testear enlace ValentinaTV
    Given abrir navegador enlaces
    And entrar en la pagina web enlaces
    And clicar Valentina
    And clicar ValentinaTV
    And clicar primervideo
    Then Comprobar que estamos pagina de videos tv

  Scenario: Testear Newsletter subscripcion
    Given abrir navegador enlaces
    And entrar en la pagina web enlaces
    And clicar Valentina
    And clicar newsletter
    And introducir email
    Then Comprobar que se ha validado correctamente

  Scenario: Testear web de tiendas y si la primera es Madrid
    Given abrir navegador enlaces
    And entrar en la pagina web enlaces
    And clicar Valentina
    And clicar tiendaFisica
    And clicar primera tienda
    Then Comprobar que la primera tienda esta en Madrid
