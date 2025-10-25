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

        List<Display> displays = hardwareAbstractionLayer.getDisplays();
        if(displays.isEmpty()){
            System.out.println("There are no displays detected");
            return;
        }

        for (int d = 0; d < displays.size(); d++){
            Display display = displays.get(d);
            byte[] edidData = display.getEdid();



            System.out.println("Monitor No: " + (d+1));
            System.out.println();



            if (edidData == null || edidData.length == 0){
                System.out.println("There's no EDID info");
                System.out.println();
                continue;
            }

            System.out.println("Screen Width: " + EdidUtil.getHcm(edidData));
            System.out.println("Screen Height: " + EdidUtil.getVcm(edidData));
            //System.out.println("Preferred Resolution: " + EdidUtil.getPreferredResolution(edidData));


            System.out.println("Manuafacturer ID: " + EdidUtil.getManufacturerID(edidData));
            System.out.println("Display ID: " + EdidUtil.getProductID(edidData));
            System.out.println("Serial Number: " + EdidUtil.getSerialNo(edidData));
            System.out.println("EDID Version: " + EdidUtil.getVersion(edidData));
            //System.out.println("Display Model: " + EdidUtil.getModel(edidData));

            System.out.println("Manuafacture Week: " + EdidUtil.getWeek(edidData));
            System.out.println("Manuafacture Year: " + EdidUtil.getYear(edidData));
            System.out.println("Is this a digital display? " + (EdidUtil.isDigital(edidData) ? "Yes": "No"));

            byte[][] descriptionBlocks = EdidUtil.getDescriptors(edidData);
            if(descriptionBlocks!= null && descriptionBlocks.length > 0){
                System.out.println();
                System.out.println("VESA Display Descriptors: ");
                for(int i = 0; i<descriptionBlocks.length; i++){
                    byte[] descriptor = descriptionBlocks[i];
                    int type = EdidUtil.getDescriptorType(descriptor);


                    //need to figure out proper vesa edid descriptor types for switch case to work properly
                    String descriptorType;
                    switch(type){
                        case monitorName:
                            descriptorType = "Monitor Name";
                            break;
                        case serialNo:
                            descriptorType = "Serial Number";
                            break;
                        case rangeLimits:
                            descriptorType = "Range Limits";
                            break;
                        default:
                            descriptorType = "Other Info";
                            break;
                    }
                }
            }

        }
    }
}
