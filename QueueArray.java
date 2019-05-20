/*
 * A queue implementation using array.
 * @author Alankar Singh
 */

public class QueueArray {
	
	/*
	 * IsEmpty();
	 * Enqueue();
	 * Dequeue();
	 * IsFull();
	 * Front();
	 * Size();
	 * Print();
	 */
	int[] array = new int[10];
	int front = 0, rear=-1;
	
	public boolean IsEmpty(){
		
		if(front == -1 && rear == -1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean IsFull(){
			
		if(rear == array.length-1){
			return true;
		}else{
			return false;
		}
		
	}
	
	public void Enqueue(int value){
		
		if(IsFull() == true){
			System.out.println("Queue is Full.");
		}else{
			array[++rear] = value;
		}
	}
	
	public void Dequeue(){
		
		front++;
	}
	
	public int Front(){
		return array[front];
	}
	
	public int Size(){
		return rear-front+1;
	}
	
	public void Print(){
		
		if(IsEmpty()==true){
			System.out.println("The queue is empty.");
		}else{
			System.out.println("The queue is :");
			for(int i = front ;i <= rear; i++) {
				System.out.println(array[i]);
			}
			System.out.println("_________________");
		}
	}
	
	public static void main(String[] args){
		QueueArray qa = new QueueArray();
		qa.Enqueue(4);
		qa.Enqueue(2);
		qa.Enqueue(10);
		qa.Enqueue(19);
		qa.Print();
		qa.Dequeue();
		qa.Print();
		qa.Dequeue();
		qa.Print();
		System.out.println("Front elemeent" +qa.Front());
		System.out.println("Size"+ qa.Size());
		System.out.println("Full"+ qa.IsFull());
		System.out.println("Empty"+qa.IsEmpty());
		
	}
}
