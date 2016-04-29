package proyecto;
/**
 * Saved as PanelCircuitos.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01630250
 * 
 * Started in April 6th, 2016
 * Last modified in April 28th, 2016
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelCircuitos extends JPanel implements ActionListener{
	
	//ImageIcon: Components (resistance, cable, voltage)
	private ImageIcon resistenciaIMG,
	conductorIMG,
	voltajeIMG;
	
	//JButton: for each component
	private JButton resistencia, 
	conductor, 
	voltaje;

	//Relation: PanelMalla
	private PanelMalla pm;
	//Relation: PanelResultados
	private PanelResultados pr;

	/**
	 * Constructor
	 * @param pm Receives a PanelMalla
	 * @param pr Receives a PanelResultados
	 */
	public PanelCircuitos(PanelMalla pm, PanelResultados pr) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1080,160));
		this.setBackground(new Color(183,183,183));

		//Receive a panel
		this.pm = pm;
		this.pr = pr;
		
		//Add images 
		this.resistenciaIMG = new ImageIcon(getClass().getResource("resistencia.png"));
		this.conductorIMG =new ImageIcon(getClass().getResource("conductor.png"));
		this.voltajeIMG = new ImageIcon(getClass().getResource("voltaje.png"));

		//Change size: Resistance Image 
		Image img = resistenciaIMG.getImage() ;  
		Image newimg = img.getScaledInstance( 150, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
		resistenciaIMG = new ImageIcon( newimg );
		
		//Change size: Cable Image 
		Image img3 = conductorIMG.getImage() ;  
		Image newimg3 = img3.getScaledInstance( 150, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
		conductorIMG = new ImageIcon( newimg3 );
		
		//Change size: voltage Image 
		Image img4 = voltajeIMG.getImage() ;  
		Image newimg4 = img4.getScaledInstance( 150, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
		voltajeIMG = new ImageIcon( newimg4 );
		
		//Set Images to the JButtons
		this.resistencia = new JButton(resistenciaIMG);
		this.conductor = new JButton(conductorIMG);
		this.voltaje = new JButton(voltajeIMG);
		
		//Set size and position of the JButtons
		this.resistencia.setBounds(150, 20,200,120);
		this.conductor.setBounds(425, 20,200,120);
		this.voltaje.setBounds(700, 20,200,120);

		//Add JButtons to the pannel
		this.add(this.resistencia);
		this.add(this.conductor);
		this.add(this.voltaje);

		//Add ActionListeners to the JButtons
		this.resistencia.addActionListener(this);
		this.voltaje.addActionListener(this);
		this.conductor.addActionListener(this);
	}
	/**
	 * SetImage in PanelReslutado
	 * SetComponent to PanelMalla
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.resistencia){
			pm.cambiarComponente("resistencia");
			pr.setImage(resistenciaIMG);
			pr.repaint();

		}else if(e.getSource()==this.voltaje){
			pm.cambiarComponente("voltaje");
			pr.setImage(voltajeIMG);
			pr.repaint();

		}else if(e.getSource()==this.conductor){
			pm.cambiarComponente("conductor");
			pr.setImage(conductorIMG);
			pr.repaint();
		}
	}
}