public class circularLinkedList {
    Node head;
    Node tail;

    public circularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private class Node
    {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public void insert(int val)
    {
        Node node=new Node(val);
        if(head==null)
        {
            head=tail=node;
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;
    }
    public void display()
    {
        Node node=head;
        if(head!=null)
        {
            do{
                System.out.print(node.data+"->");
                node=node.next;
            }
            while(node!=head);
        }
        System.out.println("HEAD");
    }
    public void delete(int val)// it will delete the element of the circular linked list
    {
        Node node=head;
        if(node==null)
        {
            return;
        }
        if(node.data==val)
        {
            head=head.next;
            tail.next=head;
            return;
        }
        do {
            Node n=node.next;
            if(n.data==val)
            {
                node.next=n.next;
                break;
            }
            node = node.next;

        }while (node!=head);
    }
}
class test3
{
    public static void main(String[] args) {
        circularLinkedList obj=new circularLinkedList();
        obj.insert(23);
        obj.insert(3);
        obj.insert(19);
        obj.insert(75);
        obj.delete(19);

        obj.display();

    }
}
