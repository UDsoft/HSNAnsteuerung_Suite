package MqttBroker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darwin on 27.02.17.
 */
public class MqttBroker {

    private final static Logger LOGGER = Logger.getLogger(MqttBroker.class.getName());

    private static MqttBroker ourInstance = new MqttBroker();
    private brokerList mqttBroker;

    private MqttBroker() {
    }

    public static MqttBroker getInstance() {
        return ourInstance;
    }

    private String brokerCmd(brokerList broker, brokerAction action) {
        String cmd = "";

        switch (action) {
            case START:
                cmd = startAction(broker);
                break;
            case CHECK_STATUS:
            case STOP:
                cmd = stopBroker(broker);
                break;
            case FORCE_RELOAD:
            case RELOAD:
            case RESTART:
            case STATUS:
                cmd = statusCheckCommand(broker);
                break;
            case TRY_RESTART:
        }
        return cmd;
    }

    private String startAction(brokerList broker) {
        String startCmd = "";
        switch (broker) {
            case EMQ:
            case HIVEMQ:
            case IBM_BLUEMIX:
            case MOSCA:
            case MOSQUITTO:
                startCmd = "service mosquitto start";
                break;
            case VERNMQ:
        }

        return startCmd;
    }

    private String stopBroker(brokerList broker) {
        String stopCmd = "";
        switch (broker) {
            case MOSQUITTO:
                stopCmd = "service mosquitto stop";
                break;
            case IBM_BLUEMIX:
            case HIVEMQ:
            case EMQ:
            case MOSCA:
            case VERNMQ:
        }
        return stopCmd;
    }

    /**
     * This function keeps command which access the broker status based on the broker.
     *
     * @param broker
     * @return
     */
    private String statusCheckCommand(brokerList broker) {
        String status = "";
        switch (broker) {
            case MOSQUITTO:
                status = "service mosquitto status";
                break;
            case VERNMQ:
            case MOSCA:
            case EMQ:
            case HIVEMQ:
            case IBM_BLUEMIX:
        }
        return status;
    }

    public void setBroker(brokerList broker) {
        this.mqttBroker = broker;
    }

    public void start() {
        runConsoleCmd(brokerAction.START);
    }

    public void stop() {
        runConsoleCmd(brokerAction.STOP);

    }

