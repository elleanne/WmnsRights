import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Interact with the user: Take in user search, Allow user to review search results
 */
public class UserInterface extends CreateFrame {
	private JFrame newFrame = new JFrame();
	//ResultsFound results = new ResultsFound();
	public void newWindow(Integer[] numOfInstances, String searching) {
		String fileN = results.filename;
		
		/* Set new frame variables*/
		newFrame.setSize(1000, 900);
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.getContentPane().setLayout(null);
		newFrame.setVisible(true);
		newFrame.setBackground(Color.orange.darker());
		newFrame.setForeground(Color.magenta.brighter());
		
		/* Create objects for the frame*/
		JLabel title = makeLabel("WmnsRights", "AvenirNext-Italic", peach, 30, 450, 10, 400, 150); // x = 450, y = 10
		JLabel searchString = makeLabel(("Searching for: " + searching), "Helvetica", Color.BLACK, 13, 20, 100, 700, 30); // x = 20, y = 40
		JLabel resultsFound = makeLabel("Results: ", "Helvetica", Color.black, 12, 20, 140, 200, 20);
		JLabel results = makeResultsLabel(numOfInstances, "Helvetica", 12, 20, 170, 800, 20);
		
		newFrame.getContentPane().add(title);
		newFrame.getContentPane().add(searchString);
		newFrame.getContentPane().add(resultsFound);
		newFrame.getContentPane().add(results);
	}
	
}
