Feature: filtrar y buscar libros

  Background:
    Given el usuario esta en la pagina de demoqa Book Store 1


  Scenario Outline: buscar y reorganizar libros de la libreria
    When reorganiza los libros por autor
    And busca el nombre del libro por el nombre <nombre>
    Then deberia poder observar el libro de primero en la lista con su <autor>
    Examples:
      | nombre                                | autor          |
      | "Learning JavaScript Design Patterns" | "Addy Osmani"  |
      | "You Don't Know JS"                   | "Kyle Simpson" |