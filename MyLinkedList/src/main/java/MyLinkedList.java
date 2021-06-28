
public class MyLinkedList{

  public static class Node{
    int val;
    Node next;
    Node prev;
    Node child;
    Node(int x){
      val = x;
      next = null;
      prev = null;
    }
  }

  Node head;
  Node tail;
  int size;

  public MyLinkedList(){
    head = null;
    tail = null;
    size = 0;
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

      if(index >= size  || index < 0) return -1;

      Node pointer = head;
      int counter = 0;

      while(pointer.next != null && counter < index){
        pointer = pointer.next;
        counter++;
      }

        return pointer.val;
    }
    
    /** Add a node of value val before the first element of the linked list.
     *  After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node curr = new Node(val);
        if(head == null){
          head = tail = curr;
          size++;
          return;
        }
        curr.next = head;
        head.prev = curr;
        head = curr;
        size++;
        if(head.next == null){
          tail = head;
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
      if(head == null){
        addAtHead(val);
        return;
      }
      Node curr = new Node(val);
      curr.prev = tail;
      tail.next = curr;
      tail = tail.next;
      // Node pointer = head;

      // while(pointer.next != null){
      //   pointer = pointer.next;
      // }

      // pointer.next = curr;
      // curr.prev = pointer;
      // curr.next = null;
      size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. 
     * If index equals to the length of linked list, the node will be appended to the end of linked list. 
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
      if(index > size || index < 0) return;
      if(index == size) {
        addAtTail(val);
        return;
      }
      if(index == 0){
        addAtHead(val);
        return;
      }
      Node pointer = head;

      for (int i = 0; i < index - 1; i++) {
        pointer = pointer.next;
      }
      Node curr = new Node(val);
      Node save = pointer;

      pointer = pointer.next;
      save.next = curr;
      curr.next = pointer;
      size++;
      
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
          head.next.prev = null;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        }else if(index == (size - 1)){
          tail = tail.prev;
          tail.next = null;
          size --;
        } else {
            Node p = head;
            for (int i = 0; i != index; i++) {
                p = p.next;
            }
            p.next.prev = p.prev;
            p.prev.next = p.next;

            size--;
            if (p.next == null) {
                tail = p;
            }
        }
    }

    public void doChild(Node parent, Node child, int index) {
      Node ptr = parent;
      for (int i = 0; i < index; i++) {
        ptr = ptr.next;
      }
      ptr.child = child;
    }

    // public Node flatten(Node head) {
    //     Node flat = new Node(0);
    //     Node ptr = flat;
    //     Node tail = null;
    //     Node headPtr = head;
        
    //     while(headPtr != null){
    //         if(headPtr.child == null){
    //             ptr.next = headPtr;
    //             ptr.next.prev = ptr;
    //             ptr = ptr.next;
    //         }else{
    //             Node temp = merge(headPtr.child);
    //             // ptr = ptr.next;
    //             headPtr.child = null;
    //             ptr.next = temp;
    //             ptr.next.prev = ptr;
    //             ptr = getTail(temp);
    //         }
    //         headPtr = headPtr.next;
    //     }
        
    //     return flat.next;
    // }
     public Node flatten(Node head) {
        Node flat = null;

      flat = merge(head);

        return flat;
    }

    public Node merge(Node child){
        if(child == null) return null;
        
        if(child.child != null){
            Node temp =  child;
            Node mergeChild = merge(child.child);
            temp.child = null;
            Node childPtr = mergeChild;
            while(childPtr.next != null){
              childPtr = childPtr.next;
            }
            if(childPtr.next != null || temp.next != null){
              childPtr.next = temp.next;
              childPtr.next.prev = childPtr;
            }
            temp.next = mergeChild;
            temp.next.prev = temp;
            
            return temp;
        }
        
        if(child.child == null){
            Node temp = null;
            temp = child;
            temp.next = merge(child.next);
            return temp;
        }

        return null;
    }

    public Node getTail(Node head){
      Node ptr = head;
      while(ptr.next != null){
        ptr = ptr.next;
      }
      return ptr;
    }

    public static String isValid(String s) {
    // Write your code here
        int[] freq = new int[26];
        
        for(char letter: s.toCharArray()){
            freq[letter - 97] += 1;
        }
        for(int i = 0, j = 1; j < freq.length; i++, j++){
          if(freq[j] == 0) continue;
            if(freq[i] != freq[j]){
                freq[j] -= 1;
                if(freq[j] == 0){
                  freq[j] = -1;
                }
            }
        }
        for(int i = 0, j = 1; j < freq.length; i++, j++){
            if(freq[j] == 0) continue;
            if(freq[i] != freq[j]){
                return "NO";
            }
            
        }
        return "YES";
    }

  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();

    // list.addAtHead(4);
    // list.addAtHead(3);
    // list.addAtHead(1);

    // list.addAtTail(5);

    // int nodeValue = list.get(0);
    // System.out.println(nodeValue);

    // // list.addAtIndex(1, 2);
    // list.deleteAtIndex(1);

    MyLinkedList leetCode = new MyLinkedList();
    // leetCode.addAtHead(1);
    // leetCode.addAtTail(3);
    // leetCode.addAtIndex(1, 2);
    // leetCode.get(1);
    // leetCode.deleteAtIndex(1);
    // leetCode.get(1);

    // leetCode.addAtIndex(0, 10);
    // leetCode.addAtIndex(0, 20);
    // leetCode.addAtIndex(1, 30); 

    // leetCode.addAtHead(2);
    // leetCode.get(1);
    // leetCode.deleteAtIndex(1);
    // leetCode.addAtHead(2);
    // leetCode.addAtHead(7);
    // leetCode.addAtHead(3);
    // leetCode.addAtHead(2);
    // leetCode.addAtHead(5);
    // leetCode.addAtTail(5);
    // leetCode.get(5);
    // leetCode.deleteAtIndex(2);
    // leetCode.deleteAtIndex(4);

    // leetCode.addAtTail(0);
    // leetCode.addAtTail(1);
    // leetCode.addAtTail(2);
    // leetCode.addAtTail(3);
    // leetCode.addAtTail(4);
    // leetCode.addAtTail(5);
    // leetCode.addAtIndex(7, 6);
    // leetCode.deleteAtIndex(5);
    // leetCode.addAtHead(5);

    // leetCode.addAtTail(1);
    // leetCode.addAtTail(2);
    // leetCode.addAtTail(3);
    // leetCode.addAtTail(4);
    // leetCode.addAtTail(5);
    // leetCode.addAtTail(6);
    
    // MyLinkedList child1 = new MyLinkedList();
    // child1.addAtTail(7);
    // child1.addAtTail(8);
    // child1.addAtTail(9);
    // child1.addAtTail(10);

    // MyLinkedList child2 = new MyLinkedList();

    // child2.addAtTail(11);
    // child2.addAtTail(12);

    // child1.doChild(child1.head, child2.head, 1);
    // leetCode.doChild(leetCode.head, child1.head, 2);
    // leetCode.flatten(leetCode.head);

    leetCode.isValid("abbac");
  }
}