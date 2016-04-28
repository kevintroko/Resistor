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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelControles extends JPanel implements ActionListener{

	//Buttons
	private JButton bResultado1;

	private PanelResultados pr = new PanelResultados();

	private JTextField tresInicial;
	private JButton bPonerRes;
	private double sumaVoltaje1,
	sumaResistencia1,
	sumaVoltaje2,
	sumaResistencia2,
	resistenciaV;

	private String componente;

	private int num;

	GaussJordan gj;

	private JLabel lComponente1, 
	lComponente2,
	lComponente3,
	lComponente4,
	lComponente5, 
	lComponente6;


	private double componente1,
	componente2,
	componente3,
	componente4,
	componente5,
	componente6,
	componentev1,
	componentev2,
	componentev3,
	componentev4,
	componentev5,
	componentev6;



	private JTextField tfComponente1,
	tfComponente2,
	tfComponente3,
	tfComponente4,
	tfComponente5,
	tfComponente6;

	private JButton bOk1,
	bOk2,
	bOk3,
	bOk4,
	bOk5,
	bOk6;

	//Constructor
	public PanelControles(PanelResultados pr, GaussJordan gj) {
		super();
		this.setPreferredSize(new Dimension(200, 541));
		this.setBackground(new Color(225,225,225));	

		//Instantiate components
		this.gj=gj;
		this.pr = pr;
		this.bResultado1= new JButton("Resultado");
		bResultado1.setForeground(Color.DARK_GRAY);

		this.tresInicial=new JTextField(6);
		tresInicial.setForeground(Color.DARK_GRAY);
		this.bPonerRes=new JButton("Ok");
		bPonerRes.setForeground(Color.DARK_GRAY);

		//Adds Listeners
		this.bResultado1.addActionListener(this);

		//Component1
		this.lComponente1 = new JLabel("Componente 1");
		this.lComponente1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.tfComponente1=new JTextField();
		this.tfComponente1.setColumns(10);
		this.bOk1 = new JButton("ok");
		this.bOk1.addActionListener(this);

		//Component2
		this.lComponente2 = new JLabel("Componente 2");
		this.lComponente2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.tfComponente2 = new JTextField();
		this.tfComponente2.setColumns(10);
		this.bOk2 = new JButton("ok");
		this.bOk2.addActionListener(this);

		//Component3
		this.lComponente3 = new JLabel("Componente 3");
		this.lComponente3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.tfComponente3 = new JTextField();
		this.tfComponente3.setColumns(10);
		this.bOk3 = new JButton("ok");
		this.bOk3.addActionListener(this);

		//Component4
		this.lComponente4 = new JLabel("Componente 4");
		this.lComponente4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.tfComponente4 = new JTextField();
		this.tfComponente4.setColumns(10);
		this.bOk4 = new JButton("ok");
		this.bOk4.addActionListener(this);

		//Component5
		this.lComponente5 = new JLabel("Componente 5");
		this.lComponente5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.tfComponente5 = new JTextField();
		this.tfComponente5.setColumns(10);
		this.bOk5 = new JButton("ok");
		this.bOk5.addActionListener(this);

		//Component6
		this.lComponente6 = new JLabel("Componente 6");
		this.lComponente6.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.tfComponente6 = new JTextField();
		this.tfComponente6.setColumns(10);
		this.bOk6 = new JButton("ok");
		this.bOk6.addActionListener(this);

		//Resistencia
		JLabel lblNewLabel_1 = new JLabel("Resistencia");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.bPonerRes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bPonerRes){
					resistenciaV=Double.parseDouble(tresInicial.getText());
				}		
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(lComponente1)
																.addComponent(tfComponente1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lComponente2))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(bOk1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(tfComponente2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(bOk2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(lComponente3)
																.addComponent(tfComponente3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lComponente4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(bOk3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(tfComponente5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lComponente5, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
																.addComponent(lComponente6, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(bOk5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(tfComponente4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(bOk4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(12)
										.addComponent(tresInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bPonerRes))
								.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(tfComponente6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bOk6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(50)
										.addComponent(lblNewLabel_1))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(46)
										.addComponent(bResultado1)))
						.addContainerGap(6, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(23)
						.addComponent(lComponente1)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfComponente1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bOk1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lComponente2)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfComponente2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bOk2))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lComponente3)
						.addGap(12)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfComponente3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bOk3))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lComponente4)
						.addGap(6)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfComponente4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bOk4))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lComponente5)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfComponente5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bOk5))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lComponente6)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfComponente6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bOk6))
						.addGap(12)
						.addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(bPonerRes)
								.addComponent(tresInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(bResultado1)
						.addGap(199))
				);
		setLayout(groupLayout);
	}


	//Actions of the buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bOk1){
			if(this.componente!=null){				
				componente1= Double.parseDouble(tfComponente1.getText());
			}
			//checks its positive
			if(componente1<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}

			//prints value (Only for testing)
			System.out.println("El valor 1 es: "+componente1);
			this.addArray();
		}
		else if(e.getSource()==bOk2){
			if(this.componente!=null){
				componente2= Double.parseDouble(tfComponente2.getText());
			}
			//checks its positive
			if(componente2<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}

			//prints value (Only for testing)
			System.out.println("El valor 2 es: "+componente2);
			this.addArray();

		}else if(e.getSource()==this.bOk3){
			if(this.componente!=null){
				componente3= Double.parseDouble(tfComponente3.getText());
			}
			//checks its positive
			if(componente3<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}

			//prints value (Only for testing)
			System.out.println("El valor 3 es: "+componente3);
			this.addArray();

		}else if(e.getSource()==this.bOk4){			
			if(this.componente!=null){
				componente4= Double.parseDouble(tfComponente4.getText());
			}
			//checks its positive
			if(componente4<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}

			//prints value (Only for testing)
			System.out.println("El valor 4 es: "+componente4);
			this.addArray();

		}else if(e.getSource()==this.bOk5){
			if(this.componente!=null){
				componente5= Double.parseDouble(tfComponente5.getText());
			}
			//checks its positive
			if(componente5<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}

			//prints value (Only for testing)
			System.out.println("El valor 5 es: "+componente5);
			this.addArray();

		}else if(e.getSource()==this.bOk6){
			if(this.componente!=null){
				this.componente6= Double.parseDouble(tfComponente6.getText());
			}
			//checks its positive
			if(componente6<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
				tfComponente6.setText("0");
				componente6=0;
			}

			//prints value (Only for testing)
			System.out.println("El valor 6 es: "+this.componente6);
			this.addArray();
		}


		else if(e.getSource()==this.bResultado1){
			this.pr.setPaint(true);
			this.pr.repaint();
			
			System.out.println(this.componente1);
			System.out.println(this.componente2);
			System.out.println(this.componente3);
			System.out.println(this.componente4);
			System.out.println(this.componente5);
			System.out.println(this.componente6);
			
			System.out.println(this.componentev1);
			System.out.println(this.componentev2);
			System.out.println(this.componentev3);
			System.out.println(this.componentev4);
			System.out.println(this.componentev5);
			System.out.println(this.componentev6);
			
			
			this.sumaResistencia1=this.componente1+this.componente2+this.componente6;

			this.sumaVoltaje1=this.componentev1+this.componentev2+this.componentev6;

			this.sumaResistencia2=this.componente4+this.componente5+this.componente3;

			this.sumaVoltaje2=this.componentev4+this.componentev5+this.componentev3;

			System.out.println("suma Resistencia 1: "+this.sumaResistencia1);
			System.out.println("suma Resistencia 2: "+this.sumaResistencia2);
			System.out.println("suma voltaje 1: "+this.sumaVoltaje1);
			System.out.println("suma voltaje 2: "+this.sumaVoltaje2);
			
			System.out.println(gj.geti1());
			System.out.println(gj.geti2());

			try {
				this.formula();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void formula() throws IOException{
		this.sumaResistencia1=this.sumaResistencia1*(-1);
		this.sumaResistencia2=this.sumaResistencia2*(-1);
		this.sumaVoltaje1=this.sumaVoltaje1*(-1);
		this.sumaVoltaje2=this.sumaVoltaje2*(-1);
		System.out.println(this.sumaResistencia1+"(i1)+"+resistenciaV+"(i2)="+this.sumaVoltaje1);
		System.out.println(resistenciaV+"(i1)"+this.sumaResistencia2+"(i2)= "+this.sumaVoltaje2);
		PrintWriter pw=new PrintWriter(new FileWriter("in1."));
		pw.print(2);
		pw.print(" ");
		pw.println(3);
		pw.println(this.sumaResistencia1+" "+resistenciaV+" "+this.sumaVoltaje1);
		pw.println(resistenciaV+" "+this.sumaResistencia2+" "+this.sumaVoltaje2);
		pw.close();	

		gj.matrices(new FileReader("in1."), new FileWriter("outfile"));
	}

	public void setComponente(String componente){
		this.componente=componente;
	}

	public void setNum(int numero){
		this.num=numero;
	}

	public void addArray(){
		if(this.componente=="resistencia"){
			if(this.num==1){
				try {
					this.componente1=Double.parseDouble(this.tfComponente1.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente1.setText("Resistencia 1");
			}else if(this.num==2){
				try {
					this.componente2=Double.parseDouble(this.tfComponente2.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente2.setText("Resistencia 2");
			}else if(this.num==3){
				try {
					this.componente3=Double.parseDouble(this.tfComponente3.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente3.setText("Resistencia 3");
			}else if(this.num==4){
				try {
					this.componente4=Double.parseDouble(this.tfComponente4.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente4.setText("Resistencia 4");
			}else if(this.num==5){
				try {
					this.componente5=Double.parseDouble(this.tfComponente5.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente5.setText("Resistencia 5");
			}else if(this.num==6){
				try {
					this.componente6=Double.parseDouble(this.tfComponente6.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente6.setText("Resistencia 6");
			}
		}else if(this.componente=="voltaje"){
			if(this.num==1){
				try {
					System.out.println("soy un voltaje 2");
					this.componentev1=Double.parseDouble(this.tfComponente1.getText());
					System.out.println(this.componentev1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente1.setText("Voltaje 1");;
			}else if(this.num==2){
				try {
					this.componentev2=Double.parseDouble(this.tfComponente2.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente2.setText("Voltaje 2");
			}else if(this.num==3){
				try {
					this.componentev3=Double.parseDouble(this.tfComponente3.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente3.setText("Voltaje 3");
			}else if(this.num==4){
				try {
					this.componentev4=Double.parseDouble(this.tfComponente4.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente4.setText("Voltaje 4");
			}else if(this.num==5){
				try {
					this.componentev5=Double.parseDouble(this.tfComponente5.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente5.setText("Voltaje 5");
			}else if(this.num==6){
				try {
					this.componentev6=Double.parseDouble(this.tfComponente6.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente6.setText("Voltaje 6");
			}
		}
		System.out.println("Componente 1:"+componente1);
		System.out.println("Componente 2:"+componente2);
		System.out.println("Componente 3:"+componente3);
		System.out.println("Componente 4:"+componente4);
		System.out.println("Componente 5:"+componente5);
		System.out.println("Componente 6:"+componente6);
	}
}


