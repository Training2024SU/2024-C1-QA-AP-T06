package co.com.sofka.util;

import co.com.sofka.model.FormularioModel;
import co.com.sofka.model.WebTableModel;
import net.datafaker.Faker;

import java.util.List;

public class util {

    public static WebTableModel crearFila(String nombre, String apellido, String correo,
                                          Integer edad, Integer salario, String departamento) {
        WebTableModel webTableModel = new WebTableModel();
        webTableModel.setNombre(nombre);
        webTableModel.setApellido(apellido);
        webTableModel.setCorreo(correo);
        webTableModel.setEdad(edad);
        webTableModel.setSalario(String.valueOf(salario));
        webTableModel.setDepartamento(departamento);
        return webTableModel;
    }

    public static FormularioModel crearUsuario() {
        FormularioModel formularioModel = new FormularioModel();
        Faker faker = new Faker();
        formularioModel.setFirstName(faker.name().firstName());
        formularioModel.setLastName(faker.name().lastName());
        formularioModel.setMobile(faker.number().digits(10));
        formularioModel.setEmail(faker.internet().emailAddress());
        formularioModel.setBirth(faker.date().birthday());
        formularioModel.setSubjects("Maths");
        formularioModel.setSubjects("Commerce");
        formularioModel.setSubjects("Chemistry");
        formularioModel.setAddress(faker.address().fullAddress());
        formularioModel.setState("Uttar Pradesh");
        formularioModel.setCity("Agra");

        return formularioModel;
    }

    public static <T> T pickRandomItem(List<T> list) {
        int randomIdx = (int) Math.floor(Math.random() * list.size());
        return list.get(randomIdx);
    }
}
