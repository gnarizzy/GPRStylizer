import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Places elements in GUI and creates listeners for buttons
 * 
 * @author Gautam Narula
 * 
 */
public class StylePanel extends JPanel {
	final JFileChooser fileChooser;
	JButton openFileButton;
	JButton stylizeButton;
	File selected;
	JLabel currentFile;
	JLabel notification;
	static JMenuBar menuBar;
	JMenu file;
	JMenu help;
	JMenuItem exit;
	JMenuItem how;
	JMenuItem methodology;
	JMenuItem history;
	

	/**
	 * Constructor for StylePanel which instantiates panel components
	 */
	public StylePanel() {
		
		fileChooser = new JFileChooser();
		currentFile = new JLabel("No file selected");
		notification = new JLabel();

		menuBar = new JMenuBar();
		file = new JMenu("File");
		help = new JMenu("Help");
		exit = new JMenuItem("Exit");
		how = new JMenuItem("How to Use");
		methodology = new JMenuItem("Methodology");
		history = new JMenuItem("History");

		file.add(exit);
		help.add(how);
		help.add(methodology);
		help.add(history);
		menuBar.add(file);
		menuBar.add(help);
		
		ButtonListener listener = new ButtonListener();
		MenuListener mListener = new MenuListener();
		openFileButton = new JButton("Choose File");
		openFileButton.addActionListener(listener);
		stylizeButton = new JButton("Fix Style Errors!");
		stylizeButton.addActionListener(listener);
		exit.addActionListener(mListener);
		how.addActionListener(mListener);
		history.addActionListener(mListener);
		methodology.addActionListener(mListener);
		
		add(menuBar);
		add(openFileButton);
		add(stylizeButton);
		add(currentFile);
		add(notification);

	}

	/**
	 * Inner class that serves as a listener for the two buttons
	 * 
	 * @author Gautam Narula
	 * 
	 */

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == openFileButton) { //user wants to choose a file
				int value = fileChooser.showOpenDialog(StylePanel.this);
				if (value == JFileChooser.APPROVE_OPTION) {
					selected = fileChooser.getSelectedFile();
					currentFile.setText(selected.getName());
				}

			}

			if (e.getSource() == stylizeButton) {//user wants to correct style mistakes
				WordReplacer wr = new WordReplacer(selected);
				try {
					wr.stylize();
					notification.setText("Style errors in the file have been corrected.");
				} catch (IOException e1) {
					notification
							.setText("There was an error in opening the file.");

				}
			}
		}

	}
	/**
	 * Inner class that serves as a listener for the menu
	 * 
	 * @author Gautam Narula
	 *
	 */
	class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==exit) //File -> exit
				System.exit(1);
			else if (e.getSource()==how){//Help-> How to Use
				JTextArea howText = new JTextArea(
						"The GPR stylizer automatically detects and corrects over a dozen different AP style mistakes. To use this software, select a TEXT file (.txt) and then click the “fix style errors” button, which instantly corrects all the errors. Unfortunately it doesn't quite work on Word docs yet, so for now you'll have to copy the text into a .txt file, run the app, and then copy it back.", 
						9, 50);
				howText.setLineWrap(true);
				howText.setWrapStyleWord(true);
				JScrollPane scrollPane = new JScrollPane(howText);
				
				JFrame howTo=new JFrame("How to Use");
				howTo.add(scrollPane);
				howTo.setVisible(true);
				howTo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //close window, but keep program running
				howTo.setSize(300,300);
			}
			else if (e.getSource()==history){
				JTextArea histText= new JTextArea("GPR Stylizer\nDeveloped by Gautam Narula \n\nVersion 1.0 released 10/20/2013",9,50);
				histText.setLineWrap(true);
				histText.setWrapStyleWord(true);
				JScrollPane scrollPane = new JScrollPane(histText);
				
				JFrame hist = new JFrame("History");
				hist.add(scrollPane);
				hist.setVisible(true);
				hist.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				hist.setSize(300,300);
				
			}
			
			else if (e.getSource()==methodology){
				JTextArea methText = new JTextArea("This software automatically detects and corrects over a dozen AP style mistakes including:\n\n- not spelling numbers below 10\n- using towards, forwards, upwards, etc. instead of toward, forward, upward, etc.\n- using % instead of percent\n- using incorrect versions of OK", 9,50);
				methText.setLineWrap(true);
				methText.setWrapStyleWord(true);
				JScrollPane scrollPane = new JScrollPane(methText);
				
				JFrame meth = new JFrame("Methodology");
				meth.add(scrollPane);
				meth.setVisible(true);
				meth.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				meth.setSize(300,300);
						
						
			}
			
		}
		
	}

}
