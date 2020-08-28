import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateFrame {
	Color peach = new Color(255, 160, 122);
	
	ResultsFound results = new ResultsFound("roeVwade.txt");
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
		
		JLabel text = new JLabel("Top Searches: " + topSearches[0] + ",\n " + topSearches[1] + ", " +
				topSearches[2] + ", " + topSearches[3] +  ", " + topSearches[4]);
		text.setBounds(x, y, w, h);
		text.setFont(new Font("AvenirNext-Regular", Font.PLAIN, 14));
		return text ;
	}
	
	/**
	 * 
	 * @param font
	 * @param fontSize
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return
	 */
	public JLabel makeResultsLabel(Integer[] numOfInstances, String font, int fontSize, int x, int y, int w, int h) {
		String fileN  = null;
		//System.out.println(results.search);
		//String [] searchA = search.split(" ");
		
		
		if((numOfInstances[0] + numOfInstances[1]) != 0) {
			System.out.println("hllo newWindow");
			numOfInstances[0] = numOfInstances[0] * 100;
			numOfInstances[1] = numOfInstances[1] * 10;
		}
		
		if(numOfInstances[0] >= 100 && (numOfInstances[1] < 40))  {
			fileN = "-\t" + results.filename + " contains definite results.\t The phrase appears " + (numOfInstances[0]/100) + " times.";
		}
		else if(numOfInstances[1] >= 40 && numOfInstances[0] < 100) {
			fileN = "-\t" + results.filename + " contains possible results.\t The total number of times any word in the phrase appears " + (numOfInstances[1]/10) + " times.";
		}
		else if(numOfInstances[0] >= 100 && (numOfInstances[1] >= 40)) {
			fileN = "-\t" +  results.filename + " contains definite results.\t The phrase appears " + (numOfInstances[0]/100) + " times.";
		}
		else {
			fileN = null;
		}
		
		JLabel results = new JLabel(fileN);
		results.setBounds(x, y, w, h);
		results.setFont(new Font(font, Font.ITALIC, fontSize));
		return results;
	}

}
