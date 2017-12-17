package big;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args){

		ArrayList<Integer[]> data = new ArrayList<Integer[]>();

		ArrayList<String[]> tdata = new ArrayList<String[]>();

		try{
			data = ReadFile.readFile(args[0]);

			tdata = MakeTest.makeTest(data);
			
			makeFile(data, 3);

			makeTestFile(tdata, 4);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void makeFile(ArrayList<Integer[]> data, int col)throws Exception{

		String csvFileName = "data.csv";
		try{
			FileWriter writer = new FileWriter(csvFileName);
			for(int i = 0; i<data.size(); i++){

				//System.out.println(data.get(i)[0] +">"+ data.get(i)[1]+">"+data.get(i)[2]);
				for(int m = 0; m<col-1; m++){
					writer.write(Integer.toString(data.get(i)[m]));
					writer.write(",");
				}
				writer.write(Integer.toString(data.get(i)[col-1]));
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void makeTestFile(ArrayList<String[]> data, int col)throws Exception{

                String csvFileName = "test.csv";
                try{
                        FileWriter writer = new FileWriter(csvFileName);
                        for(int i = 0; i<data.size(); i++){

                                //System.out.println(data.get(i)[0] +">"+ data.get(i)[1]+">"+data.get(i)[2]);
                                for(int m = 0; m<col-1; m++){
                                        writer.write(data.get(i)[m]);
                                        writer.write(",");
                                }
                                writer.write(data.get(i)[col-1]);
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
