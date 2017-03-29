package ExtensionBoard;

import com.pi4j.gpio.extension.pca.PCA9685GpioProvider;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by darwin on 25.02.17.
 */
public class PCA9683Manager implements HSNPCA9685 {

    private int address;
    private I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
    private PCA9685GpioProvider gpioProvider;
    private BigDecimal frequency;
    private BigDecimal frequencyCorrectionFactor;


    public PCA9683Manager(int address, BigDecimal frequency, BigDecimal frequencyCorrectionFactor) throws IOException, I2CFactory.UnsupportedBusNumberException {

        setGpioProvider();
        initGpioPins();

    }

    public int getAddress() {
        return 0;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setFrequency(BigDecimal frequency) {

    }

    public void setGpioProvider() {
        try {
            gpioProvider = new PCA9685GpioProvider(bus, address, frequency, frequencyCorrectionFactor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //initialize the GPIOPINS in PCA9685 to be output pwm
    public void initGpioPins() {
        GpioController gpio = GpioFactory.getInstance();

        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_00, "Pulse 00");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_01, "Pulse 01");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_02, "Pulse 02");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_03, "Pulse 03");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_04, "Pulse 04");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_05, "Pulse 05");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_06, "Pulse 06");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_07, "Pulse 07");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_08, "Pulse 08");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_09, "Pulse 09");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_10, "Always ON");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_11, "Always OFF");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_12, "Servo pulse MIN");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_13, "Servo pulse NEUTRAL");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_14, "Servo pulse MAX");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_15, "not used");

    }

    public void setPwm(Pin pin, int stepValue) {

        gpioProvider.setPwm(pin,stepValue);

    }


    public boolean shutDownGpio() {
        return false;
    }
}
