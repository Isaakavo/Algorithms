import java.util.Stack;


public class SinglyLinkList {

    public static class Node{
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }

        public Node(int x, Node next){
          val = x;
          this.next = next;
        }
    }
    Node head;
    int size;

    public SinglyLinkList() {
        head = null;
        // head.next = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node current = head;
        int pos = 0;

        while(pos != index){
            current = current.next;
            pos++;
        }

        return current.val;
    }

    /** Add a node of value val before the first element of the linked list.
     *  After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        if (size == 0){
            addAtHead(val);
            return;
        }

        Node n = new Node(val);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        n.next = null;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     *  If index equals to the length of linked list, the node will be appended to the end of linked list.
     *  If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node p = new Node(val);
        Node temp = head;
        int pos = 0;
        if (index == size){
            addAtTail(val);
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        while (pos != (index - 1)){
            temp = temp.next;
            pos++;
        }
        p.next = temp.next;
        temp.next = p;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }

        Node curr = head;
        if (index == 0){
            head = curr.next;
        }else{
            Node current= head;
            Node pre = head;
            int pos = 0;
            while (pos != index){
                pre = current;
                current = current.next;
                pos++;
            }
            pre.next = current.next;
        }
        size--;
    }

    public void makeCycle(int pos){
        Node tail = head;

        for (int i = 0; i < (size - 1); i++) {
            tail = tail.next;
        }

        if (pos == 0){
            tail.next = head;
        }else{
            Node curr = head;
            for (int i = 0; i < pos; i++) {
                curr = curr.next;
            }

            tail.next = curr;
        }
    }

    public void intersect(SinglyLinkList headA, SinglyLinkList headB, int skipA, int skipB){

        int positionCounter = 0;

        int headAVal = 0;
        int headBVal = 0;

        SinglyLinkList tempHeadA = headA;
        SinglyLinkList tempHeadB = headB;

        while(tempHeadA.head.next != null){
            if (positionCounter == skipA){
                headAVal = tempHeadA.head.val;
                break;
            }
            tempHeadA.head = tempHeadA.head.next;
            positionCounter++;
        }
        positionCounter = 0;
        while(tempHeadB.head.next != null){
            if (positionCounter == skipB){
                headBVal = tempHeadB.head.val;
                break;
            }
            tempHeadB.head = tempHeadB.head.next;
            positionCounter++;
        }
    }

  public Node reverseList(Node head){

      Node prev = null;
      Node curr = head;

      while (curr != null){
        Node nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
      }
      head = prev;
      return head;
  }

  public Node reverseListIterative(Node head){
    
    if (head == null || head.next == null) return head;
      Node p = reverseListIterative(head.next);
      head.next.next = head;
      head.next = null;
      return p;
    
  }

  public Node removeElements(Node root, int val){

    Node helper = new Node(0);
    helper.next = head;
    Node p = helper;
 
    while(p.next != null){
        if(p.next.val == val){
            Node next = p.next;
            p.next = next.next; 
        }else{
            p = p.next;
        }
    }
 
    return helper.next;

    // Node prev = null;

    // for (Node n = root; n != null ; n = n.next)
    // {
    //     if (n.val != val)
    //     {
    //         if (prev == null)
    //         {
    //             root = n;
    //         }
    //         prev = n;
    //         continue;
    //     }

    //     if (prev != null)
    //     {
    //         prev.next = n.next;
    //     }
    // }

    // if (prev == null) return null;

    // return root;
  }


  public Node alternateNodes(Node head){
    Node helper = head;
    Node p = helper;

    while(p.next != null && p.next.next != null){
      Node temp = p.next;
      p.next = p.next.next;
      p.next.next = temp;

      p = p.next;
    }

    return helper;
  }

  public Node oddEvenList(Node head){

    Node odd = head, even = head.next, evenHead = even;
    while(even != null && even.next != null){
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
        even = even.next;
    }

    odd.next = evenHead;

    return head;

  }

  public boolean isPalindrome(Node head){

    Stack<Node> s = new Stack<>();
    Node reversed = rev(head);

    Node p = head;
    while(p != null){
      s.push(p);
      p = p.next;
    }

    p = head;
    while(p != null){
      if(p.val == s.pop().val){
        p = p.next;
        continue;
      }
      return false;
    }

    return true;
  }

  public boolean isPalindrome2(Node head){
    Node temp = head;
    Node slow = head;
    
    while(temp!=null && temp.next!=null){
        temp=temp.next.next;
        if(temp!=null)
            slow=slow.next;
    }

    Node rev = rev(slow.next);
    slow.next=null;

    temp=head;
        while(temp!=null && rev!=null){
            if(temp.val==rev.val){
                temp=temp.next;
                rev=rev.next;
            }
            else return false;
        }
        
        return true;
  }

   public Node rev(Node head){
        Node pre = null;
        Node temp = head;
        
        while(temp!=null){
            Node t = temp.next;
            temp.next = pre;
            pre = temp;
            
            temp = t;
        }
        
        return pre;
    }


    public Node mergeTwoLists(Node l1, Node l2) {
      if(l1 == null && l2 == null) return null;
      Node l3 = new Node(0);
      Node pl3 = l3;

      while(l1 != null && l2 != null){
        if(l2.val >= l1.val){
          pl3.next = l1;
          l1 = l1.next;
        }else if(l1.val >= l2.val){
          pl3.next = l2;
          l2 = l2.next;
        }
        pl3 = pl3.next;
      }
      if(l1 != null) pl3.next = l1;
      if(l2 != null) pl3.next = l2;

        return l3.next;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
      Node dummyHead = new Node(0);
      Node p = l1, q = l2, curr = dummyHead;
      int carry = 0;
      while (p != null || q != null) {
          int x = (p != null) ? p.val : 0;
          int y = (q != null) ? q.val : 0;
          int sum = carry + x + y;
          carry = sum / 10;
          curr.next = new Node(sum % 10);
          curr = curr.next;
          if (p != null) p = p.next;
          if (q != null) q = q.next;
      }
      if (carry > 0) {
          curr.next = new Node(carry);
      }
      return dummyHead.next;
    }
}
