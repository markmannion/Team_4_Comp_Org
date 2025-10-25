package code;

import org.apache.commons.lang3.StringUtils;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;

import java.util.List;

public class BatteryInfo {
    public void getBatteryInfo(HardwareAbstractionLayer hal){
       List<PowerSource> sourceList = hal.getPowerSources();
       for(PowerSource source:sourceList){
           if (StringUtils.contains(source.getName(), "Battery")) {
               String name = source.getName(); //name of power source at OS level
               double voltage = source.getVoltage(); //voltage of battery in volts
               int maxCapacity = source.getMaxCapacity(); //current maximum capacity of battery in
               int originalCapacity = source.getDesignCapacity();
               double temperature = source.getTemperature(); //current temperature of battery

               System.out.println("Battery Name: " + name);
               System.out.println("Voltage: " + voltage + " volts");
               System.out.println("Max Capacity: " + maxCapacity + " mAh");
               System.out.println("Default Capacity: " + originalCapacity + " mAh");
               System.out.println("Capacity lost through usage: "+calculateCapacityLost(maxCapacity, originalCapacity)+"%");
               System.out.println("Current Battery Temperature: " + temperature + "°C");
           }
       }
    }

    private float calculateCapacityLost(int maxCapacity, int originalCapacity){
        int loss = maxCapacity -  originalCapacity;
        if(loss < 0){
            loss = loss * -1;
        }
        float lossRatio = (float) loss /originalCapacity;
        return lossRatio * 100;

    }
}
