package code;

//Mark

import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import java.util.List;


public class DiskInfo {
    private final HardwareAbstractionLayer hardware;
    public DiskInfo(HardwareAbstractionLayer hardware) {
        this.hardware = hardware;
    }

    public void printOutDiskInfo(){
        System.out.println("Disk Information");
        List<HWDiskStore> disks = hardware.getDiskStores();
        if(disks == null || disks.isEmpty()){
            System.out.println("There are no disks found");
            return;
        }

        for(HWDiskStore d: disks){
            System.out.println("Disk name: " + d.getName());
            System.out.println("Disk model: " + d.getModel());
            System.out.println("Disk serial no: " + d.getSerial());
            System.out.println("Disk size: " + d.getSize());
            System.out.println("Disk reads: " + d.getReads());
            System.out.println("Disc transfer time: " + d.getTransferTime());
            System.out.println("Disk writes: " + d.getReads());
            System.out.println();

            List<HWPartition> partitions = d.getPartitions();
            if(partitions == null || partitions.isEmpty()){
                System.out.println("There are no partitions");
            }
            else{
                System.out.println("Partitions: ");
                for(HWPartition p: partitions){
                    System.out.println("Partition ID: " + p.getIdentification());
                    System.out.println("Partition size" + p.getSize());
                    System.out.println("Partition Name: " + p.getName());
                    System.out.println("Partition type: " + p.getType());
                }
            }
        }
    }
}
