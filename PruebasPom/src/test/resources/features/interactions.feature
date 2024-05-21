Feature: Interacciones

  Background:
    Given El usuario esta en la pagina web de interactions demoqa 1

  @DavidTearDown
  Scenario Outline: Seleccionar elementos de una lista
    Given El usuario accede a la opción de seleccionables
    When selecciona los elementos <posiciones_seleccion>
    And des-selecciona los items <posiciones_des-seleccion>
    Then debería ver seleccionados los elementos <posiciones_seleccionadas>
    Examples:
      | posiciones_seleccion | posiciones_des-seleccion | posiciones_seleccionadas |
      | [1, 3, 4]            | [3]                      | [1, 4]                   |
      | [2, 1]               | [2]                      | [1]                      |

  @DavidTearDown
  Scenario: Seleccionar elementos en una rejilla
    Given El usuario accede a la opción de seleccionables
    When selecciona y des-selecciona varios elementos
    Then debería ver los elementos seleccionados correctamente

  @SortableGrid
  Scenario: Interacción exitosa de ordenamiento en una cuadrícula
    When el usuario selecciona en la página de ordenamiento
    And organiza su lista
    Then debería ver la opción ordenada

  @SortableList
  Scenario: Interacción exitosa de ordenamiento en una lista
    And ordena la lista
    Then debería veria el nuevo orden de la lista
