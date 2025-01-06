package Menu_P;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Jugador {
    private String nombre;
    private int edad;
    private String cedula;
    private String posicion;
    private int goles;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int minutosJugados;
    private String fechaContrato;
//
public Jugador(String nombre, int edad, String cedula, String posicion, int goles, int tarjetasAmarillas, int tarjetasRojas, int minutosJugados, String fechaContrato) {
    this.nombre = nombre;
    this.edad = edad;
    this.cedula = cedula;
    this.posicion = posicion;
    this.goles = goles;
    this.tarjetasAmarillas = tarjetasAmarillas;
    this.tarjetasRojas = tarjetasRojas;
    this.minutosJugados = minutosJugados;
    this.fechaContrato = fechaContrato;
}

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
}





public class Panel_Jugador extends JPanel implements ActionListener {

    private List<Jugador> listaJugadores;
    private DefaultTableModel modeloTabla1;
    private JTextField txtNombre, txtEdad, txtCedula, txtAnio, txtGoles, txtTarjetasAmarillas, txtTarjetasRojas, txtMinutosJugados;
    private JButton btnRegistrar;
    private JTable tablaJugadores;
    private JComboBox<String> cmbPosicion,cmbDia,cmbMes;

    public Panel_Jugador(DefaultTableModel modeloTabla1) {
        this.listaJugadores = new ArrayList<>();
        this.modeloTabla1 = modeloTabla1;

        setLayout(null);

        // Panel de registro
        JLabel lbNombre = new JLabel("Nombre");
        lbNombre.setBounds(50, 20, 120, 20);
        add(lbNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(180, 20, 150, 20);
        add(txtNombre);

        JLabel lbEdad = new JLabel("Edad");
        lbEdad.setBounds(370, 20, 50, 20);
        add(lbEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(430, 20, 50, 20);
        add(txtEdad);

        JLabel lbPosicion = new JLabel("Posición");
        lbPosicion.setBounds(370, 50, 120, 20);
        add(lbPosicion);

        cmbPosicion = new JComboBox<>(new String[]{
            "Delantero", "Mediocampista", "Defensor", "Portero"
        });
        cmbPosicion.setBounds(430, 50, 150, 20);
        add(cmbPosicion);

        JLabel lbCedula = new JLabel("Cédula");
        lbCedula.setBounds(50, 50, 120, 20);
        add(lbCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(180, 50, 150, 20);
        add(txtCedula);

        JLabel lbFechaContrato = new JLabel("Fecha de Contrato");
        lbFechaContrato.setBounds(50, 80, 120, 20);
        add(lbFechaContrato);

        cmbDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            cmbDia.addItem(String.valueOf(i));
        }
        cmbDia.setBounds(180, 80, 50, 20);
        add(cmbDia);

        cmbMes = new JComboBox<>(new String[]{
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        });
        cmbMes.setBounds(240, 80, 100, 20);
        add(cmbMes);

        txtAnio = new JTextField();
        txtAnio.setBounds(360, 80, 80, 20);
        add(txtAnio);
        txtAnio.setText("Año");

        JLabel lbGoles = new JLabel("Goles");
        lbGoles.setBounds(50, 110, 120, 20);
        add(lbGoles);

        txtGoles = new JTextField();
        txtGoles.setBounds(180, 110, 50, 20);
        add(txtGoles);

        JLabel lbTarjetasAmarillas = new JLabel("Tarjetas Amarillas");
        lbTarjetasAmarillas.setBounds(250, 110, 120, 20);
        add(lbTarjetasAmarillas);

        txtTarjetasAmarillas = new JTextField();
        txtTarjetasAmarillas.setBounds(380, 110, 50, 20);
        add(txtTarjetasAmarillas);

        JLabel lbTarjetasRojas = new JLabel("Tarjetas Rojas");
        lbTarjetasRojas.setBounds(450, 110, 120, 20);
        add(lbTarjetasRojas);

        txtTarjetasRojas = new JTextField();
        txtTarjetasRojas.setBounds(580, 110, 50, 20);
        add(txtTarjetasRojas);

        JLabel lbMinutosJugados = new JLabel("Minutos Jugados");
        lbMinutosJugados.setBounds(50, 140, 120, 20);
        add(lbMinutosJugados);

        txtMinutosJugados = new JTextField();
        txtMinutosJugados.setBounds(180, 140, 50, 20);
        add(txtMinutosJugados);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(650, 15, 100, 30);
        add(btnRegistrar);
        btnRegistrar.addActionListener(this);

        // Configurar modelo de la tabla
        this.modeloTabla1.addColumn("Nombre");
        this.modeloTabla1.addColumn("Edad");
        this.modeloTabla1.addColumn("Cédula");
        this.modeloTabla1.addColumn("Posición");
        this.modeloTabla1.addColumn("Goles");
        this.modeloTabla1.addColumn("Amarillas");
        this.modeloTabla1.addColumn("Rojas");
        this.modeloTabla1.addColumn("Minutos Jugados");
        this.modeloTabla1.addColumn("Fecha de Contrato");

        

        // Tabla de jugadores
        tablaJugadores = new JTable(modeloTabla1) {
            @Override
            protected void processMouseEvent(java.awt.event.MouseEvent e) {
                // Deshabilitar cualquier interacción con clics
            }
        };
        tablaJugadores.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(tablaJugadores);
        scrollPane.setBounds(20, 180, 1100, 230);
        add(scrollPane);

        cargarDatosDesdeArchivo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            String nombre = txtNombre.getText();
            String edadTexto = txtEdad.getText();
            String cedula = txtCedula.getText();
            String posicion = (String) cmbPosicion.getSelectedItem();
            String golesTexto = txtGoles.getText();
            String tarjetasAmarillasTexto = txtTarjetasAmarillas.getText();
            String tarjetasRojasTexto = txtTarjetasRojas.getText();
            String minutosJugadosTexto = txtMinutosJugados.getText();
            String dia = (String) cmbDia.getSelectedItem();
            String mes = (String) cmbMes.getSelectedItem();
            String anioTexto = txtAnio.getText();

            if (nombre.isEmpty() || edadTexto.isEmpty() || cedula.isEmpty() || posicion.isEmpty() || dia.isEmpty() || mes.isEmpty() || anioTexto.isEmpty() || 
                golesTexto.isEmpty() || tarjetasAmarillasTexto.isEmpty() || tarjetasRojasTexto.isEmpty() || minutosJugadosTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.",
                        "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int edad = Integer.parseInt(edadTexto);
                int goles = Integer.parseInt(golesTexto);
                int tarjetasAmarillas = Integer.parseInt(tarjetasAmarillasTexto);
                int tarjetasRojas = Integer.parseInt(tarjetasRojasTexto);
                int minutosJugados = Integer.parseInt(minutosJugadosTexto);
                int anio = Integer.parseInt(anioTexto);

                  if (anio < 1900 || anio > 2025) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingrese un año válido entre 1900 y 2025.",
                    "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
                     return;
                  }

                if (edad < 18 || edad > 65) {
                    JOptionPane.showMessageDialog(this, "Edad debe estar entre 18 y 65.",
                            "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String fechaContrato = dia + " de " + mes + " del " + anio;


                listaJugadores.add(new Jugador(nombre, edad, cedula, posicion, goles, tarjetasAmarillas, tarjetasRojas, minutosJugados, fechaContrato));

                // Agregar fila a la tabla
                modeloTabla1.addRow(new Object[]{nombre, edad, cedula, posicion,goles,tarjetasAmarillas,tarjetasRojas,minutosJugados,fechaContrato});
                
               
                limpiarCampos();
                guardarDatosEnArchivos();
                JOptionPane.showMessageDialog(this, "Jugador registrado exitosamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Edad, cédula, goles, tarjetas y minutos deben ser números válidos.",
                        "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "La fecha no tiene un formato válido. Use dd/MM/yyyy.",
                        "Error de fecha", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limpiarCampos() {
        //txt
        txtNombre.setText("");
        txtEdad.setText("");
        txtCedula.setText("");
        txtAnio.setText("Año");
        txtGoles.setText("");
        txtTarjetasAmarillas.setText("");
        txtTarjetasRojas.setText("");
        txtMinutosJugados.setText("");
        
        //cmb
        cmbPosicion.setSelectedIndex(0);
        cmbDia.setSelectedIndex(0);
        cmbMes.setSelectedIndex(0);
    }

    private void guardarDatosEnArchivos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tabla_jugadores.txt"))) {
            for (int i = 0; i < modeloTabla1.getRowCount(); i++) {
                writer.write(
                        modeloTabla1.getValueAt(i, 0) + "," +
                        modeloTabla1.getValueAt(i, 1) + "," +
                        modeloTabla1.getValueAt(i, 2) + "," +
                        modeloTabla1.getValueAt(i, 3) + "," +
                        modeloTabla1.getValueAt(i, 4) + "," +
                        modeloTabla1.getValueAt(i, 5) + "," +
                        modeloTabla1.getValueAt(i, 6) + "," +
                        modeloTabla1.getValueAt(i, 7) + "," +
                        modeloTabla1.getValueAt(i, 8)
                );
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Datos guardados en 'tabla_jugadores.txt'.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tabla_jugadores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                modeloTabla1.addRow(data);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla1;
    }
}

