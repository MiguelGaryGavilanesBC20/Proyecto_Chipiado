package Menu_P;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Presidente {

    private String nombre;
    private String apellido1;
    private String apellido2;

    public Presidente(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    // Método para guardar un presidente en un archivo
    public static void guardarPresidente(Presidente presidente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nombres_presidentes.txt", true))) {
            writer.write(presidente.getNombre() + " " + presidente.getApellido1() + " " + presidente.getApellido2());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar presidentes desde un archivo
    public static String cargarPresidentes() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("nombres_presidentes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return nombre + " " + apellido1 + " " + apellido2;
    }
}
