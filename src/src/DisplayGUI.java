import javax.swing.*;

/*
 * Display initial search bar, most common searches, and results of search
 */
public class DisplayGUI {
	
	public void createInitial() {
		JFrame initialF = new JFrame(); // Initial Jframe seen by the user

		JButton searchB = new JButton("Search"); //Search button
		searchB.setBounds(500, 500, 20, 20);
		searchB.addActionListener(null);
		
		initialF.add(searchB);
		initialF.setLayout(null);
		initialF.setVisible(true);
	}
	

}
