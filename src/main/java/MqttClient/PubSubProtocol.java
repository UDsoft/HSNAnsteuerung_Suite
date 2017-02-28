package MqttClient;

/**
 * Created by darwin on 26.02.17.
 */
public class PubSubProtocol {


    public PubSubProtocol() {
    }

    public String subscribeTopic(Topic topic){

        String valuePWM ="/read/value/pwm/";
        String init = "/init/";
        String readVoltage ="/read/voltage/";
        String readCurrent ="/read/current";

        switch (topic){
            case CLIENTHANDSHAKE:
                return init+"handshake";
            case INITPINS:
                return init+"pin";
            case VALUEPWM0:
                return valuePWM+"0";
            case VALUEPWM1:
                return valuePWM+"1";
            case VALUEPWM2:
                return valuePWM+"2";
            case VALUEPWM3:
                return valuePWM+"3";
            case VALUEPWM4:
                return valuePWM+"4";
            case VALUEPWM5:
                return valuePWM+"5";
            case VALUEPWM6:
                return valuePWM+"6";
            case VALUEPWM7:
                return valuePWM+"7";
            case VALUEPWM8:
                return valuePWM+"8";
            case VALUEPWM9:
                return valuePWM+"9";
            case VALUEPWM10:
                return valuePWM+"10";
            case VALUEPWM11:
                return valuePWM+"11";
            case VALUEPWM12:
                return valuePWM+"12";
            case VALUEPWM13:
                return valuePWM+"13";
            case VALUEPWM14:
                return valuePWM+"14";
            case VALUEPWM15:
                return valuePWM+"15";
            case READCURRENT1:
                return readCurrent+"1";
            case READVOLTAGE1:
                return readVoltage+"1";
            case READCURRENT2:
                return  readCurrent+"2";
            case READvOLTAGE2:
                return readVoltage+"2";
            case READCURRENT3:
                return readCurrent+"3";
            case READVOLTAGE3:
                return  readVoltage+"3";
            case READCURRENT4:
                return readCurrent+"4";
            case READVOLTAGE4:
                return readVoltage+"4";
            case READCURRENT5:
                return readCurrent+"5";
            case READVOLTAGE5:
                return readVoltage+"5";
            case READCURRENT6:
                return  readCurrent+"6";
            case READVOLTAGE6:
                return readVoltage+"6";
            case READCURRENT7:
                return readCurrent+"7";
            case READVOLTAGE7:
                return readVoltage+"7";
            case READCURRENT8:
                return readCurrent+"8";
            case READVOLTAGE8:
                return readVoltage+"8";
            case READCURRENT9:
                return readCurrent+"9";
            case READVOLTAGE9:
                return readVoltage+"9";
            case READCURREMT10:
                return readCurrent+"10";
            case READVOLTAGE10:
                return readVoltage+"10";
            case READCURRENT11:
                return readCurrent+"11";
            case READVOLTAGE11:
                return readVoltage+"11";
            case READCURRENT12:
                return readCurrent+"12";
            case READVOLTAGE12:
                return readVoltage+"12";
            case READCURRENT13:
                return readCurrent+"13";
            case READVOLTAGE13:
                return readVoltage+"13";
            case READCURRENT14:
                return readCurrent+"14";
            case READVOLTAGE14:
                return readVoltage+"14";
            case READCURRENT15:
                return readCurrent+"15";
            case READVOLTAGE15:
                return readVoltage+"15";
            default:
                return "error";
        }
    }


}
