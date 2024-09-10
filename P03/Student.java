public class Student {

    // Constructor to initialize the student's name
    public Student(String name) {
        this.studentName = name;
        this.examSum = 0;  // Initialize sum of exam grades to 0
        this.examNumGrades = 0;  // Initialize number of exams to 0
    }

    // Getter method for the student's name
    public String getName() {
        return studentName;
    }

    // Method to add an exam grade to the student's record
    public void addExam(double grade) {
        examSum += grade;  // Add the grade to the total sum
        ++examNumGrades;  // Increment the number of exams
    }

    // Method to calculate the student's average grade
    public double average() {
        if (examNumGrades == 0) {
            return 100;  // Default value if no exams have been graded
        }
        return examSum / examNumGrades;  // Calculate the average
    }

    // Private member variables
    private String studentName;  // Student's name
    private double examSum;  // Sum of all exam grades
    private int examNumGrades;  // Count of exams graded
}



public class Student {

    private String email;  // New email field

    // Constructor with email validation
    public Student(String name, String email) {
        if (!email.endsWith("@uta.edu") && !email.endsWith("@mavs.uta.edu")) {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }
        this.studentName = name;
        this.email = email;  // Set the email
        this.examSum = 0;
        this.examNumGrades = 0;
    }

    // Getter method for email
    public String getEmail() {
        return email;
    }

}
