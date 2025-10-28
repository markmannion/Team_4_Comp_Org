package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class PciInfo {

    public void printOutInfo() throws IOException {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("lspci");
        commands.add("-v");
        commands.add("-t");
        commands.add("-nn");

        ProcessBuilder pb = new ProcessBuilder(commands);
        Process process = pb.start();

        BufferedReader buffer= new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(line);
        }
    }

}
