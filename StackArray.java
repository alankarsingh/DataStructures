/*
 * A stack implementation using array.
 * @author Alankar Singh
 */

public class StackArray {
	
	/*
	 * IsEmpty();
	 * Enqueue();
	 * Dequeue();
	 * IsFull();
	 * Front();
	 * Size();
	 * Print();
	 */
	int top = -1;
	int[] array = new int[10];
	
	public void push(int value){
		if (array.length > 10){
			System.out.println("Stack overflow. We will take care of dynamic array later.");
		}
		
		array[++top] = value; 
	}
	
	public void pop(){
		if (top == -1){
			System.out.println("There is no element to pop.");
		}else{
			top--;
		}
	}
	
	public void IsEmpty(){
		if(top == -1)
			System.out.println("Is Empty");
		else
			System.out.println("Non-Empty");
	}
	
	public void print(){
		
		if(top==-1){
			System.out.println("Stack is Empty:");
		}else{
			System.out.println("Stack is: ");
			for (int i =0; i <= top; i++){
				System.out.println(array[i]);
			}
		}
	}
	
	public int size(){
		return top+1; 
	}
	
	public void top(){
		if(top==-1){
			System.out.println("No element in the stack");
		}else{
			System.out.println("Top element is:" +array[top]);
		}
	}
	
	public static void main(String[] args){
		StackArray sa = new StackArray();
		
		sa.push(4);
		sa.push(2);
		sa.push(1);
		sa.push(10);
		sa.push(156);
		sa.print();
		
	}
	
}
