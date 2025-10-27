package code;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
import java.util.List;


public class GraphicsCardInfo {
    private final HardwareAbstractionLayer hardware;
    public GraphicsCardInfo(HardwareAbstractionLayer hardware){
        this.hardware = hardware;
    }

    public void printOutGpuInfo(){
        System.out.println();
        System.out.println("GPU Info");
        System.out.println("--------");

        List<GraphicsCard> gpus = hardware.getGraphicsCards();

        if (gpus.isEmpty()){
            System.out.println("There are no GPUS detected");
        }else{
            int count = 1;
            for(GraphicsCard gpu : gpus){
                System.out.println("GPU No: " + count);
                System.out.println("GPU Name: " + gpu.getName());
                System.out.println("GPU Vendor: " + gpu.getVendor());
                System.out.printf("VRAM Total: %f GB \n", ((float)gpu.getVRam()/1024f/1024f/1024f)); //fix issue with VRAM displaying in bytes instead of GB
                System.out.println("Device ID: " + gpu.getDeviceId());
                System.out.println("GPU Version Info: " + gpu.getVersionInfo());
                System.out.println();
                count++;
            }
        }
    }
}
