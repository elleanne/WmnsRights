import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Display initial search bar, most common searches, and results of search
 * @author eacrouther
 */
public class DisplayGUI extends CreateFrame {
	private JFrame initialFrame = new JFrame();
	//ResultsFound results = new ResultsFound();
	String searching ;
	Integer[] numOfInstances = new Integer[2];
	
	
	
	public Integer[] createInitial() {
		
		 // Initial JFrame seen by the user
				//initialFrame.setSize(1000, 900);
		initialFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialFrame.getContentPane().setLayout(null);
		initialFrame.setVisible(true);
		initialFrame.setBackground(Color.orange.darker());
		initialFrame.setForeground(Color.magenta.brighter());
		//initialFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("D6F7ECD2-1774-4141-8A59-F133410C8326_1_105_c.jpeg"));
		// create objects for initial window
		JLabel title = makeLabel("WmnsRights", "AvenirNext-Italic", peach, 60, 650, 250, 400, 150);
		JButton searchButton = makeButton("Search", 780, 500, 75, 20);
		JTextField searchString = makeTextBox(625, 450, 400, 20);
		String[] topSearch = results.getTop5Searches();
		//JLabel topSearchesLabel = displayTopSearches(topSearch, 50, 800, 800, 20); // initial suggestions for searches
		JLabel backgroundImage = new JLabel("");
		
		// Set constraints for the background
		ImageIcon bg = new ImageIcon("bckgrnd.png");
		backgroundImage.setIcon(bg);
		backgroundImage.setIconTextGap(0);
		backgroundImage.setBorder(null);
		backgroundImage.setText(null);
		backgroundImage.setSize(bg.getImage().getWidth(null), bg.getImage().getHeight(null));
		// add objects to window
		initialFrame.getContentPane().add(backgroundImage);
		initialFrame.getContentPane().add(title);
		initialFrame.getContentPane().add(searchString);
		initialFrame.getContentPane().add(searchButton);
		//initialFrame.getContentPane().add(topSearchesLabel);
		
		// listen for 'search' button pressed
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	

					searching = searchString.getText();
					System.out.println("Searching for: " + searching);

					results.saveFormatString(searching);
					
					ArrayList<Integer> indexOfFoundLine = results.searchForPhrase(searching);

					ArrayList<Integer> indexOfFoundWord = results.searchEachWord(searching);
					if(indexOfFoundLine != null) {
						numOfInstances[0] = indexOfFoundLine.size();
					}
					
					if(indexOfFoundWord != null) {
						numOfInstances[1] = indexOfFoundWord.size();
					}
					/*Create new window to display search results*/
					UserInterface u = new UserInterface();
					u.newWindow(numOfInstances, searching);
					 
				} catch(Exception a) { // Improvements: separate try blocks?
					JOptionPane.showMessageDialog(null, "Please enter a valid characters"); // exception will be called when any error in the try block occurs
				}
			}
		});
		
		return numOfInstances; // currently not used, but might in the future
	}
	


}
