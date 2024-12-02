/*Name:- Sarvesh Kulkarni
  Roll no. 84
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

class BT {
    Node root;

    public void insert(int data) {
        Node newNode = new Node(data); // Create a new node with the given data

        if (root == null) {
            root = newNode;
        } else {
            whereToInsert(root, newNode);
        }
    }

    private void whereToInsert(Node current, Node newNode) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Current element: " + current.data + ". Choose where to insert: 1 for left, 2 for right");

            int choice = s.nextInt();
            if (choice == 1) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    current = current.left;
                }
            } else if (choice == 2) {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    current = current.right;
                }
            } else {
                System.out.println("Invalid choice. Please type 1 or 2.");
            }
        }
    }

    public void display() {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose operation:\n1 for Pre-order\n2 for In-order\n3 for Post-order\n4 to Count Nodes\n5 to Display Leaves");
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

            case 4:
                System.out.println("Total number of nodes in the tree: " + countNodes(root));
                break;

            case 5:
                System.out.println("Leaf nodes of the tree:");
                displayLeaves(root);
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

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1 + leftCount + rightCount;
        }
    }

    private void displayLeaves(Node node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            }
            displayLeaves(node.left);
            displayLeaves(node.right);
        }
    }
}

public class BinaryT {
    public static void main(String[] args) {
        int again;
        BT b = new BT();
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Choose operation:\n1. Insert\n2. Display");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element:");
                    int data = s.nextInt();
                    b.insert(data);
                    break;

                case 2:
                    b.display();
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("Do you want to continue (1 for yes, 0 for no)?");
            again = s.nextInt();
        } while (again != 0);
    }
}