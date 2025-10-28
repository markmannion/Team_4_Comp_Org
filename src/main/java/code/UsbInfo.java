package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.UsbDevice;

public class UsbInfo {
    private final HardwareAbstractionLayer hardware;

    UsbInfo(HardwareAbstractionLayer hardware) {
        this.hardware = hardware;
    }
    
    public void printOutInfo(){
        List<UsbDevice> devices = this.hardware.getUsbDevices(true);
        ArrayList<String> prefixes = new ArrayList<String>();
        prefixes.add("bus ");
        prefixes.add("device ");
        printOutInfo(devices,0,prefixes);
    }

    /**
            Recursively went through usb devices
         */
    public void printOutInfo(List<UsbDevice>devices, int currDepth,ArrayList<String> prefixes){
        int i =1;
        for (UsbDevice usb: devices){
            String prefix;
            try {
                prefix = prefixes.get(currDepth);
            } catch (IndexOutOfBoundsException e) {
                prefix = prefixes.getLast();
            }

            System.out.println("\t".repeat(currDepth)+ prefix +i + " " +usb.getName()+ " vendor - "+ usb.getVendor() + "(" +usb.getVendorId()+")");
            i++;
            if (!usb.getConnectedDevices().isEmpty()){
                printOutInfo(usb.getConnectedDevices(),currDepth+1,prefixes);
            }

        }


        

    }
    
}
