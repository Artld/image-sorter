package logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JProgressBar;

public class Sorter
{
	public Sorter(PathData data, final JProgressBar progress)
	{		
		String path = data.getPath();
		String path_V = data.getPath_V();
		String path_H = data.getPath_H();
		File myFolder = new File(path);

		//creating folders
		File subFolder = new File(path_V);
		if (subFolder.isDirectory()==false)
		{
			subFolder.mkdir();
		}
		subFolder = new File(path_H);
		if (subFolder.isDirectory()==false)
		{
			subFolder.mkdir();
		}

		String[] fileList = myFolder.list();
		int total = fileList.length;
		int counter = 0;
		int percent = 0;

		for (String fileName : fileList)
		{
			if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png") || fileName.endsWith(".bmp") || fileName.endsWith(".JPG") || fileName.endsWith(".JPEG") || fileName.endsWith(".PNG") || fileName.endsWith(".BMP"))
			{
				File file = new File(path + "/" + fileName);
				BufferedImage image = null;
				try
				{
					image = ImageIO.read(file);
				} 
				catch (IOException e)
				{
					e.printStackTrace();
					continue;
				}
				if (image.getWidth() > image.getHeight())
				{
					file.renameTo(new File(path_H + "/" + fileName));
				}
				else
				{
					file.renameTo(new File(path_V + "/" + fileName));
				}
			}
			counter++;
			percent = counter * 100 / total;
			progress.setString("Processing " + percent + "%");
			progress.setValue(percent);
		}
		progress.setString("Done!");
		progress.setValue(100);
	}
}
