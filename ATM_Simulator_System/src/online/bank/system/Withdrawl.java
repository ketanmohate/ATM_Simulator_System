
package online.bank.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

	JTextField amount;
	JButton withdraw, back;
	JLabel image, text, l3;
	String pin;

	Withdrawl(String pin) {
		this.pin = pin;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170, 300, 400, 20);
		image.add(text);

		amount = new JTextField();
		amount.setFont(new Font("System", Font.BOLD, 22));
		amount.setBounds(170, 350, 320, 25);
		image.add(amount);

		withdraw = new JButton("Withdraw");
		// deposit.setFont(new Font("System", Font.BOLD, 22));
		withdraw.setBounds(355, 400, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);

		back = new JButton("Back");
		// deposit.setFont(new Font("System", Font.BOLD, 22));
		back.setBounds(355, 440, 150, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 900);
		// setUndecorated(true);
		setLocation(300, 0);
		setVisible(true);

		setLayout(null);

	}

//	public void actionPerformed(ActionEvent ae) {
//		if (ae.getSource() == withdraw) {
//			String number = amount.getText();
//			Date date = new Date();
//			if (number.equals("")) {
//				JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
//			} else {
//				try {
//					Conn conn = new Conn();
//					String query = ("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + number
//							+ "')");
//					conn.s.executeUpdate(query);
//					JOptionPane.showMessageDialog(null, "Rs. " + number + " withdrawl Successfully");
//					setVisible(false);
//					new Transactions(pin).setVisible(true);
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//		}
//
//	}
	
	public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == withdraw) {
	        String number = amount.getText();
	        Date date = new Date();
	        if (number.equals("")) {
	            JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
	        } else {
	            try {
	                Conn conn = new Conn();
	                String query = "insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + number + "')";
	                conn.s.executeUpdate(query);
	                JOptionPane.showMessageDialog(null, "Rs. " + number + " Withdrawn Successfully");
	                setVisible(false);
	                new Transactions(pin).setVisible(true);
	            } catch (Exception e) {
	                System.out.println(e);
	            }
	        }
	    } else if (ae.getSource() == back) { // Handling Back button
	        setVisible(false);
	        new Transactions(pin).setVisible(true); // Navigating back to Transactions page
	    }
	}


	public static void main(String[] args) {
		new Withdrawl("").setVisible(true);
	}
}
