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

    @authentication
  Scenario Outline: Registro e inicio de sesion exitoso
    When el usuario ingresa sus crendenciales de registro user "<user>" y la contrasena "<contrasena>"
    And ingresa nuevamente sus credenciales para iniciar sesion
    Then deberia estar dentro de la pagina como usuario registrado
    Examples:
      | user                | contrasena        |
      | johan CifuentesAPI  | johan123$$ABC     |
      | jorge RodriguezAPI  | jorge123$$ABC     |
      | Pacho ValenzuelaAPI | pacho123$$ABCCool |