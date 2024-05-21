# Johan Cifuentes

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
      | isbn          | title                                     | subTitle                                  | author               |
      | 9781449325862 | Git Pocket Guide                          | A Working Introduction                    | Richard E. Silverman |
      | 9781449331818 | Learning JavaScript Design Patterns       | A JavaScript and jQuery Developer's Guide | Addy Osmani          |
      | 9781449337711 | Designing Evolvable Web APIs with ASP.NET | Harnessing the Power of the Web           | Glenn Block et al.   |
      | 9781449365035 | Speaking JavaScript                       | An In-Depth Guide for Programmers         | Axel Rauschmayer     |
    And deberia recibir una respuesta exitosa con codigo 200

  @servicio
  Scenario Outline: Obtener libro utiizando el servicio GET de DemoQA
    When realiza la peticion GET correctamente ingresando el isbn "<isbn>"
    Then deberia ver el titulo "<title>"
    And deberia recibir una respuesta exitosa con codigo 200
    Examples:
      | isbn          | title                                     |
      | 9781449325862 | Git Pocket Guide                          |
      | 9781449331818 | Learning JavaScript Design Patterns       |
      | 9781449337711 | Designing Evolvable Web APIs with ASP.NET |

  @servicio
  Scenario Outline: Crear usuario utilizando servicio POST de DemoQA
    When realiza la peticion POST correctamente ingresando el usuario "<user>" y la contrasena "<contrasena>"
    Then deberia ver informacion al usuario creado
    And deberia recibir una respuesta exitosa con codigo 201
    Examples:
      | user                | contrasena        |
      | johan CifuentesAPI  | johan123$$ABC     |
      | jorge RodriguezAPI  | jorge123$$ABC     |
      | Pacho ValenzuelaAPI | pacho123$$ABCCool |


  @servicio
  Scenario Outline: Generar token de ingreso usando metodo POST con cuenta registrada
    When crea un usuario realizando una peticion el servicio POST con el usuario "<user>" y la contrasena "<contrasena>"
    When solicita un token ingresando las credenciales del usuario creado usando el metodo POST
    Then deberia generar un token de ingreso
    And deberia ser autorizado para entrar
    And deberia recibir una respuesta exitosa con codigo 200
    Examples:
      | user             | contrasena         |
      | Juan JoseAPI     | juan1111$$ABC      |
      | David BoneloAPI  | david2222$$ABC     |
      | Julio VasquezAPI | julio3333$$ABCCool |

  @servicio
  Scenario Outline: Intento de eliminar cuenta fallido por autorizacion usando metodo DELETE
    When el usuario hace uso del servicio delete e ingresa el siguiente id "<id>"
    Then deberia recibir un mensaje de usuario no autorizado
    And deberia recibir una respuesta fallida con codigo 401
    Examples:
      | id       |
      | abcde    |
      | effgsdas |

  @servicio
  Scenario Outline: Intento de eliminar libro fallido por autorizacion usando metodo DELETE
    When el usuario "<idUsuario>" intenta eliminar el libro con isbn "<isbn>"
    Then deberia recibir un mensaje de usuario no autorizado
    And deberia recibir una respuesta fallida con codigo 401
    Examples:
      | idUsuario     | isbn         |
      | usuario123    | isbnFallido  |
      | usuarioacbd12 | isbnFallido2 |

  @servicio
  Scenario Outline: Intento de actualizar libro fallido por autorizacion usando metodo PUT
    When el usuario "<idUsuario>" intenta actualizar el libro con isbn "<isbn>" ingresando un nuevo isbn "<newIsbn>"
    Then deberia recibir un mensaje de usuario no autorizado
    And deberia recibir una respuesta fallida con codigo 401
    Examples:
      | idUsuario     | isbn         | newIsbn        |
      | usuario123    | isbnFallido  | newisbnFallido |
      | usuarioacbd12 | isbnFallido2 | newisbnFallido |





