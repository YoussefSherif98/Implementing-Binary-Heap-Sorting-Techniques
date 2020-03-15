package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;
import java.io.*;
import java.lang.*;


public class tester {

	public static void main(String[] args) {
		ISort<Integer> sort = new Sort();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		int dummy,max=100;
		long t1,t11,t2,t22,t3,t33,Heap,Insertion,Quick;
		Random r = new Random();
	    Formatter x ;
	    
	    try{
	    	x = new Formatter("testingSorting.txt");
	    }
	    catch(Exception e) {
	    	System.out.println("Error");
	    	return;
	    }
	    x.format( "DataSize, HeapSort,Quick, Insertion\n");
		System.out.println("   DataSize   HeapSort        Quick        Insertion ");
		
		for (int j = 0 ; j<12 ; j++ ) {
		
			
		for (int i=0 ; i<max ; i++ ) {
			dummy = r.nextInt(1000000);
			a.add(dummy);
			b.add(dummy);
			c.add(dummy);
		}
		//Heap Sort 
		t1 = System.nanoTime();
		sort.heapSort(a);
		t11 = System.nanoTime();
		
		Heap = t11-t1;
		
		//Insertion Sort 
		t2 = System.nanoTime();
		sort.sortSlow(b);
		t22 = System.nanoTime();
		
		Insertion = t22-t2;
		
		//Quick Sort
		t3 = System.nanoTime();
		sort.sortFast(c);
		t33 = System.nanoTime();
		
		Quick = t33-t3;
  		
		x.format("%d, %d, %d, %d\n",max,Heap,Quick,Insertion);
		System.out.printf("%d] %d  %d  %d  %d\n",j,max,Heap,Quick,Insertion);
		
		
		a.clear();
		b.clear();
		c.clear();
		
		max = max*2; 

	}
		x.close();
	
  }
}
