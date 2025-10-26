package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
        System.out.println(devices.toString());
        
        for (UsbDevice usb: this.devices){
            List<UsbDevice> subDevices = usb.getConnectedDevices();
            // System.out.println(usb);
            for (UsbDevice subdev: subDevices){
                // System.out.println("\t"+usb.());
            }
        }

        

    }
    
}
