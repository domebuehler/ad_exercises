package ch.hslu.ad.sw03.stringTree;

public final class Node {
    private Node leftChild;
    private Node rightChild;
    private String data;

    public Node(Node leftChild, Node rightChild, String data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }
}
