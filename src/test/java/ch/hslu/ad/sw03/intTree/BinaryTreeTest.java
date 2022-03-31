package ch.hslu.ad.sw03.intTree;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    void testAdd() {
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(20);
        tree.add(5);
        tree.add(14);
        tree.add(30);
        tree.add(2);
        tree.printInOrder();
        tree.contains(1);
    }

}