import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.createDirectory();
    }

    public void createDirectory() throws IOException {
        Path path = Paths.get("C:\\Users\\Sreenivas Bandaru\\Desktop\\JAVA\\NEW INPUT OUTPUT\\DIRECTORY");
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        } else {
            System.out.println("DIRECTORY EXISTS");
        }
        createFile(path);
    }

    public void createFile(Path path) throws IOException {
        Path resolve = path.resolve("FILE.TXT");
        if (!Files.exists(resolve)) {
            Files.createFile(resolve);
        } else {
            System.out.println("FILE EXISTS");
        }
        writeFile(resolve);
        writeBufferedFile(resolve);
    }

    public void writeFile(Path resolve) throws IOException {
        List<String> list = Arrays.asList("HELLO");
        Files.write(resolve, list, StandardCharsets.UTF_8);
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(resolve, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bufferedWriter.write("HEY");
        } catch (IOException ioException) {
            throw new RuntimeException();
        }
        readFile(resolve);
    }

    public void readFile(Path resolve) throws IOException {
        List<String> list = Files.readAllLines(resolve, StandardCharsets.UTF_8);
        for (String string : list) {
            System.out.println(string);
        }
    }

    public void writeBufferedFile(Path resolve) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resolve.toFile(), true))) {
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write("HIE");
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        readBufferedFile(resolve);
    }

    public void readBufferedFile(Path resolve) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resolve.toFile()))){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}