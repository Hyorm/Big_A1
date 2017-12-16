package big;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args){

		ArrayList<Integer[]> data = new ArrayList<Integer[]>();

		try{
			data = ReadFile.readFile(args[0]);
	
			makeFile(data);
		}
		catch(Exception e){
			System.out.println("File Name Error");
		}
	}
	
	public static void makeFile(ArrayList<Integer[]> data)throws Exception{

		String csvFileName = "data.csv";
		try{
			FileWriter writer = new FileWriter(csvFileName);
			for(int i = 0; i<data.size(); i++){

				//System.out.println(data.get(i)[0] +">"+ data.get(i)[1]+">"+data.get(i)[2]);
				writer.write(Integer.toString(data.get(i)[0]));
				writer.write(",");
				writer.write(Integer.toString(data.get(i)[1]));
				writer.write(",");
				writer.write(Integer.toString(data.get(i)[2]));
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
