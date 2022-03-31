package ch.hslu.ad.sw03.stringTree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringBinaryTreeTest {

    @Test
    void testSearchRoot() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("M")).isTrue();
    }

    @Test
    void testSearchExistingLeftTreeTwoChildren() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("S")).isTrue();
    }

    @Test
    void testSearchExistingLeftTreeOnlyLeftChild() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("J")).isTrue();
    }

    @Test
    void testSearchExistingLeftTreeNoChild() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("I")).isTrue();
    }

    @Test
    void testSearchExistingRightTreeTwoChildren() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("Q")).isTrue();
    }

    @Test
    void testSearchExistingRightTreeOnlyLeftChild() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("O")).isTrue();
    }

    @Test
    void testSearchExistingRightTreeOnlyRightChild() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("R")).isTrue();
    }

    @Test
    void testSearchExistingRightTreeNoChild() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("N")).isTrue();
    }

    @Test
    void testSearchNonExistingIsFalse() {
        StringBinaryTree tree = new StringBinaryTree();
        assertThat(tree.search("X")).isFalse();
    }
}