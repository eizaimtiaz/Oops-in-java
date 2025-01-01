
//q1
import java.io.FileWriter;
import java.io.IOException;

public class File2 {
	public static void main(String[] args) {
		
		try {
			FileWriter writer = new FileWriter("Poem.txt");
			writer.write("Roses are Red \nVoilets are Blue \nHanzy is Cool \nAnd so are You!");
			writer.append("\nPoem by Hanzy");
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
//q2
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filepath = "student.txt";

        try {
            FileWriter writer = new FileWriter(filepath); 

            for (int counter = 1; counter <= 5; counter++) {
                System.out.print("Enter the name of student " + counter + ": ");
                String name = input.nextLine();
                writer.write(name + "\n"); 
            }

            writer.close(); 
            System.out.println("Student names saved to " + filepath);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close(); 
        }
    }
}
//q3
import java.io.IOException;
import java.io.FileNotFoundException;

public class Task3 {
	public static void main(String[] args) {
		
		String filepath = "students.txt";

		try {
			
			FileReader reader = new FileReader(filepath);
			int data = reader.read();

			while (data != -1) {
				System.out.print((char)data);
				data = reader.read();
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
//q4
public class Task4 {
    public static void main(String[] args) {
        
        // using the readfromuserinput method when making the object
        Student student = Student.readFromUserInput();
        // giving address or path
        student.saveToFile("students.txt");

        System.out.println("Student details from file:");
        // reading the file
        Student.readFromFile("students.txt");

    }
}
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Student {
    
    // private varialbes
    private String name;
    private int age;
    private String grade;

    // constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // method to save the file
    public void saveToFile(String filepath) {
        try {
            FileWriter writer = new FileWriter(filepath, true);
            writer.write(name + "," + age + "," + grade + "\n");
            writer.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method that takes input from user and returns in a new object
    public static Student readFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        
        // makes a new object and returns the taken values from the user to the constructor
        return new Student(name, age, grade);
    }

    // method that reads data from the file and prints it
    
    public static void readFromFile(String filepath) {
        try {       
            FileReader reader = new FileReader(filepath);
            int character = reader.read();
            while(character != -1) {
                System.out.print((char)character);
                character = reader.read();
            }
            reader.close();
            }
         
        catch (IOException e) {
            System.out.println("No data found or file does not exist.");
        }
    }
}



