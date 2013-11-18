import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 * Sets up and displays GUI
 * 
 * @author Gautam Narula
 *
 */

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("GPR Stylizer Version 1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program on close
		frame.setSize(300,300); //sets size of frame to 300 x 300
		StylePanel panel = new StylePanel();
		frame.add(panel);
		frame.setJMenuBar(panel.menuBar);
		frame.setVisible(true);

	}

}
