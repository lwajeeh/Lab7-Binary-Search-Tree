// Name: Laith Wajeeh
// Class: CS 145
// Assignment: Lab 7: Binary Search Tree
// Sources: google/grepper.
// Purpose: Demonstrates the use of a binary search tree by adding/searching/and removing data.
// I wasn't able to get the delete feture to work for the tree. I think I was over complicationg it for myself.

public class TreeTest {

  public static void main(String[] args) {
    Tree<Integer> tree = new Tree<>();
    System.out.println("Inserting the following values:\n4 10 32 3 95 5 40 42 1");
    tree.insertNode(4);
    tree.insertNode(10);
    tree.insertNode(32);
    tree.insertNode(3);
    tree.insertNode(95);
    tree.insertNode(5);
    tree.insertNode(40);
    tree.insertNode(42);
    tree.insertNode(1);
    System.out.println("Preorder Traversal");
    tree.preorderTraversal();
    System.out.println("\n\nInorder Traversal");
    tree.inorderTraversal();
    System.out.println("\n\nPostorder Traversal");
    tree.postorderTraversal();
    System.out.println("\n\nDoes the value 7 exist in the Tree?: " + tree.search(7) + "\n");
    System.out.println("Does the value 95 exist in the Tree?: " + tree.search(95) + "\n");
    tree.outputTree(5);
  }

}

