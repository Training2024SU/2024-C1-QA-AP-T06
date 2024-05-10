@DavidTearDown
Feature: Pestañas y ventanas

  Background:
    Given El usuario esta en la pagina de ventanas de navegador 3

  Scenario: Abrir una nueva pestaña
    When abre una nueva pestaña
    Then debería ver una nueva pestaña con un mensaje

  Scenario: Abrir una nueva ventana
    When abre una nueva ventana
    Then debería ver una nueva ventana con un mensaje

  Scenario: Abrir una nueva ventana de mensaje
    When abre una nueva ventana de mensaje
    Then debería ver una nueva ventana de mensaje