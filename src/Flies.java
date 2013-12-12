import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;


public class Flies {
	int flySize;
	int x;
	int y;
	int direction;
	boolean freeFlying;
	int speed;
	//Timer timer;
	
	public Flies() {
		//timer = new Timer();
		flySize = 4;
		//while(true) {
		x = (int)(Math.random() * 600) + 1;
		y = (int)(Math.random() * 450) + 1;
		
		//if (isTileFree(thisTile()))
			//break;
		//}
		
		direction = 3;//(int)(Math.random() * 4) + 1;
		//each number is associated with a quadrant in 
		//xy plane so, 1 is in the northeast, 2 is northwest etc.
		
		
		
	}
	
	
	public int thisTile() {
		int nextX = x;
		int nextY = y;
		
		nextX = nextX - (nextX % 50);
		nextY = nextY - (nextX % 50);
		
		return (nextX / 50) + (12 * nextY / 50);
	}
	
	public int nextTile() {
		int currentX = x;
		int currentY = y;
		this.move(direction);
		int nextX = x;
		int nextY = y;
		x = currentX;
		y = currentY;
		
		nextX = nextX - (nextX % 50);
		nextY = nextY - (nextX % 50);
		
		return (nextX / 50) + (12 * nextY / 50);
	}
	
	
	
	public void switchDirection() {
		
		
		switch(direction) {
		case 1:
			if (x >= 596) {
				direction = 2;
				break;
			}
			if (y <= 4) {
				direction = 4;
				break;
			}
			int currentX = x;
			int currentY = y;
			this.move(2);
			if (CaptureTheFliesPanel.isPathFree(this))
				direction = 2;
			x = currentX;
			y = currentY;
			
			currentX = x;
			currentY = y;
			this.move(4);
			if (CaptureTheFliesPanel.isPathFree(this))
				direction = 4;
			x = currentX;
			y = currentY;
			
			break;
			
		case 2:
			if (x <= 4) {
				direction = 1;
				break;
			}
			if (y <= 4) {
				direction = 3;
				break;
			}
			currentX = x;
			currentY = y;
			this.move(1);
			if (CaptureTheFliesPanel.isPathFree(this))
				direction = 1;
			x = currentX;
			y = currentY;
			
			currentX = x;
			currentY = y;
			this.move(3);
			if (CaptureTheFliesPanel.isPathFree(this))
				direction = 3;
			x = currentX;
			y = currentY;

			break;
			
		case 3:
			if (y >= 396) {
				direction = 2;
				break;
			}
			if (x <= 4) {
				direction = 4;
				break;
			}
			currentX = x;
			currentY = y;
			this.move(2);
			if (CaptureTheFliesPanel.isPathFree(this))
				direction = 2;
			x = currentX;
			y = currentY;
			
			currentX = x;
			currentY = y;
			this.move(4);
			if (CaptureTheFliesPanel.isPathFree(this))
				direction = 4;
			x = currentX;
			y = currentY;

			break;
			
		case 4:
			if (x >= 596) {
				direction = 3;
				break;
			}
			if (y >= 396) {
				direction = 1;
				break;
			}
			currentX = x;
			currentY = y;
			this.move(1);
			if (CaptureTheFliesPanel.isPathFree(this))
				direction = 1;
			x = currentX;
			y = currentY;
			
			currentX = x;
			currentY = y;
			this.move(3);
			if (CaptureTheFliesPanel.isPathFree(this))
				direction = 3;
			x = currentX;
			y = currentY;
			break;
		}		
	}
	
	public void move(int direction) {
		switch(direction) {
		
		case 1:
			x ++;
			y --;
			break;
			
		case 2:
			x --;
			y --;
			break;
			
		case 3:
			x --;
			y ++;
			break;
			
		case 4:
			x ++;
			y ++;
			break;
	
			
		}
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(x, y, flySize, flySize);
	}
}
