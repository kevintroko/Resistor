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
	private PanelResultados pr;
	private String componente;

	private ImageIcon iCo,iV,iR;

	//Main Constructor
	public PanelMalla(PanelControles pc, PanelResultados pr)  {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(440,680));
		this.setBackground(Color.WHITE);

		//Instantiation
		this.pc=pc;
		this.pr = pr;
		this.iCo=new ImageIcon(getClass().getResource("conductor.png"));
		this.iV=new ImageIcon(getClass().getResource("voltaje.png"));
		this.iR=new ImageIcon(getClass().getResource("resistencia.png"));

		//Change size: Resistor Image  
		Image img = iR.getImage() ;  
		Image newimg = img.getScaledInstance( 70, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
		iR = new ImageIcon( newimg );

		//Change size: conductor Image  
		Image img3 = iCo.getImage() ;  
		Image newimg3 = img3.getScaledInstance( 70, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
		iCo = new ImageIcon( newimg3 );

		//Change size: voltage Image
		Image img4 = iV.getImage() ;  
		Image newimg4 = img4.getScaledInstance( 70, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
		iV = new ImageIcon( newimg4 );
		

		this.bComponente1=new JButton();
		this.bComponente2=new JButton();
		this.bComponente3=new JButton();
		this.bComponente4=new JButton();
		this.bComponente5=new JButton();
		this.bComponente6=new JButton();

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

		this.bComponente1.setBounds(180, 30, 80, 60);
		this.bComponente2.setBounds(350, 150, 80, 60);
		this.bComponente3.setBounds(350, 310, 80, 60);
		this.bComponente4.setBounds(180, 430, 80, 60);
		this.bComponente5.setBounds(25, 310, 80, 60);
		this.bComponente6.setBounds(25, 150, 80, 60);
	}

	//Method with all the Graphics functions
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		dibujaMalla(g);
		drawResistencia(g,160,260);
	}

	//Draws the initial circuit
	public void dibujaMalla(Graphics g){
		
		g.setColor(Color.BLACK);
		g.drawLine(60, 60, 180, 60);

		g.drawLine(260, 60, 380, 60);
		g.drawLine(380, 60, 380, 150);

		g.drawLine(380, 210, 380, 310);

		g.drawLine(380, 370, 380, 460);
		g.drawLine(380, 460, 260, 460);

		g.drawLine(180, 460, 60, 460);
		g.drawLine(60, 460, 60, 370);

		g.drawLine(60, 310, 60, 210);
		g.drawLine(60, 60, 60, 150);

		g.drawLine(60, 260, 160, 260);
		g.drawLine(280, 260, 380, 260);
	}

	public void drawResistencia(Graphics g,int x, int y){
		g.drawLine(x, y, x+10, y-20);
		g.drawLine(x+10,y-20,x+30,y+20);
		g.drawLine(x+30,y+20,x+50,y-20);
		g.drawLine(x+50,y-20,x+70,y+20);
		g.drawLine(x+70,y+20,x+90,y-20);
		g.drawLine(x+90,y-20,x+110,y+20);
		g.drawLine(x+110,y+20,x+120,y);

	}

	public void cambiarComponente(String componente){
		this.componente=componente;
		//System.out.println("malla: "+this.componente);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		//Draws Button
		if(e.getSource() == this.bComponente1){
			pc.setNum(1);
			this.checar(this.bComponente1);
		}else if(e.getSource()==this.bComponente2){
			pc.setNum(2);
			this.checar(this.bComponente2);
		}else if(e.getSource()==this.bComponente3){
			pc.setNum(3);
			this.checar(this.bComponente3);
		}else if(e.getSource()==this.bComponente4){
			pc.setNum(4);
			this.checar(this.bComponente4);
		}else if(e.getSource()==this.bComponente5){
			pc.setNum(5);
			this.checar(this.bComponente5);
		}else if(e.getSource()==this.bComponente6){
			pc.setNum(6);
			this.checar(this.bComponente6);
		}


		if(e.getSource()==bComponente1||e.getSource()==bComponente2||e.getSource()==bComponente6){
			if(this.componente=="resistencia"){
				pc.setComponente("resistencia");
				//System.out.println("num r1: "+pc.getContadorR1());
				pc.addArray();


			}else if(this.componente=="voltaje"){
				pc.setComponente("voltaje");
				//System.out.println("num v1: "+pc.getContadorV1());
				pc.addArray();

			}else if(this.componente=="conductor"){
				pc.setComponente("conductor");
			}else{
				System.out.println("no hay boton presionado 1");
			}
		}

		else if(e.getSource()==bComponente3||e.getSource()==bComponente4||e.getSource()==bComponente5){
			if(this.componente=="resistencia"){
				pc.setComponente("resistencia");
				//System.out.println("num r2: "+pc.getContadorR2());
				pc.addArray();

			}else if(this.componente=="voltaje"){
				pc.setComponente("voltaje");
				//System.out.println("num v2: "+pc.getContadorV2());
				pc.addArray();

			}else if(this.componente=="conductor"){
				pc.setComponente("conductor");
			}else{
				System.out.println("no hay boton presionado 2");
			}
		}

		//Draws Button
		if(e.getSource() == this.bComponente1){
			this.checar(this.bComponente1);
			pr.setComponent("Componente1");
			pr.setImagenAr(pr.getImage(), 0);
			pr.repaint();
		}else if(e.getSource()==this.bComponente2){
			this.checar(this.bComponente2);
			pr.setComponent("Componente2");
			pr.setImagenAr(pr.getImage(), 1);
			pr.repaint();
		}else if(e.getSource()==this.bComponente3){
			this.checar(this.bComponente3);
			pr.setComponent("Componente3");
			pr.setImagenAr(pr.getImage(), 2);
			pr.repaint();
		}else if(e.getSource()==this.bComponente4){
			this.checar(this.bComponente4);
			pr.setComponent("Componente4");
			pr.setImagenAr(pr.getImage(), 3);
			pr.repaint();
		}else if(e.getSource()==this.bComponente5){
			this.checar(this.bComponente5);
			pr.setComponent("Componente5");
			pr.setImagenAr(pr.getImage(), 4);
			pr.repaint();
		}else if(e.getSource()==this.bComponente6){
			this.checar(this.bComponente6);
			pr.setComponent("Componente6");
			pr.setImagenAr(pr.getImage(), 5);
			pr.repaint();
		}
	}

	//Checks which component has to draw
	public void checar(JButton boton){
		if(componente=="resistencia"){
			boton.setIcon(iR);
		}else if(componente=="conductor"){
			boton.setIcon(iCo);
		}else if(componente=="voltaje"){
			boton.setIcon(iV);
		}
	}

}