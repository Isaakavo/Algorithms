  public class Main {

  public static void main(String[] args) {
    SinglyLinkList mySingle = new SinglyLinkList();


    SinglyLinkList cycle = new SinglyLinkList();


    int[] test = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
    for (int t: test) {
        cycle.addAtTail(t);
    }
    cycle.makeCycle(24);

    LinkedListCycle linkedListCycle = new LinkedListCycle();

    linkedListCycle.hasCycle(cycle);
    SinglyLinkList.Node test2 = linkedListCycle.detectCycle(cycle);

    SinglyLinkList headA = new SinglyLinkList();
    SinglyLinkList headB = new SinglyLinkList();

    headA.addAtHead(1);

    headA.addAtTail(4);
    headA.addAtTail(1);
    headA.addAtTail(8);
    headA.addAtTail(4);
    headA.addAtTail(5);

    headB.addAtTail(5);
    headB.addAtTail(6);
    headB.addAtTail(1);
    headB.addAtTail(8);
    headB.addAtTail(4);
    headB.addAtTail(5);

    SinglyLinkList intersected = new SinglyLinkList();

    intersected.intersect(headA, headB, 2, 3);


    SinglyLinkList delete = new SinglyLinkList();

    delete.addAtTail(1);
    delete.addAtTail(2);
    delete.addAtTail(3);
    delete.addAtTail(4);
    delete.addAtTail(5);

    LinkedListCycle deleteA = new LinkedListCycle();

    deleteA.removeNthFromEnd(delete.head, 2);

    // mySingle.addAtTail(1);
    // mySingle.addAtTail(2);
    // mySingle.addAtTail(6);
    // mySingle.addAtTail(3);
    // mySingle.addAtTail(4);
    // mySingle.addAtTail(5);
    // mySingle.addAtTail(6);
    // mySingle.reverseList(mySingle.head);
    // mySingle.reverseListIterative(mySingle.head);
    // mySingle.removeElements(mySingle.head, 6);
    // mySingle.alternateNodes(mySingle.head);
    // mySingle.oddEvenList(mySingle.head);


    int[] elements = {1,2,3,2,1};

    for(int el : elements){
      mySingle.addAtTail(el);
    }

    // mySingle.removeElements(mySingle.head, 6);
    // mySingle.oddEvenList(mySingle.head);

    // mySingle.addAtTail(1);
    // mySingle.addAtTail(2);
    // mySingle.addAtTail(2);
    // mySingle.addAtTail(1);
    // mySingle.addAtTail(5);

    mySingle.isPalindrome2(mySingle.head);


    SinglyLinkList l1 = new SinglyLinkList();
    SinglyLinkList l2 = new SinglyLinkList();

    // l1.addAtTail(1);
    // l1.addAtTail(2);
    // l1.addAtTail(4);

    // l2.addAtTail(1);
    // l2.addAtTail(3);
    // l2.addAtTail(4);

    // l1.mergeTwoLists(l1.head, l2.head);

    // l1.mergeTwoLists(l1.head, l2.head);

    l1.addAtTail(9);
    // l1.addAtTail(4);
    // l1.addAtTail(3);

    l2.addAtTail(1);
    l2.addAtTail(9);
    l2.addAtTail(9);
    l2.addAtTail(9);
    l2.addAtTail(9);
    l2.addAtTail(9);
    l2.addAtTail(9);
    l2.addAtTail(9);
    l2.addAtTail(9);
    l2.addAtTail(9);
    l1.addTwoNumbers(l1.head, l2.head);

  }
}
