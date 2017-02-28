package MqttClient;


import Data.HSNStandardData;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MqttClient implements MqttCallback {

    //Record all the issue and actions in this logger.
    private final static Logger LOGGER = Logger.getLogger(MqttClient.class.getName());


    //Variable needed for this
    MqttAsyncClient mqttAsyncClient;
    MemoryPersistence persistence = new MemoryPersistence();

    private int qos;
    private String ipAddress;
    private int port;
    private String clientID;

    public MqttClient(int qos, String ipAddress, int port, String clientID) {
        setQos(qos);
        setIpAddress(ipAddress);
        setPort(port);
        setClientID(clientID);
    }

    public int getQos() {
        return qos;
    }

    /*
    qos = Quality of Service::
    (0)->At most once
    (1)->At least once
    (2)->Exactly once.
     */
    public void setQos(int qos) {
        if ((qos <= 2) && (qos > -1)) {
            this.qos = qos;
        } else {
            LOGGER.log(Level.WARNING, "QOS level was not 0 , 1 or 2");
            System.out.println("QOS Level in MQTT only valid if : ");
            System.out.println("0  = At most once ");
            System.out.println("1 = At least once ");
            System.out.println("2 = Exactly once ");
        }
    }

    public String getIpAddress() {
        return ipAddress;
    }

    /*
    ipAddress normal formatted ipaddress e.g:"192.168.1.101"
    the format is then changed to "tcp://ipaddress:".
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = "tcp://" + ipAddress + ":";
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getClientID() {
        return clientID;
    }

    /*
    clientID is important to
     */
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    //True if mqttClient is connected to the Broker
    public boolean isConnected() {
        return mqttAsyncClient.isConnected();
    }

    /*
    Return true if disconnected
    Return false if still connected
     */
    public boolean disconnected() {
        try {
            mqttAsyncClient.disconnect();
            LOGGER.log(Level.INFO, "Raspberry Pi Master Controller Disconnected with the Broker");
            return true;
        } catch (MqttException e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, e.getMessage().toString());
            LOGGER.log(Level.WARNING, e.getCause().toString());
            LOGGER.log(Level.WARNING, e.getLocalizedMessage().toString());

        }

        return false;
    }

    private String getBroker() {
        String ipAddress = getIpAddress();
        int port = getPort();
        return ipAddress + port;
    }

    public void connect() {
        String broker = getBroker();
        try {
            mqttAsyncClient = new MqttAsyncClient(broker, clientID, persistence);
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            mqttAsyncClient.setCallback(this);
            System.out.println("Connection to broker: " + broker);
            mqttAsyncClient.connect(connectOptions);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mqttAsyncClient.isConnected()) {
                System.out.println("Connected to broker: " + broker);
            } else {
                LOGGER.log(Level.SEVERE, "Error to connect to Broker " + MqttClient.class.getName() + "--- method connect ");
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic) {
        if (mqttAsyncClient.isConnected()) {
            privateSub(topic);
        } else {
            connect();
            System.out.println("Reconnecting to Broker");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isConnected()) {
                privateSub(topic);
            }else{
                LOGGER.log(Level.WARNING,"ERROR Connecting Broker while subscribing");
            }
        }
    }

    private boolean privateSub(String topic) {
        try {
            mqttAsyncClient.subscribe(topic, qos);
            System.out.println("Successfully subscribe to topic : " + topic);
            return true;
        } catch (MqttException e) {
            System.out.println("Failed to subscribe to topic : " + topic);
            e.printStackTrace();
            return false;
        }
    }

    public void publish(String topic, String message, int qos) {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(qos);
        if (mqttAsyncClient.isConnected()) {
            try {

                mqttAsyncClient.publish(topic, mqttMessage);
                LOGGER.log(Level.INFO, message + "is published to Broker");
            } catch (MqttException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, e.toString(), e);
            }
        }

    }


    public void connectionLost(Throwable throwable) {
        try {
            System.out.println("Connection Lost");
            mqttAsyncClient.connect();
        } catch (MqttException ex) {
            Logger.getLogger(MqttClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

        Gson gson = new Gson();
        HSNStandardData data = gson.fromJson(mqttMessage.toString(),HSNStandardData.class);
        System.out.println(data.getClientID());

    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
