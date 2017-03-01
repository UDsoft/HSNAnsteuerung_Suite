package Data;

import java.io.Serializable;

/**
 * Created by darwin on 01.03.17.
 */
public class Status implements Serializable {

    private static final String defaultBundle = "Data.Status";

    /**
     * @serial  The non-localized name of the status
     */
    private final String name;

    /**
     * @serial The integer value of the status
     */
    private final int value;

    /**
     * HANDSHAKE is a security status  where the client send the clientID.
     * This will be important for verify the accessibility.
     */
    public static final Status HANDSHAKE = new Status("handshake",0);

    /**
     * INIT is status to initialize all the
     */
    public static final Status INIT = new Status("init",1);

    public static final Status OUTPUT = new Status("output",2);

    public static final Status READ_VOLTAGE = new Status("read_voltage",3);

    public static final Status READ_CURRENT = new Status("read_current",4);



    public Status(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
