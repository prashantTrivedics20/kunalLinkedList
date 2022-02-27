public class DLL {
    Node head;
    public void insertFirst(int val)
    {
        Node node=new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null) {
            head.prev = node;
        }
        head=node;
    }
//    public void display()
//    {
//        Node node=head;
//        while(node!=null)
//        {
//            System.out.print(node.val+"->");
//            node=node.next;
//        }
//        System.out.println("NULL");
//    }
    public void insertLast(int val)
    {
        Node node=new Node(val);
        Node last=head;
        node.next=null;
        if(head==null)
        {
            node.prev=null;
            head=node;
            return;
        }
        while(last.next!=null)
        {
            last=last.next;
        }
        last.next=node;
        node.prev=last;
    }
    public Node find(int val)// find the particular node and return it
    {
        Node node=head;
        while(node!=null)
        {
            if(node.val==val)
            {
                return node;

            }
            node=node.next;

        }
        return null;
    }
    public void insert(int after,int val)// add the element after the element
    {
        Node p=find(after);
        if(p==null)
        {
            System.out.println("does not exits");
        }
        Node node=new Node(val);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if(node.next!=null) {
            node.next.prev = node;
        }

    }
    public void displayReverse()
    {
        Node node=head;
        Node last=null;
        while(node!=null)
        {
            last=node;
            System.out.print(node.val+"->");
            node=node.next;
        }
        System.out.println("NULL");
        System.out.println("print in reverse");
        while(last!=null)
        {
            System.out.print(last.val+"->");
            last=last.prev;
        }
        System.out.println("start");
    }
    private class Node
    {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }


}
class test2
{
    public static void main(String[] args) {
        DLL obj=new DLL();
        obj.insertFirst(3);
        obj.insertFirst(2);
        obj.insertFirst(8);
        obj.insertFirst(17);
        obj.insertLast(99);
        obj.insert(8,65);
        //obj.display();
        obj.displayReverse();


    }
}
