package Data;

import com.google.gson.Gson;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.Pin;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.logging.Logger;

/**
 * Created by darwin on 11.03.17.
 */
public class HSNPwmManager {

    Logger logger = Logger.getLogger(HSNPwmManager.class.getName());

    String groupName ;
    int pwmValue;

    public HSNPwmManager(String groupName, int pwmValue) {
        this.groupName = groupName;
        this.pwmValue = pwmValue;
    }

    /**
     * The Constructor is used when the data is been recieved from other device.
     *
     * @param data : to populate the class using MqttMessage
     */
    public HSNPwmManager(MqttMessage data) {
        Gson gson = new Gson();
        gson.fromJson(data.toString(), HSNPwmManager.class);
    }

    /**
     * @return : data in json format known in HSNAnsteuerung
     */
    public String jsonFormattedData() {
        String json;
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
    }

    //Group name is associated with the pins.
    public Pin[] getPins(){
        Pin[] pins = new Pin[]{};
        switch (groupName){
            case "x":
                pins = new Pin[]{PCA9685Pin.PWM_00,PCA9685Pin.PWM_01};
                break;
            case "y":
                pins = new Pin[]{PCA9685Pin.PWM_02,PCA9685Pin.PWM_03};
                break;
            case "z":
                pins = new Pin[]{PCA9685Pin.PWM_04,PCA9685Pin.PWM_05};
                break;


        }
        if(pins.length == 0){

        }
        return pins;
    }


}
