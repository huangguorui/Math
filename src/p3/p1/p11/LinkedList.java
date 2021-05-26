package p3.p1.p11;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e) {
        //方法一
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        //方法二
        head = new Node(e, head);
        size ++;
    }

    //在链表的index（0-based)位置添加新的元素e
    //在链表中不是一个常用的操作，练习用:)
    public void add(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if(index == 0)
            addFirst(e);
        else{
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            //第一步
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            //第二部
            prev.next = new Node(e,prev);
            size ++;
        }
    }

    //在链表末尾添加新的元素e
    public void addLast(E e){
        add(size,e);
    }

}
