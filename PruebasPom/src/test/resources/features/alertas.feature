Feature: Alertas
  Yo como usuario de la aplicacion demoqa
  Quiero hacer uso de las alertas
  Para notificar cosas importantes

  Background:
    Given que el usuario esta en la pagina de inicio
    When ingresa hasta el apartado de alertas

  @CasoClick
  Scenario: Alerta de click
    And clickea sobre la alerta de click
    Then debería ver una ventana emergente

  @CasoTimer
  Scenario: Alerta con timer
    And clickea sobre la alerta con timer
    Then debería ver una ventana emergente despues de cinco segundos

  @CasoConfirmacion
  Scenario: Alerta con confirmacion
    And clickea sobre la alerta con confirmacion
    Then debería ver una ventana emergente con una opcion de confirmar

  @CasoPrompt
  Scenario: Alerta con prompt
    And clickea sobre la alerta con prompt enviando el name Juan
    Then deberia observar la alerta con el nombre
