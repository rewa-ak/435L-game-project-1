package project1;
/**
 * Main game play page 
 * inhereting the gameStart class
 * @author Rewa, Awoun
 * @version 1.0
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class window2 extends gameStart {
	public static int x;
	public static int y;
	public static int z;
	public static String[] mathEqStrings= {"0","0","0","0","0","0","0","0","0","0"};
	public static String[] eqresultsStrings= {"0","0","0","0","0","0","0","0","0","0"};
	public static String[] opStrings={"+","*","-","/"};
	public static int n;
	public static int m;
	public static int cursor;
	public static boolean answer=false;
	
	//copied function
	/**
	 * Random number generator (integer)
	 * @param min min number of the random number
	 * @param max max number of the random number
	 * @return random number needed
	 */
	public static int randomNum(int min, int max) {
	    Random foo = new Random();
	    int randomNumber = foo.nextInt(max - min) + min;
	    return randomNumber;
	}
	
	//copied function 
	/**
	 * A function to remove an element from the array
	 * @param arr array targeted
	 * @param index index of the array that we need toremove
	 * @return the new edited array
	 */
    public static int[] removeTheElement(int[] arr, int index)
    {
 
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
            || index >= arr.length) {
 
            return arr;
        }
 
        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];
 
        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {
 
            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }
 
            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }
 
        // return the resultant array
        return anotherArray;
    }
    /**
     * A function to generate math equations for every level of the game
     * It generates two arrays one for the math equations another for the results
     * @param Level determines the level chosen by the user
     * @throws ScriptException
     */
	public static void mathEquations(int Level) throws ScriptException {
		
		if (Level==1) {
			
			for (int i=0;i<10;i++) {
				x=randomNum(0, 9);
				y=randomNum(-9, 9);
				if (y<0) {
					mathEqStrings[i]=String.valueOf(x)+String.valueOf(y);
				}
				else {
					mathEqStrings[i]=String.valueOf(x)+"+"+String.valueOf(y);
				}
				eqresultsStrings[i]=String.valueOf(x+y);
				
			}
		}
		else if(level==2) {
			for (int i=0;i<10;i++) {
				x=randomNum(0, 99);
				y=randomNum(-99, 99);
				if (y<0) {
					mathEqStrings[i]=String.valueOf(x)+String.valueOf(y);
				}
				else {
					mathEqStrings[i]=String.valueOf(x)+"+"+String.valueOf(y);
				}
				eqresultsStrings[i]=String.valueOf(x+y);
				
			}
		}
		else if(level==3) {
			for (int i=0;i<10;i++) {
				int[] opChoice= {0,1,2,3};
				n=randomNum(0, 3);
				int[] opChoice2= removeTheElement(opChoice, n);
				m=randomNum(0,2); //remove n from opChoice
				String op1=opStrings[opChoice[n]];
				String op2=opStrings[opChoice2[m]];
				x=randomNum(0, 99);
				y=randomNum(0, 99);
				z=randomNum(0, 99);
				if (op1=="/") {
					if (y==0){y=randomNum(1, 99);}
					x=y*x;
				}
				if (op2=="/") {
					if (z==0){z=randomNum(1, 99);}
					y=z*y;
				}
				ScriptEngineManager mgr = new ScriptEngineManager();
			    ScriptEngine engine = mgr.getEngineByName("JavaScript");
				mathEqStrings[i]=String.valueOf(x)+op1+String.valueOf(y)+op2+String.valueOf(z);
				eqresultsStrings[i]=(String) engine.eval(mathEqStrings[i]);
								
			}
		}
	}
	private static JTextField txtEnterYourAnswer;
	/**
	 * Main function to open the window of the game and calls the mathEquations function
	 * @param args
	 */

	public static void main(String[] args)  {
		try {
			mathEquations(level);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			showWindow();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
/**
 * The frame generator function to display the game
 * @throws ScriptException
 */
	
	public static void showWindow() throws ScriptException {
		JFrame frame = new JFrame("window2");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		txtEnterYourAnswer = new JTextField();
		txtEnterYourAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterYourAnswer.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 13));
		txtEnterYourAnswer.setText("Enter your answer here");
		txtEnterYourAnswer.setBounds(10, 230, 103, 20);
		frame.getContentPane().add(txtEnterYourAnswer);
		txtEnterYourAnswer.setColumns(10);
		
		

		JButton btnNewButton = new JButton("Results\r\n");
		btnNewButton.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 16));
		btnNewButton.setBounds(355, 230, 69, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		window3 w3 = new window3();
		w3.showWindow();

		
	}
	
});
		JTextField equationField= new JTextField("",10);
		mathEquations(level);
		for (int j=0;j<10;j++) {
			int cols=randomNum(50, 350);
			cursor=j;
			answer=false;
			for (int k=0;k<1000;k++) {
				
				equationField.setText(mathEqStrings[j]);
				equationField.setBounds(cols, k+5, 100,23 );
				frame.getContentPane().add(equationField);
				try {
					Thread.sleep(1000-speed);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (answer==true) {break;}
			}
		}
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 16));
		btnNewButton_1.setBounds(123, 230, 69, 21);
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtEnterYourAnswer.getText()==eqresultsStrings[cursor]) {
					if (level==1) {
						level1result++;
					}
					else if(level==2) {
						level2result++;
					}
					else if(level==3) {
						level3result++;
					}
					answer=true;
					
				}
				else {
					JLabel wrongAnswer=new JLabel("Wrong answer, try again");
					wrongAnswer.setBounds(202,230,69,21);
					frame.getContentPane().add(wrongAnswer);
				}
			}
			
		});
		frame.setVisible(true);
}}
