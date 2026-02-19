import java.io.*;

// Serializable Class
class Student implements Serializable {

    private static final long serialVersionUID = 1L; // Best practice

    private int studentId;
    private String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student {" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

public class Main {

    private static final String FILE_PATH =
            "C:\\Users\\Sreenivas Bandaru\\Desktop\\JAVA\\SERIALIZATION DESERIALIZATION\\STUDENT.ser";

    public static void main(String[] args) {

        Student student = new Student(1, "SHUBHAM");

        serializeStudent(student);
        deserializeStudent();
    }

    // Serialization
    private static void serializeStudent(Student student) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

            oos.writeObject(student);
            System.out.println("✅ Object serialized successfully.");

        } catch (IOException e) {
            System.err.println("❌ Serialization failed: " + e.getMessage());
        }
    }

    // Deserialization
    private static void deserializeStudent() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_PATH))) {

            Student student = (Student) ois.readObject();
            System.out.println("✅ Object deserialized successfully.");
            System.out.println(student);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Deserialization failed: " + e.getMessage());
        }
    }
}
