//Cris Chou
//CYC180001

public class IDedLinkedList<E extends IDedObject> {

	Node head;

	// empty linklist
	public void makeEmpty() {
		
		head = null;
		
	}

	public E findID(int ID) {

		Node node = head;
		
		while (node.next != null) {

			// check if any item has matching ID
			if (node.data.getID() == ID) {
				
				//System.out.println(node.data.printID());
				
				return (E) node.data;
			}

			node = node.next;
		}
		// check last value of linkedlist
		if (node.data.getID() == ID) {
			
			//System.out.println(node.data.printID());
			return (E) node.data;

		} else {

			return null;

		}
	}

	// insert method
	public boolean insertAtFront(E data) {

		Node node = new Node();
		node.data = data;
		node.next = null;

		if (head == null) {

			head = node;
			return true;

		} else {

			Node temp = head;
			// check if ID already exists
			while (temp.next != null) {

				if (temp.data.getID() == node.data.getID()) {

					return false;

				}
				temp = temp.next;

			}
			// check last value of list
			if (temp.data.getID() == node.data.getID()) {

				return false;

			} else {

				// make the new node the head node
				node.next = head;
				head = node;
				return true;

			}
		}

	}

	// delete from front method
	public E deleteFromFront() {
		Node temp;
		// if head is null, list is empty
		if (head == null || head.data == null) {

			return null;

		} else {

			temp = head;

			head = head.next;
			temp.next = null;

			return (E) head.data;

		}

	}

	// delete method

	public E delete(int ID) {
		Node node = head;
		Node prev = null;
		// checking if value is the first value
		if (head.data.getID() == ID) {
			
			prev = head;
			head = head.next;
			prev.next = null;
			
			// return deleted data
			return (E) prev.data;

		} else {

			while (node.next != null) {
				if (node.data.getID() == ID) {

					prev.next = node.next;
					node.next = null;
					
					// return the deleted data
					return (E) node.data;
				}
				node = node.next;
				// make sure for the first time prev lags 1 behind
				if (prev == null) {

					prev = head;

				} else {

					prev = prev.next;

				}
			}
			// check last value of list
			if (node.data.getID() == ID) {
				// if last value is being deleted, means previous value is new last value of
				// list which means its pointing to null
				prev.next = null;

				// return the deleted data
				return (E) node.data;

			}

			return null;

		}

	}

	// print sum of ids method
	public int printTotal() {
		int total = 0;

		Node temp = head;
		if (head != null) {
			while (temp.next != null) {

				total += temp.data.getID();
				temp = temp.next;

			}
			// add final value of list
			total += temp.data.getID();
			return total;

		} else {

			return -1;

		}
	}

	// Node
	class Node<E extends IDedObject> {

		E data;

		Node<E> next;

	}

}
