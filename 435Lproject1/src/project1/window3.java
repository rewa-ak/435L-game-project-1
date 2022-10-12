package project1;
/**
 * User scores page class
 * Inherits window 2
 * @author Rewa, Awoun
 * @version 1.0
 */
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class window3 extends window2 {
	private static JTextField txtEnterYourAnswer;
/**
 * Main function to call showWindow function
 * @param args
 */
	public static void main(String[] args) {
		showWindow();}

	/**
	 * Displays the frame created for this window
	 */
	public static void showWindow() {

JFrame frame = new JFrame("window3");
frame.setBounds(100, 100, 450, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JButton btnNewButton = new JButton("Exit\r\n");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		System.exit(1);
	}
});
btnNewButton.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 16));
btnNewButton.setBounds(361, 230, 63, 21);
frame.getContentPane().add(btnNewButton);
JButton btnNewButton_1 = new JButton("Home");
btnNewButton_1.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		gameStart frame = new gameStart();
		frame.setVisible(true);
		

		
	}
	

});
btnNewButton_1.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 16));
btnNewButton_1.setBounds(22, 230, 68, 21);
frame.getContentPane().add(btnNewButton_1);
JLabel lblNewLabel = new JLabel("Username: " + username);
JLabel level1scoreJLabel=new JLabel("Level 1 score: " + level1result);
JLabel level2scoreJLabel=new JLabel("Level 2 score: " + level2result);
JLabel level3scoreJLabel=new JLabel("Level 3 score: " + level3result);


lblNewLabel.setBounds(42, 58, 89, 23);
level1scoreJLabel.setBounds(42, 97, 89, 23);
level2scoreJLabel.setBounds(42, 136, 89, 23);
level3scoreJLabel.setBounds(42, 175, 89, 23);
frame.getContentPane().add(lblNewLabel);
frame.getContentPane().add(level1scoreJLabel);
frame.getContentPane().add(level2scoreJLabel);
frame.getContentPane().add(level3scoreJLabel);



frame.setVisible(true);
}}
