Feature: modal dialog
  Yo como usuario de la aplicacion demoqa
  Quiero hacer uso de los modal dialog
  Para recibir mensajes pequeños y largos

  @modalDialogs
  Scenario: see modal dialogs
    Given El usuario esta en la pagina de inicio de demoqa 1
    When Navega hasta el apartado de modal dialogs
    And hace clic sobre los tipo de modal dialog
    Then deberia ver los titulos de los dialogos "Small Modal" "Large Modal"