import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.*;

/**
 * Contains main method and creates window for user to start search
 * @author eacrouther
 */
public class WmxnsRights {
	static Integer[] numOfInstancesLine_Word = new Integer[2];

	public static void main(String[] args) {

		/*Initialize search window*/
		.invokeLater(new Runnable() {
			public void run() {
				try {
					//CreateFrame f = new CreateFrame();
					DisplayGUI g = new DisplayGUI();
					Integer[] numOfInstances = g.createInitial();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
