/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchTree;

/**
 *
 * @author Leona
 */
public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;

    public AVLTree() {
        this.root = null;
    }

    private int height(AVLNode<T> node) {
        return (node == null) ? 0 : node.height;
    }

    private int balanceFactor(AVLNode<T> node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode<T> rotateRight(AVLNode<T> node) {
        AVLNode<T> x = node.left;
        AVLNode<T> T2 = x.right;

        x.right = node;
        node.left = T2;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> x) {
        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(T element) {
        root = insert(root, element);
    }

    private AVLNode<T> insert(AVLNode<T> node, T element) {
        if (node == null) {
            return new AVLNode<>(element);
        }

        if (element.compareTo(node.element) < 0) {
            node.left = insert(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = insert(node.right, element);
        } else {
            // Duplicate elements are not allowed in AVL tree
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

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
    
    public void remove(T element) {
        root = remove(root, element);
    }
    
    private AVLNode<T> remove(AVLNode<T> node, T element) {
        if (node == null) {
            return null;
        }

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

        if (node == null) {
            return null;
        }

        // Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

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
    
    public void removeMax() {
        if (root == null) {
            return;
        }

        root = removeMax(root);
    }

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

    public void removeMin() {
        if (root == null) {
            return;
        }

        root = removeMin(root);
    }

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
    
    public T findMin(){
        if(root == null){
            return null;
        }
        
        AVLNode<T> minNode = findMin(root);
        return minNode.element;
    }

    private AVLNode<T> findMin(AVLNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    public T findMax() {
        if (root == null) {
            return null;
        }

        AVLNode<T> maxNode = findMax(root);
        return maxNode.element;
    }

    private AVLNode<T> findMax(AVLNode<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Método auxiliar para balancear um nó
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
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        inOrderTraversal(root, result);
        result.append("]");
        return result.toString();
    }

    private void inOrderTraversal(AVLNode<T> node, StringBuilder result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.append(node.element).append(" ");
            inOrderTraversal(node.right, result);
        }
    }
}
