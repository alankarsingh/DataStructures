/*
 * A class to create a new node with the value and link to it's previous and next node.
 */
class NewNode{
	
	int data;
	NewNode next;
	NewNode prev;
	
	public NewNode(int value){
		data = value;
		next = prev = null;
		
	}
}

/*
 * This class shows the implementation of Doubly Linked List.
 */
public class DoublyLinkedList {

	NewNode head;
	
	public DoublyLinkedList(){
		head = null;
	}
	
	/*
	 * A method to add a new node to linked list 
	 * @param int val
	 */
	public void add(int val) {
		
		NewNode node = new NewNode(val);
		
		if (head== null) {
			head = node;
		}else {
			NewNode temp;
			temp = head;
			while(temp.next!= null) {
				temp = temp.next;
			}
			
			temp.next=node;
			node.prev = temp;
			
		}
	}
	
	/*
	 * A method to insert a new node at given index to linked list 
	 * @param int index
	 * @param int val
	 */
	public void insert(int index, int val) {
		
		int counter = 1;
		NewNode tail = head;
		
		while(counter < index) {
			tail.prev= tail;
			tail = tail.next;
			counter++;
		}
		NewNode node = new NewNode(val);
		tail.prev= node.prev;
		node.next = tail;
	}
	
	/*
	 * A method to delete a node from linked list 
	 * @param int val
	 */
	public void delete() {
		
		NewNode tail = head;
		while(tail.next.next!= null) {
			tail = tail.next;
		}
		tail.next = null;
	}
	
	/*
	 * A method to display the doubly linked list
	 * @param int val
	 */
	public void display(){
		
		NewNode temp;
		if(head== null){
			System.out.println("The list is display.");
		}else{
			temp = head;
			while(temp!=null){
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
	
	public static void main(String[] args){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add(4);
		dll.add(7);
		dll.add(41);
		dll.add(71);
		dll.add(14);
		dll.add(17);
		dll.insert(2,11);
		dll.display();
	}
}
