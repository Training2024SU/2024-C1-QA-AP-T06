Feature: Elements

  Background:
    Given El usuario esta en la pagina web de elements demoqa 1

  @CheckBox
  Scenario: Interacción con casillas de verificación
    Given el usuario accede a la sección de casillas de verificación
    When expande selecciona y reduce las casillas de verificación
    Then debería ver un mensaje con la cantidad de casillas seleccionadas

  @Radio
  Scenario: Interacción con radio button
    Given el usuario accede a la sección de botones de radio
    When selecciona las opciones de radio
    Then debería ver un mensaje correspondiente al boton de radio seleccionado

