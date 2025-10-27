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
    private List<UsbDevice> devices;

    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        UsbInfo usb = new UsbInfo(hal);
        usb.getInfo();


    }

    UsbInfo(HardwareAbstractionLayer hal) {
        devices = hal.getUsbDevices(true);
    }

    
    public void getInfo(){
        getInfo(this.devices,0);
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
