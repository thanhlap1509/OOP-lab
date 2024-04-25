package OtherProjects.hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "OtherProjects/hust/soict/globalict/garbage/test";
        byte[] inputBytes = {0};
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(filename));

        // using string builder
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b: inputBytes){
            outputStringBuilder.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("time using StringBuilder: " + (endTime - startTime));

        // using string buffer
        startTime = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer();
        for (byte b: inputBytes){
            outputStringBuffer.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("time using StringBuffer: " + (endTime - startTime));
    }
}
