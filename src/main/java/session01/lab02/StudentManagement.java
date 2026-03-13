package session01.lab02;

import session01.lab02.Student;

import java.util.Scanner;

public class StudentManagement {
    private static Student[] students = new Student[100];
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);

    //==================== MAIN ====================
    public static void main(String[] args) {
        byte choice;
        do{
            showMenu();
            choice = Byte.parseByte(scanner.nextLine());

            switch (choice){
                case 1 -> createStudent();
                case 2 -> displayAll();
                case 3 -> findStudentById();
                case 4 -> updateStudentById();
                case 5 -> System.out.print("See you later!");
                default -> System.out.print("Invalid choice!");
            }
        }while (choice != 5);
    }

    //==================== MENU ====================
    private static void showMenu(){
        System.out.println("\n===== STUDENT MANAGEMENT =====");
        System.out.println("|  1. Create a student         |");
        System.out.println("|  2. Display all              |");
        System.out.println("|  3. Find a student by id     |");
        System.out.println("|  4. Update a student by id   |");
        System.out.println("|  5. Quit                     |");
        System.out.println("================================");
        System.out.print("Choose: ");
    }

    //============== CREATE STUDENT ===============
    private static void createStudent(){
        // Enter id
        String id;
        do{
            System.out.print("Enter id:");
            id = scanner.nextLine();
        }while (!validateId(id));

        // Enter name
        String name;
        do{
            System.out.print("Enter name:");
            name = scanner.nextLine();
        }while (name.isEmpty());

        // Enter age
        int age;
        do{
            System.out.print("Enter age (18+):");
            age = Integer.parseInt(scanner.nextLine());
        }while (age < 18);

        //Enter address
        String address;
        do{
            System.out.print("Enter address:");
            address = scanner.nextLine();
        }while (address.isEmpty());

        //Enter gender
        String gender;
        do{
            System.out.print("Enter gender (male/female):");
            gender = scanner.nextLine();
        }while (!gender.equals("male") && !gender.equals("female"));

        //Enter email
        String email;
        do{
            System.out.print("Enter email:");
            email = scanner.nextLine();
        }while (!validateEmail(email));

        //Increase the number of students by 1
        students[count++] = new Student(id, name, age, address, gender, email);
        System.out.println("Student created successfully!");
    }

    //================ DISPLAY ALL ================
    private static void displayAll(){
        if(count == 0){
            System.out.print("No students found.");
            return;
        }
        for (int i = 0; i < count; i++){
            System.out.println(students[i]);
        }
    }

    //================ FIND BY ID =================
    private static void findStudentById(){
        System.out.print("Enter ID to find: ");

        String id = scanner.nextLine();
        Student student = findById(id);

        if(student == null){
            System.out.print("Student not found.");
        } else {
            System.out.print(student);
        }
    }

    // ================= UPDATE =================
    private static void updateStudentById() {
        System.out.print("Enter ID to update: ");
        String id = scanner.nextLine();

        Student student = findById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        student.setName(scanner.nextLine());

        int age;
        do {
            System.out.print("Enter new age: ");
            age = Integer.parseInt(scanner.nextLine());
        } while (age < 18);
        student.setAge(age);

        System.out.print("Enter new address: ");
        student.setAddress(scanner.nextLine());

        String gender;
        do {
            System.out.print("Enter new gender (male/female): ");
            gender = scanner.nextLine().toLowerCase();
        } while (!gender.equals("male") && !gender.equals("female"));
        student.setGender(gender);

        System.out.print("Enter new email: ");
        student.setEmail(scanner.nextLine());

        System.out.println("Student updated successfully!");
    }

    // ================= UTILS =================
    private static boolean validateId(String id) {
        if (id.isEmpty()) {
            System.out.println("ID is required.");
            return false;
        }
        if (findById(id) != null) {
            System.out.println("ID is duplicate.");
            return false;
        }
        return true;
    }

    private static Student findById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    private static boolean validateEmail(String email){
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Email is required.");
            return false;
        }

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(regex)) {
            System.out.println("Invalid email format.");
            return false;
        }

        return true;
    }
}
