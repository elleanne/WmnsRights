import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
	Color peach = new Color(255, 160, 122);
	public String createInitial() {
		 // Initial JFrame seen by the user
				//initialFrame.setSize(1000, 900);
		initialFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialFrame.getContentPane().setLayout(null);
		initialFrame.setVisible(true);
		//initialFrame.setBackground(Color.orange.darker());
		initialFrame.setForeground(Color.magenta.darker());
		//initialFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("D6F7ECD2-1774-4141-8A59-F133410C8326_1_105_c.jpeg"));
		// create objects for initial window
		JLabel title = makeLabel("WmxnsRights", "AvenirNext-Italic", peach, 60, 650, 250, 400, 150);
		JButton searchButton = makeButton("Search", 780, 500, 75, 20);
		JTextField searchString = makeTextBox(625, 450, 400, 20);
		JLabel topSearchesLabel = displayTopSearches(results.getTop5Searches(), 50, 800, 800, 20); // initial suggestions for searches
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
		initialFrame.getContentPane().add(topSearchesLabel);
		
		// listen for 'search' button pressed
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					searching = searchString.getText();
					System.out.println("Searching for: " + searching);
					results.gatherResults(searching);
					for(int i = 0; i < results.indexOfFound.size(); i++) {
						System.out.println(results.indexOfFound.get(i));
					}
				} catch(Exception a) {
					JOptionPane.showMessageDialog(null, "Please enter a valid characters");
				}
			}
		});
		return searching;
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
		textBox.setColumns(10);
		return textBox;
	}
	
	/**
	 * Create a JLabel for the initial window
	 * @param labelName
	 * @param font
	 * @param clr
	 * @param fontSize
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public JLabel makeLabel(String labelName, String font, Color clr, int fontSize, int x, int y, int w, int h) {
		JLabel label = new JLabel(labelName);
		label.setBounds(x, y, w, h);
		label.setFont(new Font(font, Font.PLAIN, fontSize));
		label.setForeground(clr);
		return label;
	}

	/**
	 * Get the top searched strings created by @getTop5Searches() and write them to a JLabel
	 * @param topSearches
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return JLabel
	 */
	public JLabel displayTopSearches(String[] topSearches, int x, int y, int w, int h) {
		
		JLabel text = new JLabel("Top Searches: " + topSearches[0] + ", " + topSearches[1] + ", " +
				topSearches[2] + ", " + topSearches[3] +  ", " + topSearches[4]);
		text.setBounds(x, y, w, h);
		text.setFont(new Font("AvenirNext-Regular", Font.PLAIN, 14));
		return text ;
	}

}
