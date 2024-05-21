Feature: Elements DemoQA

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


  @TextBox
  Scenario Outline: Llenar un formulario de contacto
    When ingresa a la pagina del formulario
    And El usuario llena el formulario con la siguiente informacion:

      | Full Name | Email    | Current Address    | Permanent Address      |
      | <nombre>  | <correo> | <direccion_actual> | <direccion_permanente> |

    Then El usuario debería ver un mensaje de confirmacion de envío

    Examples:
      | nombre          | correo          | direccion_actual   | direccion_permanente   |
      | Francisco Pacho | pacho@gmail.com | Dirección actual 1 | Dirección permanente 1 |
      | Johan Lucas     | johan@gmail.com | Dirección actual 2 | Dirección permanente 2 |
      | Juan Bautista   | juan@gmail.com  | Dirección actual 3 | Dirección permanente 3 |

  @CheckBox
  @Elements
  Scenario: Interacción con casillas de verificación
    Given el usuario accede a la sección de casillas de verificación
    When expande selecciona y reduce las casillas de verificación
    Then debería ver un mensaje con la cantidad de casillas seleccionadas

  @Radio
  @Elements
  Scenario: Interacción con radio button
    Given el usuario accede a la sección de botones de radio
    When selecciona las opciones de radio
    Then debería ver un mensaje correspondiente al boton de radio seleccionado

  @linkElement
  @nuevaPestaña
  Scenario: abrir link nueva pestaña
    Given el usuario navega al apartado links de Elementos
    When el usuario hace clic en los enlaces Home y HomewXVOz
    Then se deberia estar en el apartado links de elementos luego de abrir la pestaña de los enlaces Home y HomewXVOz

  @linkElement
  @linkApi
  Scenario: interaccion links api call
    Given el usuario navega al apartado links de Elementos
    When el usuario hace click en todas los link de api call
    Then se deberia mostrar en pantalla un mensaje con la respuesta de la api


  @BrokenLinkImagen
  @LinkValido
  Scenario: Verificando funcionamientos de links y imagenes

    When el usuario esta ubicado en la seccion de links e imagenes
    And el usuario selecciona una imagen o link
    Then deberia de mostrar su correspondiente alerta como buena o rota

  @BrokenLinkImagen
  @LinkInvalido
  Scenario: Verificando funcionamientos de links y imagenes

    When  el usuario esta ubicado en la seccion de links e imagenes
    And el usuario selecciona un link invalido
    Then deberia de mostrar su correspondiente alerta de link invalido

  @BrokenLinkImagen
  @ImagenValida
  Scenario: Verificando funcionamientos de links y imagenes

    When  el usuario esta ubicado en la seccion de links e imagenes
    And el usuario selecciona un puede ver una imagen valida
    Then deberia de mostrar su correspondiente alerta de imagen valida

  @BrokenLinkImagen
  @ImagenInvalida
  Scenario: Verificando funcionamientos de links y imagenes

    When  el usuario esta ubicado en la seccion de links e imagenes
    And el usuario selecciona un no puede ver una imagen valida
    Then deberia de mostrar su correspondiente alerta de imagen invalido



    @BottonClick
  Scenario: Prueba de click en el boton
    When hace click en el boton
    Then deberia ver el mensaje de click


  @BottonClickDerecho
  Scenario: Prueba de click derecho en el boton
    When hace click derecho en el boton
    Then deberia ver el mensaje de click derecho


  @BottonDobleClick
  Scenario: Prueba de doble click en el boton
    When hace doble click en el boton
    Then deberia ver el mensaje de doble click

  @DavidTearDown
  Scenario: Propiedades dinamicas
    When El usuario accede a la opción de propiedades dinámicas
    And Espera a que las propiedades de los elementos cambien
    Then debería ver los elementos actualizarse








