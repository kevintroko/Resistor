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

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Mark Octavio Rivera Acosta
 * @author Kevin Oswaldo Cabrera Navarro
 */

@SuppressWarnings("serial")
public class PanelResultados extends JPanel {
	
	//Boolean to enable the paintComponent() in panelResultados
	private boolean isPainted = false;
	private ImageIcon image;
	private ImageIcon[] imagenes = new ImageIcon[6];
	private String componente;
	
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
		if (getIsPainted()) {
			paintCircuit(g);
		}
		this.isPainted = false;
	}
	
	/**
	 * Draw a new circuit using the size of the electric current 
	 * with identifier colors that represents the size of the charge.
	 * @param g
	 */
	public void paintCircuit(Graphics g) {
		
		int x = 160;
		int y = 260;
		g.drawLine(x, y, x+10, y-20);
		g.drawLine(x+10,y-20,x+30,y+20);
		g.drawLine(x+30,y+20,x+50,y-20);
		g.drawLine(x+50,y-20,x+70,y+20);
		g.drawLine(x+70,y+20,x+90,y-20);
		g.drawLine(x+90,y-20,x+110,y+20);
		g.drawLine(x+110,y+20,x+120,y);
		
		g.setColor(getColor(40));
		g.drawLine(60, 60, 160, 60);
		g.drawLine(60, 60, 60, 140);
		
		g.setColor(getColor(70));
		g.drawLine(260, 60, 380, 60);
		g.drawLine(380, 60, 380, 140);

		g.setColor(getColor(120));
		g.drawLine(380, 220, 380, 300);

		g.setColor(getColor(30));
		g.drawLine(380, 380, 380, 460);
		g.drawLine(380, 460, 260, 460);

		g.setColor(getColor(70));
		g.drawLine(160, 460, 60, 460);
		g.drawLine(60, 460, 60, 380);
		
		g.setColor(getColor(120));
		g.drawLine(60, 300, 60, 220);
		g.drawLine(60, 260, 160, 260);

		g.drawLine(280, 260, 380, 260);
		
		g.drawImage(getImageAr(0).getImage(), 180, 30, 80, 60, null);
		g.drawImage(getImageAr(1).getImage(), 350, 150, 80, 60, null);
		g.drawImage(getImageAr(2).getImage(), 350, 310, 80, 60, null);
		g.drawImage(getImageAr(3).getImage(), 180, 430, 80, 60, null);
		g.drawImage(getImageAr(4).getImage(), 25, 310, 80, 60, null);
		g.drawImage(getImageAr(5).getImage(), 25, 150, 80, 60, null);
	
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
	public void setImage(ImageIcon image){
		this.image = image;
	}
	public ImageIcon getImage(){
		return this.image;
	}
	public void setComponent(String componente){
		this.componente = componente;
	}
	public String getComponent(){
		return this.componente;
	}
	
	public void setImagenAr(ImageIcon image, int i){
		this.imagenes[i] = image;
	}
	
	public ImageIcon getImageAr(int i){
		return this.imagenes[i];
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