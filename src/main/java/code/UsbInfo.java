package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.UsbDevice;

public class UsbInfo {
    private final HardwareAbstractionLayer hardware;


    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        UsbInfo usb = new UsbInfo(hal);
        usb.getInfo();
    }

    UsbInfo(HardwareAbstractionLayer hardware) {
        this.hardware = hardware;
    }

    
    public void getInfo(){
        List<UsbDevice> devices = this.hardware.getUsbDevices(true);
        getInfo(devices,0);
    }

    public void getInfo(List<UsbDevice>devices, int currDepth){
        for (UsbDevice usb: devices){
            System.out.println("\t".repeat(currDepth)+usb.getName()+ " vendor - "+ usb.getVendor() + "(" +usb.getVendorId()+")");
            if (!usb.getConnectedDevices().isEmpty()){
                getInfo(usb.getConnectedDevices(),currDepth+1);
            }

        }


        

        

    }
    
}
