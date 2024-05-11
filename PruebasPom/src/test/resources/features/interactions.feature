Feature:  Sortable successful

  Background:
    Given El usuario esta en la pagina web de interactions demoqa 1

  @SortableGrid
  Scenario: Interacción exitosa de ordenamiento en una cuadrícula
    When el usuario selecciona en la página de ordenamiento
    And organiza su lista
    Then debería ver la opción ordenada

  @SortableList
  Scenario: Interacción exitosa de ordenamiento en una lista
    And ordena la lista
    Then debería veria el nuevo orden de la lista
