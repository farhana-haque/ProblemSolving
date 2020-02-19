package LinkedList.single;

public class LinkedList {
	Node head;
	
	//insert at beginning
	public void push(int value) {
		Node node = new Node(value);
		if(head == null) {
			head = node;
			return;
		}
		node.next = head;
		head = node;
	}

	//insert at end
	public void append(int value) {
		if (head == null) {
			head = new Node(value);
			return;
		}

		Node current = head;
		while (current.next != null)
			current = current.next;
		current.next = new Node(value);
	}
	
	//insert after a node
	public void insertAfter(Node prevNode, int value) {
		if(prevNode == null)
			return;
		Node node = new Node(value);
		node.next = prevNode.next;
		prevNode.next = node;
		
	}
	
	public void deleteList() {
		head = null;
	}
	
	public void delete(int key) {
		Node current = head;
		Node prev = head;
		while(current != null && current.value != key) {
			prev = current;
			current = current.next;
		}
		
		if(current.value == key) {
			prev.next = current.next;
		}
	}
	
	public void deleteAtPosition(int position) {
		Node current = head;
		Node prev = head;
		if(position == 0) {
			head = head.next;
		} else {
			int index = 0;
			while(index < position && current != null) {
				prev = current;
				current = current.next;
				index = index + 1;
			}
			if(index == position) {
				prev.next = current.next;
			}
			
		}
		
	}
	
	
	public void printLinkedList() {
		System.out.println();
		Node current = head;
		while(current != null) {
			System.out.print(current.value+ " ----> ");
			current = current.next;
		}
	}
	
	public int getCountIterative() {
		Node tmp = head;
		int count = 0;
		while(tmp != null) {
			tmp = tmp.next;
			count = count+1;
		}
		
		return count;
	}
	
	public int getCountRecursive() {
		return getCount(head);
	}
	
	public int getCount(Node node) {
		if(node == null)
			return 0;
		return 1 + getCount(node.next);
	}
	
	public boolean searchIterative(int value) {
		Node tmp = head;
		
		while(tmp != null) {
			if(tmp.value == value)
				return true;
		}
		
		return false;
	}
	
	public boolean searchRecursive(int value) {
		return search(head, value);
	}
	
	public boolean search(Node node , int value) {
		if(node == null)
			return false;
		if(node.value == value)
			return true;
		return search(node.next, value);
	}
	
	public Node getNodeFromStart(int position) {
		Node tmp = head;
		int currentPosition = 0;
		while(currentPosition < position && tmp != null) {
			tmp = tmp.next;
			currentPosition = currentPosition + 1;
		}
		
		if(currentPosition == position)
			return tmp;
		
		return null;
		
	}
	
	public Node getNodeFromEnd(int position) {
		Node fast = head;
		Node slow = head;
		int currentPosition = 0;
		while(currentPosition < position && fast != null) {
			fast = fast.next;
			currentPosition = currentPosition + 1;
		}
		
		if(currentPosition != position)
			return null;
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;
	}

}
