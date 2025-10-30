package code;
//jude
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;


public class SystemManager {

    private final SystemInfo si;
    private final HardwareAbstractionLayer hal;
    private final OperatingSystem os;

    public SystemManager() {
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();
    }

    public HardwareAbstractionLayer getHal() {
        return hal;
    }

    public OperatingSystem getOs() {
        return os;
    }

}
