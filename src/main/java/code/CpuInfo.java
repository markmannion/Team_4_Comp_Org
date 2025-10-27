package code;


import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

import java.lang.Thread;

import java.util.List;


public class CpuInfo {
    CentralProcessor cpu;
    CentralProcessor.ProcessorIdentifier cpuIdentifier;
    List<CentralProcessor.ProcessorCache> processorCacheList;


    CpuInfo(HardwareAbstractionLayer hal) {
        cpu = hal.getProcessor();
        cpuIdentifier = cpu.getProcessorIdentifier();
        processorCacheList = cpu.getProcessorCaches();

    }


    public long getCpuFrequency(int core) {
        long[] coreList = cpu.getCurrentFreq();
        return coreList[core] / 1000000;
    }

    public void getCpuSummary() {
        System.out.println("Name: " + cpuIdentifier.getName());
        System.out.println("Family: " + cpuIdentifier.getFamily());
        System.out.println("Model: " + cpuIdentifier.getModel());
        System.out.println("Stepping: " + cpuIdentifier.getStepping());

    }

    public void getCaches() {
        for (int i = processorCacheList.size() - 1; i >= 0; i--) {
            CentralProcessor.ProcessorCache cache = processorCacheList.get(i);
            System.out.println("Cache: " + cache.getLevel());
            System.out.println("Type: " + cache.getType());
            System.out.println("Size: " + cache.getCacheSize());
            System.out.println("Line size: " + cache.getLineSize());
            System.out.println();

        }
    }

    public int cpuUtilPercent() {
        try {
            long[] prevTicks = cpu.getSystemCpuLoadTicks();
            Thread.sleep(1000); // wait a second
            double cpuLoad = cpu.getSystemCpuLoadBetweenTicks(prevTicks);
            return (int) Math.round(cpuLoad * 100); // multiply by 100 to get percent
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // best practice
            return -1; // or some fallback value
        }
    }

    public void getCpuUtilPercent(){

        System.out.printf("CPU Usage: "+ cpuUtilPercent());
    }
}
