package ap.datafiles;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile
{
	public String path;
	
	public ReadFile(String file_path)
	{
		path = file_path;
	}
	
	public String[] OpenFile() throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		//int numberOfLines = 3;
		// Note: This isn't helpful! Change this later
		//int numberOfLines = readLines();
		int numberOfLines = 1646;
		String[] textData = new String[numberOfLines];
		int i;
		for(i=0;i<numberOfLines;i+=1)
		{
			if(textReader.readLine()=="# END"){i=numberOfLines+1;}
			textData[i] = textReader.readLine();
		}
		textReader.close();
		return textData;
	}
	
	int readLines() throws IOException
	{
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		String aLine;
		int numberOfLines = 0;
		while((aLine = bf.readLine()) != null)
		{
			numberOfLines+=1;
		}
		bf.close();
		return numberOfLines;
	}
}