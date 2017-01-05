package logic;

public class PathData
{
	private String path;
	private String path_V;
	private String path_H;
	
	public PathData()
	{
		setPath(System.getProperty("user.home"));
	}
	public void setPath(String path)
	{
		this.path = path;
		this.path_V = path + "/Vertical";
		this.path_H = path + "/Horizontal";
	}
	public String getPath()
	{
		return path;
	}
	public String getPath_V()
	{
		return path_V;
	}
	public String getPath_H()
	{
		return path_H;
	}
}
