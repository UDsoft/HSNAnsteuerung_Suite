package MqttClient;

/**
 * Created by darwin on 26.02.17.
 */
public enum Topic {


    VALUE_PWM_X("/set/value/pwm/x"),
    VALUE_PWM_Y("/set/value/pwm/y"),
    VALUE_PWM_Z("/set/value/pwm/z"),

    //Future
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
