package ch.hslu.ad.sw03.stringTree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class StringBinaryTree implements StringBinaryTreeInterface {

    private static final Logger LOG = LogManager.getLogger(StringBinaryTree.class);

    private Node root;
    private int searchDepth = 0;
    private boolean searchStatus = false;

    public StringBinaryTree() {
        Node i = new Node(null, null, "I");
        Node j = new Node(i, null, "J");
        Node l = new Node(null, null, "L");
        Node k = new Node(j, l, "K"); // = linker Teilbaum

        Node n = new Node(null, null, "N");
        Node o = new Node(n, null, "O");
        Node s = new Node(null, null, "S");
        Node r = new Node(null, s, "R");
        Node q = new Node(o, r, "Q"); // = rechter Teilbaum

        this.root = new Node(k, q, "M");
    }

    @Override
    public void add(final String string) {

    }

    @Override
    public boolean search(final String string) {
        this.searchDepth = 0;
        this.searchStatus = false;
        compareNode(this.root, string);
        return this.searchStatus;
    }

    private void compareNode(final Node node,final String string) {
        this.searchDepth++;
        LOG.info("comparing {} to {}", node, string);
        if (node != null) {
            if (node.getData().equals(string)) {
                LOG.info("found element {}, depth = {}" , string, this.searchDepth);
                this.searchStatus = true;
            } else if (node.getData().compareTo(string) < 0) {
                LOG.info("go right");
                compareNode(node.getRightChild(), string);
            } else {
                LOG.info("go left");
                compareNode(node.getLeftChild(), string);
            }
        } else {
            LOG.info("element {} was not found", string);
        }
    }
}
