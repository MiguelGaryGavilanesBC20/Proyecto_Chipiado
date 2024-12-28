package Menu_P;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Panel_Jugador extends JPanel implements ActionListener {

    private JButton boton1, boton2;
    private JLabel label1, label2, label3, label4;
    private JTextField texto1, texto2, texto3;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scrollPane;
    private JComboBox<String> comboEquipo;

    public Panel_Jugador(DefaultTableModel modeloTabla) {
        setLayout(null);

        label1 = new JLabel("Nombre");
        label1.setBounds(50, 20, 50, 20);
        add(label1);

        texto1 = new JTextField();
        texto1.setBounds(110, 20, 110, 20);
        add(texto1);

        label2 = new JLabel("Apellido");
        label2.setBounds(50, 50, 50, 20);
        add(label2);

        texto2 = new JTextField();
        texto2.setBounds(110, 50, 110, 20);
        add(texto2);

        label3 = new JLabel("Fecha de Nacimiento");
        label3.setBounds(50, 80, 130, 20);
        add(label3);

        texto3 = new JTextField();
        texto3.setBounds(180, 80, 110, 20);
        add(texto3);

        label4 = new JLabel("Equipo");
        label4.setBounds(50, 110, 50, 20);
        add(label4);

        comboEquipo = new JComboBox<>();
        comboEquipo.setBounds(110, 110, 110, 20);
        add(comboEquipo);

        // Actualizar el combo de equipos
        actualizarComboEquipo();

        boton1 = new JButton("Registrar");
        boton1.setBounds(300, 20, 100, 30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Actualizar");
        boton2.setBounds(300, 50, 100, 30);
        add(boton2);
        boton2.addActionListener(this);

        this.modeloTabla = modeloTabla;
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Fecha de Nacimiento");
        modeloTabla.addColumn("Equipo");

        tabla = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(40, 160, 420, 200);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton2) {
            actualizarComboEquipo();  // Actualizar lista de equipos
        } else if (e.getSource() == boton1) {
            String nombre = primeraletra(texto1.getText());
            String apellido = primeraletra(texto2.getText());
            String fechaNacimiento = texto3.getText();
            String equipo = obtenerSeleccionComboBox();

            // Validación de los campos
            if (nombre.isEmpty() || apellido.isEmpty() || fechaNacimiento.isEmpty() || equipo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.",
                        "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
            } else {
                if (validarFecha(fechaNacimiento)) {
                    // Se agrega la fila a la tabla si la fecha es válida
                    modeloTabla.addRow(new Object[]{nombre, apellido, fechaNacimiento, equipo});
                    texto1.setText("");
                    texto2.setText("");
                    texto3.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "La fecha no tiene un formato válido." +
                            " Use dd/MM/yyyy", "Error de fecha", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private String primeraletra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return palabra;
        }
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
    }

    private String obtenerSeleccionComboBox() {
        Object seleccionado = comboEquipo.getSelectedItem();
        return seleccionado != null ? seleccionado.toString() : "";
    }

    public void actualizarComboEquipo() {
        comboEquipo.removeAllItems();
        ArrayList<String> listaEquipos = cargarNombresDesdeArchivo("nombres_equipos.txt");

        if (listaEquipos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista de equipos está vacía.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (String nombre : listaEquipos) {
            if (nombre != null && !nombre.isEmpty()) {
                comboEquipo.addItem(nombre);
            }
        }
    }

    private ArrayList<String> cargarNombresDesdeArchivo(String archivo) {
        ArrayList<String> listaNombres = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String nombre;
            while ((nombre = reader.readLine()) != null) {
                if (!nombre.trim().isEmpty()) {
                    listaNombres.add(nombre);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaNombres;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    // Método para validar la fecha en formato dd/MM/yyyy
    private boolean validarFecha(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