    private StringBuffer runConsoleCmd(brokerAction action) {
        StringBuffer output = new StringBuffer();
        Process process;
        try {
            //This command start the Broker
            process = Runtime.getRuntime().exec(brokerCmd(mqttBroker, action));
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output;
    }

    //This function is called outside this class to check the status of the broker if it is ON or OFF.
    public boolean getStatus() {
        boolean status = false;

        switch (mqttBroker) {
            case VERNMQ:
            case MOSCA:
            case EMQ:
            case HIVEMQ:
            case IBM_BLUEMIX:
            case MOSQUITTO:
                status = mosquittoStatus();
                break;
        }

        /**
         * Change this once the method learn how to check status
         */
        return status;

    }

    /**
     * This method is specifically for Mosquitto Broker.
     *
     * @return At the time of this code was build this is the output of the command "sudo service mosquiito status"
     * ---------------------ACTIVE----------(THIS LINE DOESNT BELONG TO CONSOLE ONLY FOR READBILITY)-------
     * ->● mosquitto.service - LSB: mosquitto MQTT v3.1 message broker
     * Loaded: loaded (/etc/init.d/mosquitto)
     * Active: active (running) since Mon 2017-02-27 22:27:48 UTC; 3s ago
     * Process: 3722 ExecStop=/etc/init.d/mosquitto stop (code=exited, status=0/SUCCESS)
     * Process: 3825 ExecStart=/etc/init.d/mosquitto start (code=exited, status=0/SUCCESS)
     * CGroup: /system.slice/mosquitto.service
     * └─3831 /usr/sbin/mosquitto -c /etc/mosquitto/mosquitto.conf
     * <p>
     * Feb 27 22:27:48 raspberrypi mosquitto[3825]: Starting network daemon:: mosqu....
     * Feb 27 22:27:48 raspberrypi systemd[1]: Started LSB: mosquitto MQTT v3.1 mes....
     * Hint: Some lines were ellipsized, use -l to show in full.
     * <p>
     * ---------------------INACTIVE----------(THIS LINE DOESNT BELONG TO CONSOLE ONLY FOR READBILITY)-------
     * ->● mosquitto.service - LSB: mosquitto MQTT v3.1 message broker
     * Loaded: loaded (/etc/init.d/mosquitto)
     * Active: inactive (dead) since Mon 2017-02-27 22:50:51 UTC; 5s ago
     * Process: 4594 ExecStop=/etc/init.d/mosquitto stop (code=exited, status=0/SUCCESS)
     * Process: 3825 ExecStart=/etc/init.d/mosquitto start (code=exited, status=0/SUCCESS)
     * <p>
     * Feb 27 22:33:10 raspberrypi systemd[1]: Started LSB: mosquitto MQTT v3.1 mes....
     * Feb 27 22:33:27 raspberrypi systemd[1]: Started LSB: mosquitto MQTT v3.1 mes....
     * Feb 27 22:34:04 raspberrypi systemd[1]: Started LSB: mosquitto MQTT v3.1 mes....
     * Feb 27 22:38:28 raspberrypi systemd[1]: Started LSB: mosquitto MQTT v3.1 mes....
     * Feb 27 22:40:27 raspberrypi systemd[1]: Started LSB: mosquitto MQTT v3.1 mes....
     * Feb 27 22:42:26 raspberrypi systemd[1]: Started LSB: mosquitto MQTT v3.1 mes....
     * Feb 27 22:50:51 raspberrypi systemd[1]: Stopping LSB: mosquitto MQTT v3.1 me....
     * Feb 27 22:50:51 raspberrypi mosquitto[4594]: Stopping network daemon:: mosqu....
     * Feb 27 22:50:51 raspberrypi systemd[1]: Stopped LSB: mosquitto MQTT v3.1 mes....
     * Feb 27 22:50:55 raspberrypi systemd[1]: Stopped LSB: mosquitto MQTT v3.1 mes....
     * Hint: Some lines were ellipsized, use -l to show in full.
     * <p>
     * <p>
     * Based on above status report this function is coded to look at the Active session
     * and read the active or inactive status
     */
    private boolean mosquittoStatus() {
        boolean status = false;
        StringBuffer output = new StringBuffer();

        Process process;

        try {
            //This command start the Broker
            process = Runtime.getRuntime().exec(brokerCmd(mqttBroker, brokerAction.STATUS));
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            int skipLine = 2;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                currentLine += 1;
                output.append(line);
                //DEBUG USEFULL : System.out.println(output);
                /** Active: active (running) since Mon 2017-02-27 22:58:15 UTC; 25min ago **/
                /**  Active: inactive (dead) since Mon 2017-02-27 22:50:51 UTC; 5s ago **/
                if (currentLine == 3) {
                    String[] condition = output.toString().trim().split("\\s");
                    for (int x = 0; x < condition.length; x++) {
                        //DEBUG USEFULL : System.out.println(condition[x].toString());
                        //the status can be found in 1 position in condition array. so check the status now
                        if (x == 1) {
                            //DEBUG purpose : System.out.println("Checking : " + condition[x]);
                            if (condition[x].equals("active")) {
                                status = true;
                                LOGGER.log(Level.INFO, "MQTT BROKER ONLINE");

                            } else {
                                status = false;
                                LOGGER.log(Level.INFO, "MQTT BROKER OFFLINE");
                            }
                        }
                    }
                    System.out.println();
                    break;
                }
                output.delete(0, output.length());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //useful for debugging and useful to build ... Can be removed and commented when in production.
    private void readConsole(BufferedReader reader, StringBuffer output) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }
        System.out.println(output);
    }


    public enum brokerList {
        MOSQUITTO,
        EMQ,
        HIVEMQ,
        MOSCA,
        VERNMQ,
        IBM_BLUEMIX
    }


    public enum brokerAction {
        START,
        STOP,
        CHECK_STATUS,
        RELOAD,
        FORCE_RELOAD,
        RESTART,
        TRY_RESTART,
        STATUS
    }


}
