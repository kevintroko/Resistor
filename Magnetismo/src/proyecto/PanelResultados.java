package proyecto;
/**
 * Saved as PanelResultados.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01234567
 * 
 * Started in April 6th, 2016
 * Last modified in April 26th, 2016
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelResultados extends JPanel {
	
	
	private boolean isPainted = false;
	protected boolean pintaBonito = false;
	public PanelResultados() {
		super();
		
		this.setPreferredSize(new Dimension(440,680));
		this.setBackground(new Color(251,250,250));

		GaussJordan ecuación = new GaussJordan();
		try {
			ecuación.matrices(new FileReader("in1."), new FileWriter("outfile"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (getIsPainted()) {
			paintTexto(g);
		}
		this.isPainted = false;
	}
	
	public void paintTexto(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(60, 60, 160, 60);
		System.out.println("hola");
	}
	
	public void setPaint(boolean isPainted) {
		this.isPainted = isPainted;
	}
	
	public boolean getIsPainted() {
		return this.isPainted;
	}

}