Feature: Formulario de incripcion
  yo como usario de la aplicación demoga
  quiero llenar el formulario de incripcion
  para obtener los beneficios de la pagina

  Background:
    Given El usuario esta en la pagina web de forms demoqa 1
    And   And el usuario navega al apartado Practice Form de forms

    @practiceForm
  Scenario: inscripcion correcta
    When ingresa su informacion correctamente
    And envia el formulario
    Then deberia observar un mensaje de registro exitoso con la información ingresada

