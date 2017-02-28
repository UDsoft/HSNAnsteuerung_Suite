package Networks;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HSNNetwork{


    public HSNNetwork() {
    }

    /**
     * Get the IP address of the Device running the mosquitto Broker. It architecture that the Broker is
     * found in the same device where the manipulator is running
     * @param NetworkType Choose which network interface is used wireless or lan.
     * @return IP Address of the Mosquitto broker.
     */
    public String getIPAddress(NetworkType NetworkType) {
        String usedInterface;
        switch(NetworkType){
            case LAN:
                usedInterface ="eth0";
                break;
            case WIRELESS:
                usedInterface ="wlan0";
                break;
            default:
                usedInterface ="wlan0";

        }
        String IPAddress = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nic = networkInterfaces.nextElement();
                Enumeration<InetAddress> addresses = nic.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (nic.getName().contains(usedInterface)) {
                        IPAddress = addr.getHostAddress();
                    }

                }
            }
        } catch (SocketException e) {
            Logger.getLogger(HSNNetwork.class.getName()).log(Level.SEVERE, null, e);
        }
        return IPAddress;
    }


}
