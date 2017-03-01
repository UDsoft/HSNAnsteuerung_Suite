import MqttBroker.MqttBroker;
import MqttClient.*;
import Networks.HSNNetwork;
import Networks.NetworkType;

import java.net.SocketException;
import java.net.UnknownHostException;

import static MqttBroker.MqttBroker.brokerList.MOSQUITTO;

/**
 * Created by darwin on 25.02.17.
 */
public class Main {
    public static void main(String[] args) throws UnknownHostException, SocketException {

        HSNNetwork network = new HSNNetwork();


        //Start The Broker
        MqttBroker broker = MqttBroker.getInstance();
        broker.setBroker(MOSQUITTO);
        broker.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (broker.getStatus()) {
            System.out.println("Mqtt Broker online ");
        }


        String ipAddress = network.getIPAddress(NetworkType.LAN);
        int qos = 2;
        int port = 1883;
        String clientID = "UDLogic";

        MqttClient mqttClient = new MqttClient(qos,ipAddress,port,clientID);

        mqttClient.connect();

        //First Topic to be INIT
        if(mqttClient.isConnected()){
            System.out.println("Welcome to UDTECH");
            mqttClient.subscribe(Topic.CLIENT_HANDSHAKE);
            mqttClient.subscribe(Topic.INIT_PINS);

        }

        while (mqttClient.isConnected()){

        }




        broker.stop();
        if (!broker.getStatus()) {
            System.out.println("MQTT Broker Offline");
        }


    }


}
