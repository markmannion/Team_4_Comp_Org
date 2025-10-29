package code;

import java.util.Scanner;

public class LiveGraph {

    int cpuUtil;
    int memoryUtil;
    int cpuTemp;
    int cpuFrequency;
    Scanner input;
    CpuInfo cpuInfo;
    MemoryInfo memoryInfo;
    Thread monitor;

    public LiveGraph(MemoryInfo memoryInfo, CpuInfo cpuInfo) {
        this.memoryInfo = memoryInfo;
        this.cpuInfo = cpuInfo;
        input = new Scanner(System.in);
    }

    public void graph() {

        monitor = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                cpuUtil = cpuInfo.cpuUtilPercent();
                memoryUtil = memoryInfo.memoryUtilPercent();
                cpuTemp = cpuInfo.CpuTemp();
                cpuFrequency = cpuInfo.getCpuFrequencyPercent();
                System.out.print("\u001B[2J");
                System.out.print("\u001B[H");
                System.out.flush();

                System.out.println("Cpu util:    " + graphLogic(cpuUtil) + " " + cpuUtil + "%");
                System.out.println("Memory util: " + graphLogic(memoryUtil) + " " + memoryUtil + "%");
                System.out.println("Cpu temp:    " + graphLogic(cpuTemp) + " " + cpuTemp + "c");
                System.out.println("Cpu frequency" + graphLogic(cpuFrequency)+ " " + cpuInfo.getCpuFrequency()/1000000 + "Mhz");
                System.out.println("Fan rpm:     "+  cpuInfo.getFanSpeed());
                System.out.println();
                System.out.println("\nPress Enter to quit...");

                try {
                    Thread.sleep(1000); // Update every second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        monitor.start();

        // Wait for user input to exit
        input.nextLine();

        // Stop monitoring thread
        monitor.interrupt();
        System.out.println("\nExiting loop...");

    }

    public String graphLogic(int x){
         x = Math.round(x / 5.0f);
        return "[" +
                "█".repeat(Math.max(0, x)) +
                " ".repeat(Math.max(0, 20 - x))+"]";


    }
}
