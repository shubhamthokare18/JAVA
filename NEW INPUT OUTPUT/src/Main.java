import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Path DIRECTORY_PATH =
            Paths.get("C:\\Users\\Sreenivas Bandaru\\Desktop\\JAVA\\NEW INPUT OUTPUT\\DIRECTORY");

    private static final String FILE_NAME = "file.txt";

    public static void main(String[] args) {

        Main app = new Main();

        try {
            Path directory = app.createDirectory();
            Path file = app.createFile(directory);

            app.writeUsingFiles(file);
            app.appendUsingBufferedWriter(file);

            System.out.println("\nReading using Files.readAllLines():");
            app.readUsingFiles(file);

            System.out.println("\nReading using BufferedReader:");
            app.readUsingBufferedReader(file);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // ===== Create Directory =====
    public Path createDirectory() throws IOException {

        if (Files.exists(DIRECTORY_PATH)) {
            System.out.println("Directory already exists.");
        } else {
            Files.createDirectories(DIRECTORY_PATH);
            System.out.println("Directory created successfully.");
        }

        return DIRECTORY_PATH;
    }


    // ===== Create File =====
    public Path createFile(Path directory) throws IOException {

        Path filePath = directory.resolve(FILE_NAME);

        if (Files.exists(filePath)) {
            System.out.println("File already exists.");
        } else {
            Files.createFile(filePath);
            System.out.println("File created successfully.");
        }

        return filePath;
    }


    // ===== Write Using Files.write (NIO) =====
    public void writeUsingFiles(Path file) throws IOException {

        List<String> lines = Arrays.asList("Hello", "Hey");

        Files.write(
                file,
                lines,
                StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING
        );

        System.out.println("Data written using Files.write()");
    }


    // ===== Append Using BufferedWriter =====
    public void appendUsingBufferedWriter(Path file) throws IOException {

        try (BufferedWriter writer =
                     Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

            writer.newLine();
            writer.write("Hi");
        }

        System.out.println("Data appended using BufferedWriter.");
    }


    // ===== Read Using Files =====
    public void readUsingFiles(Path file) throws IOException {

        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);

        for (String line : lines) {
            System.out.println(line);
        }
    }


    // ===== Read Using BufferedReader =====
    public void readUsingBufferedReader(Path file) throws IOException {

        try (BufferedReader reader =
                     Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
