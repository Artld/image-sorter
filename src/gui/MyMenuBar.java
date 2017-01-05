package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	public MyMenuBar() 
	{
		JMenuItem menuItemAbout = new JMenuItem(new AbstractAction("About")
		{
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e)
			{
				JFrame frame = new JFrame();
				frame.setLocation(200,200);
				
				JLabel label = new JLabel("<html><center>" +
				"<br>To solve problem with orientation this application" +
				"<br>separates image files into two categories based" +
				"<br>on it's resolution. In folder with images you specify " +
				"<br>application creates folders with names" +
				"<br>'Vertical' and 'Horizontal' and puts files inside." +
				"<br>" +
				"<br>Autor: artld " +
				"<br>License: BSD" +
				"</center></html>");
	
				label.setFont(new Font("Tahoma",1,14));
				frame.add(label);
				frame.pack();
				frame.setVisible(true);
			}
		});
		add(menuItemAbout);
	}
}
