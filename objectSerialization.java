import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;

import org.omg.CORBA.portable.InputStream;

import java.io.ObjectOutputStream;

public class objectSerialization {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("hongzenan");
        user.setPassword("password");

        ObjectOutputStream object = null;
        try {
            FileOutputStream out = new FileOutputStream("D:\\study\\java\\FileIO-NIO\\user.txt");
            object = new ObjectOutputStream(out);
            object.writeObject(user);
            object.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(user);

        try {
            FileInputStream in = new FileInputStream("D:\\study\\java\\FileIO-NIO\\user.txt");
            ObjectInputStream objectIn = new ObjectInputStream(in);
            user = (User) objectIn.readObject();
            objectIn.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(user);
    }
}