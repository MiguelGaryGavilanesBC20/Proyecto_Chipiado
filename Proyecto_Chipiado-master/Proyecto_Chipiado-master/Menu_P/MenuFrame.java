package Menu_P;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import java.util.ArrayList;

public class MenuFrame extends JFrame implements ActionListener {
    private JMenuBar mibarra;
    private JMenu acerca, archivo, editar, logo;
    private JMenuItem info_p, participantes, salir, p_principal;
    private JMenuItem nuevo_op1, nuevo_op2, nuevo_op3, nuevo_op4;
    private JMenuItem consult_op1, consult_op2, consult_op3, consult_op4;
    private JLabel m_general;

    private Panel_Jugador formularioPanel;
    private Panel_Equipo formularioPanel2;
    private PanelArbitro formularioPanel3;
    private PanelDirigente formularioPanel4;

    public MenuFrame() {
        setTitle("Programa de Campeonato de Fútbol");
        setLayout(new BorderLayout());
        setBounds(100, 100, 1150, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DefaultTableModel modeloTabla = new DefaultTableModel();
        DefaultTableModel modeloTabla1 = new DefaultTableModel();
        DefaultTableModel modeloTabla2 = new DefaultTableModel();
        DefaultTableModel modeloTabla3 = new DefaultTableModel();
        DefaultTableModel modeloTabla4 = new DefaultTableModel();

        // Inicializar paneles
        formularioPanel = new Panel_Jugador(modeloTabla1);
        add(formularioPanel);
        formularioPanel2 = new Panel_Equipo(modeloTabla2);
        add(formularioPanel2);
        formularioPanel3 = new PanelArbitro(modeloTabla3);
        add(formularioPanel3);
        formularioPanel4 = new PanelDirigente(modeloTabla4);
        add(formularioPanel4);

        // Panel inicial
        m_general = new JLabel("Programa de Campeonato de Futbol", JLabel.CENTER);
        m_general.setFont(new Font("Ink Free", Font.PLAIN, 25));
        add(m_general, BorderLayout.CENTER);

        // Configurar la barra de menú
        configurarMenu();

        setVisible(true);
    }

    private void configurarMenu() {
        mibarra = new JMenuBar();

        // Menús
        archivo = new JMenu("  Archivo  ");
        editar = new JMenu("  Editar  ");
        acerca = new JMenu("  Acerca de...  ");
        logo = new JMenu("   ");

        // Submenús y elementos
        JMenu nuevo = new JMenu("Nuevo  ");
        nuevo_op1 = new JMenuItem("Jugador");
        nuevo_op1.addActionListener(this);
        nuevo_op2 = new JMenuItem("Equipo");
        nuevo_op2.addActionListener(this);
        nuevo_op3 = new JMenuItem("Arbitro");
        nuevo_op3.addActionListener(this);
        nuevo_op4 = new JMenuItem("Dirigente");
        nuevo_op4.addActionListener(this);

        salir = new JMenuItem("Salir");
        salir.addActionListener(this);

        p_principal = new JMenuItem("Inicio");
        p_principal.addActionListener(this);

        info_p = new JMenuItem("Información del Programa");
        info_p.addActionListener(this);

        participantes = new JMenuItem("Autores");
        participantes.addActionListener(this);

        JMenu consulta = new JMenu("Consulta  ");
        consult_op1 = new JMenuItem("Jugadores");
        consult_op1.addActionListener(this);
        consult_op2 = new JMenuItem("Equipos");
        consult_op2.addActionListener(this);
        consult_op3 = new JMenuItem("Árbitros");
        consult_op3.addActionListener(this);
        consult_op4 = new JMenuItem("Dirigentes");
        consult_op4.addActionListener(this);

        // Construir menú
        mibarra.add(logo);
        mibarra.add(archivo);
        mibarra.add(editar);
        mibarra.add(acerca);

        archivo.add(p_principal);
        archivo.add(nuevo);
        archivo.add(salir);

        nuevo.add(nuevo_op1);
        nuevo.add(nuevo_op2);
        nuevo.add(nuevo_op3);
        nuevo.add(nuevo_op4);

        editar.add(consulta);
        consulta.add(consult_op1);
        consulta.add(consult_op2);
        consulta.add(consult_op3);
        consulta.add(consult_op4);

        acerca.add(info_p);
        acerca.add(participantes);

        setJMenuBar(mibarra);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nuevo_op1) {
            mostrarPanel(formularioPanel);
        } else if (e.getSource() == nuevo_op2) {
            mostrarPanel(formularioPanel2);
        } else if (e.getSource() == nuevo_op3) {
            mostrarPanel(formularioPanel3);
        } else if (e.getSource() == nuevo_op4) {
            mostrarPanel(formularioPanel4);
        } else if (e.getSource() == salir) {
            System.exit(0);
        } else if (e.getSource() == p_principal) {
            getContentPane().removeAll();
            add(m_general, BorderLayout.CENTER);
            revalidate();
            repaint();
        } else if (e.getSource() == info_p) {
            JOptionPane.showMessageDialog(this,
                    "Programa de campeonato creado por el Grupo C\nMateria: Programación Orientada a Objetos.\nMateria impartida por el Ing. Crespo Mendoza Roberto.",
                    "Información del Programa", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == participantes) {
            JOptionPane.showMessageDialog(this,
                    "Jose Agapito Hernandez Vega\nMiguel Eduardo Loyola Mora\nGary Johao Zuñiga Saltos\nCristhian Alejandro Gavilanes Sanchez\nChristian Alexander Bone Arias",
                    "Autores", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == consult_op1) {
            ConsultaPanel1 consultaJugadores = new ConsultaPanel1(formularioPanel.getModeloTabla(), "DATOS DE LOS JUGADORES");
             mostrarPanel(consultaJugadores);
        } else if (e.getSource() == consult_op2) {
            ConsultaPanel2 consultaEquipos = new ConsultaPanel2(formularioPanel2.getModeloTabla(), "DATOS DE LOS EQUIPOS");
             mostrarPanel(consultaEquipos);
        } else if (e.getSource() == consult_op3) {
            ConsultaPanel3 consultaArbitros = new ConsultaPanel3(formularioPanel3.getModeloTabla(), "DATOS DE LOS ÁRBITROS");
             mostrarPanel(consultaArbitros);
        } else if (e.getSource() == consult_op4) {
            ConsultaPanel4 consultaDirigentes = new ConsultaPanel4(formularioPanel4.getModeloTabla(), "DATOS DE LOS DIRIGENTES");
             mostrarPanel(consultaDirigentes);
        }
    }

    private void mostrarPanel(JPanel panel) {
        getContentPane().removeAll();
        add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    
}
