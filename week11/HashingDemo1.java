package week11;
/*
 * HashingDemo1t.java - Class to demonstrate hash tables.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedHashing.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class HashingDemo1 {
	/*
	 * hashArray[0] -> Barnes hashArray[1] -> Andrews -> Mathison -> Jones
	 * hashArray[2] -> Yates -> Carlson
	 */
	public static String[] dataArray = new String[] { "Yates", "Andrews", "Barnes", "Mathison", "Jones", "Carlson" };
	public static int[] customerIDsArray = new int[] { 1111, 2222, 3333, 4444, 5555, 6666 };
	public static HashNode hashArray[] = new HashNode[250];

	public static void main(String[] args) {
		displayDataArray();
		displayHashExampleOutput();

		String file = "/Users/parkerbanks/eclipse-workspace/CSIS_2420/src/week11/HashingDemoDataFile.csv";
		String line;
		int ID;
		String lastName;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] lineA = line.split("[,]", 0);

				ID = Integer.parseInt(lineA[0]);
				lastName = lineA[1];
				appendNode(hashIt(lastName), ID, lastName);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		displayHashArray();
		long startTime = System.nanoTime();
		HashNode R1 = Search("Savage");
		long endTime = System.nanoTime();
		if (R1 != null) {
			System.out.println("Found: " + R1.customerID + " " + R1.lastName);
		} else {
			System.out.println("Couldn't find user.");
		}
		System.out.println("Search took " + (endTime - startTime) + " nanoseconds.");
	}

	private static void displayHashExampleOutput() {
		int asciiTotal = 0;
		for (int j = 0; j < dataArray.length; j++) {
			for (int k = 0; k < dataArray[j].length(); k++) {
				char c = dataArray[j].charAt(k);
				System.out.println(c + "  " + (int) c);
				asciiTotal = asciiTotal + (int) c;
			}
			System.out.print("asciiTotal: " + asciiTotal);
			System.out.println("\t[" + asciiTotal % hashArray.length + "]\n");
			asciiTotal = 0;
		}
	}

	private static void displayDataArray() {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.printf("dataArray[%d]: %s%n", i, dataArray[i]);
		}
		System.out.println();
		for (int i = 0; i < customerIDsArray.length; i++) {
			System.out.printf("customerIDsArray[%d]: %s%n", i, customerIDsArray[i]);
		}
		System.out.println();
	}

	public static int hashIt(String data) {
		int asciiTotal = 0;
		for (int n = 0; n < data.length(); n++) {
			char c = data.charAt(n);
			asciiTotal = asciiTotal + (int) c;
		}
		return asciiTotal % hashArray.length;
	}

	public static void appendNode(int arrayIndex, int customerID, String name) {
		if (hashArray[arrayIndex] == null) {
			hashArray[arrayIndex] = new HashNode(customerID, name);
		} else {
			HashNode current = hashArray[arrayIndex];
			while (current.next != null) {
				current = current.next;
			}
			current.next = new HashNode(customerID, name);
		}
	}

	public static void displayHashArray() {
		for (int i = 0; i < hashArray.length; i++) {
			System.out.printf("hashArray[%d]", i);
			if (hashArray[i] != null) {
				HashNode current = hashArray[i];
				System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
				while (current.next != null) {
					current = current.next;
					System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
				}
			}
			System.out.println();
			;
		}
	}

	public static HashNode Search(String s) {
		HashNode ref = null;
		if (hashArray.length == 0) {
			return ref;
		} else {
			int asciiTotal = hashIt(s);
			if (hashArray[asciiTotal] == null) {
				return ref;
			} else {
				HashNode current = hashArray[asciiTotal];
				while (current != null) {
					if (current.lastName.equals(s)) {
						return current;
					}
					current = current.next;
				}
			}
		}
		return ref;
	}
}
