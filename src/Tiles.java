import java.awt.Color;
import java.awt.Graphics;


public class Tiles {

	boolean isTileWhite;
	boolean isTarget;
	static boolean targetChosen = false;
	//static int targetX;
	//static int targetY;
	Color color;
	int x;
	int y;
	static int tileSize = 50;

	public Tiles(int x, int y, boolean isTarget) {

		this.isTarget = isTarget;

		if (isTarget) {
			if (!targetChosen) {
				color = Color.RED;
				targetChosen = true;
			}
			else {
				color = Color.GREEN;
			}
			this.x = x;
			this.y = y;
			//targetX = x;
			//targetY = y;

			isTileWhite = true;
		}


		else {

			int num = (int)(Math.random() * 10) + 1;
			if (num < 10) {
				isTileWhite = true;
				color = Color.WHITE;
			}
			else {
				isTileWhite = false;
				color = Color.GRAY;
			}

			this.x = x;
			this.y = y;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getTileColor() {
		return isTileWhite;
	}



	public void switchColor() {
		if (!isTarget) {

			if (!isTileWhite) {
				color = Color.WHITE;
				isTileWhite = true;
			}
			
			else {
				color = Color.GRAY;
				isTileWhite = false;
			}
		}

		if (isTarget) {
			return;
		}
	}

	public void draw (Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, tileSize, tileSize);

	}


}
