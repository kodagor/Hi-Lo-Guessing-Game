import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;	// text field for the user's guess
	private JLabel lblOutput;		// label for too high/to low output
	private int theNumber;			// the number we're trying to guess
	private int triesLeft = 7;		// setting the number of tries
	
	public void checkGuess() {		// method to check too high or too low
		// get the user's guess
		String guessText = txtGuess.getText();
		String message = "";

		try {	
			// check the guess for too high/too low
			int guess = Integer.parseInt(guessText);
			
			// count this as one trial
			triesLeft--;
			
			// too high
			if (guess > theNumber) {
				message = guess + " is too high. ";
				message += "You have " + triesLeft + " tries left";
				lblOutput.setText(message);
			}
			// too low
			else if (guess < theNumber) {
				message = guess + " is to low.";
				message += "You have " + triesLeft + " tries left";
				lblOutput.setText(message);
			} 
			// equal
			else {
				message = guess + " is right. You win! Let's play again!";
				lblOutput.setText(message);
				newGame();
			}
			
			// popup confirm!!! SEARCH MORE IN GOOGLE (no and cancel option!!!)
			
			if (triesLeft <= 0) {
				javax.swing.JOptionPane.showMessageDialog(null, "Sorry, you ran out of tries. The number was " + theNumber + ". Play again!");
				
				newGame();
			}
		} catch (Exception e) {
			lblOutput.setText("Enter a whole number between 1 and 100");
		} finally {
			// leaving text field ready
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	
	public void newGame() { // create a new random number 1 ... 100
		theNumber = (int)(Math.random() * 100 + 1);
		triesLeft = 7;
	}
	
	public GuessingGame() {
		setTitle("Guessing Game");
		getContentPane().setBackground(new Color(102, 51, 204));
		setBackground(new Color(102, 51, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblKodagorsHiloGuessing = new JLabel("Kodagor's Hi-Lo Guessing Game");
		lblKodagorsHiloGuessing.setForeground(new Color(255, 255, 255));
		lblKodagorsHiloGuessing.setBounds(2, 44, 632, 36);
		lblKodagorsHiloGuessing.setFont(new Font("Lato", Font.BOLD, 24));
		lblKodagorsHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblKodagorsHiloGuessing);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 204));
		panel.setBounds(4, 124, 628, 36);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setForeground(new Color(255, 255, 255));
		lblGuessANumber.setBounds(110, 8, 256, 20);
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setFont(new Font("Lato", Font.PLAIN, 16));
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(378, 5, 136, 26);
		panel.add(txtGuess);
		txtGuess.setFont(new Font("Lato", Font.PLAIN, 16));
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.setForeground(new Color(255, 255, 255));
		btnGuess.setBackground(new Color(0, 51, 204));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Lato", Font.BOLD, 18));
		btnGuess.setBounds(253, 204, 131, 49);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above. You have 7 tries.");
		lblOutput.setForeground(new Color(255, 255, 255));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Lato", Font.PLAIN, 16));
		lblOutput.setBounds(2, 297, 632, 36);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(640, 480));
		theGame.setVisible(true);
		
	}
}
