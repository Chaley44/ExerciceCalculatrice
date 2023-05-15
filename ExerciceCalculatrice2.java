package tpjavaswing.events;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExerciceCalculatrice2 implements ActionListener{

	JFrame frame;
	JTextField ecran;
	JPanel panelEcran;
	
	JButton[] numberButton = new JButton[10];
	JButton[] functionButton = new JButton[7];
	
	JButton addButton, subButton, mulButton, divButton, pointButton, egaleButton, delButton;
	JPanel container;
	JPanel panelBouton;
	JPanel panelOperateur;
	
	Font police = new Font("Verdana", Font.PLAIN, 16);
	double chiffre1 = 0, chiffre2 =0 , result = 0;
	char operateur;
	
	
	public ExerciceCalculatrice2() {
		frame = new JFrame("Calculatrice");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		container = new JPanel();
		ecran = new JTextField("582.9");
		ecran.setPreferredSize(new Dimension(220,20));
		ecran.setFont(police);
		
		panelEcran = new JPanel();
		panelEcran.setPreferredSize(new Dimension(220, 30));
		panelEcran.add(ecran);
		
		
		
		addButton= new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton =  new JButton("/");
		pointButton = new JButton(".");
		egaleButton =new JButton("=");
		delButton = new JButton("C");
		
		
		functionButton[0] = addButton;
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = pointButton;
		functionButton[5] = egaleButton;
		functionButton[6] = delButton;
		
		for(int i = 0; i<7; i++) {
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(police);
			functionButton[i].setFocusable(false);
		}
		
		for(int i = 0;i<10;i++) {
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFocusable(false);
		}
		
		container.setLayout(new BorderLayout());
		
		panelBouton = new JPanel();
		panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		panelBouton.add(numberButton[1]);
		panelBouton.add(numberButton[2]);
		panelBouton.add(numberButton[3]);
		panelBouton.add(numberButton[4]);
		panelBouton.add(numberButton[4]);
		panelBouton.add(numberButton[5]);
		panelBouton.add(numberButton[6]);
		panelBouton.add(numberButton[7]);
		panelBouton.add(numberButton[8]);
		panelBouton.add(numberButton[9]);
		panelBouton.add(numberButton[0]);
		panelBouton.add(pointButton);
		panelBouton.add(egaleButton);
		
		panelOperateur = new JPanel();
		
		panelOperateur.setLayout(new GridLayout(0, 1, 5, 5));
		panelOperateur.add(delButton);
		panelOperateur.add(addButton);
		panelOperateur.add(subButton);
		panelOperateur.add(mulButton);
		panelOperateur.add(divButton);
		
		
		container.add(panelEcran, BorderLayout.NORTH);
		container.add(panelOperateur, BorderLayout.EAST);
		container.add(panelBouton, BorderLayout.CENTER);
		
		frame.add(container);
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		ExerciceCalculatrice2 calculette = new ExerciceCalculatrice2();

	}
	public void initBouton() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<10; i++ ) {
			if(e.getSource() == numberButton[i]) {
				ecran.setText(ecran.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == pointButton) {
			ecran.setText(ecran.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			chiffre1 = Double.parseDouble(ecran.getText());
			operateur = '+';
			ecran.setText("");
		}
		if(e.getSource() == subButton) {
			chiffre1 = Double.parseDouble(ecran.getText());
			operateur = '-';
			ecran.setText("");
		}
		if(e.getSource() == mulButton) {
			chiffre1 = Double.parseDouble(ecran.getText());
			operateur = '*';
			ecran.setText("");
		}
		if(e.getSource() == divButton) {
			chiffre1 = Double.parseDouble(ecran.getText());
			operateur = '/';
			ecran.setText("");
		}
		if(e.getSource() == egaleButton) {
			chiffre2 = Double.parseDouble(ecran.getText());
			switch(operateur) {
			
			case '+':result = chiffre1 + chiffre2;
				break;
			case '-': result = chiffre1 - chiffre2;
				break;
			case '*': result = chiffre1 * chiffre2;
				break;
			case '/': try{
				result = chiffre1 / chiffre2;
			} catch(ArithmeticException a) {
		        ecran.setText("0");
				break;
				
			}
			}
			ecran.setText(String.valueOf(result));
			chiffre1 = result;
		}
		
		
		if(e.getSource() == delButton) {
			ecran.setText("");
			
		}
	}

}
