package proyecto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * PROJECT METODOS NUMERICOS
 * Saved as MainProjecto.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01630250
 * 
 * Started in April 6th, 2016
 * Last modified in April 26th, 2016
 */

public class MainProyecto extends JFrame{
	private static final long serialVersionUID = 1L;

	public MainProyecto(){
		super("Circuitos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1080, 720));

		GaussJordan ecuacion = new GaussJordan();
		
		try {
			ecuacion.matrices(new FileReader("in1."), new FileWriter("outfile"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		PanelResultados pr = new PanelResultados();
		this.add(pr, BorderLayout.EAST);

		PanelControles pc = new PanelControles(pr, ecuacion);	
		this.add(pc, BorderLayout.WEST);

		PanelMalla pm = new PanelMalla(pc);
		this.add(pm, BorderLayout.CENTER);	

		PanelCircuitos pcr = new PanelCircuitos(pm);
		this.add(pcr, BorderLayout.SOUTH);

		this.setLocation(50, 0);
		this.pack();
		this.setVisible(true);
<<<<<<< HEAD

		GaussJordan ecuación = new GaussJordan();

		try {
			ecuación.matrices(new FileReader("in1."), new FileWriter("outfile"));
		} catch (IOException e) {
			e.printStackTrace();
		}
=======
		
>>>>>>> origin/master
	}


	public static void main(String[] args){
		@SuppressWarnings("unused")
		MainProyecto frame = new MainProyecto();
	}
}