package proyecto;
/**
 * Saved as PanelMalla.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01234567
 * 
 * Started in April 6th, 2016
 * Last modified in April 25th, 2016
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelMalla extends JPanel implements ActionListener{
	//Declaration 
	private JButton bComponente1,
	bComponente2,
	bComponente3,
	bComponente4,
	bComponente5,
	bComponente6;

	private PanelControles pc;
	private String componente;

	ImageIcon iC;
	ImageIcon iCo;
	ImageIcon iV;
	ImageIcon iR;

	//Main Constructor
	public PanelMalla(PanelControles pc)  {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(440,680));
		this.setBackground(Color.WHITE);

		//Instantiation
		this.pc=pc;
		this.iC=new ImageIcon(getClass().getResource("capacitor.png"));
		this.iCo=new ImageIcon(getClass().getResource("conductor.png"));
		this.iV=new ImageIcon(getClass().getResource("voltaje.png"));
		this.iR=new ImageIcon(getClass().getResource("resistencia.png"));

		//Change size: Resistor Image  
		Image img = iR.getImage() ;  
		Image newimg = img.getScaledInstance( 100, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		iR = new ImageIcon( newimg );

		//Change size: Capacitor Image
		Image img2 = iC.getImage() ;  
		Image newimg2 = img2.getScaledInstance( 100, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		iC = new ImageIcon( newimg2 );

		//Change size: conductor Image  
		Image img3 = iCo.getImage() ;  
		Image newimg3 = img3.getScaledInstance( 100, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		iCo = new ImageIcon( newimg3 );

		//Change size: voltage Image
		Image img4 = iV.getImage() ;  
		Image newimg4 = img4.getScaledInstance( 100, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		iV = new ImageIcon( newimg4 );

		this.bComponente1=new JButton("Componente1");
		this.bComponente2=new JButton("Componente2");
		this.bComponente3=new JButton("Componente3");
		this.bComponente4=new JButton("Componente4");
		this.bComponente5=new JButton("Componente5");
		this.bComponente6=new JButton("Componente6");

		//Adding components
		this.add(bComponente1);
		this.add(bComponente2);
		this.add(bComponente3);
		this.add(bComponente4);
		this.add(bComponente5);
		this.add(bComponente6);

		//Adds listeners
		this.bComponente1.addActionListener(this);
		this.bComponente2.addActionListener(this);
		this.bComponente3.addActionListener(this);
		this.bComponente4.addActionListener(this);
		this.bComponente5.addActionListener(this);
		this.bComponente6.addActionListener(this);

		this.bComponente1.setBounds(160, 20, 100, 80);
		this.bComponente2.setBounds(320, 140, 100, 80);
		this.bComponente3.setBounds(320, 300, 100, 80);
		this.bComponente4.setBounds(160, 420, 100, 80);
		this.bComponente5.setBounds(20, 300, 100, 80);
		this.bComponente6.setBounds(20, 140, 100, 80);
	}

	//Method with all the Graphics functions
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		dibujaMalla(g);
	}

	//Draws the initial circuit
	public void dibujaMalla(Graphics g){
		g.setColor(Color.BLACK);
		g.drawLine(60, 60, 160, 60);
		g.drawRect(160, 20, 100, 80);

		g.drawLine(260, 60, 380, 60);
		g.drawLine(380, 60, 380, 140);
		g.drawRect(320, 140, 100, 80);

		g.drawLine(380, 220, 380, 300);
		g.drawRect(320, 300, 100, 80);

		g.drawLine(380, 380, 380, 460);
		g.drawLine(380, 460, 260, 460);
		g.drawRect(160, 420, 100, 80);

		g.drawLine(160, 460, 60, 460);
		g.drawLine(60, 460, 60, 380);
		g.drawRect(20, 300, 100, 80);

		g.drawLine(60, 300, 60, 220);
		g.drawRect(20, 140, 100, 80);
		g.drawLine(60, 60, 60, 140);

		g.drawLine(60, 260, 380, 260);
	}

	public void cambiarComponente(String componente){
		this.componente=componente;
		//System.out.println("malla: "+this.componente);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(pc.getContadorTotal()<6){
			//Adds numbers to the sum in the panel controls
			if(e.getSource()==bComponente1||e.getSource()==bComponente2||e.getSource()==bComponente6){
				if(this.componente=="resistencia"){
					System.out.println(this.componente);
					pc.setContadorR1();
					System.out.println("num r1: "+pc.getContadorR1());
					pc.agregaPanel();
					
				}else if(this.componente=="voltaje"){
					pc.setContadorV1();
					System.out.println("num v1: "+pc.getContadorV1());
					pc.agregaPanel();
				}else if(this.componente=="conductor"){
					pc.setContadorT();
				}else if(this.componente=="capacitor"){
					pc.setContadorT();
				}else{
					System.out.println("no hay boton presionado");
				}
			}
			
			else if(e.getSource()==bComponente3||e.getSource()==bComponente4||e.getSource()==bComponente5){
				if(this.componente=="resistencia"){
					System.out.println(this.componente);
					pc.setContadorR2();
					System.out.println("num r2: "+pc.getContadorR2());
					pc.agregaPanel();
					
				}else if(this.componente=="voltaje"){
					pc.setContadorV2();
					System.out.println("num v2: "+pc.getContadorV2());
					pc.agregaPanel();
					
				}else if(this.componente=="conductor"){
					pc.setContadorT();
				}else if(this.componente=="capacitor"){
					pc.setContadorT();
				}else{
					System.out.println("no hay boton presionado");
				}
			}
		}else{
			JOptionPane.showMessageDialog(this, "Limit reached");
		}

		//Draws Button
		if(e.getSource() == this.bComponente1){
			this.checar(this.bComponente1);
		}else if(e.getSource()==this.bComponente2){
			this.checar(this.bComponente2);
		}else if(e.getSource()==this.bComponente3){
			this.checar(this.bComponente3);
		}else if(e.getSource()==this.bComponente4){
			this.checar(this.bComponente4);
		}else if(e.getSource()==this.bComponente5){
			this.checar(this.bComponente5);
		}else if(e.getSource()==this.bComponente6){
			this.checar(this.bComponente6);
		}
	}

	//Checks which component has to draw
	public void checar(JButton boton){
		if(componente=="resistencia"){
			boton.setIcon(iR);
		}else if(componente=="capacitor"){
			boton.setIcon(iC);
		}else if(componente=="conductor"){
			boton.setIcon(iCo);
		}else if(componente=="voltaje"){
			boton.setIcon(iV);
		}
	}
}