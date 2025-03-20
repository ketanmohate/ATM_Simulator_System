
package online.bank.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

	long random;
	JTextField pan, aadhar;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox religion, category, income, education, occupation;
	String formno;

	SignupTwo(String formno) {
		this.formno = formno;
		setLayout(null);

		setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");

		JLabel additionalDetails = new JLabel("Page 2:  Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 25));
		additionalDetails.setBounds(290, 20, 400, 30);
		add(additionalDetails);

		JLabel name = new JLabel("Religion : ");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 80, 100, 30);
		add(name);
//        
		String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Others" };
		religion = new JComboBox(valReligion);
		religion.setBounds(300, 80, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);

		JLabel fname = new JLabel("Category : ");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 140, 200, 30);
		add(fname);

		String valCategory[] = { "General", "OBC", "SC", "ST", "Others" };
		category = new JComboBox(valCategory);
		category.setBounds(300, 140, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);

		JLabel mobileno = new JLabel("Income: ");
		mobileno.setFont(new Font("Raleway", Font.BOLD, 20));
		mobileno.setBounds(100, 200, 100, 30);
		add(mobileno);

		String incomeCategory[] = { "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000" };
		income = new JComboBox(incomeCategory);
		income.setBounds(300, 200, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
//        

		JLabel dob = new JLabel("Educational  ");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 260, 200, 30);
		add(dob);

		JLabel gender = new JLabel("Qualification : ");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		String educationaValues[] = { "Non-Graducate", "Graduate", "Post-Graduation", "Doctrate", "Others" };
		education = new JComboBox(educationaValues);
		education.setBounds(300, 275, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
//        

		JLabel email = new JLabel("Occupation : ");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);

		String occupationValues[] = { "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others" };
		occupation = new JComboBox(occupationValues);
		occupation.setBounds(300, 340, 400, 30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
//        

		JLabel marital = new JLabel("Pan Number : ");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 400, 200, 30);
		add(marital);

		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
		pan.setBounds(300, 400, 400, 30);
		add(pan);

		JLabel address = new JLabel("Aadhar Number : ");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 460, 200, 30);
		add(address);

		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		aadhar.setBounds(300, 460, 400, 30);
		add(aadhar);

		JLabel city = new JLabel("Senior Citizen : ");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 510, 200, 30);
		add(city);

		syes = new JRadioButton("Yes");
		syes.setBounds(300, 510, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);

		sno = new JRadioButton("No ");
		sno.setBounds(450, 510, 150, 30);
		sno.setBackground(Color.WHITE);
		add(sno);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(syes);
		maritalGroup.add(sno);

		JLabel state = new JLabel("Existing Account : ");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 550, 200, 30);
		add(state);

		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 550, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);

		eno = new JRadioButton("No ");
		eno.setBounds(450, 550, 150, 30);
		eno.setBackground(Color.WHITE);
		add(eno);

		ButtonGroup emaritalGroup = new ButtonGroup();
		emaritalGroup.add(eyes);
		emaritalGroup.add(eno);

		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 570, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);

		setSize(850, 900);
		setLocation(350, 20);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		String formno = "" + random;
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		String seniorcitizen = null;
		if (syes.isSelected()) {
			seniorcitizen = "Yes";
		} else if (sno.isSelected()) {
			seniorcitizen = "NO";
		}

		String existingaccount = null;
		if (eyes.isSelected()) {
			existingaccount = "Yes";
		} else if (eno.isSelected()) {
			existingaccount = "No";
		}

		String span = pan.getText();
		String saadhar = aadhar.getText();

		try {
			Conn c = new Conn();
			String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','"
					+ sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','"
					+ seniorcitizen + "','" + existingaccount + "')";

			c.s.executeUpdate(query);

			new SignupThree(formno).setVisible(true);
			setVisible(false);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new SignupTwo("").setVisible(true);
	}

}
