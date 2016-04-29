package proyecto;
/**
 * Saved as PanelControles.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01630250
 * 
 * Started in April 6th, 2016
 * Last modified in April 28th, 2016
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
	//Every swing and component of the class is declared outside the constructor
	private PanelResultados pr;
	private GaussJordan gj;
	private String componente;
	private JTextField tresInicial;
	private JButton bResultado1,bPonerRes;
	private JButton bOk1,bOk2,bOk3,bOk4,bOk5,bOk6;
	private JTextField tfComponente1,tfComponente2,tfComponente3,tfComponente4,tfComponente5,tfComponente6;
	private JLabel lComponente1,lComponente2,lComponente3,lComponente4,lComponente5,lComponente6;

	//Declaration of global variables and needed components for the PanelControles Class
	private double componentev1,componentev2,componentev3,componentev4,componentev5,componentev6;
	private double sumaVoltaje1,sumaResistencia1,sumaVoltaje2,sumaResistencia2,resistenciaV;
	private double componente1,componente2,componente3,componente4,componente5,componente6;
	private boolean co1,co2,co3,co4,co5,co6;
	private int num;

	//Constructor
	public PanelControles(PanelResultados pr, GaussJordan gj) {
		super();
		this.setPreferredSize(new Dimension(200, 541));
		this.setBackground(new Color(225,225,225));	

		//Instantiate components
		this.gj=gj;
		this.pr = pr;
		this.bResultado1= new JButton("Resultado");
		this.tresInicial=new JTextField(6);
		this.bPonerRes=new JButton("Ok");

		//Color background changed to dark_gray
		bResultado1.setForeground(Color.DARK_GRAY);
		bPonerRes.setForeground(Color.DARK_GRAY);
		tresInicial.setForeground(Color.DARK_GRAY);

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

		//Resistance
		JLabel lblNewLabel_1 = new JLabel("Resistencia");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.bPonerRes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bPonerRes){
					resistenciaV=Double.parseDouble(tresInicial.getText());
				}		
			}
		});

		//This method were created by a Java Windows Builder in order to have a nice group layout for the component
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

	/**
	 * This is where all the actions that are performed by the buttons are described
	 * the buttons inside this method are: 
	 * each 'ok' button for textLabels in the PanelControles, also, the 'resultado' button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bOk1){
			//if component is not null then get the number inside the tfComponente1
			if(this.componente!=null){				
				componente1= Double.parseDouble(tfComponente1.getText());
			}
			//checks if the number its positive, if not then it alerts the user with a message dialog.
			if(componente1<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}
			//when the program checks its not null, and it's not negative. then it call the addArray method
			this.addArray();
		}else if(e.getSource()==bOk2){
			//if component is not null then get the number inside the tfComponente2
			if(this.componente!=null){
				componente2= Double.parseDouble(tfComponente2.getText());
			}
			//checks if the number its positive, if not then it alerts the user with a message dialog.
			if(componente2<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}
			//when the program checks its not null, and it's not negative. then it call the addArray method
			this.addArray();
		}else if(e.getSource()==this.bOk3){
			if(this.componente!=null){
				//if component is not null then get the number inside the tfComponente3
				componente3= Double.parseDouble(tfComponente3.getText());
			}
			//checks if the number its positive, if not then it alerts the user with a message dialog.
			if(componente3<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}
			//when the program checks its not null, and it's not negative. then it call the addArray method
			this.addArray();

		}else if(e.getSource()==this.bOk4){		
			//if component is not null then get the number inside the tfComponente4
			if(this.componente!=null){
				componente4= Double.parseDouble(tfComponente4.getText());
			}
			//checks if the number its positive, if not then it alerts the user with a message dialog.
			if(componente4<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}
			//when the program checks its not null, and it's not negative. then it call the addArray method
			this.addArray();

		}else if(e.getSource()==this.bOk5){
			//if component is not null then get the number inside the tfComponente5
			if(this.componente!=null){
				componente5= Double.parseDouble(tfComponente5.getText());
			}
			//checks if the number its positive, if not then it alerts the user with a message dialog.
			if(componente5<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
			}
			//when the program checks its not null, and it's not negative. then it call the addArray method
			this.addArray();

		}else if(e.getSource()==this.bOk6){
			//if component is not null then get the number inside the tfComponente6
			if(this.componente!=null){
				this.componente6= Double.parseDouble(tfComponente6.getText());
			}
			//checks if the number its positive, if not then it alerts the user with a message dialog.
			if(componente6<0){
				if(componente=="resistencia"){
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER RESISTENCIAS NEGATIVAS");
				}else{
					JOptionPane.showMessageDialog(null, "NO PUEDEN SER VOLTAJES NEGATIVOS");
				}
				tfComponente6.setText("0");
				componente6=0;
			}
			//when the program checks its not null, and it's not negative. then it call the addArray method
			this.addArray();
		}
		//Checks if the button pressed is the bResultado1
		else if(e.getSource()==this.bResultado1){
			//Paints the colored panelResultados
			//It gets all the components from the first net and sums them
			this.sumaResistencia1=this.componente1+this.componente2+this.componente6;
			this.sumaVoltaje1=this.componentev1+this.componentev2+this.componentev6;
			//It gets all the components from the second net and sums them
			this.sumaResistencia2=this.componente4+this.componente5+this.componente3;
			this.sumaVoltaje2=this.componentev4+this.componentev5+this.componentev3;
			
			//Catches the IOExceptio
			try {
				this.formula();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.multiplicaI();
		}
	}
	
	/**
	 * This method is in charge for the making of the two formulas that the circuit does
	 * in the other hand, it also writes in a in. archive the needed matrix for the Gauss Jordan operations
	 * and being able to get the i1 and i2 from the functions
	 * @throws IOException
	 */
	public void formula() throws IOException{
		this.sumaResistencia1=this.sumaResistencia1*(-1);
		this.sumaResistencia2=this.sumaResistencia2*(-1);
		this.sumaVoltaje1=this.sumaVoltaje1*(-1);
		this.sumaVoltaje2=this.sumaVoltaje2*(-1);
		System.out.println(this.sumaResistencia1+"(i1)+"+resistenciaV+"(i2)="+this.sumaVoltaje1);
		System.out.println(resistenciaV+"(i1)"+this.sumaResistencia2+"(i2)= "+this.sumaVoltaje2);
		PrintWriter pw = new PrintWriter(new FileWriter("in1."));
		pw.print(2);
		pw.print(" ");
		pw.println(3);
		pw.println(this.sumaResistencia1+" "+resistenciaV+" "+this.sumaVoltaje1);
		pw.println(resistenciaV+" "+this.sumaResistencia2+" "+this.sumaVoltaje2);
		pw.close();	
		this.pr.setPaint(true);
		this.pr.repaint();
		gj.matrices(new FileReader("in1."), new FileWriter("outfile"));
		//JOptionPane.showMessageDialog(null, "Hola");
	}
	
	/**
	 * Getter of the function to get which component is chosen 
	 * and been able to have difference between resistances and voltages
	 * @param componente
	 */
	public void setComponente(String componente){
		this.componente=componente;
	}

	/**
	 * This function is a basic setter for the num variable in the panelMall
	 * @param numero
	 * The parameter numero is the one that defines the button that has been clicked in the panelMalla
	 */
	public void setNum(int numero){
		this.num=numero;
	}

	/**
	 * Add array is in charge of adding the text fields containers into the containers of each component in order to sum them
	 * it also differentiates the voltages from the resistances.
	 * the component is surrounded by a try catch because in the moment they are created, there are no components in their text fields
	 */
	public void addArray(){
		if(this.componente=="resistencia"){
			if(this.num==1){
				//if co1 is true then co1 is a resistance
				//this.co1=true;
				try {
					this.componente1=Double.parseDouble(this.tfComponente1.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente1.setText("Resistencia 1");
			}else if(this.num==2){
				//if co2 is true then co2 is a resistance
				this.co2=true;
				try {
					this.componente2=Double.parseDouble(this.tfComponente2.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente2.setText("Resistencia 2");
			}else if(this.num==3){
				//if co3 is true then co3 is a resistance
				this.co3=true;
				try {
					this.componente3=Double.parseDouble(this.tfComponente3.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente3.setText("Resistencia 3");
			}else if(this.num==4){
				//if co4 is true then co4 is a resistance
				this.co4=true;
				try {
					this.componente4=Double.parseDouble(this.tfComponente4.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente4.setText("Resistencia 4");
			}else if(this.num==5){
				//if co5 is true then co5 is a resistance
				this.co5=true;
				try {
					this.componente5=Double.parseDouble(this.tfComponente5.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente5.setText("Resistencia 5");
			}else if(this.num==6){
				//if co6 is true then co6 is a resistance
				this.co6=true;
				try {
					this.componente6=Double.parseDouble(this.tfComponente6.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente6.setText("Resistencia 6");
			}
		}else if(this.componente=="voltaje"){
			if(this.num==1){
				this.co1=false;
				try {
					this.componentev1=Double.parseDouble(this.tfComponente1.getText());
					System.out.println(this.componentev1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente1.setText("Voltaje 1");;
			}else if(this.num==2){
				this.co2=false;
				try {
					this.componentev2=Double.parseDouble(this.tfComponente2.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente2.setText("Voltaje 2");
			}else if(this.num==3){
				this.co3=false;
				try {
					this.componentev3=Double.parseDouble(this.tfComponente3.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente3.setText("Voltaje 3");
			}else if(this.num==4){
				this.co4=false;
				try {
					this.componentev4=Double.parseDouble(this.tfComponente4.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente4.setText("Voltaje 4");
			}else if(this.num==5){
				this.co5=false;
				try {
					this.componentev5=Double.parseDouble(this.tfComponente5.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente5.setText("Voltaje 5");
			}else if(this.num==6){
				this.co6=false;
				try {
					this.componentev6=Double.parseDouble(this.tfComponente6.getText());					
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.lComponente6.setText("Voltaje 6");
			}
		}
	}

	/**
	 * Multiplica method gets the local i1 and i2 to get each cable value and multiply it if it is a resistor
	 * if not, then it will just send the voltage value, the co1 values helps to see where it is a voltage 
	 * and where is a resistance, true for resistance and false for voltage.
	 */
	public void multiplicaI(){
		double i1=gj.geti1();
		double i2=gj.geti2();
		double cable1,cable2,cable3,cable4,cable5,cable6;
		//if true then multiply component for the respective i and save it in the cable variable
		if(this.co1){
			cable1=componente1*i1;			
		}else cable1=componente1;

		if(this.co2){			
			cable2=componente2*i1;
		}else cable2=componente2;

		if(this.co3){			
			cable3=componente3*i2;
		}else cable3=componente3;

		if(this.co4){			
			cable4=componente4*i2;
		}else cable4=componente4;

		if(this.co5){			
			cable5=componente5*i2;
		}else cable5=componente5;

		if(this.co6){			
			cable6=componente6*i1;
		}else cable6=componente6;
		
		//this function is extended from the PanelResultados and it sends all the values to the panel
		pr.setCables(cable1, cable2, cable3, cable4, cable5, cable6);
	}
}