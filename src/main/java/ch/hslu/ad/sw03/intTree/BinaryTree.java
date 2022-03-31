package ch.hslu.ad.sw03.intTree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BinaryTree implements BinaryTreeInterface<Integer> {

    private static final Logger LOG = LogManager.getLogger(BinaryTree.class);

    private int size = 0;
    private Node root = null;
    private Node current = null;
    private Integer intToAdd;
    private Integer intToSearch;
    private boolean searchStatus;

    @Override
    public void add(final Integer element) {
        this.intToAdd = element;
        if (this.root != null) {
            this.current = this.root;
            rekursivAdd();
        } else {
            this.root = new Node(element);
            LOG.info("set root to {}", this.root);
            this.size++;
        }
    }

    private void rekursivAdd() {
        if (this.current.getData().equals(this.intToAdd)) {
            LOG.info("{} is all ready there", this.intToAdd);
            return;
        } else if (this.current.getData().compareTo(this.intToAdd) < 0) {
            addToTheRight();
        } else if (this.current.getData().compareTo(this.intToAdd) > 0) {
            addToTheLeft();
        }
    }

    private void addToTheRight() {
        if (this.current.getRightChild() != null) {
            this.current = this.current.getRightChild();
            rekursivAdd();
        } else {
            this.current.setRightChild(new Node(this.intToAdd));
            this.size++;
            LOG.info("added {} on the right", this.intToAdd);
        }
    }

    private void addToTheLeft() {
        if (this.current.getLeftChild() != null) {
            this.current = this.current.getLeftChild();
            rekursivAdd();
        } else {
            this.current.setLeftChild(new Node(this.intToAdd));
            this.size++;
            LOG.info("added {} on the left", this.intToAdd);
        }
    }

    public void printInOrder() {
        LOG.info("--- traverse in order ---");
        printInOrderRekursiv(this.root);
    }

    private void printInOrderRekursiv(Node node) {
        if (node.hasLeftChild()) {
            printInOrderRekursiv(node.getLeftChild());
        }
        LOG.info(node.getData());
        if (node.hasRightChild()) {
            printInOrderRekursiv(node.getRightChild());
        }
    }

    @Override
    public boolean contains(final Integer element) {
        this.searchStatus = false;
        this.intToSearch = element;
        searchRekursiv(this.root);
        return this.searchStatus;
    }

    private void searchRekursiv(final Node node) {
        if (node == null) {
            LOG.info("{} is not in the tree", this.intToSearch);
        } else if (node.getData().equals(this.intToSearch)) {
            LOG.info("{} was found", this.intToSearch);
            this.searchStatus = true;
        } else if (node.getData().compareTo(this.intToSearch) > 0) {
            LOG.info("search on the left");
            searchRekursiv(node.getLeftChild());
        } else {
            LOG.info("search on the right");
            searchRekursiv(node.getRightChild());
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
