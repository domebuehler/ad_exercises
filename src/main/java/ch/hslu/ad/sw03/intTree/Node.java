package ch.hslu.ad.sw03.intTree;

public final class Node<T extends Comparable> {

    private Node leftChild;
    private Node rightChild;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", data=" + data +
                '}';
    }
}
