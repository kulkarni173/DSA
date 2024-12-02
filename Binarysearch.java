/*Name:- Sarvesh Kulkarni
  Roll no.:- 84
*/
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class SK {
    Node root;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            insert(root, newNode);
        }
    }

    private void insert(Node currentNode, Node newNode) {
        if (newNode.data < currentNode.data) {
            if (currentNode.left == null) {
                currentNode.left = newNode;
            } else {
                insert(currentNode.left, newNode);
            }
        } else if (newNode.data >= currentNode.data) {
            if (currentNode.right == null) {
                currentNode.right = newNode;
            } else {
                insert(currentNode.right, newNode);
            }
        }
    }

    public void display() {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose operation:\n1 for Pre-order\n2 for In-order\n3 for Post-order");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Pre-order traversal of the tree:");
                preorderTraversal(root);
                break;

            case 2:
                System.out.println("In-order traversal of the tree:");
                inorderTraversal(root);
                break;

            case 3:
                System.out.println("Post-order traversal of the tree:");
                postorderTraversal(root);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
        System.out.println();
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
    int Min(Node root) {
        int min = root.data;

        while (root.left != null)
        {min = root.left.data;
            root  = root.left;}
        return min;
    }

    int Max(Node root)

    {
        int max = root.data;
        while(root.right != null)
        {
            max = root.right.data;
            root   = root.right;
        }
        return max;
    }

    public boolean searchElement(int data) {
        return searchElement(root, data);
    }

    private boolean searchElement(Node node, int data) {
        if (node == null) {
            return false;
        } else if (node.data == data) {
            return true;
        } else if (data < node.data) {
            return searchElement(node.left, data);
        } else {
            return searchElement(node.right, data);
        }
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = Min(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
}

public class Binarysearch {
    public static void main(String[] args) {
        int again = 1; // Initialize again to 1 to enter the loop
        SK S = new SK();
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Choose operation:\n1. Insert\n2. Display\n3. Search element\n4.Minimum \n5.Maximum\n6. Delete\nEnter here: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element:");
                    int data = s.nextInt();
                    S.insert(data);
                    break;

                case 2:
                    S.display();
                    break;

                case 3:
                    System.out.println("Enter element to search:");
                    int searchData = s.nextInt();
                    if (S.searchElement(searchData)) {
                        System.out.println("Element found in the tree.");
                    } else {
                        System.out.println("Element not found in the tree.");
                    }
                    break;

                case 4:
                    if (S.root != null) {
                        int min = S.Min(S.root);
                        System.out.println("Minimum element in the tree: " + min);
                    } else {
                        System.out.println("Tree is empty.");
                    }
                    break;

                case 5:
                    if (S.root != null) {
                        int max = S.Max(S.root);
                        System.out.println("Maximum element in the tree: " + max);
                    } else {
                        System.out.println("Tree is empty.");
                    }
                    break;
                case 6:
                    System.out.println("Enter the Node which you want to delete: ");
                    data=s.nextInt();
                    S.delete(data);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("Enter 1 to continue, 0 to exit: ");
            again = s.nextInt();
        } while (again != 0);
    }
}