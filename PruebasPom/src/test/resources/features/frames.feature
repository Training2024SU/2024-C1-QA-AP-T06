Feature:
  Yo como usuario de la aplicacion demoqa
  Quiero hacer uso de los frames
  para interactuar con la información que contiene adentro

  Background:
    Given El usuario esta en la pagina de inicio 1

  @frames
  Scenario: navegar dentro iframes
    When ingresa hasta el apartado de frames
    And navega dentro de los iframe presentes
    Then debería ver el mensaje dentro de los iframe

  @nestedFrames
  Scenario: navegar dentro de frames anidados
    When ingresa hasta el apartado de nested frames
    And navega dentro de los iframe anidados
    Then debería ver el mensaje dentro del iframe parent y iframe child