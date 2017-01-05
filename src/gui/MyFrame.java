package gui;

import java.awt.BorderLayout;
import javax.swing.*;

class MyFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public MyFrame()
	{
		setTitle("Image Sorter");
		setBounds(200, 200, 350, 270);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new MyMenuBar();
		menu.setBounds(0, 0, 350, 20);
		add(menu);
		
		MyPanel panel = new MyPanel();
		add(panel, BorderLayout.CENTER);
		
		setLayout(null);
		setVisible(true);
	}
}