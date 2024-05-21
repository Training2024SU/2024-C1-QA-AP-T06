Feature: prueba de los Widgets
  yo como usuario de la página dmoqa
  quiero poder utilizar los widgets
  para disfrutar todos sus beneficios

  Background:
    Given El usuario esta en la pagina web de widgets demoqa 1

  @accordian
  Scenario: prueba de Accordian
    Given el usuario se dirige a la página widget Accordian
    When quiere utilizar el Accordian
    Then deberia moverse automaticamente

  @autocomplete
  Scenario: prueba de Auto complete
    Given el usuario se dirige a la página widget Auto complete
    When quiere utilizar el auto complete "Aq" "bla"
    Then deberia completarse automaticamente

  @tabs
  Scenario: interaccion con tabs
    When se dirije a la pagina tabs
    Then deberia poder interactuar con los elementos de la pagina

  @Fechas
  Scenario Outline: Seleccionar fecha
    Given El usuario accede a los widgets de fecha y hora
    When selecciona la fecha: "<fecha>"
    Then debería ver el campo de fecha llenado con "<textoFecha>"
    Examples:
      | fecha      | textoFecha |
      | 1985-07-15 | 07/15/1985 |
      | 2075-03-10 | 03/10/2075 |
      | 2099-12-31 | 12/31/2099 |

  @FechaHora
  Scenario Outline: Seleccionar fecha y hora
    Given El usuario accede a los widgets de fecha y hora
    When selecciona la fecha y hora: "<fechaHora>"
    Then debería ver el campo de fechaHora llenado con "<textoFechaHora>"
    Examples:
      | fechaHora        | textoFechaHora             |
      | 2024-04-30T12:30 | April 30, 2024 12:30 PM    |
      | 2035-09-15T15:45 | September 15, 2035 3:45 PM |
      | 2015-11-20T09:00 | November 20, 2015 9:00 AM  |

  @tool
  Scenario Outline: interaccion con elementos tool Tips
    When se dirije a la pagina toolTips
    And ingresa el texto "<texto>" en el campo de texto
    Then deberia ver el texto ingresado en el campo
    Examples:
      | texto                     |
      | El texto esta en el campo |

  @menu
  Scenario: prueba de la interaccion de menu
    Given el usuario se dirige a la página widget menu
    When quiere navegar por el menu
    Then deberia visualizarse el menu correcto

  @selectMenu
  Scenario: llenar campos select menu
    When se dirije a la pagina select menu
    And completa todos los campos
    Then deberia poder ver toda la infomacion ingresada

  @progressBar
  Scenario: Activar la barra de progreso exitosamente
    When se dirije a la pagina Progress bar
    And usa el boton Start
    And pausa la barra de progreso
    And la activa otra vez
    Then deberia terminar de cargar la barra completa y ver la palabra "Reset" y "100%"

