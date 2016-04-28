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

/**
 * @author Mark Octavio Rivera Acosta
 * @author Kevin Oswaldo Cabrera Navarro
 */

@SuppressWarnings("serial")
public class PanelResultados extends JPanel {
	
	//Boolean to enable the paintComponent() in panelResultados
	private boolean isPainted = false;
	
	/**
	 * Class constructor
	 * Do not receive any parameter
	 * Add a size and background color to the panel
	 */
	public PanelResultados() {
		super();
		this.setPreferredSize(new Dimension(440,680));
		this.setBackground(new Color(251,250,250));
		
	}
	
	/**
	 * If button on PanelControles is pressed, paint a new circuit
	 * Set boolean isPainted to false
	 * @param g
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (getIsPainted()) {
			paintTexto(g);
		}
		this.isPainted = false;
	}
	
	/**
	 * Draw a new circuit using the size of the electric current 
	 * with identifier colors that represents the size of the charge.
	 * @param g
	 */
	public void paintTexto(Graphics g) {
		
		
		g.setColor(getColor(40));
		g.drawLine(60, 60, 160, 60);
		g.drawRect(160, 20, 100, 80);
		
		g.setColor(getColor(40));
		g.drawLine(260, 60, 380, 60);
		g.drawLine(380, 60, 380, 140);
		g.drawRect(320, 140, 100, 80);

		g.setColor(getColor(20));
		g.drawLine(380, 220, 380, 300);
		g.drawRect(320, 300, 100, 80);

		g.setColor(getColor(30));
		g.drawLine(380, 380, 380, 460);
		g.drawLine(380, 460, 260, 460);
		g.drawRect(160, 420, 100, 80);

		g.setColor(getColor(40));
		g.drawLine(160, 460, 60, 460);
		g.drawLine(60, 460, 60, 380);
		g.drawRect(20, 300, 100, 80);
		
		g.setColor(getColor(90));
		g.drawLine(60, 300, 60, 220);
		g.drawRect(20, 140, 100, 80);
		g.drawLine(60, 60, 60, 140);
		
		g.setColor(getColor(150));
		g.drawLine(60, 260, 160, 260);
		g.drawLine(280, 260, 380, 260);
	}
	
	/**
	 * set isPainted to true if JButton BResultado is pressed in PanelControles
	 */
	public void setPaint(boolean isPainted) {
		this.isPainted = isPainted;
	}
	/**
	 * 
	 * @return isPainted
	 * 					return true if the JButton in PanelControles was pressed
	 */
	public boolean getIsPainted() {
		return this.isPainted;
	}
	
	/**
	 * Compare the size of a current in a circuit section
	 * @param corriente
	 * @return color 
	 * 				this color is assigned to the corresponding circuit section 
	 */
	public Color getColor(int corriente){
		
		Color color = Color.black;
		
		if (corriente < 60) {
			color = Color.GREEN;
		}else if (corriente > 60 & corriente < 100) {
			color = Color.ORANGE;
		}else{
			color = Color.RED;
		}
		
		return color;
	}

}