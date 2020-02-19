package linkedlist.single;

public class Main {
	static LinkedList linkedList;
	public static void main(String[] args) {
		testInsert();
		testFindElement();

	}

	private static void testInsert() {
		linkedList = new LinkedList();
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.insertAfter(linkedList.head.next, 6);
		linkedList.printLinkedList();
		linkedList.deleteAtPosition(3);
		System.out.println("Search status " +linkedList.searchRecursive(0));
		linkedList.printLinkedList();
	}
	
	private static void testFindElement() {
		int position = 1;
		Node node = linkedList.getNodeFromStart(position);
		if(node != null) {
			System.out.println("Found node from position " + position + " with value " + node.value);
		} else {
			System.out.println("No element");
		}
		
		position = 3;
		node = linkedList.getNodeFromEnd(position);
		if(node != null) {
			System.out.println("Found node from position " + position + " with value " + node.value);
		} else {
			System.out.println("No element");
		}
	}

}
