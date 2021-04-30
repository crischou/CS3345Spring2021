import java.util.Scanner;
import java.lang.*;
//Cris Chou
//CYC180001

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashTableLinearProbe<Integer, String> hashTable = new HashTableLinearProbe<Integer, String>();

		Scanner input = new Scanner(System.in);

		System.out.println("1. To insert");
		System.out.println("2. To find");
		System.out.println("3. To delete");
		System.out.println("4. To exit");

		System.out.print("Enter choice: ");
		int choice = input.nextInt();
		//could add throws incase not int 
		while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
			//could add throws incase not int 
			System.out.println("Your choice is invalid");
			System.out.print("Enter choice: ");
			choice = input.nextInt();
		}

		while (choice != 4) {
			//could add throws incase not int 
			if (choice != 1 && choice != 2 && choice != 3) {
				System.out.println("Your choice is invalid");
				System.out.print("Enter choice: ");
				choice = input.nextInt();

			}
			if (choice == 1) {
				System.out.print("Enter Key: ");
				int key = input.nextInt();

				System.out.print("Enter Value: ");
				String value = input.next();
				
				if(hashTable.insert(key, value)) {
					
					System.out.println("\nSucessfully inserted\n");
					
				}else if(!hashTable.insert(key, value)) {
					
					System.out.println("\nDuplicated value not inserted\n");
					
				}
				
			} else if (choice == 2) {
				
				System.out.print("Enter Key: ");
				int key = input.nextInt();
				
				if(hashTable.find(key) == null) {
					
					System.out.println("\nValue not found\n");
					
				}else {
					
					System.out.println("\n"+hashTable.find(key)+"\n");
					
				}

			} else if (choice == 3) {
				
				System.out.print("Enter Key: ");
				int key = input.nextInt();
				
				if(hashTable.delete(key)) {
					
					System.out.println("\nSucessfully deleted\n");
					
				}else if(!hashTable.delete(key)) {
					
					System.out.println("\nValue not deleted or not deleted\n");
				}
				
			} else {
				System.out.println("Your choice is invalid");
				System.out.print("Enter choice: ");
				choice = input.nextInt();
				
			}
			

			System.out.println("1. To insert");
			System.out.println("2. To find");
			System.out.println("3. To delete");
			System.out.println("4. To exit");

			System.out.print("Enter choice: ");
			choice = input.nextInt();

		}
		System.out.println("Goodbye");

	}

}
