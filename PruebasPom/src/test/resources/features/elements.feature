Feature:

  Background:
    Given El usuario esta en la pagina web de elements demoqa 1

  @webtables
  Scenario Outline: agregar, actualizar y borrar tablas
    When usa el boton de add
    And llena el formulario con <nombre> <apellido> <correo> <edad> <salario> <departamento>
    And actualiza la fila con correo <correoActualizar> a datos random
    And elimina la fila con el correo <correoEliminar>
    Then deberia verse todos los cambios hechos en la tabla <correo> <nombre> <apellido>
    Examples:
      | nombre  | apellido   | correo              | edad | salario | departamento | correoActualizar     | correoEliminar      |
      | "jorge" | "de neiva" | "jorge@example.com" | 35   | 2000    | "CALIDAD"    | "cierra@example.com" | "alden@example.com" |

  @nuevaPestaña
  Scenario: abrir link nueva pestaña
    Given el usuario esta en el apartado links de Elementos
    When el usuario hace clic en los enlaces Home y HomewXVOz
    Then se deberian redirigir al home de DemoQA correctamente

  @CheckBox
  Scenario: Interacción con casillas de verificación
    Given el usuario accede a la sección de casillas de verificación
    When expande selecciona y reduce las casillas de verificación
    Then debería ver un mensaje con la cantidad de casillas seleccionadas
