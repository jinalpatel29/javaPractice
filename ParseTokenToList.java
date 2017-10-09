package com.practice.jinal.filelinestolist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParseTokenToList {
	public static final String pattern ="[^a-zA-Z0-9]";

	public static void main(String[] args) throws IOException {

		System.out.print("Please enter file name");
		Scanner sc = new Scanner(System.in);
		String file = sc.next();
		String fileName = System.getProperty("user.home")+"/"+file;	
		// Check of fileName is null or empty string return with invalid msg
		String token = getFileExtention(fileName);
		// Check if token is null and return with error msg if it is
		javaParserUtility(fileName, token);
		sc.close();
	}

	private static void javaParserUtility(String fileName, String token) throws IOException { // Don't make it void instead return Array of Strings and output in main()
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line ="";
			while((line = reader.readLine()) != null){
				System.out.println("Line Before removing special chars\n"+line+"\n");

				line = line.replaceAll(pattern, "");
				System.out.println("Line After removing special chars\n"+line+"\n");

				if(token != null){ // null check should always be in the order of variable first 
					String[] words = line.split(token);
					if(words != null){ //also check if words is empty 
						List<String> resultList = new ArrayList<>(Arrays.asList(words)); // Is this necessary? //converArrayIntoList(words);
						System.out.println(resultList+"\n");
					}
				}
			}

		}catch (IOException e) {
			System.err.println(e);
		}finally {
			if(reader != null){
				reader.close();
			}
		}
	}


	private static String getFileExtention(String fileName) {
		// Use Utils to get extension don't do this
		// FilenameUtils.getExtension("/path/to/file/foo.txt")
		// Avoid writing unecessary lines of code
		int i = fileName.lastIndexOf('.');	
		String extention = null;
		if(i>0){
			extention = fileName.substring(i+1);		
		}
		return extention;
	}


	/* This is a optional method if we don't want to convert the Array of String using Arrays.asList(T..a) function.
	 * 
	 * 
	 * private static List<String> converArrayIntoList(String[] words) {
		List<String> result = new ArrayList<>();
		for(int i=0; i<words.length; i++){
			result.add(words[i]);
		}

		return result;
	}
	 */



}
