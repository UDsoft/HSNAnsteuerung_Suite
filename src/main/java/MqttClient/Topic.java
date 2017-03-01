package MqttClient;

/**
 * Created by darwin on 26.02.17.
 */
public enum Topic {

    /**
     String valuePWM = "/read/value/pwm/";
     String init = "/init/";
     String readVoltage = "/read/voltage/";
     String readCurrent = "/read/current";
     **/

    CLIENT_HANDSHAKE("/init/handshake"),
    INIT_PINS("/init/pin"),
    VALUE_PWM_0("/read/value/pwm/0"),
    VALUE_PWM_1("/read/value/pwm/1"),
    VALUE_PWM_2("/read/value/pwm/2"),
    VALUE_PWM_3("/read/value/pwm/3"),
    VALUE_PWM_4("/read/value/pwm/4"),
    VALUE_PWM_5("/read/value/pwm/5"),
    VALUE_PWM_6("/read/value/pwm/6"),
    VALUE_PWM_7("/read/value/pwm/7"),
    VALUE_PWM_8("/read/value/pwm/8"),
    VALUE_PWM_9("/read/value/pwm/9"),
    VALUE_PWM_10("/read/value/pwm/10"),
    VALUE_PWM_11("/read/value/pwm/11"),
    VALUE_PWM_12("/read/value/pwm/12"),
    VALUE_PWM_13("/read/value/pwm/13"),
    VALUE_PWM_14("/read/value/pwm/14"),
    VALUE_PWM_15("/read/value/pwm/15"),

    //Topic for Reading the current.
    READ_CURRENT_0("/read/current/0"),
    READ_CURRENT_1("/read/current/1"),
    READ_CURRENT_2("/read/current/2"),
    READ_CURRENT_3("/read/current/3"),
    READ_CURRENT_4("/read/current/4"),
    READ_CURRENT_5("/read/current/5"),
    READ_CURRENT_6("/read/current/6"),
    READ_CURRENT_7("/read/current/7"),
    READ_CURRENT_8("/read/current/8"),
    READ_CURREMT_9("/read/current/9"),
    READ_CURRENT_10("/read/current/10"),
    READ_CURRENT_11("/read/current/11"),
    READ_CURRENT_12("/read/current/12"),
    READ_CURRENT_13("/read/current/13"),
    READ_CURRENT_14("/read/current/14"),
    READ_CURRENT_15("/read/current/15"),

    //Topic for reading the voltage.
    READ_VOLTAGE_0("/read/voltage/0"),
    READ_vOLTAGE_1("/read/voltage/0"),
    READ_VOLTAGE_2("/read/voltage/0"),
    READ_VOLTAGE_3("/read/voltage/0"),
    READ_VOLTAGE_4("/read/voltage/0"),
    READ_VOLTAGE_5("/read/voltage/0"),
    READ_VOLTAGE_6("/read/voltage/0"),
    READ_VOLTAGE_7("/read/voltage/0"),
    READ_VOLTAGE_8("/read/voltage/0"),
    READ_VOLTAGE_9("/read/voltage/0"),
    READ_VOLTAGE_10("/read/voltage/0"),
    READ_VOLTAGE_11("/read/voltage/0"),
    READ_VOLTAGE_12("/read/voltage/0"),
    READ_VOLTAGE_13("/read/voltage/0"),
    READ_VOLTAGE_14("/read/voltage/0"),
    READ_VOLTAGE_15("/read/voltage/0");

    private String topic;

    Topic(String topic) {
        this.topic = topic;
    }

    public String getTopic(){
        return topic;
    }
}
