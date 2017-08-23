package jinal.practive.csvreadwrite;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CsvReaderWriter {
	private static final String CSV_HEADER ="id ,firstname, lastname, gender, age";
	private static final String CSV_COMMA = ",";
	private static final String NEW_LINE= "\n";

	public static void main(String[] args){

		String csvFile = System.getProperty("user.home")+"/sample.csv";	
	//	readCsvFile(csvFile);		
		writeCsvFile(csvFile);
	}

	private static void writeCsvFile(String csvFile) {

		Student student1 = new Student(10, "Jinal", "Patel", "female", 28);
		Student student2 = new Student(20, "Vishal", "Bhai", "male", 29);
		Student student3 = new Student(30, "Nupur", "Tonpe", "female", 27);
		Student student4 = new Student(40, "Disha", "Patel", "female", 29);
		Student student5 = new Student(15, "Mike", "Welsh", "male", 50);
		Student student6 = new Student(60, "Abhijit", "Alur", "male", 30);

		ArrayList<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);

		FileWriter writer = null;

		try{
			writer = new FileWriter(csvFile);
			writer.append(CSV_HEADER);
			writer.append(NEW_LINE);

			for(Student student : students){
				writer.append(String.valueOf(student.getId()));
				writer.append(CSV_COMMA);
				writer.append(student.getFirstname());
				writer.append(CSV_COMMA);
				writer.append(student.getLastname());
				writer.append(CSV_COMMA);
				writer.append(student.getGender());
				writer.append(CSV_COMMA);
				writer.append(String.valueOf(student.getAge()));
				writer.append(NEW_LINE);
			}

			System.out.println("csv write successful");	

		}catch (Exception e) {
			System.out.println("Error in csv file writer");
			e.printStackTrace();
		}finally {
			try{
				writer.flush();
				writer.close();
			}catch(IOException io){
				System.out.println("Error in flushing or closing writer");
				io.printStackTrace();
			}
		}


	}

	private static void readCsvFile(String csvFile) {
		BufferedReader br = null;
		if(csvFile!=null){
			try{
				br = new BufferedReader(new FileReader(csvFile));
				String line = "";

				while((line=br.readLine())!=null){
					String[] data = line.split(",");
					System.out.println("data [ data1 ="+data[0]+" ,data2 ="+data[1]+" ]");				
				}


			}catch (Exception e) {
				System.out.println("Error in reading csv");
				e.printStackTrace();
			}finally {
				try{
					br.close();
				}catch(IOException io){
					System.out.println("Error in closing reader");
					io.printStackTrace();
				}
			}

		}

	}
}


