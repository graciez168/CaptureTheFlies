import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class SideBar extends JPanel{

	int initialWallColor = 0;
	JSlider wallColors = new JSlider(0, 255, initialWallColor);
	JLabel wC = new JLabel("Wall Colors");
	
	int initialNumFlies = 1;
	JSlider numFlies = new JSlider(1, 50, initialNumFlies);
	JLabel nF = new JLabel("Number of Flies");
	
	int initialFlySpeed = 1;
	JSlider flySpeed = new JSlider(1, 10, initialFlySpeed);
	JLabel fS = new JLabel("Fly Speed");
	
	JButton reset = new JButton("Reset values");
	
	String[] levelChoices = {"Easy", "Medium", "Hard"};
	JComboBox levels = new JComboBox(levelChoices);
	
	
	public SideBar() {
		setLayout(null);
		setBackground(Color.WHITE);

		add(wallColors);
		wallColors.setSize(150, 17);
		wallColors.setLocation(31, 26);
		
		add(wC);
		wC.setSize(100, 30);
		wC.setLocation(50, 49);
	
		add(numFlies);
		numFlies.setSize(150, 17);
		numFlies.setLocation(31, 131);
		
		add(nF);
		nF.setSize(100, 30);
		nF.setLocation(50, 149);
		
		add(flySpeed);
		flySpeed.setSize(150, 17);
		flySpeed.setLocation(31, 231);
		
		add(fS);
		fS.setSize(100, 30);
		fS.setLocation(50, 249);
		
		add(reset);
		reset.setSize(150, 30);
		reset.setLocation(25, 325);
		
		add(levels);
		levels.setSize(150, 30);
		levels.setLocation(25, 425);
	}
}
