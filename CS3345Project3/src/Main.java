//Cris Chou
//CYC180001

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		// get name of input and output files
		System.out.print("Enter input filename: ");
		String inputName = input.next();

		System.out.print("Enter output filename: ");
		String outputName = input.next();

		LazyBinarySearchTree tree = new LazyBinarySearchTree();
		int key;

		Scanner infile = new Scanner(new File(inputName));
		PrintWriter outfile = new PrintWriter(new File(outputName));

		// read through whole file
		while (infile.hasNext()) {
			String command = infile.next();

			// check for insert
			if (command.contains("Insert:")) {
				// key is after " : "
				key = Integer.parseInt(command.substring(command.indexOf(":") + 1));
				//System.out.println(key);
				
				try {
					if (tree.insert(key)) {
						
						outfile.println("True");

					} else {

						outfile.println("False");

					}
					// catch errors
				}catch (Exception e){
					
					outfile.println("Error in delete: IllegalArgumentException raised");
					
				}
				// check for delete
			} else if (command.contains("Delete:")) {

				// key is after " : "
				key = Integer.parseInt(command.substring(command.indexOf(":") + 1));
				//System.out.println(key);
				try {
					if (tree.delete(key)) {

						outfile.println("True");

					} else {

						outfile.println("False");

					}
					// catch errors
				} catch (Exception e) {

					outfile.println("Error in delete: IllegalArgumentException raised");

				}

				// find min
			} else if (command.contains("FindMin")) {

				// -1 means no min
				if (tree.findMin() == -1) {

					outfile.println("-1");

				} else {

					outfile.println(tree.findMin());

				}

				// find max
			} else if (command.contains("FindMax")) {

				// -1 means no max
				if (tree.findMax() == -1) {

					outfile.println("-1");

				} else {

					outfile.println(tree.findMax());

				}

				//contains
			} else if (command.contains("Contains")) {

				key = Integer.parseInt(command.substring(command.indexOf(":") + 1));
				//System.out.println(key);
				try {
					
					if(tree.contains(key)) {
						
						outfile.println("True");
						
					}else {
						
						outfile.println("False");
						
					}
					
				}catch (Exception e) {
					
					outfile.println("Error in Line: Contains");
					
				}
				
				//print tree
			} else if (command.contains("PrintTree")) {
				
				outfile.println(tree.toString());
				
				//get height
			} else if (command.contains("Height")) {
				
				outfile.println(tree.height());
				
				//get size
			} else if (command.contains("Size")) {
				
				outfile.println(tree.size());
				
				//if not valid command
			} else {

				outfile.println("Error in Line: " + command);

			}

		}
		
		infile.close();
		outfile.close();

	}

}
