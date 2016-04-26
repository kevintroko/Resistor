package proyecto;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
		
		PanelControles pc = new PanelControles();	
		this.add(pc, BorderLayout.WEST);

		PanelResultados pr = new PanelResultados(pc);
		this.add(pr, BorderLayout.EAST);
		

		PanelMalla pm = new PanelMalla(pc);
		this.add(pm, BorderLayout.CENTER);	

		PanelCircuitos pcr = new PanelCircuitos(pm);
		this.add(pcr, BorderLayout.SOUTH);
		
		this.setLocation(50, 0);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args){
		@SuppressWarnings("unused")
		MainProyecto frame = new MainProyecto();
	}
}