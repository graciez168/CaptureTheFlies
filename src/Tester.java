import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Tester {
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Tester");
		TesterPanel panel = new TesterPanel();
		panel.setSize(window.getWidth(), window.getHeight());
		panel.setLocation(0, 0);
		window.setContentPane(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(100,75);
		window.setSize(600,450);
		window.setVisible(true);
	}
	
	
}

