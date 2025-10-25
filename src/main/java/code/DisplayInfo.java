package code;

//EdidUtil under oshi.util api page


import oshi.hardware.Display;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.EdidUtil;
import java.util.List;

public class DisplayInfo {
    public static void main(String[] args){
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();

        List<Display> displays = hardware.getDisplays();
        if(displays.isempty()){
            System.out.println("There are no displays detected");
            return;
        }

        for (int d = o; d < displays.size(); d++){
            Display display = displays.get(d);
            byte[] edidData = display.getEdid();



            System.out.println("Monitor No: " + (i+1));
            System.out.println();



            if (edidData == null || edidData.length == 0){
                System.out.println("There's no EDID info");
                System.out.println();
                continue;
            }


            System.out.println("Manuafacturer ID: " + EdidUtil.getManufacturerID(edidData));
            System.out.println("Display ID: " + EdidUtil.getProductID(edidData));
            System.out.println("Serial Number: " + EdidUtil.getSerialNo(edidData));
            System.out.println("Model Name: " + EdidUtil.getModel(edidData));
            System.out.println("EDID Version: " + EdidUtil.getVersion(edidData));
            System.out.println("Manuafacture Week: " + Edidutil.getWeek(edidData));
            System.out.println("Manuafacture Year: " + EdidUtil.getYear(edidData));
            System.out.println("Is this a digital display? " + (EdidUtil.isDigital(edidData) ? "Yes": "No"));

        }
    }
}
