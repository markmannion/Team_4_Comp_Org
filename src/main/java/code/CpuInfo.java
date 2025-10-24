package code;


import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class CpuInfo {

    CpuInfo(HardwareAbstractionLayer hal){
        CentralProcessor cpu = hal.getProcessor();
    }

}
