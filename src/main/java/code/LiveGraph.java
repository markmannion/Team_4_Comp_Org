package code;

import java.util.Scanner;

public class LiveGraph extends Thread {

    int cpuUtil;
    int cpuTemp;
    int cpuVoltage;
    int memoryUtil;
    Scanner input;
    CpuInfo cpuInfo;
    MemoryInfo memoryInfo;


    public LiveGraph(MemoryInfo memoryInfo,CpuInfo cpuInfo){
        this.memoryInfo = memoryInfo;
        this.cpuInfo = cpuInfo;
        input = new Scanner(System.in);
    }
    @Override
    public  void run() {


        while (true) {

            cpuUtil = cpuInfo.cpuUtilPercent();
            memoryUtil = memoryInfo.memoryUtilPercent();
            System.out.println("Cpu util% : "+ graphLogic(cpuUtil));
            System.out.println("Memory Util% " + graphLogic(memoryUtil));
//            String x = input.nextLine();
//            if (x.isEmpty()) {
//                System.out.println("Exiting loop");
//                break;
//            }


        }
    }
    public String graphLogic(int x){
         x = Math.round(x / 5.0f);
        return "[" +
                "█".repeat(Math.max(0, x)) +
                " ".repeat(Math.max(0, 20 - x))+"]";


    }
}
