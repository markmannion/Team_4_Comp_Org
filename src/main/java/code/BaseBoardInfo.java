package code;
import oshi.hardware.Baseboard;
import oshi.hardware.HardwareAbstractionLayer;

public class BaseBoardInfo {
    private final HardwareAbstractionLayer hardware;
    public BaseBoardInfo(HardwareAbstractionLayer hardware) {
        this.hardware = hardware;
    }

    public void printOutBaseBoardInfo(){
        Baseboard motherboard = hardware.getComputerSystem().getBaseboard();

        System.out.println("Motherboard Information");

        System.out.println("Motherboard manuafacturer: " + motherboard.getManufacturer());
        System.out.println("Motherboard model: " + motherboard.getModel());
        System.out.println("Motherboard Version: " + motherboard.getVersion());
        System.out.println("Motherboard Serial number: " + motherboard.getSerialNumber());
        System.out.println();
    }

}
