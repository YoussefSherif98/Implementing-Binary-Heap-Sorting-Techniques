package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.lang.ArrayIndexOutOfBoundsException;;

public class MyHeap<T extends Comparable<T>> implements IHeap<T> {
	private ArrayList<INode<T>> heap;
	private int size;
	private int lastIndex;

	public MyHeap() {
		heap = new ArrayList<INode<T>>();
		size = 0;
		lastIndex = 0 ;
		INode<T> dummy = new HeapNode(0, null,size+1);
		heap.add(dummy);
	}

	public INode<T> getRoot() {
		if (size == 0)
			return null;
		return heap.get(1);
	}

	public int size() {
		return lastIndex;
	}

	public void heapify(INode<T> node) {
		if (node == null){
			return;
		}
		INode<T> largest = node;
		if (HasLeftChild(node)) {
			if (Compare(node, node.getLeftChild()))
				largest = node.getLeftChild();
			if (HasRightChild(node)) {
				if (Compare(node, node.getRightChild())) {
					if (Compare(node.getLeftChild(), node.getRightChild()))
						largest = node.getRightChild();
				}
			}
		}
		if (largest.getValue().compareTo(node.getValue()) != 0) {
			swap(node, largest);
			heapify(largest);
		}
		return;
	}

	public T extract() {
		if (size == 0 )
			return null;
		
		T dummy = heap.get(1).getValue();
		swap(heap.get(1), heap.get(size));
		if (size != 0) {
			if (HasRightChild(heap.get(size / 2))) {
				heap.get(size / 2).setRchild(null);
			} else {
				heap.get(size / 2).setLchild(null);
			}
			heap.remove(size);
			size--;
			lastIndex--;
			if (size != 0) {
				heapify(heap.get(1));
			}
		} else {
			heap.remove(size);
			size--;
			lastIndex--;
		}
		return dummy;
	}

	public void insert(T element) {
		if (element == null ) {
			return;
		}
		INode<T> node;
		if (size == 0) {
			node = new HeapNode(element, null,size+1);
			heap.add(node);
			size++;
			lastIndex++;
		} else {
			node = new HeapNode(element, heap.get((size + 1) / 2),size+1);
			if (HasLeftChild(heap.get((size + 1) / 2))) {
				heap.get((size + 1) / 2).setRchild(node);
			} else {
				heap.get((size + 1) / 2).setLchild(node);
			}
			heap.add(node);
			size++;
			lastIndex++;
			minHeapify(node);
		}
	}

	public void build(Collection<T> unordered) {
		if (unordered == null)
			return;
		
		for (T item : unordered) {
			INode<T> node;
			if (size == 0) {
				node = new HeapNode(item, null,size+1);
				heap.add(node);
				size++;
				lastIndex++;
			} else {
				node = new HeapNode(item, heap.get((size + 1) / 2),size+1);
				if (HasLeftChild(heap.get((size + 1) / 2))) {
					heap.get((size + 1) / 2).setRchild(node);
				} else {
					heap.get((size + 1) / 2).setLchild(node);
				}
				heap.add(node);
				size++;
				lastIndex++;
			}
		}
		for (int i = (size / 2); i > 0; i--) {
			heapify(heap.get(i));
		}
	}

	private boolean HasLeftChild(INode<T> node) {
		if (node.getLeftChild() != null  && node.getLeftChild().getIndex() <= lastIndex)
			return true;
		else
			return false;

	}

	private boolean HasRightChild(INode<T> node) {
		if (node.getRightChild() != null && node.getRightChild().getIndex() <= lastIndex)
			return true;
		else
			return false;
	}

	private boolean Compare(INode<T> node1, INode<T> node2) {
		int compare = node1.getValue().compareTo(node2.getValue());
		if (compare > 0 || compare == 0) // if values in node1(parent) bigger than or equal its of node2(child) no swap
											// needed
			return false;
		else
			return true;
	}

	private void swap(INode<T> node1, INode<T> node2) {
		T dummy = node1.getValue();
		node1.setValue(node2.getValue());
		node2.setValue(dummy);
	}

	private void minHeapify(INode<T> node) {
		if (node.getParent() == null)
			return;
		if (Compare(node.getParent(), node)) {
			swap(node, node.getParent());
			minHeapify(node.getParent());
		} else
			return;
	}
	public IHeap<T> HeapSort (ArrayList<T> unordered){
		
		build(unordered);
		
		while (lastIndex > 0) {
		swap(heap.get(1),heap.get(lastIndex));
		lastIndex--;
		heapify(heap.get(1));
		}
		
		return this;
	}
}
