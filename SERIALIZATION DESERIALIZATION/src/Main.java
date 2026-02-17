import java.io.*;

class Student implements Serializable {

    int studentId;
    String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "STUDENT: {" +
                "\"STUDENT ID\": " + studentId + "," +
                "\"STUDENT NAME\": \"" + studentName + "\"" +
                "}";
    }
}

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Student student = new Student(1, "SHUBHAM");

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Sreenivas Bandaru\\Desktop\\JAVA\\SERIALIZATION DESERIALIZATION\\STUDENT.SER"));
            objectOutputStream.writeObject(student);
            System.out.println("JAVA OBJECT TO BYTE STREAM");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Sreenivas Bandaru\\Desktop\\JAVA\\SERIALIZATION DESERIALIZATION\\STUDENT.SER"))) {
            Student student1 = (Student) objectInputStream.readObject();
            System.out.println("BYTE STREAM TO JAVA OBJECT");
            System.out.println(student1);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}