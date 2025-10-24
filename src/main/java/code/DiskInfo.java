package code;


import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;

import java.util.List;

public class DiskInfo {

    DiskInfo(HardwareAbstractionLayer hal) {
        List<HWDiskStore> disk = hal.getDiskStores();
    }

}
