package code;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class
Main {
    public static void main(String[] args) {
        SystemManager manager = new SystemManager();
        CpuInfo cpuInfo = new CpuInfo(manager.getHal());

        GraphicsCardInfo gpuInfo = new GraphicsCardInfo(manager.getHal());
        gpuInfo.printOutGpuInfo();

        DisplayInfo displayInfo = new DisplayInfo(manager.getHal());
        displayInfo.printOutDisplayInfo();

        BaseBoardInfo motherboardInfo = new BaseBoardInfo(manager.getHal());
        motherboardInfo.printOutBaseBoardInfo();
    }
}
