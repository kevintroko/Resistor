package proyecto;
/**
 * Saved as PanelCircuitos.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01234567
 * 
 * Started in April 6th, 2016
 * Last modified in April 25th, 2016
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
	private ImageIcon resistenciaIMG,
					  capacitorIMG,
					  conductorIMG,
					  voltajeIMG;
	
	private JButton resistencia, 
					capacitor, 
					conductor, 
					voltaje;
	
	private PanelMalla pm;
	
	public PanelCircuitos(PanelMalla pm) {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1080,160));
		this.setBackground(new Color(183,183,183));
		
		//Receive a panel
		this.pm=pm;
		this.resistenciaIMG = new ImageIcon(getClass().getResource("resistencia.png"));
		this.capacitorIMG = new ImageIcon(getClass().getResource("capacitor.png"));
		this.conductorIMG =new ImageIcon(getClass().getResource("conductor.png"));
		this.voltajeIMG = new ImageIcon(getClass().getResource("voltaje.png"));

		 Image img = resistenciaIMG.getImage() ;  
		 Image newimg = img.getScaledInstance( 150, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
		 resistenciaIMG = new ImageIcon( newimg );
		   
		 Image img2 = capacitorIMG.getImage() ;  
		 Image newimg2 = img2.getScaledInstance( 150, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
		 capacitorIMG = new ImageIcon( newimg2 );
		   
		 Image img3 = conductorIMG.getImage() ;  
		 Image newimg3 = img3.getScaledInstance( 150, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
		 conductorIMG = new ImageIcon( newimg3 );
		   
		 Image img4 = voltajeIMG.getImage() ;  
		 Image newimg4 = img4.getScaledInstance( 150, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
		 voltajeIMG = new ImageIcon( newimg4 );
		
		this.resistencia = new JButton(resistenciaIMG);
		this.capacitor = new JButton(capacitorIMG);
		this.conductor = new JButton(conductorIMG);
		this.voltaje = new JButton(voltajeIMG);
		
		this.resistencia.setBounds(50, 20,200,120);
		this.capacitor.setBounds(300, 20,200,120);
		this.conductor.setBounds(550, 20,200,120);
		this.voltaje.setBounds(800, 20,200,120);
		
		this.add(this.resistencia);
		this.add(this.capacitor);
		this.add(this.conductor);
		this.add(this.voltaje);
		
		this.resistencia.addActionListener(this);
		this.capacitor.addActionListener(this);
		this.voltaje.addActionListener(this);
		this.conductor.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.resistencia){
			pm.cambiarComponente("resistencia");
			
		}else if(e.getSource()==this.capacitor){
			pm.cambiarComponente("capacitor");
			
		}else if(e.getSource()==this.voltaje){
			pm.cambiarComponente("voltaje");
			
		}else if(e.getSource()==this.conductor){
			pm.cambiarComponente("conductor");	
		}
	}
}