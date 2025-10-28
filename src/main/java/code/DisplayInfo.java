package code;
//EdidUtil under oshi.util api page
import oshi.hardware.Display;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.EdidUtil;
import java.util.List;

public class DisplayInfo {
    private final HardwareAbstractionLayer hardware;

    public DisplayInfo(HardwareAbstractionLayer hardware) {
        this.hardware = hardware;
    }

    public void printOutDisplayInfo() {
        List<Display> displays = hardware.getDisplays();
        if (displays.isEmpty()) {
            System.out.println("There are no displays detected");
            return;
        }
        for (int d = 0; d < displays.size(); d++) {
            Display display = displays.get(d);
            byte[] edidData = display.getEdid();
            System.out.println("Monitor No: " + (d + 1));
            if (edidData == null || edidData.length == 0) {
                System.out.println("There's no EDID info");
                System.out.println();
                continue;
            }

            System.out.println("Screen Width: " + EdidUtil.getHcm(edidData));
            System.out.println("Screen Height: " + EdidUtil.getVcm(edidData));

            //Unless it's a monitor it won't print a valid resolution/refresh rate
            System.out.println("Preferred Resolution: " + EdidUtil.getTimingDescriptor(edidData));
            System.out.println("Manuafacturer ID: " + EdidUtil.getManufacturerID(edidData));
            System.out.println("Display ID: " + EdidUtil.getProductID(edidData));
            System.out.println("Serial Number: " + EdidUtil.getSerialNo(edidData));
            System.out.println("EDID Version: " + EdidUtil.getVersion(edidData));

            //not really needed as descriptorType 0xFC prints a valid display name
            System.out.println("Display Model: " + EdidUtil.getDescriptorText(edidData));
            System.out.println("Manuafacture Week: " + EdidUtil.getWeek(edidData)); //laptops don't have any week info
            System.out.println("Manuafacture Year: " + EdidUtil.getYear(edidData));
            System.out.println("Is this a digital display? " + (EdidUtil.isDigital(edidData) ? "Yes" : "No"));
            byte[][] descriptionBlocks = EdidUtil.getDescriptors(edidData); //has to be a 2d array as per api
            if (descriptionBlocks != null && descriptionBlocks.length > 0) {
                System.out.println();
                System.out.println("VESA Display Descriptors: ");
                for (int i = 0; i < descriptionBlocks.length; i++) {
                    byte[] descriptor = descriptionBlocks[i];
                    int type = EdidUtil.getDescriptorType(descriptor);
                    //descriptor codes for display info (18 byte blocks = descriptors)
                    //https://en.wikipedia.org/wiki/Extended_Display_Identification_Data
                    String descriptorType;
                    switch (type) {
                        case 0xFC:
                            descriptorType = "Display Name";
                            break;
                        case 0xFF:
                            descriptorType = "Serial Number";
                            break;
                        case 0xFD:
                            descriptorType = "Range Limits"; //refresh rate but is known as range limits in VESA EDID
                            break;
                        default:
                            descriptorType = "Other Info";
                            break;
                    }
                    String descriptorText = EdidUtil.getDescriptorText(descriptor);
                    System.out.println(descriptorType + " : " + descriptorText);
                }
                System.out.println();
            }
        }
    }
}
