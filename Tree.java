
// TreeNode and Tree class declarations for a binary search tree.

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
   // package access members
   TreeNode<T> leftNode; // left node  
   T data; // node value
   TreeNode<T> rightNode; // right node

   // constructor initializes data and makes this a leaf node
   public TreeNode(T nodeData) { 
      data = nodeData;              
      leftNode = rightNode = null; // node has no children
   }

   // locate insertion point and insert new node; ignore duplicate values
   public void insert(T insertValue) {
      // insert in left subtree
      if (insertValue.compareTo(data) <0) {
         // insert new TreeNode
         if (leftNode == null) {
            leftNode = new TreeNode<>(insertValue);
         }
         else { // continue traversing left subtree recursively
            leftNode.insert(insertValue); 
         }
      }
      // insert in right subtree
      else if (insertValue.compareTo(data)> 0) {
         // insert new TreeNode
         if (rightNode == null) {
            rightNode = new TreeNode<>(insertValue);
         }
         else { // continue traversing right subtree recursively
            rightNode.insert(insertValue); 
         }
      }
   }

   // find if a value exists in the tree
   public Boolean search(T insertValue) {
      if (insertValue.compareTo(data) <0) {
         // traverse left subtree recursively
         if (leftNode != null) {
            return leftNode.search(insertValue);
         }
      }
      // find in right subtree
      else if (insertValue.compareTo(data)> 0) {
         // continue traversing right subtree recursively
         if (rightNode != null) {
            return rightNode.search(insertValue); 
         } 
      } else {
         return true;
      }
      return false;
   }

   // public void insertNode(TreeNode<T> insertNode) {
   //  // insert in left subtree
   //  if (insertNode.data.compareTo(data) <0) {
   //     // insert new TreeNode
   //     if (leftNode == null) {
   //        leftNode = insertNode;
   //     }
   //     else { // continue traversing left subtree recursively
   //        leftNode.insertNode(insertNode);
   //     }
   //  }
   //  // insert in right subtree
   //  else if (insertNode.data.compareTo(data)> 0) {
   //     // insert new TreeNode
   //     if (rightNode == null) {
   //        rightNode = insertNode;
   //     }
   //     else { // continue traversing right subtree recursively
   //        rightNode.insertNode(insertNode);
   //     }
   //  }
 }

   // public void remove(T removevalue) {
   //  if (rightNode != null) {
   //      if (removevalue.compareTo(rightNode.data)> 0 && rightNode.rightNode != null) {
   //       leftNode.rightNode.remove(removevalue);
   //      } else if (removevalue.compareTo(rightNode.data) <0 && rightNode.rightNode != null) {
   //       rightNode.leftNode.remove(removevalue);
   //      } else {
   //       if (rightNode.rightNode == null && rightNode.leftNode == null) {
   //        rightNode = null;
   //       } else if (rightNode.rightNode != null && rightNode.leftNode == null) {
   //        rightNode = rightNode.rightNode;
   //       } else if (rightNode.rightNode == null && rightNode.leftNode != null) {
   //        rightNode = rightNode.leftNode;
   //       } else {
   //        //rightNode.leftNode.insertNode(rightNode.rightNode);
   //        rightNode = rightNode.leftNode;
   //       }        
   //    }
    //}
//     if (leftNode != null) {
//       if (removevalue.compareTo(leftNode.data)> 0 && leftNode.rightNode != null) {
//        rightNode.remove(removevalue);
//       } else if (removevalue.compareTo(rightNode.data) <0 && leftNode.leftNode != null) {
//        leftNode.remove(removevalue);
//       } else {
//        if (leftNode.rightNode == null && leftNode.leftNode == null) {
//         rightNode = null;
//        } else if (leftNode.rightNode != null && leftNode.leftNode == null) {
//         rightNode = leftNode.rightNode;
//        } else if (leftNode.rightNode == null && leftNode.leftNode != null) {
//         rightNode = leftNode.leftNode;
//        } else {
//         //leftNode.leftNode.insertNode(leftNode.rightNode);
//         leftNode = leftNode.leftNode;
//        }        
//     }
//    }
//    System.out.println("**" + data + "**");
//    }
// }

// class Tree definition
public class Tree<T extends Comparable<T>> {
   private TreeNode<T> root;

   // constructor initializes an empty Tree of integers
   public Tree() { 
      root = null; 
   }

   // insert a new node in the binary search tree
   public void insertNode(T insertValue) {
      if (root == null) {
         root = new TreeNode<>(insertValue); // create root node
      }
      else {
         root.insert(insertValue); // call the insert method
      }
   }
   
   // public void removeValue(T removeData) {
      
   //  root.remove(removeData); // call the remove method
      
   // }

   // begin preorder traversal
   public void preorderTraversal() { 
      preorderHelper(root); 
   }

   // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }

      System.out.printf("%s ", node.data); // output node data
      preorderHelper(node.leftNode); // traverse left subtree
      preorderHelper(node.rightNode); // traverse right subtree
   }

   // begin inorder traversal
   public void inorderTraversal() { 
      inorderHelper(root); 
   }

   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }

      inorderHelper(node.leftNode); // traverse left subtree
      System.out.printf("%s ", node.data); // output node data
      inorderHelper(node.rightNode); // traverse right subtree
   }

   // begin postorder traversal
   public void postorderTraversal() { 
      postorderHelper(root); 
   }

   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }
  
      postorderHelper(node.leftNode); // traverse left subtree
      postorderHelper(node.rightNode); // traverse right subtree
      System.out.printf("%s ", node.data); // output node data
   }

   // begin printing tree
   public void outputTree(int totalSpace) {
      outputTreeHelper(root, totalSpace>= 0 ? totalSpace : 0);
   }

   // recursive method to print tree
   private void outputTreeHelper(TreeNode<T> currentNode, int spaces) {
      // recursively print right branch, then left
      if (currentNode != null) {
         outputTreeHelper(currentNode.rightNode, spaces + 5);

         for (int k = 0; k <spaces; k++) {
            System.out.print(" ");
         }

         System.out.println(currentNode.data);
         outputTreeHelper(currentNode.leftNode, spaces + 5);
      }
   }

   //
   public void outputTree() { 
   outputTreeHelper(root); 
   }


   private void outputTreeHelper(TreeNode<T> node) {
   if (node == null) {
       System.out.print("null");
       return;
   }
     

     outputTreeHelper(node.rightNode); // traverse left subtree
     System.out.printf("%1$5s ", node.data); // output node data
     outputTreeHelper(node.leftNode); // traverse left subtree
    }
    
    //searches for value in sub tree and returns Boolean.
    public Boolean search(T insertValue) {
      return root.search(insertValue);
   }
}