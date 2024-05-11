Feature: Resimensionar en la sección de resize en demoQA

  Yo como usuario de la página demoQA
  Quiero resimensionar elementos en la sección de resize
  Para interactuar con ellos

  Background:
    Given El usuario esta en la pagina web de interacciones de demoqa 1

  @redimensionarCajas
  Scenario: redimenzionar cajas diferente tamaño
    Given selecciona la opcion Resizable
    When el usuario redimenziona las cajas
    Then las cajas deberian visualizarse del tamaño correctamente dimensionado