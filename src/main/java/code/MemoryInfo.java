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
        memory = hal.getMemory();
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
            System.out.println(getTotalMemoryGB());
        }


    }

    public void getVirtualMemoryInfo() {
        System.out.println("Max Virtual Memory: " + virtualMemory.getVirtualMax());
        System.out.println("Virtual Memory Inuse: " + virtualMemory.getVirtualInUse());
    }

    public int memoryUtilPercent() {
        long total = memory.getTotal();
        long used = total - memory.getAvailable();

        if (total == 0) {
            return 0; // avoid division by zero
        }

        double percent = (double) used / total * 100;
        return (int) Math.round(percent);
    }



}
