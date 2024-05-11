  #Autor:Andreina Iglesias
  #Opcion 1 para navegar con Chrome y 2 para navegar con Edge
  #Opciones 2, 3 y 4 en los pasos When, son para navegar en las pesatañas de opciones de Dragabble

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
    When accede a la seccion de acceso restringido en el navegador de dragabble 2
    And mueve los elementos uno horizontal y otro verticalmente
    Then deberian visualizarse en el lugar indicado

  @containerrestricted
  Scenario: Interaccion container restricted
    When accede a la seccion de contenedor restringido en el navegador de dragabble 3
    And mueve los elementos con contenedor restringido
    Then deberian figurar en el lugar indicado

  @cursorstyle
  Scenario: Interaccion cursor style
    When accede a la seccion en estilo de cursor en el navegador de dragabble 4
    And mueve los elementos
    Then deberia visualizar que se cambian de lugar
