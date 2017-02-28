package ExtensionBoard;

import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by darwin on 25.02.17.
 */
public class PCA9683Manager implements HSNPCA9685 {

    int address;
    I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);


    public PCA9683Manager(int address) throws IOException, I2CFactory.UnsupportedBusNumberException {
    }


    public void setAddress(int address) {
        this.address = address;
    }

    public int getAddress() {
        return 0;
    }

    public void setFrequency(BigDecimal frequency) {

    }


    public void setGpioProvider(I2CBus bus, int address, BigDecimal frequency, BigDecimal frequencyCorrectionFactopr) {

    }

    public boolean initGpioPins() {
        return false;
    }

    public boolean setPwm(PCA9685Pin pin, int stepValue) {
        return false;
    }

    public boolean shutDownGpio() {
        return false;
    }
}
