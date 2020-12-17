package LinkedList;

public class Node {
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node(Object item) {
        this.item = item;
        next = null;
    }

	public Node() {
        item = null;
        next = null;
	}
}
