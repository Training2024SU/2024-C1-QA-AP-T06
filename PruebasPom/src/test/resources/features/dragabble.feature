  #Autor:Andreina Iglesias
  #Opcion 1 para navegar con Chrome y 2 para navegar con Edge
  #Opciones 2, 3 y 4 en el paso When, son para navegar en las pesatañas de Dragabble

  Feature: Arrastre en la sección de Dragabbles en demoQA

  Yo como usuario de la página demoQA
  Quiero arrastrar elementos en la sección de Dragabbles
  Para interactuar con ellos

  Background:
    Given El usuario esta en la pagina web de interacciones de demoqa 1
    And selecciona la opcion Dragabble

  @simple
  Scenario: Interaccion draggable simple
    When mueve el elemento
    Then deberia visualizarse en el lugar indicado

  @axisrestricted
  Scenario: Interaccion axis restricted
    When accede a la ventana simple en el navegador de draggable 2
    And mueve los elementos uno horizontal y otro verticalmente
    Then deberian visualizarse en el lugar indicado

  @containerrestricted
  Scenario: Interaccion container restricted
    When accede a la ventana container restricted en el navegador de draggable 3
    And mueve los elementos con contenedor restringido
    Then deberian figurar en el lugar indicado

  @cursorstyle
  Scenario: Interaccion cursor style
    When accede a la ventana cursor style en el navegador de draggable 4
    And mueve los elementos
    Then deberia visualizar que se cambian de lugar
