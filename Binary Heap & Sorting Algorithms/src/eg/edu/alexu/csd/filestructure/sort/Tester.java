package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		ArrayList<Integer> unorderedArray = new ArrayList<Integer>();
		
		unorderedArray.add(7);
		unorderedArray.add(3);
		unorderedArray.add(13);
		unorderedArray.add(8);
		unorderedArray.add(1);
		unorderedArray.add(2);
		unorderedArray.add(-5);
		unorderedArray.add(-15);
		unorderedArray.add(3);
		unorderedArray.add(1);
		unorderedArray.add(0);
		unorderedArray.add(7);
		unorderedArray.add(4);
		unorderedArray.add(2);
		unorderedArray.add(53);
		unorderedArray.add(-50);
		unorderedArray.add(1);




		ISort<Integer> SortingTester = new Sort<Integer>();
		
		/*
		SortingTester.sortFast(unorderedArray);
		*/
		
		SortingTester.sortSlow(unorderedArray);
		
		for(int i=0; i<unorderedArray.size() ; i++)
			System.out.print(unorderedArray.get(i)+" , ");
		
	}

}
