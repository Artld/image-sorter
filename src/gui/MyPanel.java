package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

import logic.PathData;
import logic.Sorter;

class MyPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	MyPanel()
	{
		final PathData data = new PathData();
		
		setBounds(10, 10, 320, 220);
		setLayout(null);
		
		//Label "Path:"
		JLabel label1 = new JLabel("Path:");
		label1.setBounds(10, 30, 40, 20);
		add(label1);
		
		//Text Field to display Path
		final JTextField tf1 = new JTextField();		
		tf1.setText(data.getPath());
		tf1.setBounds(50, 30, 200, 20);
		add(tf1);
		
		//Button to edit Path
		JButton btnPath = new JButton("...");
		btnPath.setBounds(250,30,60,20);
		btnPath.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int ret = fc.showOpenDialog(null);
				if (ret == JFileChooser.APPROVE_OPTION)
				{
					File file = fc.getSelectedFile();
					tf1.setText(file.getPath());
				}
			}
		});
		add(btnPath);
		
		//Bar to view progress of sorting
		final JProgressBar progress = new JProgressBar();
		progress.setBounds(10, 100, 302, 30);
		progress.setStringPainted(true);
		progress.setVisible(false);
		add(progress);
		
		//Button to start sorting
		JButton btnStart = new JButton("Start Sorting");
		btnStart.setBounds(90,190,140,25);
		btnStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (new File(tf1.getText()).isDirectory())
				{
					data.setPath(tf1.getText());
					
					progress.setVisible(true);
					
					new Thread(new Runnable()
					{
					    @Override
					    public void run()
					    {
				    		new Sorter(data, progress);
					    }
					}).start();
				}
			}
		});
		add(btnStart);
	}
}
