class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class MyCircularDeque {
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        capacity = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        addNode(head, value);
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        addNode(tail.prev, value);
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        deleteNode(head.next);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        deleteNode(tail.prev);
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.next.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private void addNode(Node prevNode, int value) {
        Node newNode = new Node(value);
        Node nextNode = prevNode.next;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
