package big; 

import java.awt.*; 
import java.io.*; 
import java.util.*; 

public class MakeTest{

	public final static ArrayList<String[]> testData = new ArrayList<String[]>();

	public static ArrayList<String[]> makeTest(ArrayList<Integer[]> data) throws Exception{

		int ttn = (int)(data.size()*0.02);

		int qtn = (int)(ttn*0.035);

		System.out.println(ttn+" > "+qtn);

		Integer[] tNum = new Integer[data.size()];

		tNum = makeNum(data.size(), ttn);

		Integer[] qNum = new Integer[ttn];

		qNum = makeNum(ttn, qtn);

		try{
			String[] nowList = new String[4];
	
			//makeTestData

			int qNum_n = 0;
			for(int i = 0; i < ttn; i++){

				for(int j = 0; j < 3; j++){
					nowList[j] = Integer.toString(data.get(tNum[i])[j]);
				}
				if(qNum[qNum_n]==i){

					nowList[3] = "q";
					qNum_n++;

				}
				else{
					nowList[3] = "c";

				}
				testData.add(nowList.clone());	
			}
		}
		catch(Exception e){

			e.printStackTrace();

		}
		return testData;
	}

	public static Integer[] makeNum(int num_a, int num_r){

		Integer[] randNum = new Integer[num_r];

		for(int i = 0; i < num_r; i++){
			randNum[i] = (int)(Math.random()*(num_a));
			for(int j = 0; j < i; j++){
				if(randNum[i] == randNum[j]){
					i--;
					break;
				}
			}
		}

		randNum = sort(randNum, 0, num_r-1);

		return randNum;
	}
	public static Integer[] sort(Integer[] data, int l, int r){
        	int left = l;
        	int right = r;
        	int pivot = data[(l+r)/2];
        
       		do{
			while(data[left] < pivot) left++;
  	         	while(data[right] > pivot) right--;
   	         	if(left <= right){    
   	         	    	int temp = data[left];
   	         	    	data[left] = data[right];
   	         	    	data[right] = temp;
   	         	    	left++;
   	         	   	right--;
   	         	}
   	     	}while (left <= right);
        
    	   	if(l < right) sort(data, l, right);
    	    	if(r > left) sort(data, left, r);

		return data;
	}
}
