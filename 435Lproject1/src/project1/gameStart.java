package project1;
/**
 * Game Welcome page
 * @author Rewa, Awoun
 * @version 1.0
 * 
 */

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.script.ScriptException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class gameStart extends JFrame {
	public static int level1result=0;
	public static int level2result=0;
	public static int level3result=0;
	public String level1String="Level 1";
	public String level2String="Level 2";
	public String level3String="Level 3";
	public static String username= "";
	public static int level=0;
	public static int speed=0;
	private JPanel contentPane;
	

	
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameStart frame = new gameStart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameStart() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField user = new JTextField("username",30);
		user.setBounds(42, 58, 89, 23);
		JLabel lblTypeYourUsername = new JLabel("Enter your Username\r\n");
		lblTypeYourUsername.setBounds(42, 40, 154, 14);
		contentPane.add(lblTypeYourUsername);
		contentPane.add(user);
		
		JTextField speedField= new JTextField("0",30);
		speedField.setBounds(42,136,89,23);
		JLabel lblTypeYourSpeed= new JLabel("Choose your desired speed\r\n");
		lblTypeYourSpeed.setBounds(42, 118, 200, 14);
		contentPane.add(lblTypeYourSpeed);
		contentPane.add(speedField);
		
		JButton level1 = new JButton("Level 1");
		level1.setBounds(286, 58, 89, 23);
		contentPane.add(level1);
		
		JButton level2 = new JButton("Level 2");
		level2.setBounds(286, 97, 89, 23);
		contentPane.add(level2);
		
		JButton level3 = new JButton("Level 3");
		level3.setBounds(286, 136, 89, 23);
		contentPane.add(level3);
		
		username= user.getText();
		speed=Integer.parseInt(speedField.getText());
		
		level1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level=1;
				window2 w2 = new window2();
				try {
					window2.showWindow();
				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		level2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level=2;
				window2 w2 = new window2();
				try {
					window2.showWindow();
				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		level3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level=3;
				window2 w2 = new window2();
				try {
					window2.showWindow();
				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton QUIT = new JButton("QUIT");
		QUIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		QUIT.setBounds(286, 214, 89, 23);
		contentPane.add(QUIT);
	}
}
