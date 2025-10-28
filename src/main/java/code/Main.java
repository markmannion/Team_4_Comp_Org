package code;
import java.util.Scanner;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class
Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //declaring scanner
        SystemManager manager = new SystemManager(); //system info

        //declaring objects
        CpuInfo cpuInfo = new CpuInfo(manager.getHal());
        GraphicsCardInfo gpuInfo = new GraphicsCardInfo(manager.getHal());
        DisplayInfo displayInfo = new DisplayInfo(manager.getHal());
        BaseBoardInfo motherboardInfo = new BaseBoardInfo(manager.getHal());

    }
}
