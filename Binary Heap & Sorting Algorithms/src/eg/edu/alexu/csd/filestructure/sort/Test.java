package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;

public class Test {
	public static void main(String[] args) {
		IHeap<Integer> heap = new MyHeap();
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(100);
		c.add(134);
		c.add(4);
		c.add(1780);
		c.add(67);
		c.add(19);
		c.add(1);
		heap.build(c);
		while (heap.size() != 0 ) {
			int x = heap.extract();
			System.out.println(x);
		}

	}
}
