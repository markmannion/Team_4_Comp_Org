package code;

import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class MemoryInfo {

    MemoryInfo(HardwareAbstractionLayer hal){
        GlobalMemory memory = hal.getMemory();

    }

}
