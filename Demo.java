import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (File root: roots) {
            System.out.println(root);
        }

        File file = new File("D:\\study\\java\\FileIO-NIO\\test.txt");

        try {
            boolean exist = file.createNewFile();
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("hello hongzenan");
            out.close();
            System.out.println("File is created successful");
        } catch(IOException e) {
            e.printStackTrace();
        }

        FileReader finstream = null;
        try {
            finstream = new FileReader(file);
            BufferedReader in = new BufferedReader(finstream);
            String line = "";
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (file != null) {
                try {
                    finstream.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}