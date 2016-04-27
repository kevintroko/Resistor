package proyecto;
/**
 * Saved as PanelControles.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01234567
 * 
 * Started in April 6th, 2016
 * Last modified in April 26th, 2016
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelControles extends JPanel implements ActionListener{
	
	PanelResultados pr;
	//Buttons
	private JButton bResultado;

	//JLABEL
	private JLabel lSumaVoltajes1,
				   lSumaVoltajes2,
				   lSumaResistencias1,
				   lSumaResistencias2;

	//Resistances array and voltages
	private Resistencia[] arrRes1=new Resistencia[3];
	private Resistencia[] arrRes2=new Resistencia[3];
	private Voltaje[] arrVol1=new Voltaje[3];
	private Voltaje[] arrVol2=new Voltaje[3];

			
	private int sumaVoltaje1,
				sumaResistencia1,
				sumaVoltaje2,
				sumaResistencia2;

	//Possible resistances
	private Resistencia panelRes, 
						panelRes2,
						panelRes3,
						panelRes4,
						panelRes5,
						panelRes6;

	private Voltaje voltaje1,
					voltaje2,
					voltaje3,
					voltaje4,
					voltaje5,
					voltaje6;


	//Counter of possible resistances
	private int contador1,contador2,
	contadorV1, contadorV2,
	contadorT;

	//Constructor
	public PanelControles(PanelResultados pr) {
		super();
		((FlowLayout)this.getLayout()).setAlignment(FlowLayout.CENTER);
		this.setPreferredSize(new Dimension(200,720));
		this.setBackground(new Color(225,225,225));	

		//Instantiate components
		this.bResultado= new JButton("Resultado");
		this.panelRes=new Resistencia();
		this.panelRes2=new Resistencia();
		this.panelRes3=new Resistencia();
		this.panelRes4=new Resistencia();
		this.panelRes5=new Resistencia();
		this.panelRes6=new Resistencia();
		this.voltaje1=new Voltaje();
		this.voltaje2=new Voltaje();
		this.voltaje3=new Voltaje();
		this.voltaje4=new Voltaje();
		this.voltaje5=new Voltaje();
		this.voltaje6=new Voltaje();
		this.lSumaResistencias1=new JLabel();
		this.lSumaVoltajes1=new JLabel();
		this.lSumaResistencias2=new JLabel();
		this.lSumaVoltajes2=new JLabel();
		this.pr=pr;

		//Add components into the array
		arrRes1[0]=this.panelRes;
		arrRes1[1]=this.panelRes2;
		arrRes1[2]=this.panelRes3;
		arrRes2[0]=this.panelRes4;
		arrRes2[1]=this.panelRes5;
		arrRes2[2]=this.panelRes6;

		arrVol1[0]=this.voltaje1;
		arrVol1[1]=this.voltaje2;
		arrVol1[2]=this.voltaje3;
		arrVol2[0]=this.voltaje4;
		arrVol2[1]=this.voltaje5;
		arrVol2[2]=this.voltaje6;

		//Adds components into the panel
		this.add(bResultado);
		this.add(lSumaResistencias1);
		this.add(lSumaVoltajes1);
		this.add(lSumaResistencias2);
		this.add(lSumaVoltajes2);
		
		//Adds Listeners
		this.bResultado.addActionListener(this);
	}

	//Adds the resistances and voltages into the array
	public void agregaPanel(){
		System.out.println("contador res1: "+this.contador1);
		System.out.println("contador res2: "+this.contador2);
		System.out.println("contador vol1: "+this.contadorV1);
		System.out.println("contador vol2 "+this.contadorV2);
		
		this.contadorT=this.contador1+this.contador2+this.contadorV1+this.contadorV2;
		System.out.println("contador total: "+this.contadorT+"\n");

		if(this.contadorT<7){
			for(int i=0;i<this.contador1;i++){
					this.add(this.arrRes1[i]);
					//System.out.println("resitencia[i]: "+i);
			}
			
			for(int i=0;i<this.contador2;i++){
				this.add(this.arrRes2[i]);
				//System.out.println("resitencia[i]: "+i);
			}

			for(int j=0;j<this.contadorV1;j++){
					this.add(this.arrVol1[j]);
					//System.out.println("voltaje[j]: "+j);
			}
			
			for(int j=0;j<this.contadorV2;j++){
				this.add(this.arrVol2[j]);
				//System.out.println("voltaje[j]: "+j);
		    }
			this.add(bResultado);
			this.add(lSumaResistencias1);
			this.add(lSumaVoltajes1);
			this.add(lSumaResistencias2);
			this.add(lSumaVoltajes2);
			this.revalidate();
		}
	}




	public String toString() { 
	    return this.contador1+"";
	} 
	
	//Actions of the buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.bResultado){
			this.agregaPanel();
			System.out.println("El valor de "+e.getSource()+" es: "+this.arrRes1[1].getValor());
			
			//Sums values of the res array
			this.sumaResistencia1=0;
			this.sumaVoltaje1=0;
			this.sumaResistencia2=0;
			this.sumaVoltaje2=0;

			for(int i=0;i<arrRes1.length;i++){					
					this.sumaResistencia1+=arrRes1[i].getValor();
			}
			for(int j=0;j<arrVol1.length;j++){
				this.sumaVoltaje1+=arrVol1[j].getValor();
			}
			
			for(int i=0;i<arrRes2.length;i++){					
				this.sumaResistencia2+=arrRes2[i].getValor();
			}
			for(int j=0;j<arrVol2.length;j++){
				this.sumaVoltaje2+=arrVol2[j].getValor();
			}

			this.lSumaResistencias1.setText("Suma 1: "+this.sumaResistencia1);
			this.lSumaVoltajes1.setText("Voltaje 1; "+this.sumaVoltaje1);
			this.lSumaResistencias1.setText("Suma 2: "+this.sumaResistencia2);
			this.lSumaVoltajes1.setText("Voltaje 2; "+this.sumaVoltaje2);

			//this.pr.dibujaCircuito(getGraphics());
		}
	}

	//Pseudo Setters
	public void setContadorR1(){
		this.contador1++;	
	}
	public void setContadorR2(){
		this.contador2++;	
	}
	public void setContadorV1(){
		this.contadorV1++;	
	}
	public void setContadorV2(){
		this.contadorV2++;	
	}
	public void setContadorT(){
		this.contadorT++;
	}
	
	
	

	//Getters
	public int getContadorR1(){return this.contador1;}
	public int getContadorR2(){return this.contador2;}

	public int getContadorV1() {return this.contadorV1;}
	public int getContadorV2() {return this.contadorV2;}

	public int getContadorTotal(){return this.contadorT;}

	public Resistencia[] getArray() {return this.arrRes1;}

	public Voltaje[] getArrayV(){return this.arrVol1;}
}