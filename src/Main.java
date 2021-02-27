import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;


public class Main {
	public static String [] arrayS;
	public static Double [] arrayD;
	public static ArrayList <Integer> arrayAverage;
	public final static String separator=" ";



	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

		int counter=Integer.parseInt(bf.readLine()); 
		String line="";
		String message="";

		for(int i = 0; i<counter; i++) {
			line = bf.readLine();
			arrayS = line.split(separator);
			arrayD=new Double[arrayS.length];
			arrayAverage=new ArrayList<Integer>();
			
			for (int j=0;j<arrayS.length;j++) {
				arrayD[j]=Double.parseDouble(arrayS[j]);
			}
			message+=bubbleSort(arrayD,arrayAverage)+"\n";

		}

		System.out.println(message);

		bf.close();
	}
	public static String bubbleSort(Double [] array,ArrayList<Integer>  arrayA) {
		String line="";
		int changes;
		for(int i = 1; i<array.length;i++) {
			changes = 0;	
			for(int j=0; j<array.length-i;j++) {
				if(array[j]>array[j+1]) {
					Double temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					changes++;
				}
			}
			arrayA.add(changes);
		}
		double average = 0;
		for(int i = 0; i<arrayA.size();i++ ) {
			average = average + arrayA.get(i);
		}
		average = average /arrayA.size() ;
		BigDecimal bd = new BigDecimal(average).setScale(2, RoundingMode.DOWN);
	     average = bd.doubleValue();
		DecimalFormatSymbols customSeparator = new DecimalFormatSymbols();
		customSeparator.setDecimalSeparator('.');
		DecimalFormat formato1 = new DecimalFormat("#.00", customSeparator);
		formato1.setRoundingMode(RoundingMode.DOWN);
	
		if (average*10%1 ==0) {
			formato1 = new DecimalFormat("#.0", customSeparator);
			formato1.setRoundingMode(RoundingMode.DOWN);
		}

		line+=formato1.format(average)+" ";
		for(int i = 0; i<array.length;i++ ) {
			if (i==array.length-1) {
				line+= array[i];
			}else {
				line+= array[i]+" ";
			}
		}
		return line;
	}
}
