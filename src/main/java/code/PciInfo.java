package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class PciInfo {

    // public void read(){
    //     java.io.File pcieDirFile = new java.io.File("/sys/bus/pci/devices");
    //     File[] pciFiles = pcieDirFile.listFiles();
    //     for (File pciFile : pciFiles) {
    //         System.out.println(pciFile);
    //         File[] infos = pciFile.listFiles();
    //         for (File info : infos) {
    //             System.out.println(info);
    //         }


    //     }

    // }

    public void printOutInfo() throws IOException {

        ArrayList<String> commands = new ArrayList<String>();
        commands.add("lspci");
        commands.add("-v");
        commands.add("-t");
        commands.add("-nn");
        commands.add("-m");

        ProcessBuilder pb = new ProcessBuilder(commands);
        Process process = pb.start();

        BufferedReader buffer= new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(line);
        }
    }

}
