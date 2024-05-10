Feature:

  Background:
    Given El usuario esta en la pagina web de elements demoqa 1

    @nuevaPestaña
    Scenario: abrir link nueva pestaña
      Given el usuario esta en el apartado links de Elementos
      When el usuario hace clic en los enlaces Home y HomewXVOz
      Then se deberian redirigir al home de DemoQA correctamente

