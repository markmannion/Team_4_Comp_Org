package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PciInfo {

    public static void getInfo() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("lspci");
        Process process = pb.start();

        BufferedReader buffer= new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(line);
        }
    }


    public static void main(String[] args) throws IOException {
        getInfo();

    }
}
