/*
Name;- Sarvesh Kulkarni
Roll no.:- 84
 */

import java.util.Scanner;
import java.util.LinkedList;

class HashTableChain {
    private LinkedList<Integer>[] table;
    private int size;
    @SuppressWarnings("unchecked")
    public HashTableChain(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int hashfunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashfunction(key);
        table[index].add(key);
    }


    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index: " + i + " -> " + table[i]);
        }
    }
    public boolean search(int key) {
        int index = hashfunction(key);
        return table[index].contains(key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the hash table: ");
        int size = sc.nextInt();
        HashTableChain hashtable = new HashTableChain(size);

        while (true) {
            System.out.println("Which operation do you want to perform?\n1. Insert\n2. Display\n3. Search key\n4. Exit: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("How many keys do you want to insert: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter the key to insert: ");
                        int key = sc.nextInt();
                        hashtable.insert(key);
                    }
                    break;
                case 2:
                    System.out.println("Displaying the table: ");
                    hashtable.display();
                    break;
                case 3:
                    System.out.println("Which key do you want to search: ");
                    int k = sc.nextInt();
                    if (hashtable.search(k)) {
                        System.out.println("Key found.");
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}