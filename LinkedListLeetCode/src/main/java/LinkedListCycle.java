public class LinkedListCycle {

    public boolean hasCycle(SinglyLinkList head) {
        if (head.head == null || head.head.next == null) return false;

        SinglyLinkList.Node slowPointer = head.head;
        SinglyLinkList.Node fastPointer = head.head;

        fastPointer = advancePointer(fastPointer);

        while(slowPointer.next != null){
            if (fastPointer == slowPointer){
                return true;
            }
            slowPointer = slowPointer.next;
            if (fastPointer != null){
                fastPointer = advancePointer(fastPointer);
            }
        }
        return false;
    }

    public SinglyLinkList.Node detectCycle(SinglyLinkList head){
        if (head.head == null || head.head.next == null) return null;
        SinglyLinkList.Node slow = head.head;
        SinglyLinkList.Node fast = head.head;

        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        if (fast == null || fast.next == null)
            return null;

        slow = head.head;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    SinglyLinkList.Node advancePointer (SinglyLinkList.Node node){
        for (int i = 0; i < 2; i++) {
            if (node.next != null)
                node = node.next;
        }
        return node;
    }


    public SinglyLinkList.Node removeNthFromEnd(SinglyLinkList.Node head, int n){
        SinglyLinkList.Node dummy = new SinglyLinkList.Node(0);
        dummy.next = head;

        SinglyLinkList.Node first = dummy;
        SinglyLinkList.Node second = dummy;

        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }

}
