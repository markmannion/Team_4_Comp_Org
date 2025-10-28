package code;

import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.hardware.VirtualMemory;

import java.util.List;

public class MemoryInfo {

    GlobalMemory memory;
    List<PhysicalMemory> physicalMemoryList;
    VirtualMemory virtualMemory;


    MemoryInfo(HardwareAbstractionLayer hal) {
        GlobalMemory memory = hal.getMemory();
        physicalMemoryList = memory.getPhysicalMemory();
        virtualMemory = memory.getVirtualMemory();

    }


    public void getTotalMemoryBytes() {
        System.out.print(memory.getTotal());

    }

    public long getTotalMemoryGB() {
        return (memory.getTotal() / 1000000000);
    }

    public void getMemoryInfo() {
        try {
            System.out.println("Manufacturer: " + physicalMemoryList.get(0).getManufacturer());
            System.out.println("Capacity: " + getTotalMemoryGB());
            System.out.println("Clock Speed: " + physicalMemoryList.get(0).getClockSpeed() / 1000000);
            System.out.println("Part Number: " + physicalMemoryList.get(0).getPartNumber());
            System.out.println("Page size" + memory.getPageSize());
        } catch (Exception e) {
            System.out.println("Youre better than everyone ");
        }


    }

    public void getVirtualMemoryInfo() {
        System.out.println("Max Virtual Memory: " + virtualMemory.getVirtualMax());
        System.out.println("Virtual Memory Inuse: " + virtualMemory.getVirtualInUse());

    }


}
