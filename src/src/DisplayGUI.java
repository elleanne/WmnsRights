import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Display initial search bar, most common searches, and results of search
 */
public class DisplayGUI {
	private JFrame initialFrame = new JFrame();
	ResultsFound results = new ResultsFound();
	String searching ;
	public void createInitial() {
		 // Initial Jframe seen by the user
		initialFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialFrame.getContentPane().setLayout(null);
		initialFrame.setVisible(true);
		JButton searchButton = makeButton("Search", 850, 500, 75, 20);
		JTextField searchString = makeTextBox(800, 450, 150, 20);
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					searching = searchString.getText();
					System.out.println("Searching for: " + searching);			
					results.addSearch(searching);
					String[] topSearches = results.getTop5Searches();
					if(topSearches[0] != null) { 
						JLabel topSearchesLabel = displayTopSearches(topSearches, 100, 550, 800, 20); 
						System.out.println("heelo");
					}
				} catch(Exception a) {
					JOptionPane.showMessageDialog(null, "Please enter a valid characters");
				}
			}
		});
	}
	
	/**
	 * Create a JButton in the GUI window
	 * @param buttonName
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return JButton
	 */
	public JButton makeButton(String buttonName, int x, int y, int w, int h) {
		JButton button = new JButton(buttonName); //Search button
		button.setBounds(x, y, w, h);
		button.addActionListener(null);
		initialFrame.add(button);
		return button ;
	}
	/**
	 * Create a textbox in the GUI window
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return JTextField
	 */
	public JTextField makeTextBox(int x, int y, int w, int h) {
		JTextField textBox = new JTextField();
		textBox.setBounds(x, y, w, h);
		initialFrame.getContentPane().add(textBox);
		textBox.setColumns(10);
		return textBox;
	}

	
	public JLabel displayTopSearches(String[] topSearches, int x, int y, int w, int h) {
		
		JLabel text = new JLabel("Top Searches: " + topSearches[0] + ", " + topSearches[1] + ", " +
				topSearches[2] + ", " + topSearches[3] +  ", " + topSearches[4]);
		text.setBounds(x, y, w, h);
		initialFrame.getContentPane().add(text);
		return text ;
	}

}
