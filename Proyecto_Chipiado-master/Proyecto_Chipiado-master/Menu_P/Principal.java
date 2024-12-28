package Menu_P;

import javax.swing.JFrame;

public class Principal {
    
	public static void main(String[] args) {

        MenuFrame mimarco = new MenuFrame();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);
        mimarco.setResizable(false);
		mimarco.setLocationRelativeTo(null);

    }
}