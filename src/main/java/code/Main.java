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

        while(true){
            System.out.println("Welcome to SysInfo : Team 4");
            System.out.println("Choose which information to display: ");
            System.out.println("1. CPU Information");
            System.out.println("2. GPU Information");
            System.out.println("3. OS Information");
            System.out.println("4. Motherboard Information");
            System.out.println("5. Display Information");
            System.out.println("6. USB Information");
            System.out.println("7. PCIE Information");
            System.out.println("8. Battery Information");
            System.out.println("9. Network Information");
            System.out.println("10. Exit SysInfo");
            System.out.print("---> ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //cpuInfo method
                    //System.out.println("-------------------------");
                    //break;
                case 2:
                    gpuInfo.printOutGpuInfo();
                    System.out.println("-------------------------");
                    break;
                case 3:
                    //OSInfo method
                    //System.out.println("-------------------------");
                    //break;
                case 4:
                    motherboardInfo.printOutBaseBoardInfo();
                    System.out.println("-------------------------");
                    break;
                case 5:
                    displayInfo.printOutDisplayInfo();
                    System.out.println("-------------------------");
                    break;
                case 6:
                    //USBInfo method
                    //System.out.println("-------------------------");
                    //break;
                case 7:
                    //PCIEInfo method
                    //System.out.println("-------------------------");
                    //break;
                case 8:
                    //BatteryInfo Method
                    //System.out.println("-------------------------");
                    //break;
                case 9:
                    //NetworkInfo method
                    //System.out.println("-------------------------");
                    //break;
                case 10:
                    System.out.println("Exiting Sysinfo");
                    System.out.println("-------------------------");
                    sc.close();
                    return;
                default:
                    System.out.println("Please choose a valid option");
            }
        }
    }
}
