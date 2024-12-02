/* Name:- Sarvesh Kulkarni
  Roll No.:-84
*/
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Node {
    Node left, right;
    int Freq;
    char Data;
}

class MyComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.Freq - y.Freq;
    }
}

public class Huffman {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int n = scanner.nextInt();

        char[] charArray = new char[n];
        int[] charFreq = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            charArray[i] = scanner.next().charAt(0);

            System.out.print("Enter frequency of " + charArray[i] + ": ");
            charFreq[i] = scanner.nextInt();
        }

        PriorityQueue<Node> q = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            Node hn = new Node();
            hn.Data = charArray[i];
            hn.Freq = charFreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        Node root = null;

        while (q.size() > 1) {
            Node x = q.poll();
            Node y = q.poll();

            Node f = new Node();
            f.Freq = x.Freq + y.Freq;
            f.Data = '-';

            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        System.out.println("\nHuffman Codes:");
        printCode(root, "");
    }

    public static void printCode(Node root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.Data)) {
            System.out.println(root.Data + ":" + s);
            return;
        }
        if (root.left != null) {
            printCode(root.left, s + "0");
        }
        if (root.right != null) {
            printCode(root.right, s + "1");
        }
    }
}