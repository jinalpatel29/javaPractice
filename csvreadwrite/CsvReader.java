package jinal.practive.csvreadwrite;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
	

	public static void main (String[] args){
		
		String file = System.getProperty("user.home")+"/sample.csv";
		
		BufferedReader reader = null;
		
		if(file!=null)
			try{
				String line="";
				reader = new BufferedReader(new FileReader(file));
				reader.readLine();
				while((line=reader.readLine())!=null){
					String[] lineData = line.split(",");
					System.out.println("RAW CSV Data :"+line);
					System.out.println("converted CSV Data :"+ convertToList(lineData) +"\n");
				}
								
				
		}catch (Exception e) {
			System.out.println("Error in reading file content");
			e.printStackTrace();
		}finally {
			try{
				reader.close();
			}catch (IOException e) {
				System.out.println("Error in closing reader");
			}
		}
		
	}

	private static List<String> convertToList(String[] lineData) {
		List<String> result = new ArrayList<>();
		if(lineData != null){
			for(int i =0; i<lineData.length; i++){
				result.add(lineData[i]);			
			}
		}
		return result;		
	}
}
