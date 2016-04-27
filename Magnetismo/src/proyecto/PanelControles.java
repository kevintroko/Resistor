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
	//Buttons
	private JButton bResultado;
	
	//JLABEL
	private JLabel lSumaVoltajes,
				   lSumaResistencias;

	//Resistances array and voltages
	private Resistencia[] arrRes = new Resistencia[6];
	private Voltaje[] arrVol= new Voltaje[6];
	
	private int sumaVoltaje,
				sumaResistencia;
	
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
	private int contador,
				contadorV,
				contadorT;

	//Constructor
	public PanelControles() {
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
		this.lSumaResistencias=new JLabel();
		this.lSumaVoltajes=new JLabel();

		//Add components into the array
		arrRes[0]=this.panelRes;
		arrRes[1]=this.panelRes2;
		arrRes[2]=this.panelRes3;
		arrRes[3]=this.panelRes4;
		arrRes[4]=this.panelRes5;
		arrRes[5]=this.panelRes6;
		arrVol[0]=this.voltaje1;
		arrVol[1]=this.voltaje2;
		arrVol[2]=this.voltaje3;
		arrVol[3]=this.voltaje4;
		arrVol[4]=this.voltaje5;
		arrVol[5]=this.voltaje6;

		//Adds components into the panel
		this.add(bResultado);
		this.add(lSumaResistencias);
		this.add(lSumaVoltajes);
		
		//Adds Listeners
		this.bResultado.addActionListener(this);
	}

	//Adds the resistances and voltages into the array
	public void agregaPanel(){
		System.out.println("contador res: "+this.contador);
		System.out.println("contador vol: "+this.contadorV);
		this.contadorT=this.contador+this.contadorV;
		System.out.println("contador total: "+this.contadorT+"\n");

		if(this.contadorT<7){
			for(int i=0;i<this.contador;i++){
				this.add(this.arrRes[i]);
				//System.out.println("resitencia[i]: "+i);
			}
			
			for(int j=0;j<this.contadorV;j++){
				this.add(this.arrVol[j]);
				//System.out.println("voltaje[j]: "+j);
			}
			this.add(bResultado);
			this.revalidate();
		}
	}

	//Actions of the buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.bResultado){
			this.agregaPanel();
			//Sums values of the res array
			this.sumaResistencia=0;
			this.sumaVoltaje=0;
			
			for(int i=0;i<arrRes.length;i++){
				this.sumaResistencia+=arrRes[i].getValor();
			}
			for(int j=0;j<arrVol.length;j++){
				this.sumaVoltaje+=arrVol[j].getValor();
			}
			
			this.lSumaResistencias.setText("Suma: "+this.sumaResistencia);
		}
	}

	//Pseudo Setters
	public void setContadorR(){
		this.contador++;	
	}

	public void setContadorV(){
		this.contadorV++;	
	}
	
	public void setContadorT(){
		this.contadorT++;
	}

	//Getter
	public int getContadorR(){
		return this.contador;
	}

	public int getContadorV() {
		return this.contadorV;
	}

	public int getContadorTotal(){
		return this.contadorT;
	}

	public Resistencia[] getArray() {
		return this.arrRes;
	}
	
	public Voltaje[] getArrayV(){
		return this.arrVol;
	}
}