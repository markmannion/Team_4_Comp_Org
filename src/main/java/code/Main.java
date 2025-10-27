package code;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class
Main {
    public static void main(String[] args) {
        SystemManager manager = new SystemManager();
        CpuInfo cpuInfo = new CpuInfo(manager.getHal());
        new BatteryInfo().getBatteryInfo(manager.getHal());
        new NetworkInfo().getNetworkInfo(manager.getHal());
    }
}
