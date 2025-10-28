package code;
import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;
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

    public void printOutFirmwareInfo(){
        Firmware firmware = hardware.getComputerSystem().getFirmware();

        System.out.println("Firmware Information");
        System.out.println("Firmware Manufacturer: " + firmware.getManufacturer());
        System.out.println("Firmware Version: " + firmware.getVersion());
        System.out.println("Firware Description: " + firmware.getDescription());
        System.out.println("Firmware Name: " + firmware.getName());
        System.out.println("Firmware Release Date: " + firmware.getReleaseDate());
        System.out.println();
    }

}
