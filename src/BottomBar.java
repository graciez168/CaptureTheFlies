import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BottomBar extends JPanel{
	
	JLabel currentScore = new JLabel("Current Score: " + 0);
	JButton instructions = new JButton("Instructions");
	JButton newGame = new JButton("New Game");
	
	public BottomBar() {
		setLayout(null);
		setBackground(Color.BLUE);
		
		add(currentScore);
		currentScore.setSize(120, 40);
		currentScore.setLocation(60,5);
		
		add(instructions);
		instructions.setSize(120, 40);
		instructions.setLocation(240, 5);
		
		add(newGame);
		newGame.setSize(120, 40);
		newGame.setLocation(420, 5);
		
	}

}
