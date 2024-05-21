Feature: Alertas
  Yo como usuario de la aplicacion demoqa
  Quiero hacer uso de las alertas
  Para notificar cosas importantes

  Background:
    Given que el usuario esta en la pagina de inicio

  @CasoClick
  Scenario: Alerta de click
    When ingresa hasta el apartado de alertas
    And clickea sobre la alerta de click
    Then debería ver una ventana emergente

  @CasoTimer
  Scenario: Alerta con timer
    When ingresa hasta el apartado de alertas
    And clickea sobre la alerta con timer
    Then debería ver una ventana emergente despues de cinco segundos

  @CasoConfirmacion
  Scenario: Alerta con confirmacion
    When ingresa hasta el apartado de alertas
    And clickea sobre la alerta con confirmacion
    Then debería ver una ventana emergente con una opcion de confirmar

  @CasoPrompt
  Scenario: Alerta con prompt
    When ingresa hasta el apartado de alertas
    And clickea sobre la alerta con prompt enviando el name Juan
    Then deberia observar la alerta con el nombre
