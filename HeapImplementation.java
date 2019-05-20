import java.lang.*;
/*
 * A class which shows the Heap implementation.
 * @author Alankar Singh
 */
public class HeapImplementation {

	int[] heap;
	int latest;
	int i;
	
	public HeapImplementation() {

		heap = new int[20];
		i = -1;
		latest = 0;

	}
	/*
	 * To add the new value in the heap 
	 * Uncomment the min heap and comment the max heap from the method to add it in min heap manner.
	 */
	public void add(int val) {

		heap[++i] = val;
		latest++;
		maxHeap();
//		minHeap();
	}
	
	// A minHeap method
	public void minHeap() {

		int index = latest - 1;
		int parentIndex = index;
		// find the parent value;
		if (index == 0) {
			return;
		} else {
			while (true) {
				parentIndex = (int) Math.floor((parentIndex - 1) / 2);
				if (heap[index] < heap[parentIndex]) {
					int temp = heap[parentIndex];
					heap[parentIndex] = heap[index];
					heap[index] = temp;
				} else {
					break;
				}
			}
		}

	}

	// A max Heap method
	public void maxHeap() {

		int index = latest - 1;
		int parentIndex = index;

		// find the parent value;
		if (index == 0) {
			return;
		} else {
			while (true) {
				parentIndex = (int) Math.floor((parentIndex - 1) / 2);
				if (heap[index] > heap[parentIndex]) {
					int temp = heap[parentIndex];
					heap[parentIndex] = heap[index];
					heap[index] = temp;
					index = parentIndex;
				} else {
					break;
				}
			}
		}

	}
	
	public void delete(){
		
		// Remove the value;
		heap[0]=heap[latest-1];
		heap[latest-1] =0;
		latest--;
		int parent =0 ,nextParent = 0;
		int leftChildIndex, rightChildIndex;
		
		while(true){
			
			 leftChildIndex = 2*nextParent+1;
			 rightChildIndex = 2*nextParent+2;
			 if(heap[leftChildIndex] !=0 || heap[rightChildIndex] !=0){
				 nextParent = heap[leftChildIndex]<heap[rightChildIndex] ? rightChildIndex : leftChildIndex;
			 		if(heap[nextParent]>heap[parent]){
			 			int tempo = heap[parent];
			 			heap[parent] = heap[nextParent];
			 			heap[nextParent] = tempo;
			 			parent = nextParent;
			 		}else{
			 			break;
			 		}
			 }else{
				 break;
			 }
		}
		
	}

	public void display() {

		int counter = 0;
		while (counter < latest) {
			System.out.print(heap[counter] + " ");
			counter++;
		}
	}

	public static void main(String[] args) {

		HeapImplementation hi = new HeapImplementation();
		hi.add(50);
		hi.add(30);
		hi.add(70);
		hi.add(10);
		hi.add(20);
		hi.add(60);
		hi.add(80);
		hi.display();
		hi.delete();
		System.out.println();
		System.out.println("Heap after delete");
		hi.display();
	}

}
