import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedIo {
    public static void main(String[] args) {
        BufferedIo io = new BufferedIo();

        try {
            long startTime = System.currentTimeMillis();
            io.readWrite("D:\\study\\java\\FileIO-NIO\\sample-data.txt", "D:\\study\\java\\FileIO-NIO\\readWrite.txt");
            long endTime = System.currentTimeMillis();
            System.out.println("use time: " + (endTime - startTime) + "milli seconds");

            long startTime1 = System.currentTimeMillis();
            io.readWriteBuffer("D:\\study\\java\\FileIO-NIO\\sample-data.txt", "D:\\study\\java\\FileIO-NIO\\readWriteBuffer.txt");
            long endTime1 = System.currentTimeMillis();
            System.out.println("buffer use time: " + (endTime1 - startTime1) + "milli seconds");

            long startTime2 = System.currentTimeMillis();
            io.readWriteArray("D:\\study\\java\\FileIO-NIO\\sample-data.txt", "D:\\study\\java\\FileIO-NIO\\readWriteArray.txt");
            long endTime2 = System.currentTimeMillis();
            System.out.println("array use time: " + (endTime2 - startTime2) + "milli seconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readWrite(String fileFrom, String fileTo) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(fileFrom);
            out = new FileOutputStream(fileTo);
            while (true) {
                int bytedata = in.read();
                if (bytedata == -1)
                    break;
                out.write(bytedata);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void readWriteBuffer(String fileFrom, String fileTo) throws IOException {
        InputStream bufferedIn = null;
        OutputStream bufferedOut = null;
        try {
            InputStream in = new FileInputStream(fileFrom);
            bufferedIn = new BufferedInputStream(in);

            OutputStream out = new FileOutputStream(fileTo);
            bufferedOut = new BufferedOutputStream(out);

            while (true) {
                int bytedata = bufferedIn.read();
                if (bytedata == -1)
                    break;
                bufferedOut.write(bytedata);
            }
        } finally {
            if (bufferedIn != null) {
                bufferedIn.close();
            }
            if (bufferedOut != null) {
                bufferedOut.close();
            }
        }
    }

    public static void readWriteArray(String fileFrom, String fileTo) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(fileFrom);
            out = new FileOutputStream(fileTo);

            int available = in.available();
            byte[] totalBytes = new byte[available];
            int bytedata = in.read(totalBytes);
            out.write(totalBytes);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}