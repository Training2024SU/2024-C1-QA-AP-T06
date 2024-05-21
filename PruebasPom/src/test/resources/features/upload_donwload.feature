Feature: Elements DemoQA

  Background:
    Given El usuario esta en la pagina web de elements demoqa 4


  @UploadAndDownloand
@Upload

Scenario: Verificar funcionamientos de Upload

When  el usuario esta ubicado en la seccion de Upload y downloand
And el usuario selecciona un archivo y lo carga
Then deberia de mostrar el archivo que lo carga

@UploadAndDownloand
@Downloand
Scenario: Verificar funcionamientos de Upload

When  el usuario esta ubicado en la seccion de Upload y downloand
And el usuario descarga archivo
Then deberia de mostrar el archivo que lo descarga
