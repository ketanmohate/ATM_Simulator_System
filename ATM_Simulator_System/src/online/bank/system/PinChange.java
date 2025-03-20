
package online.bank.system;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
	JPasswordField pin1, repin;
	JButton change, back;
	JLabel image, text, pintext, repintext;
	String pin;

	PinChange(String pin) {
		this.pin = pin;

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		text = new JLabel("CHANGE YOUR PIN");
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.WHITE);
		text.setBounds(250, 260, 500, 40);
		image.add(text);

		pintext = new JLabel("New PIN:");
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setForeground(Color.WHITE);
		pintext.setBounds(165, 320, 180, 35);
		image.add(pintext);

		pin1 = new JPasswordField();
		pin1.setFont(new Font("Raleway", Font.BOLD, 25));
		pin1.setBounds(330, 320, 180, 25);
		image.add(pin1);

		repintext = new JLabel("Re-Enter New PIN:");
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setForeground(Color.WHITE);
		repintext.setBounds(165, 360, 180, 35);
		image.add(repintext);

		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 25));
		repin.setBounds(330, 360, 180, 25);
		image.add(repin);

		change = new JButton("CHANGE");
		change.setBounds(355, 485, 150, 30);
		change.addActionListener(this);
		image.add(change);

		back = new JButton("BACK");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);

		setLayout(null);

		setSize(900, 900);
		setLocation(300, 0);
		// setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {
			try {
				String npin = pin1.getText();
				String rpin = repin.getText();

				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				if (ae.getSource() == change) {
					if (pin1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Enter New PIN");
					}
					if (repin.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
					}
				}
				Conn c1 = new Conn();
				String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pin + "' ";
				String query2 = "update login set pin = '" + rpin + "' where pin = '" + pin + "' ";
				String query3 = "update signupthree set pin = '" + rpin + "' where pin = '" + pin + "' ";

				c1.s.executeUpdate(query1);
				c1.s.executeUpdate(query2);
				c1.s.executeUpdate(query3);
				JOptionPane.showMessageDialog(null, "PIN changed successfully");
				setVisible(false);
				new Transactions(rpin).setVisible(true);

			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			setVisible(false);
			new Transactions(pin).setVisible(true);// rpin
		}
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
