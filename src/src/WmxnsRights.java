import java.awt.EventQueue;

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
					//g.createInitial();
					g.createInitial();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
