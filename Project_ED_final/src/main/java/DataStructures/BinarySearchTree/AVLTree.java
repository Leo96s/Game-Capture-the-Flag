/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.BinarySearchTree;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents an AVL (Adelson-Velsky and Landis) tree data structure.
 * AVL trees are self-balancing binary search trees where the heights
 * of the two child subtrees of any node differ by at most one.
 * @param <T> The type of elements stored in the AVL tree, which must
 *            implement the Comparable interface to enable comparison.
 */
public class AVLTree<T extends Comparable<T>> {

    /** The root node of the AVL tree. */
    private AVLNode<T> root;

    /**
     * Constructs an empty AVL tree.
     */
    public AVLTree() {
        this.root = null;
    }

    /**
     * Calculates the height of the given AVL node.
     * @param node The node for which to calculate the height.
     * @return The height of the node, or 0 if the node is null.
     */
    private int height(AVLNode<T> node) {
        return (node == null) ? 0 : node.height;
    }

    /**
     * Calculates the balance factor of the given AVL node.
     * @param node The node for which to calculate the balance factor.
     * @return The balance factor of the node.
     */
    private int balanceFactor(AVLNode<T> node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    /**
     * Performs a right rotation on the given AVL node.
     * @param y The node to rotate.
     * @return The new root node after the rotation.
     */
    private AVLNode<T> rotateRight(AVLNode<T> y) {
        AVLNode<T> x = y.left;
        AVLNode<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    /**
     * Performs a left rotation on the given AVL node.
     * @param x The node to rotate.
     * @return The new root node after the rotation.
     */
    private AVLNode<T> rotateLeft(AVLNode<T> x) {
        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    /**
     * Inserts a new element into the AVL tree.
     * @param element The element to insert.
     */
    public void insert(T element) {
        root = insert(root, element);
    }

    /**
     * Recursively inserts a new element into the AVL tree.
     * @param node The current node being evaluated.
     * @param element The element to insert.
     * @return The updated node after insertion.
     */
    private AVLNode<T> insert(AVLNode<T> node, T element) {
        // Base case: if the node is null, create a new node with the element
        if (node == null) {
            return new AVLNode<>(element);
        }

        // Recursive insertion based on comparison with the current node's element
        if (element.compareTo(node.element) < 0) {
            node.left = insert(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = insert(node.right, element);
        } else {
            // Duplicate elements are not allowed in AVL tree
            return node;
        }

        // Update the height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Rebalance the tree if necessary
        return balanceInsertion(node, element);
    }

    /**
     * Balances the AVL tree after insertion of a new element.
     * @param node The current node being evaluated.
     * @param element The element that was inserted.
     * @return The updated node after rebalancing.
     */
    private AVLNode<T> balanceInsertion(AVLNode<T> node, T element) {
        int balance = balanceFactor(node);

        // Left Left Case
        if (balance > 1 && element.compareTo(node.left.element) < 0) {
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && element.compareTo(node.right.element) > 0) {
            return rotateLeft(node);
        }

        // Left Right Case
        if (balance > 1 && element.compareTo(node.left.element) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && element.compareTo(node.right.element) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    /**
     * Removes an element from the AVL tree.
     * @param element The element to remove.
     */
    public void remove(T element) {
        root = remove(root, element);
    }

    /**
     * Recursively removes an element from the AVL tree.
     * @param node The current node being evaluated.
     * @param element The element to remove.
     * @return The updated node after removal.
     */
    private AVLNode<T> remove(AVLNode<T> node, T element) {
        // Base case: if the node is null, return null
        if (node == null) {
            return null;
        }

        // Recursive removal based on comparison with the current node's element
        if (element.compareTo(node.element) < 0) {
            node.left = remove(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = remove(node.right, element);
        } else {
            // Element to be deleted found

            // Node with only one child or no child
            if ((node.left == null) || (node.right == null)) {
                AVLNode<T> temp = (node.left != null) ? node.left : node.right;

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    // One child case
                    node = temp;
                }
            } else {
                // Node with two children
                AVLNode<T> temp = findMin(node.right);
                node.element = temp.element;
                node.right = remove(node.right, temp.element);
            }
        }

        // If the node was deleted, return null
        if (node == null) {
            return null;
        }

        // Update the height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Rebalance the tree if necessary
        return balanceRemoval(node);
    }

    /**
     * Balances the AVL tree after removal of an element.
     * @param node The current node being evaluated.
     * @return The updated node after rebalancing.
     */
    private AVLNode<T> balanceRemoval(AVLNode<T> node) {
        // Get the balance factor of this node
        int balance = balanceFactor(node);

        // Left Left Case
        if (balance > 1 && balanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }

        // Left Right Case
        if (balance > 1 && balanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && balanceFactor(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Right Left Case
        if (balance < -1 && balanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Additional methods for removing the maximum and minimum elements
    // Similar to remove method, but specific to removing the maximum and minimum elements.

    /**
     * Removes the maximum element from the AVL tree.
     */
    public void removeMax() {
        if (root == null) {
            return;
        }

        root = removeMax(root);
    }

    /**
     * Recursively removes the maximum element from the AVL tree.
     * @param node The current node being evaluated.
     * @return The updated node after removal.
     */
    private AVLNode<T> removeMax(AVLNode<T> node) {
        if (node.right == null) {
            return node.left;
        }

        node.right = removeMax(node.right);

        // Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Rebalance the tree
        return balanceNode(node);
    }

    /**
     * Removes the minimum element from the AVL tree.
     */
    public void removeMin() {
        if (root == null) {
            return;
        }

        root = removeMin(root);
    }

    /**
     * Recursively removes the minimum element from the AVL tree.
     * @param node The current node being evaluated.
     * @return The updated node after removal.
     */
    private AVLNode<T> removeMin(AVLNode<T> node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = removeMin(node.left);

        // Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Rebalance the tree
        return balanceNode(node);
    }

    /**
     * Finds the minimum element in the AVL tree.
     * @return The minimum element in the tree, or null if the tree is empty.
     */
    public T findMin(){
        if(root == null){
            return null;
        }

        AVLNode<T> minNode = findMin(root);
        return minNode.element;
    }

    /**
     * Recursively finds the minimum element in the AVL tree.
     * @param node The current node being evaluated.
     * @return The node containing the minimum element.
     */
    private AVLNode<T> findMin(AVLNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Finds the maximum element in the AVL tree.
     * @return The maximum element in the tree, or null if the tree is empty.
     */
    public T findMax() {
        if (root == null) {
            return null;
        }

        AVLNode<T> maxNode = findMax(root);
        return maxNode.element;
    }

    /**
     * Recursively finds the maximum element in the AVL tree.
     * @param node The current node being evaluated.
     * @return The node containing the maximum element.
     */
    private AVLNode<T> findMax(AVLNode<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * Balances the AVL tree by performing rotations if necessary after insertion or removal of a node.
     * @param node The node to balance.
     * @return The balanced node.
     */
    private AVLNode<T> balanceNode(AVLNode<T> node) {
        // Get the balance factor of this node
        int balance = balanceFactor(node);

        // Left Left Case
        if (balance > 1 && balanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }

        // Left Right Case
        if (balance > 1 && balanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && balanceFactor(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Right Left Case
        if (balance < -1 && balanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    /**
     * Performs an in-order traversal of the AVL tree and returns a string representation of its elements.
     * @return A string representation of the elements in the AVL tree.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        inOrderTraversal(root, result);
        result.append("]");
        return result.toString();
    }

    /**
     * Performs an in-order traversal of the AVL tree and appends each element to the given StringBuilder.
     * @param node The current node being evaluated during traversal.
     * @param result The StringBuilder to which the elements are appended.
     */
    private void inOrderTraversal(AVLNode<T> node, StringBuilder result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.append(node.element).append(" ");
            inOrderTraversal(node.right, result);
        }
    }
}
