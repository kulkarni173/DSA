/* Name:- Sarvesh Kulkarni
   Roll.no:- 84
*/

import java.util.*;

class LP {
    private int currentsize, maxsize;
    private String[] key;
    private String[] val;

    public LP(int size) {
        this.maxsize = size;
        this.currentsize = 0;
        this.key = new String[maxsize];
        this.val = new String[maxsize];
    }
    private int Hash(String k){
        return Integer.parseInt(k)%maxsize;
    }

    public void insert(String k, String v) {
        if (currentsize >= maxsize) {
            System.out.println("Hash Table is full, cannot insert new key.");
            return;
        }

        int temp = Hash(k);
        int i = temp;
        do {
            if (key[i] == null) {
                key[i] = k;
                val[i] = v;
                currentsize++;
                return;
            }
            i = (i + 1) % maxsize;
        } while (i != temp);
    }

    public void display() {
        for (int i = 0; i < maxsize; i++) {
            if (key[i] != null) {
                System.out.println(i + " " + key[i] + " " + val[i]);
            }
        }
    }

    public void remove(String k) {
        int index = Hash(k);
        int i = index;
        do {
            if (key[i] == null) {
                return;
            }
            if (key[i].equals(k)) {
                key[i] = null;
                val[i] = null;
                currentsize--;
                return;
            }
            i = (i + 1) % maxsize;
        } while (i != index);
    }

    public void get(String k) {
        int index = Hash(k);
        int i = index;
        while (key[i] != null) {
            if (key[i].equals(k)) {
                System.out.println("Found key: " + k + " -> " + val[i]);
                return;
            }
            i = (i + 1) % maxsize;
            if (i == index) {
                break;
            }
        }
        System.out.println("Key not found: " + k);
    }

    public boolean isempty() {
        return currentsize == 0;
    }

    public int getsize() {
        return currentsize;
    }

    public void clearTable() {
        for (int i = 0; i < maxsize; i++) {
            key[i] = null;
            val[i] = null;
        }
        currentsize = 0;
        System.out.println("Hash table cleared.");
    }
}


public class Hashtable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the table size:");
        int size = s.nextInt();
        LP hashtable = new LP(size);

        int choice;
        do {
            System.out.println("\nOperation:");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Delete");
            System.out.println("4. Is Empty");
            System.out.println("5. Get Size");
            System.out.println("6. Get");
            System.out.println("7. clear table");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key and value: ");
                    String key = s.next();
                    String value = s.next();
                    hashtable.insert(key, value);
                    break;
                case 2:
                    hashtable.display();
                    break;
                case 3:
                    System.out.print("Enter key to delete: ");
                    String keyToDelete = s.next();
                    hashtable.remove(keyToDelete);
                    break;
                case 4:
                    System.out.println("Is Empty: " + hashtable.isempty());
                    break;
                case 5:
                    System.out.println("Current Size: " + hashtable.getsize());
                    break;
                case 6:
                    System.out.print("Enter key to get value: ");
                    String keyToGet = s.next();
                    hashtable.get(keyToGet);
                    break;
                case 7:
                    hashtable.clearTable();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 8);
    }
}