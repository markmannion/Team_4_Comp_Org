package code;

import java.io.IOException;
import java.util.Scanner;


public class
Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //declaring scanner
        SystemManager manager = new SystemManager(); //system info

        //declaring objects
        CpuInfo cpuInfo = new CpuInfo(manager.getHal());

        GraphicsCardInfo gpuInfo = new GraphicsCardInfo(manager.getHal());
        MemoryInfo memoryInfo = new MemoryInfo(manager.getHal());
        DisplayInfo displayInfo = new DisplayInfo(manager.getHal());
        BaseBoardInfo motherboardInfo = new BaseBoardInfo(manager.getHal());
        UsbInfo usbInfo = new UsbInfo(manager.getHal());
        PciInfo pciInfo = new PciInfo();


        while (true) {
            System.out.println("Welcome to SysInfo : Team 4");
            System.out.println("Choose which information to display: ");
            System.out.println("1. CPU Information");
            System.out.println("2. GPU Information");
            System.out.println("3. Memory Information");
            System.out.println("4. Motherboard Information");
            System.out.println("5. Display Information");
            System.out.println("6. USB Information");
            System.out.println("7. PCIE Information");
            System.out.println("8. Battery Information");
            System.out.println("9. Network Information");
            System.out.println("10. Exit SysInfo");
            System.out.print("---> ");

            int choice = sc.nextInt();
            int menu = 0;
            while (true) {
                switch (choice) {
                    case 1: {
                        System.out.println("Which cpu information would you like to display? ");
                        System.out.println("1. General Information");
                        System.out.println("2. Cache Information");
                        int choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1:
                                cpuInfo.getCpuSummary();
                                System.out.println("-------------------------");

                                break;
                            case 2:
                                cpuInfo.getCaches();
                                System.out.println("-------------------------");

                                break;
                        }

                        break;
                    }
                    case 2: {
                        gpuInfo.printOutGpuInfo();
                        System.out.println("-------------------------");
                        break;
                    }
                    case 3: {
                        System.out.println("Which Ram information would you like to display? ");
                        System.out.println("1. Physical Ram ");
                        System.out.println("2. Virtual Ram");
                        int choice2 = sc.nextInt();
                        System.out.println();
                        switch (choice2) {
                            case 1:
                                memoryInfo.getMemoryInfo();
                                System.out.println("-------------------------");

                                break;
                            case 2:
                                memoryInfo.getVirtualMemoryInfo();
                                System.out.println("-------------------------");

                                break;

                        }
                        break;
                    }

                    case 4: {
                        System.out.println("Which motherboard information would you like to display? ");
                        System.out.println("1. General Information");
                        System.out.println("2. Firmware Information");
                        int choice2 = sc.nextInt();
                        System.out.println();
                        switch (choice2) {
                            case 1:
                                motherboardInfo.printOutBaseBoardInfo();
                                System.out.println("-------------------------");
                                break;
                            case 2:
                                motherboardInfo.printOutFirmwareInfo();
                                System.out.println("-------------------------");
                                break;
                            default:
                                System.out.println("Please enter a valid number");
                                System.out.println("-------------------------");
                                break;
                        }

                        break;
                    }
                    case 5:
                        displayInfo.printOutDisplayInfo();
                        System.out.println("-------------------------");
                        break;
                    case 6:
                        usbInfo.printOutInfo();
                        System.out.println("-------------------------");
                        break;
                    case 7:
                        pciInfo.printOutInfo();
                        System.out.println("-------------------------");
                        break;
                    case 8:
                        new BatteryInfo().getBatteryInfo(manager.getHal());
                        System.out.println("-------------------------");
                        break;
                    case 9:
                        new NetworkInfo().getNetworkInfo(manager.getHal());
                        System.out.println("-------------------------");
                        break;
                    case 10:
                        System.out.println("Exiting SysInfo");
                        System.out.println("-------------------------");
                        sc.close();
                        return;
                    default:
                        System.out.println("Please choose a valid option");
                }

                System.out.println("Press 1 to return to menu");
                menu= sc.nextInt();
                if(menu ==1) break;
            }
        }
    }
}