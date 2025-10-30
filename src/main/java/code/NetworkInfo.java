package code;
//hazel
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import java.util.Arrays;
import java.util.List;

public class NetworkInfo {
    public void getNetworkInfo(HardwareAbstractionLayer hal){
        List<NetworkIF> networkList = hal.getNetworkIFs();
        int counter = 1;
        for (NetworkIF network:networkList){
            System.out.println("~~~~ NETWORK "+counter+" ~~~~");
            counter++;
            String name = network.getName(); //Network interface name
            String description = network.getDisplayName(); //Network interface description
            String addressV4 = Arrays.toString(network.getIPv4addr()); //IP v4 address,  unique identifier (decimal)
            String addressV6 = Arrays.toString(network.getIPv6addr()); //IP v6 address, unique identifier (hex)
            long byteSent = network.getBytesSent(); //Bytes sent over network
            long byteReceived = network.getBytesRecv(); //Bytes received over network
            long packetSent = network.getPacketsSent(); //Packets sent over network
            long packetReceived = network.getPacketsRecv(); //Packets received over network

            System.out.println("name: "+name);
            System.out.println("description: "+description);
            System.out.println("Internet Protocol V6 Address: "+addressV6);

            if (addressV4 != "[]"){ //Check if IP v4 address is null
                System.out.println("Internet Protocol V4 Address: "+addressV4);
            }

            System.out.println("Bytes Sent: "+byteSent);
            System.out.println("Bytes Received: "+byteReceived);
            System.out.println("Packets Sent: "+packetSent);
            System.out.println("Packets Received: "+packetReceived);
            System.out.println(" ");
        }
    }
}
