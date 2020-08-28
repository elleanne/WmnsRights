import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.*;


/*
 * Contains main method
 */
public class WmxnsRights {
	static Integer[] numOfInstancesLine_Word = new Integer[2];

	public static void main(String[] args) {

		/*Initialize search window*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateFrame f = new CreateFrame();
					DisplayGUI g = new DisplayGUI();
					Integer[] numOfInstances = g.createInitial();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface u = new UserInterface();
					u.wait();
					// Should change this to that a ranked array[] of the best to worst articles is passed to u.newWindow
					u.newWindow() ;

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
	}
}
