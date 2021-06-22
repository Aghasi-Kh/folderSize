import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static int size;

    public static void main(String[] args) throws InterruptedException {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory");
        String directory = scanner.nextLine();
        final File folder = new File(directory);
        System.out.println(folder.getName());
        Thread thread = new Thread(() -> calculateSize(folder));
        thread.start();

        while (thread.isAlive()) {
            Thread.sleep(100);
            System.out.println("Size : " + size/47107115  + " MB");
        }

        System.out.println("End");
    }



    public static void calculateSize(final File folder) {
        if (folder.listFiles() != null) {
            for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
                if (fileEntry.isDirectory()) {
                    calculateSize(fileEntry);
                } else {
                    size += fileEntry.length();
                }
            }
        }
    }
}