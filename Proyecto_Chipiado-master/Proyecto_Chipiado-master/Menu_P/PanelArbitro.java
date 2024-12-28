package Menu_P;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelArbitro extends JPanel implements ActionListener {
    private List<Arbitro> listaArbitros;
    private DefaultTableModel modeloTabla;
    private JTextField txtNombre,txtEdad,txtCedula;
    private JLabel lbNombre, lbEdad, lbCedula;
    private JButton btnRegistrar;
    private JTable tablaArbitros;
    private JScrollPane scrollPane;

    public PanelArbitro(DefaultTableModel modeloTabla) {
        this.listaArbitros = new ArrayList<>();
        
        setLayout(null);

        // Panel de registro
        JPanel panelRegistro = new JPanel();
        panelRegistro.setLayout(new GridLayout(3, 2, 10, 10));

        lbNombre = new JLabel("Nombre Completo");
        lbNombre.setBounds(50, 20, 50, 20);
        add(lbNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(110, 20, 110, 20);
        add(txtNombre);

        lbEdad = new JLabel("Edad");
        lbEdad.setBounds(50, 50, 50, 20);
        add(lbEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(110, 50, 110, 20);
        add(txtEdad);

        lbCedula = new JLabel("Cedula");
        lbCedula.setBounds(50, 80, 50, 20);
        add(lbCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(110, 80, 110, 20);
        add(txtCedula);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(300, 20, 100, 30);
        add(btnRegistrar);
        btnRegistrar.addActionListener(this);

        
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Cedula");

        // Tabla de árbitros
        this.modeloTabla = modeloTabla;
        tablaArbitros = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tablaArbitros);
        scrollPane.setBounds(50, 130, 420, 200);
        add(scrollPane);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            String nombre = txtNombre.getText();
            String edadtxt = txtEdad.getText();
            String cedulatxt = txtCedula.getText();

            // Validar campos
            if (nombre.isEmpty() || edadtxt.isEmpty() || cedulatxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.","Error al agregar los datos",JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                
                int edad = Integer.parseInt(edadtxt);
                int cedula = Integer.parseInt(cedulatxt);
                
                if (edad <= 0 || cedula <= 0) {
                    JOptionPane.showMessageDialog(this, "La edad y la cédula deben ser numeros", "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    
                // Agregar árbitro a la tabla
                modeloTabla.addRow(new Object[]{nombre, edad, cedula, 0});
                
                Arbitro nuevoArbitro = new Arbitro(nombre, edad, cedula);
                listaArbitros.add(nuevoArbitro);

                // Limpiar campos
                txtNombre.setText("");
                txtEdad.setText("");
                txtCedula.setText("");
            }
        }
    }

    public List<Arbitro> getListaArbitros() {
      return listaArbitros;
    }
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
