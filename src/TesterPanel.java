import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;



public class TesterPanel extends JPanel implements ActionListener {
	
	public static ArrayList<Tiles> tileList = new ArrayList<Tiles>(108);
	public static ArrayList<Flies> flyList = new ArrayList<Flies>(10);
	
	public void actionPerformed(ActionEvent evt) {
		int i = 0;
		while (i < 10) {
			if (isPathFree(flyList.get(i).nextTile())) {
				flyList.get(i).move(flyList.get(i).direction);
			}
				
			i++;
		}
		repaint();
	}
	
	public TesterPanel() {
		setLayout(null);

		int x = 0;
		int y = 0;
		for (int i = 1; i <= 108; i++) {
			tileList.add(new Tiles(x,y));
			
			x += 50;
			
			if (i % 12 == 0) {
				x = 0;
				y += 50;
			}
			
			
			
		}
		
		for (int i = 0; i < 10; i++) {
			flyList.add(new Flies());
		}

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int i = 0;
		int f = 0;
		while(i < 108) {
			(tileList.get(i)).draw(g);
			i++;
		}
		
		while(f < 10) {
			(flyList.get(f)).draw(g);
			f++;
		}
	
	}
	
	

}
