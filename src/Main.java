// Coded by Jacob Aaron Espinoza @ jacob.espinoza@malad.us
// For CTE Software Development 2
// Instructor: Mr. Gross
// This program reads a CSV file and calculates the average frequency and sum of the percentage of the letters in the file.

// Import classes
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args)
            throws IOException {
        boolean debug = true;
        if (debug) {
            System.out.println("Debugging is enabled.");
        }
        if (debug) {
            System.out.println("Reading the file letter_frequency.csv"); // In case the file does not exist
        }
        BufferedReader br = new BufferedReader(new FileReader("letter_frequency.csv"));
        // Intialize strings
        String tables = br.readLine();
        String regex = "[,]";
        String[] myArray;
        int sum = 0; // Set sum to 0
        float percentage = 0; // Set percentage to 0
        int i = 1; // Set i to 1
        if (debug) {
            System.out.println("Reading the file, but only up to 26 lines"); // In case there are more lines than expected
        }
        for (i = 1; i <= 26; i++) { // Loop through the file, up to 26 lines
            tables = br.readLine(); // Read the line
            tables = tables.replaceAll("\"", ""); // Remove the quotation marks
            myArray = tables.split(regex); // Split the line into an array
            if (debug) {
                System.out.println("Printing the line separated by spaces."); // To notify in case the file is not formatted correctly
            }
            System.out.println(myArray[0] + " " + myArray[1] + " " + myArray[2]); // Print the line, separated by spaces
            if (debug) {
                System.out.println("Calculating the sum of the frequency and percentage"); // In case the result is not what is expected
            }
            sum += Integer.parseInt(myArray[1].trim());
            ; // Sum of the frequency
            percentage += Float.parseFloat(myArray[2]); // Sum of the percentage
        }
        System.out.println("The average frequency is " + (float) sum / 26.0);
        System.out.println("The sum of the percentage is " + percentage);
        if (debug) {
            System.out.println("Expecting to read student.txt"); // In case the file does not exist
        }
        String fileName = "student.txt";

        Scanner scn = new Scanner(System.in);
        String firstName; // Declaring a string variable to store the first name
        String lastName; // Declaring a string variable to store the last name
        String yearSchool; // Declaring a string variable to store the year in school
        String nameSchool; // Declaring a string variable to store the name of the school
        int age;
// If user enters "y", allow them to add additional students
        String check = "y";
        try {
            BufferedWriter f_writer = new BufferedWriter(new FileWriter(fileName));
            while (check.equals("y")) {
                System.out.println("Enter your first name: ");
                firstName = scn.nextLine(); // Reading the first name from the user
                System.out.println("Enter your last name: ");
                lastName = scn.nextLine(); // Reading the last name from the user
                System.out.println("Enter the year in school: ");
                yearSchool = scn.nextLine(); // Reading the year in school from the user
                System.out.println("Enter the name of your school: ");
                nameSchool = scn.nextLine(); // Reading the year in school from the user
                System.out.println("Enter your age: ");
                if (debug) {
                    System.out.println("Expecting user to input an integer"); // In case the user does not enter a number
                }
                age = Integer.parseInt(scn.nextLine().trim()); // Reading the age from the user as an int

                if (debug) {
                    System.out.println("Writing to the file student.txt"); // In case it is not possible to write to the file
                }
                f_writer.write(firstName);
                f_writer.write("\n");
                f_writer.write(lastName);
                f_writer.write("\n");
                f_writer.write(yearSchool);
                f_writer.write("\n");
                f_writer.write(nameSchool);
                f_writer.write("\n");
                f_writer.write(age + "\n");
                System.out.println("Do you want to enter another student? (y/n)");
                check = scn.nextLine().trim();
            }
            scn.close();
            f_writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedReader br2; // Declaring BufferedReader
        try {
            br2 = new // Creating BufferedReader object
            if (debug) {
                System.out.println("Reading the file student.txt"); // In case the file does not exist
            }
            BufferedReader(new FileReader("student.txt")); // Name of file to open
            // Declaring strings to store data
            Boolean next = true;
            sum = 0; // Resetting sum to use it again
            int count = 0;
            while (next) { // As long as first name is not null, keep reading
                firstName = br2.readLine();
                if (firstName == null) {
                    next = false;
                    break;
                }
                lastName = br2.readLine();
                yearSchool = br2.readLine();
                nameSchool = br2.readLine();

                if (debug) {
                    System.out.println("Expecting to read an integer"); // In case it is invalid
                }
                age = Integer.parseInt(br2.readLine().trim()); // Reading age as an integer and trimming the whitespace
                sum += age; // Adding age to sum
                count++; // Add one to count for every student
                if (debug) {
                    System.out.println("Printing the student data"); // In case there is no data
                }
                System.out.println("First Name: " + firstName + " Last Name: " + lastName + " Year in School: " + yearSchool + " Name of School: " + nameSchool + " Age: " + age);
            }
            if (debug) {
                System.out.println("Calculating the average age"); // In case the result is not what is expected
            }
            System.out.println("The average age is " + (float) sum / count); // Divide sum by count to display the average
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}