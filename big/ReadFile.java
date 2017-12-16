package big;

import java.awt.*;
import java.io.*;
import java.util.*;

public class ReadFile{

	public final static ArrayList<Integer[]> arr = new ArrayList<Integer[]>();

	public static ArrayList<Integer[]> readFile(final String fileName) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader(fileName));

		String[] origin = new String[3];

		ArrayList<String> userName = new ArrayList<String>();

		String line;

		Integer[] newList = new Integer[3];

		String preProName = "i";

		int productNum = 0;

		int i = 0;

		try{
		while((line = br.readLine()) != null){
			
			if(i>0){

				origin = element(line);

				//productId

				if(preProName.equals(origin[0])){
					newList[0] = productNum;
				}
				else{
					preProName = origin[0];
					productNum++;
					newList[0] = productNum;
				}

				//UserId

				if(userName.size() < 1){

					userName.add(origin[1]);

					newList[1] = 1;

				}	
				
				int j = 0;	
				for(j = 0; j<userName.size(); j++){
					if(userName.get(j).equals(origin[1])){
						newList[1] = j+1;
						break;
					}
				}
				if(j == userName.size()){
					userName.add(origin[1]);
					newList[1] = userName.size();
				}
				newList[2] = Integer.parseInt(origin[2]);
			
				arr.add(newList.clone());
				//System.out.println(arr.get(i-1)[0]+" > "+arr.get(i-1)[1]+" > "+arr.get(i-1)[2]+"\n");
			}

			i++;
		}

		System.out.println(arr.size());

		}
		catch(Exception e){

			System.out.println("error");

		}
		return arr;
	}

	public static String[] element(String line){
	
		String[] origin = new String[3];

		String[] sub = line.split(",");

		origin[0] = sub[1];

		origin[1] = sub[2];

		origin[2] = sub[5];

		return origin;
	}
}
