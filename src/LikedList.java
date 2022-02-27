class LinkedList {

private class Node
{
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
    private Node head;// head and tails are the reference variable that is pointing to node
    private Node tail;
    private int size;
    public LinkedList()
    {
        this.size=0;
    }
    // insert at the first position
    public void insertFirst(int val)
    {
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null)
        {
            tail=head;
        }
        size++;
    }
    //insert the element at the last of the linked list
    public void insertLast(int val)
    {
        if(tail==null)
        {
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;

    }
    // insert the node at particular position....
    public void insertParticularPosition(int val,int index)
    {
        if(index==0)
        {
            insertFirst(val);
            return;
        }
        if(index==size)
        {
            insertLast(val);
            return;
        }
        Node temp=head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    // delete the node at first
    public int deleteFirst()
    {
        int val=head.value;
        head=head.next;
        if(head==null)
        {
            tail=null;
        }
        size--;
        return val;
    }
    // delete the last element of the node ....
    public int deleteLast()
    {
        if(size<=1)
        {
            return deleteFirst();
        }
        Node secondLast=get(size-2);
        int value=tail.value;
        tail=secondLast;
        tail.next=null;
        return value;
    }

    public Node get(int index)// this function is help full to delete the any position of the node
    {
        Node node=head;
        for (int i = 0; i <index ; i++) {
            node =node.next;
        }
        return node;
    }
    public Node find(int val)// find the particular node and return it
    {
        Node node=head;
        while(node!=null)
        {
            if(node.value==val)
            {
                return node;

            }
            node=node.next;

        }
        return null;
    }
    // delete the element in the particular index
    public int deleteParticularElement(int index)
    {
        if(index==0)
        {
            return deleteFirst();
        }
        if(index==size-1)
        {
            return deleteLast();
        }
        Node prev=get(index-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        return val;

    }


    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }



}

class test
{
    public static void main(String[] args) {
        LinkedList obj=new LinkedList();
        obj.insertFirst(3);
        obj.insertFirst(2);
        obj.insertFirst(8);
        obj.insertFirst(17);
        obj.insertLast(99);
        obj.insertParticularPosition(100,3);
        obj.display();
        System.out.println(obj.deleteFirst());// it will delete the first node and return the value also
        obj.display();
        System.out.println(obj.deleteLast());// it will delete the Last node and return the value also
        obj.display();
        System.out.println(obj.deleteParticularElement(2));// it will delete the value from particular position
        obj.display();
    }
}
