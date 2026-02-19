import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String DIRECTORY_PATH =
            "C:\\Users\\Sreenivas Bandaru\\Desktop\\JAVA\\INPUT OUTPUT\\DIRECTORY";

    private static final String FILE_NAME = "file.txt";

    public static void main(String[] args) {

        Main app = new Main();

        try {
            File directory = app.createDirectory();
            File file = app.createFile(directory);

            app.writeUsingFileWriter(file);
            app.appendUsingBufferedWriter(file);

            System.out.println("\nReading using FileReader:");
            app.readUsingScanner(file);

            System.out.println("\nReading using BufferedReader:");
            app.readUsingBufferedReader(file);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Create Directory
    public File createDirectory() {

        File dir = new File(DIRECTORY_PATH);

        if (dir.exists()) {
            System.out.println("Directory already exists.");
        } else if (dir.mkdir()) {
            System.out.println("Directory created successfully.");
        } else {
            System.out.println("Failed to create directory.");
        }

        return dir;
    }

    // Create File
    public File createFile(File directory) throws IOException {

        File file = new File(directory, FILE_NAME);

        if (file.exists()) {
            System.out.println("File already exists.");
        } else if (file.createNewFile()) {
            System.out.println("File created successfully.");
        }

        return file;
    }

    // Write using FileWriter
    public void writeUsingFileWriter(File file) throws IOException {

        try (FileWriter writer = new FileWriter(file)) {

            writer.write("Hello");
            writer.write(System.lineSeparator());
            writer.write("Hey");
            writer.write(System.lineSeparator());
            writer.write("Hi");

            System.out.println("Data written using FileWriter.");
        }
    }

    // Append using BufferedWriter
    public void appendUsingBufferedWriter(File file) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            writer.newLine();
            writer.write("Welcome");

            System.out.println("Data appended using BufferedWriter.");
        }
    }

    // Read using Scanner + FileReader
    public void readUsingScanner(File file) throws IOException {

        try (Scanner scanner = new Scanner(new FileReader(file))) {

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    // Read using BufferedReader
    public void readUsingBufferedReader(File file) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
