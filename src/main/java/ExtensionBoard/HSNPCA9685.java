package ExtensionBoard;

import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.i2c.I2CBus;

import java.math.BigDecimal;

/**
 * Created by darwin on 27.02.17.
 */
public interface HSNPCA9685 {
    public int getAddress();

    public void setAddress(int address);

    public void setFrequency(BigDecimal frequency);

    public void setGpioProvider();

    public void initGpioPins();

    public void setPwm(Pin pin, int stepValue);

    public boolean shutDownGpio();


}
