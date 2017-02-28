package Data;

import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.lang.reflect.Type;

/**
 * Created by darwin on 27.02.17.
 */
public class HSNStandardData {
    /**
     * {
     *     clientID:"clientName",
     *     name:"pinName",
     *     pin_number:"",
     *     value:"",
     *     isOutput:"true/false"
     *     unit:"",
     *     description:""
     *     }
     * }
     */

    private String name;
    private String pinNumber;
    private String value;
    private boolean isOutput;
    private String unit;
    private String description;
    private String clientID;

    /**
     * Empty Constructor
     */
    public HSNStandardData() {
    }

    /**
     *
     * @param name : name of the
     * @param clientID : device ID which is the owner of the msg
     * @param pinNumber : pin number produce the output
     * @param value : value of the output
     * @param isOutput : True if it is an OUTPUT / False if it is meant to be INPUT
     * @param unit : Scientific unit of the value
     * @param description : random description of the value.
     */
    public HSNStandardData(String name,String clientID, String pinNumber,
                           String value, boolean isOutput, String unit,
                           String description) {
        this.name = name;
        this.clientID = clientID;
        this.pinNumber = pinNumber;
        this.value = value;
        this.isOutput = isOutput;
        this.unit = unit;
        this.description = description;
    }

    /**
     * The Constructor is used when the data is been recieved from other device.
     * @param data : to populate the class using MqttMessage
     */
    public HSNStandardData(MqttMessage data){
        Gson gson = new Gson();
        gson.fromJson(data.toString(),this.getClass());
    }

    /**
     *
     * @return : data in json format known in HSNAnsteuerung
     */
    public String jsonFormattedData(){
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this);
        return json;
    }

    public String getName() {
        return name;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public String getValue() {
        return value;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    public String getClientID() {
        return clientID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setOutput(boolean output) {
        isOutput = output;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
