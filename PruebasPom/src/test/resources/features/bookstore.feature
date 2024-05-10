Feature: Books Store

  Como usuario de la página de DemoQA,
  Quiero acceder a la librería
  Para utilizar sus servicios y explorar los libros disponibles.


  Background:
    Given el usuaro tiene acceso a los servicios de la biblioteca en DemoQA

  @servicio
  Scenario: Obtener todos los libros utilizando el servicio GET de DemoQA
    When realiza la peticion GET correctamente para obtener todos los libros
    Then deberia ver los siguentes libros ofrecidos en la pagina
      | isbn          | title                               | subTitle                                  | author               |
      | 9781449325862 | Git Pocket Guide                    | A Working Introduction                    | Richard E. Silverman |
      | 9781449331818 | Learning JavaScript Design Patterns | A JavaScript and jQuery Developer's Guide | Addy Osmani          |
    And deberia recibir una respuesta exitosa con codigo 200