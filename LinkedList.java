package LinkedList;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList()  {
        head = new Node(); // dummy node
        size = 0;
    }

    public void add(Object item) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(item);
        size++;
    }

    public void add(int i, Object item) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Good luck, private Ryan!");
        }
        Node curr = head;
        int index = 0;
        while (index != i) {
            curr = curr.next;
            index++;
        }
        curr.next = new Node(item, curr.next);
        size++;
    }

    public Object get(int index) {
        if (index < 0) {
            index = size + index;
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Good luck, private Ryan!");
        }

        Node curr = head;
        int i = 0;
        while (index != i - 1) {
            curr = curr.next;
            i++;
        }
        return curr.item;
    }

    public boolean contains(Object item) {
        Node curr = head.next;
        while (curr != null) {
            if (curr.item.equals(item)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String out = "";
        for (Node curr = head.next; curr != null; curr = curr.next) {
            out += curr.item + " ";
        }
        return out;
    }

    /** 
    * Removes the first matched object and
    * returns the position of the removed object
    * from the LinkedList.
    * 
    * @param item represents the item the user wants to remove
    * @return     position of the removed item
    */
    int remove(Object item) 
    {
        Node temp = head;
        Node prev = null;
        
        while(temp != null)
        {
            if(temp.item == item)
            {
                head = temp.next;
                return LinkedList.indexOf(temp.item);
            }
            prev = temp;
        
        }
         prev.next = temp.next;
        if(temp == null)
        {
            return size;
        }
       
        
    }

    /**
    * Removes the object given the position and
    * returns the removed object from the LinkedList.
    * 
    * @param position represents the position of the object
    *                 to be removed
    * @return         the item that was removed
    */
    Object remove(int position) 
    {
        if(position == 1)
        {
            Node temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }
        else
        {
            Node previous = head;
            int count = 1;

            while(count < position - 1)
            {
                previous = previous.next;
                count++;
            }
            Node curr = previous.next;
            previous.next = curr.next;
            curr.next = null;
            return curr;

        }
    }
}
