import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FungsiKalkulator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] FunctionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;

	Font myfont = new Font("Hack", Font.BOLD,30);

	double num1=0, num2=0, hasil=0;
	char operator;

	FungsiKalkulator(){

		frame = new JFrame("Kalkulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				
					String pesanterimakasih = "Terima Kasih telah mencoba proyek saya!\n\nNama: Kevin Adiputra Mahesa\nNim: 09011282328115\nKelas: SK1A\nSumber pengetahuan: youtube, Chrome, Chat Gpt";
					JOptionPane.showMessageDialog(frame, pesanterimakasih);
					System.out.println(pesanterimakasih);
				
				System.exit(0);
			}
		});

		textfield = new JTextField();
		textfield.setBounds(50,25,300,50);
		textfield.setFont(myfont);
		textfield.setEditable(false);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");

		FunctionButtons[0] = addButton;
		FunctionButtons[1] = subButton;
		FunctionButtons[2] = mulButton;
		FunctionButtons[3] = divButton;
		FunctionButtons[4] = decButton;
		FunctionButtons[5] = equButton;
		FunctionButtons[6] = delButton;
		FunctionButtons[7] = clrButton;
		FunctionButtons[8] = negButton;

		for(int i = 0;i<9;i++){
			FunctionButtons[i].addActionListener(this);
			FunctionButtons[i].setFont(myfont);
			FunctionButtons[i].setFocusable(false);
		}

		for(int i = 0;i<10;i++){
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myfont);
			numberButtons[i].setFocusable(false);
		}

		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);

		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);

	}

	public void Kalkulator() {

		Kalkulator calc = new Kalkulator();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++){
			if(e.getSource() == numberButtons[i]){
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton){
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()==subButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource()==divButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource()==equButton){
			num2=Double.parseDouble(textfield.getText());

			switch(operator){
			case '+':
				hasil=num1+num2;
				break;	
			case '-':
				hasil=num1-num2;
				break;
			case '*':
				hasil=num1*num2;
				break;
			case '/':
				hasil=num1/num2;
				break;			
			}
			textfield.setText(String.valueOf(hasil));
			num1 = hasil;
		}
		if(e.getSource()==clrButton){
			textfield.setText("");
		}
		if(e.getSource()==delButton){
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++){
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton){
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}

	}

}