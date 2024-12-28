package Menu_P;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Panel_Equipo extends JPanel implements ActionListener {

    private JButton botonRegistrar, botonActualizar, botonRegistrarPresidente;
    private JLabel label1, label2, label3, label4, labelPresidente;
    private JTextField texto1, textoPresidenteNombre, textoPresidenteApellido1, textoPresidenteApellido2;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scrollPane;
    private JComboBox<String> comboDirigente, comboCategoria, comboPresidente;
    private ArrayList<String> jugadores = new ArrayList<>();

    public Panel_Equipo(DefaultTableModel modeloTabla) {
        setLayout(null);

        // Campo para registrar el equipo
        label1 = new JLabel("Nombre");
        label1.setBounds(50, 20, 50, 20);
        add(label1);

        texto1 = new JTextField();
        texto1.setBounds(110, 20, 110, 20);
        add(texto1);

        label2 = new JLabel("Dirigente");
        label2.setBounds(50, 50, 50, 20);
        add(label2);

        comboDirigente = new JComboBox<>();
        comboDirigente.setBounds(110, 50, 110, 20);
        add(comboDirigente);
        actualizarComboDirigente();  // Cargar dirigentes del archivo

        label3 = new JLabel("Categoría");
        label3.setBounds(50, 80, 80, 20);
        add(label3);

        comboCategoria = new JComboBox<>(new String[]{"Primera", "Segunda"});
        comboCategoria.setBounds(110, 80, 110, 20);
        add(comboCategoria);

        label4 = new JLabel("Presidente");
        label4.setBounds(50, 110, 80, 20);
        add(label4);

        comboPresidente = new JComboBox<>();
        comboPresidente.setBounds(110, 110, 110, 20);
        add(comboPresidente);
        actualizarComboPresidente();  // Cargar presidentes del archivo

        botonRegistrar = new JButton("Registrar Equipo");
        botonRegistrar.setBounds(300, 20, 120, 30);
        add(botonRegistrar);
        botonRegistrar.addActionListener(this);

        botonActualizar = new JButton("Actualizar");
        botonActualizar.setBounds(300, 50, 100, 30);
        add(botonActualizar);
        botonActualizar.addActionListener(this);

        // Campos para registrar presidente
        labelPresidente = new JLabel("Nuevo Presidente");
        labelPresidente.setBounds(50, 150, 150, 20);
        add(labelPresidente);

        textoPresidenteNombre = new JTextField();
        textoPresidenteNombre.setBounds(110, 180, 110, 20);
        add(textoPresidenteNombre);

        textoPresidenteApellido1 = new JTextField();
        textoPresidenteApellido1.setBounds(110, 210, 110, 20);
        add(textoPresidenteApellido1);

        textoPresidenteApellido2 = new JTextField();
        textoPresidenteApellido2.setBounds(110, 240, 110, 20);
        add(textoPresidenteApellido2);

        botonRegistrarPresidente = new JButton("Registrar Presidente");
        botonRegistrarPresidente.setBounds(300, 180, 160, 30);
        add(botonRegistrarPresidente);
        botonRegistrarPresidente.addActionListener(this);

        // Tabla para equipos
        this.modeloTabla = modeloTabla;
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirigente");
        modeloTabla.addColumn("Categoría");
        modeloTabla.addColumn("Presidente");

        tabla = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(40, 280, 420, 200);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonActualizar) {
            actualizarComboDirigente();  // Actualizar la lista de dirigentes
            actualizarComboPresidente();  // Actualizar la lista de presidentes
        } else if (e.getSource() == botonRegistrar) {
            String nombre = primeraletra(texto1.getText());
            String dirigente = obtenerSeleccionComboBox(comboDirigente);
            String categoria = obtenerSeleccionComboBox(comboCategoria);
            String presidente = obtenerSeleccionComboBox(comboPresidente);

            if (nombre.isEmpty() || dirigente.isEmpty() || categoria.isEmpty() || presidente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.",
                        "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
            } else {
                // Verificación de jugadores según la categoría
                if (categoria.equals("Primera") && jugadores.size() > 24) {
                    JOptionPane.showMessageDialog(this,
                            "Un equipo de Primera no puede tener más de 24 jugadores.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (categoria.equals("Segunda") && jugadores.size() < 11) {
                    JOptionPane.showMessageDialog(this,
                            "Un equipo de Segunda debe tener al menos 11 jugadores.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                modeloTabla.addRow(new Object[]{nombre, dirigente, categoria, presidente});
                texto1.setText("");  // Limpiar el campo de texto
                jugadores.clear();  // Limpiar la lista de jugadores después de registrar el equipo
            }
        } else if (e.getSource() == botonRegistrarPresidente) {
            // Registrar el nuevo presidente
            String nombrePresidente = textoPresidenteNombre.getText().trim();
            String apellido1 = textoPresidenteApellido1.getText().trim();
            String apellido2 = textoPresidenteApellido2.getText().trim();

            if (nombrePresidente.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, complete todos los campos del presidente.",
                        "Error al agregar el presidente", JOptionPane.ERROR_MESSAGE);
            } else {
                Presidente presidente = new Presidente(nombrePresidente, apellido1, apellido2);
                Presidente.guardarPresidente(presidente);
                actualizarComboPresidente();  // Actualizar la lista de presidentes
                JOptionPane.showMessageDialog(this,
                        "Presidente registrado correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private String primeraletra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return palabra;
        }
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
    }

    private String obtenerSeleccionComboBox(JComboBox<String> comboBox) {
        Object seleccionado = comboBox.getSelectedItem();
        return seleccionado != null ? seleccionado.toString() : "";
    }

    public void actualizarComboDirigente() {
        comboDirigente.removeAllItems();
        ArrayList<String> listaDirigentes = cargarNombresDesdeArchivo("nombres_dirigentes.txt");

        if (listaDirigentes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista de dirigentes está vacía.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (String nombre : listaDirigentes) {
            if (nombre != null && !nombre.isEmpty()) {
                comboDirigente.addItem(nombre);
            }
        }
    }

    public void actualizarComboPresidente() {
        comboPresidente.removeAllItems();
        ArrayList<String> listaPresidentes = cargarNombresDesdeArchivo("nombres_presidentes.txt");

        if (listaPresidentes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista de presidentes está vacía.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (String nombre : listaPresidentes) {
            if (nombre != null && !nombre.isEmpty()) {
                comboPresidente.addItem(nombre);
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
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaNombres;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
