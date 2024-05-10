Feature:
  Yo como usuario de la aplicacion demoqa
  Quiero hacer uso de los frames
  para interactuar con la información que contiene adentro

  Background:
    Given El usuario esta en la pagina de inicio 1
    When ingresa hasta el apartado de frames
  @frames
  Scenario: navegar dentro iframes
    And navega dentro de los iframe presentes
    Then debería ver el mensaje dentro de los iframe