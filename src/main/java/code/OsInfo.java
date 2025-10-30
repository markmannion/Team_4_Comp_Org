package code;


import oshi.software.os.OperatingSystem;

import java.util.List;

public class OsInfo {

    OperatingSystem os;
    OperatingSystem.OSVersionInfo versionInfo;

    OsInfo(OperatingSystem os){
        this.os = os;
        versionInfo = os.getVersionInfo();
    }

    public void getOsInfo(){
        System.out.println("Operating System: " + os);
        System.out.println("Manufacturer: " + os.getManufacturer());
        System.out.println("Family: " + os.getFamily());


        System.out.println("Version: " + versionInfo.getVersion());
        System.out.println("Code Name: " + versionInfo.getCodeName());
        System.out.println("Build Number: " + versionInfo.getBuildNumber());

        System.out.println("Bitness: " + os.getBitness() + "-bit");
        System.out.println("Boot Time: " + os.getSystemBootTime());
        System.out.println("Process Count: " + os.getProcessCount());
    }

}
