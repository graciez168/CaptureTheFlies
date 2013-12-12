import java.awt.*;

import javax.swing.JPanel;

import java.util.ArrayList;


import java.awt.event.*;

import javax.swing.*;


public class CaptureTheFliesPanel extends JPanel implements MouseListener, ActionListener {


	public static int score = 0;
	public static ArrayList<Tiles> tileList = new ArrayList<Tiles>(108);
	public static ArrayList<Flies> flyList = new ArrayList<Flies>(10);
	Timer timer = new Timer(10,this);
	int numFlies = 1;
	


	public void actionPerformed(ActionEvent evt) {
		int i = 0;
		while (i < numFlies) {
			//if (!isCurrentTileFree(flyList.get(i))) {
			//break;
			//}

			if (isPathFree(flyList.get(i))) {
				flyList.get(i).move(flyList.get(i).direction);
			}

			else {
				flyList.get(i).switchDirection();
				flyList.get(i).move(flyList.get(i).direction);
			}
			i++;
		}


		repaint();
	}

	public CaptureTheFliesPanel() {
		
		setLayout(null);
		addMouseListener(this);
		timer.start();



		int x = 0;
		int y = 0;
		boolean isTargetChosen = false;
		int target = 0;
		int i = 1;
		while(i < 109) {
			
			if (isTargetChosen) {
				if ((i - target) < 3) {
					tileList.add(new Tiles(x,y,true));
				}
				
				else if ((i - 12 - target) < 3 && (i - 12 - target) >= 0) {
					tileList.add(new Tiles(x,y,true));
				}
				
				else if ((i - 24 - target) < 3 && (i - 24 - target) >= 0) {
					tileList.add(new Tiles(x,y,true));
				}
				
				else {
				tileList.add(new Tiles(x,y,false));
				}
			}
			
			if (!isTargetChosen) {
				int targetNum = (int)(Math.random() * 10) + 1;
				if (targetNum == 7 && x <= 450) {
					tileList.add(new Tiles(x,y,true));
					isTargetChosen = true;
					target = i;
				}
				else {
					tileList.add(new Tiles(x, y, false));
				}
			}
			
			

			if (i % 12 == 0) {
				x = 0;
				y += 50;
			}
			
			else {
				x += 50;
			}

			i++;

		}

		for (int f = 0; f < numFlies; f++) {
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

		while(f < numFlies) {
			(flyList.get(f)).draw(g);
			f++;
		}

	}

	public static ArrayList getTiles() {
		return tileList;
	}

	public static int thisTile(int x, int y) {
		x = x - (x % Tiles.tileSize);
		y = y - (y % Tiles.tileSize);

		return (x / Tiles.tileSize) + (12 * y / Tiles.tileSize);
	}

	public static boolean isPathFree(Flies fly) {
		int currentX = fly.x;
		int currentY = fly.y;
		fly.move(fly.direction);
		boolean free = isCurrentTileFree(fly);

		fly.x = currentX;
		fly.y = currentY;


		return free;
	}

	public static boolean isCurrentTileFree(Flies fly) {
		if (fly.x < 0 || fly.x > (600 - 4) || fly.y < 0 || fly.y > (450 - 4)) {
			return false;
		}
		return (tileList.get(thisTile(fly.x, fly.y)).isTileWhite);

	}
	

	public void mousePressed(MouseEvent evt) {
		score ++;
		CaptureTheFlies.bottomPanel.currentScore.setText("Current Score: " + score);
		int x = evt.getX();  
		int y = evt.getY(); 

		tileList.get(thisTile(x, y)).switchColor();
		repaint();
		
	} 


	public void mouseEntered(MouseEvent evt) { }
	public void mouseExited(MouseEvent evt) { }
	public void mouseClicked(MouseEvent evt) { }
	public void mouseReleased(MouseEvent evt) { }
}


