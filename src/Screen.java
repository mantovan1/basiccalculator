import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Screen extends JFrame{
	
	JLabel lbl_display;
	
	JButton btn_clear;
	JButton btn_equals;
	
	JButton btn_number[] = new JButton[10];
	
	JButton btn_plus;
	JButton btn_minus;
	JButton btn_times;
	JButton btn_dividedBy;
	
	char operator;

	public Screen() {
		
		setTitle("Calculator");
		setLayout(null);
		setResizable(false);
		setSize(300, 270);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		lbl_display = new JLabel();
		lbl_display.setBounds(10, 10, 208, 40);
		lbl_display.setOpaque(true);
		lbl_display.setBackground(new Color(220, 220, 220));
		add(lbl_display);
		
		btn_clear = new JButton("C");
		btn_clear.setBounds(220, 10, 68, 40);
		btn_clear.setBackground(new Color(48,48,48));
		btn_clear.setForeground(Color.WHITE);
		btn_clear.setBorderPainted(false);
		btn_clear.addActionListener(e -> lbl_display.setText(""));
		add(btn_clear);
		
		btn_number[9] = new JButton("9");
		btn_number[9].setBounds(150, 60, 68, 40);
		btn_number[9].setBackground(new Color(48,48,48));
		btn_number[9].setForeground(Color.WHITE);
		btn_number[9].setBorderPainted(false);
		btn_number[9].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 9));
		add(btn_number[9]);
		
		btn_number[8] = new JButton("8");
		btn_number[8].setBounds(80, 60, 68, 40);
		btn_number[8].setBackground(new Color(48,48,48));
		btn_number[8].setForeground(Color.WHITE);
		btn_number[8].setBorderPainted(false);
		btn_number[8].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 8));
		add(btn_number[8]);
		
		btn_number[7] = new JButton("7");
		btn_number[7].setBounds(10, 60, 68, 40);
		btn_number[7].setBackground(new Color(48,48,48));
		btn_number[7].setForeground(Color.WHITE);
		btn_number[7].setBorderPainted(false);
		btn_number[7].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 7));
		add(btn_number[7]);
		
		btn_number[6] = new JButton("6");
		btn_number[6].setBounds(150, 102, 68, 40);
		btn_number[6].setBackground(new Color(48,48,48));
		btn_number[6].setForeground(Color.WHITE);
		btn_number[6].setBorderPainted(false);
		btn_number[6].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 6));
		add(btn_number[6]);
		
		btn_number[5] = new JButton("5");
		btn_number[5].setBounds(80, 102, 68, 40);
		btn_number[5].setBackground(new Color(48,48,48));
		btn_number[5].setForeground(Color.WHITE);
		btn_number[5].setBorderPainted(false);
		btn_number[5].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 5));
		add(btn_number[5]);
		
		btn_number[4] = new JButton("4");
		btn_number[4].setBounds(10, 102, 68, 40);
		btn_number[4].setBackground(new Color(48,48,48));
		btn_number[4].setForeground(Color.WHITE);
		btn_number[4].setBorderPainted(false);
		btn_number[4].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 4));
		add(btn_number[4]);
		
		btn_number[3] = new JButton("3");
		btn_number[3].setBounds(150, 144, 68, 40);
		btn_number[3].setBackground(new Color(48,48,48));
		btn_number[3].setForeground(Color.WHITE);
		btn_number[3].setBorderPainted(false);
		btn_number[3].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 3));
		add(btn_number[3]);
		
		btn_number[2] = new JButton("2");
		btn_number[2].setBounds(80, 144, 68, 40);
		btn_number[2].setBackground(new Color(48,48,48));
		btn_number[2].setForeground(Color.WHITE);
		btn_number[2].setBorderPainted(false);
		btn_number[2].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 2));
		add(btn_number[2]);
		
		btn_number[1] = new JButton("1");
		btn_number[1].setBounds(10, 144, 68, 40);
		btn_number[1].setBackground(new Color(48,48,48));
		btn_number[1].setForeground(Color.WHITE);
		btn_number[1].setBorderPainted(false);
		btn_number[1].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 1));
		add(btn_number[1]);
		
		btn_number[0] = new JButton("0");
		btn_number[0].setBounds(10, 186, 68, 40);
		btn_number[0].setBackground(new Color(48,48,48));
		btn_number[0].setForeground(Color.WHITE);
		btn_number[0].setBorderPainted(false);
		btn_number[0].addActionListener(e -> lbl_display.setText(lbl_display.getText() + 0));
		add(btn_number[0]);
		
		btn_equals = new JButton("=");
		btn_equals.setBounds(80, 186, 138, 40);
		btn_equals.setBackground(new Color(8, 67, 11));
		btn_equals.setForeground(Color.WHITE);
		btn_equals.setBorderPainted(false);
		btn_equals.addActionListener(e -> {
			
			String display = lbl_display.getText();
			
			if(this.operator != 0) {
			
				display = display.replace('+', ' ');
				display = display.replace('-', ' ');
				display = display.replace('×', ' ');
				display = display.replace('÷', ' ');
				
				String number[] = display.split(" ", 2);
				
				Calcs c = new Calcs();
				
				Double results = new Double(0);
				
				switch (this.operator) {
				
				case '+':
				
					results = c.addition(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
					break;
					
				case '-':
					
					results = c.subtraction(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
					break;
					
				case '×':
					
					results = c.multiplication(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
					break;
					
				case '÷':
					
					results = c.division(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
				
				} 
				
				if (results - Math.round(results) == 0) {
					
					Integer r = (int) Math.round(results);
					
					lbl_display.setText(r.toString());
					
				} else {
				
					lbl_display.setText(results.toString());
					
				}
				
				this.operator = 0;
				
			}
			
		});
		add(btn_equals);
		
		btn_plus = new JButton("+");
		btn_plus.setBounds(220, 186, 68, 40);
		btn_plus.setBackground(new Color(255,127,80));
		btn_plus.setForeground(Color.WHITE);
		btn_plus.setBorderPainted(false);
		btn_plus.addActionListener(e -> validateOperator('+'));
		add(btn_plus);
		
		btn_minus = new JButton("-");
		btn_minus.setBounds(220, 144, 68, 40);
		btn_minus.setBackground(new Color(255,127,80));
		btn_minus.setForeground(Color.WHITE);
		btn_minus.setBorderPainted(false);
		btn_minus.addActionListener(e -> validateOperator('-'));
		add(btn_minus);
		
		btn_times = new JButton("×");
		btn_times.setBounds(220, 102, 68, 40);
		btn_times.setBackground(new Color(255,127,80));
		btn_times.setForeground(Color.WHITE);
		btn_times.setBorderPainted(false);
		btn_times.addActionListener(e -> validateOperator('×'));
		add(btn_times);
		
		btn_dividedBy = new JButton("÷");
		btn_dividedBy.setBounds(220, 60, 68, 40);
		btn_dividedBy.setBackground(new Color(255,127,80));
		btn_dividedBy.setForeground(Color.WHITE);
		btn_dividedBy.setBorderPainted(false);
		btn_dividedBy.addActionListener(e -> validateOperator('÷'));
		add(btn_dividedBy);
		
		setVisible(true);
		
	}
	
	public void validateOperator(char operator) {
		
		char last_char;
		
		if (lbl_display.getText() != "") {
		
			last_char = lbl_display.getText().charAt(lbl_display.getText().length()-1);
			
			if (
				(last_char != '+') &&
				(last_char != '-') &&
				(last_char != '×') &&
				(last_char != '÷') &&
				(this.operator == 0)
			) {
				
				lbl_display.setText(lbl_display.getText() + operator);
				this.operator = operator;
				
			}
		
		}
		
	}

}
