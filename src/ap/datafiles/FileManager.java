package ap.datafiles;
import java.io.IOException;

public class FileManager
{
	public static void main(String[] args) throws IOException
	{
		String file_name = "C:/test.txt";
		try
		{
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			int i;
			for(i=0;i<aryLines.length;i+=1)
			{
				System.out.println(aryLines[i]);
			}
		}
		catch (IOException e)
		{
			System.out.println("IO Error");
		}
		
		WriteFile data = new WriteFile(file_name, true);
		data.writeToFile("Hello world");
		System.out.println("Text File Written To");
	}
}