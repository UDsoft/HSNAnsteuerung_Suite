package Data;


import ExtensionBoard.PinGroup;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by darwin on 27.02.17.
 */
public class HSNStandardData {

    private String werte;
    private String group;
    /**
     * Empty Constructor
     */
    public HSNStandardData() {

    }

    //Constructor with the value and group name
    public HSNStandardData(String werte, String group) {
        this.werte = werte;
        this.group = group;
    }


    public String getWerte() {
        return werte;
    }

    public void setWerte(String werte) {
        this.werte = werte;
    }

    public PinGroup getGroup() {
        PinGroup pinGroup = null;
        switch (group){
            case "X":
                pinGroup= PinGroup.X;
                break;
            case "Y":
                pinGroup =  PinGroup.Y;
                break;
            case "Z":
                pinGroup =  PinGroup.Z;
                break;
            default:
                System.out.println("ERROR in knowing the Group");
                break;
        }

        return pinGroup;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * The Constructor is used when the data is been recieved from other device.
     *
     * @param data : to populate the class using MqttMessage
     */
    public HSNStandardData(MqttMessage data) {
        Gson gson = new Gson();

        gson.fromJson(data.toString(), HSNStandardData.class);
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


}
