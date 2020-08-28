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
	
	
	public static void main(String[] args) {
		
		/*Initialize search window*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayGUI g = new DisplayGUI();
					g.createInitial();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
