package co.com.sofka.util;

import co.com.sofka.model.FormularioModel;
import co.com.sofka.model.WebTableModel;

public class util {

    public static WebTableModel crearFila(String nombre, String apellido, String correo, Integer edad, Integer salario, String departamento){
        WebTableModel webTableModel = new WebTableModel();
        webTableModel.setNombre(nombre);
        webTableModel.setApellido(apellido);
        webTableModel.setCorreo(correo);
        webTableModel.setEdad(edad);
        webTableModel.setSalario(String.valueOf(salario));
        webTableModel.setDepartamento(departamento);
        return webTableModel;
    }

}
