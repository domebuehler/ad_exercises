package ch.hslu.ad.sw03.stringTree;
/**
 * This Collection implements a BinaryTree for String-Elements.
 */
public interface StringBinaryTreeInterface {

    /**
     * Add a String in the BinaryTree.
     * @param string the String to add
     */
    void add(final String string);

    /**
     * Checks if the BinaryTree contains the String.
     * @param string The String to check
     * @return {@code true} if the String was found
     */
    boolean search(final String string);
}
