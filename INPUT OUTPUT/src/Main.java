import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.createDirectory();
    }

    public void createDirectory() throws IOException {
        File file = new File("C:\\Users\\Sreenivas Bandaru\\Desktop\\JAVA\\INPUT OUTPUT\\DIRECTORY");
        if (!file.exists()) {
            file.mkdir();
        } else {
            System.out.println("DIRECTORY EXISTS");
        }
        createFile(file.getAbsolutePath());
    }

    public void createFile(String path) throws IOException {
        File file = new File(path + "/FILE.TXT");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("FILE EXISTS");
        }
        writeFile(file);
        writeBufferedFile(file);
    }

    public void writeFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("HELLO");
            fileWriter.write("HEY");
            fileWriter.write(System.lineSeparator());
            fileWriter.write("HIE");
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        readFile(file);
    }

    public void readFile(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public void writeBufferedFile(File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write("HI");
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        readBufferedFile(file);
    }

    public void readBufferedFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}