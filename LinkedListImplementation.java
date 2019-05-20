/*
 * A class which shows the implementation of LinkedList
 * @author Alankar Singh
 */

/*
 * Create a class for creating a node;
 */
class Node{
	int data;
	Node next;
	
	public Node(int val) {
		data = val;
		next = null;
	}
}

public class LinkedListImplementation {

	Node head;

	public void add(int val) {

		Node temp;
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			temp = head;
			while(temp.next!= null){
				temp = temp.next;
			}	
			temp.next  = newNode;	
		}
	}
	
	/*
	 * Delete the last element from the list.
	 */
	public void delete(){
		
		Node temp = head;
		if(size()==0){
			System.out.println("LinkedList is empty.");
		}else{
			while(temp.next.next!= null){
				temp = temp.next;
			}
			temp.next = null;
		}
	}
	
	public void remove(int val) {
		if(head == null){
			System.out.print("Cannot remove");
		}
		Node temp;
		temp = head;
		while(temp.next.data!=val){
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}
	
	public int size(){
		int len=0;
		Node traverse = head;
		while (traverse != null) {
			traverse = traverse.next;
			len++;
		}
		return len;
	}
	
	public void insert(int index, int val){
		 
		Node temp = head;
		int counter=1;
		if(size()<index){
			System.out.println("Invalid Index.");
		}else{
			while(counter < index){
				temp = temp.next;
				counter++;
			}
			Node newNode = new Node(val);
			newNode.next = temp.next;
			temp.next = newNode;
		}
		
	}
	

	public void display() {
		System.out.println("LinkedList is :");
		Node traverse = head;
		while (traverse != null) {
			System.out.println(traverse.data);
			traverse = traverse.next;
		}
		System.out.println("____________");
	}

	public static void main(String[] args) {

		LinkedListImplementation lli = new LinkedListImplementation();
		
		lli.add(6);
		lli.add(1);
		lli.add(3);
		lli.add(9);
		lli.add(10);
		lli.display();
		System.out.println("Size is :"+lli.size());			
		lli.display();
		lli.delete();
		System.out.println("Size is :"+lli.size());
		lli.insert(3, 45);
		lli.display();
	}
}
