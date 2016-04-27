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
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelResultados extends JPanel {	
	
	public PanelResultados() {
		super();

		((FlowLayout)this.getLayout()).setAlignment(FlowLayout.LEFT);
		this.setPreferredSize(new Dimension(440,680));
		this.setBackground(new Color(251,250,250));
		
		GaussJordan ecuación = new GaussJordan();
		try {
			ecuación.matrices(new FileReader("in1."), new FileWriter("outfile"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ecuación.geti1());
		System.out.println(ecuación.geti2());
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.setColor(new Color(23,150,23));
		
		g.drawLine(60, 60, 160, 60);
		
		g.drawLine(260, 60, 380, 60);
		g.drawLine(380, 60, 380, 140);
		
		g.drawLine(380, 220, 380, 300);
		
		g.drawLine(380, 380, 380, 460);
		g.drawLine(380, 460, 260, 460);
		
		g.drawLine(160, 460, 60, 460);
		g.drawLine(60, 460, 60, 380);
		
		g.drawLine(60, 300, 60, 220);
		g.drawLine(60, 60, 60, 140);
		
		g.drawLine(60, 260, 380, 260);
	}

}