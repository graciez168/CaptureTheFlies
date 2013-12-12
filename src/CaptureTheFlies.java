import javax.swing.JFrame;
import javax.swing.JPanel;


public class CaptureTheFlies {
		
	static CaptureTheFliesPanel gamePanel = new CaptureTheFliesPanel();
	static BottomBar bottomPanel = new BottomBar();
	static SideBar sidePanel = new SideBar();
	
	public static void main(String[] args) {
		
		//3 panels: CaptureTheFlies, bottom bar, settings sidebar
		JPanel content = new JPanel();
		content.setLayout(null);
		
		
		content.add(gamePanel);
		gamePanel.setLocation(0,0);
		gamePanel.setSize(600, 450);
		
		
		content.add(bottomPanel);
		bottomPanel.setLocation(0,450);
		bottomPanel.setSize(600, 50);
		
		
		content.add(sidePanel);
		sidePanel.setLocation(600, 0);
		sidePanel.setSize(200, 500);
		
		String name = "Capture the Flies";
		int windowX = 600 + 200 + 16;
		int windowY = 450 + 50 + 38;
		JFrame window = new JFrame(name);
		window.setSize(windowX, windowY);
		window.setLocation(100,100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	
		window.setContentPane(content);
	}
}
