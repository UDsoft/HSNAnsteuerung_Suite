package ExtensionBoard;

import Messumformer.HSNAusgang;
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

    private int address = 0x40;
    private I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
    private PCA9685GpioProvider gpioProvider;
    private BigDecimal frequency = new BigDecimal("1000");
    private BigDecimal frequencyCorrectionFactor = new BigDecimal(1.0578);
    GpioController gpio = GpioFactory.getInstance();

    //Set the Output properties based on measured Current and Voltage
    HSNAusgang XVoltage_20till100 = new HSNAusgang(20,100,115,600,115 );
    HSNAusgang XVoltage_20Percentage  = new HSNAusgang(0,20,40,111,40,-2);
    HSNAusgang XCurrent = new HSNAusgang(0,100 ,5,640,5,-1);
    HSNAusgang YVoltage = new HSNAusgang(109,589,109);
    HSNAusgang YCurrent = new HSNAusgang(108,634,108);
    HSNAusgang ZVoltage = new HSNAusgang(111,593,111);
    HSNAusgang ZCurrent = new HSNAusgang(112,638,112);

    public PCA9683Manager(int address, BigDecimal frequency, BigDecimal frequencyCorrectionFactor) throws IOException, I2CFactory.UnsupportedBusNumberException {

        setGpioProvider();
        initGpioPins();

    }

    //Using the Standard Value as defined.
    public PCA9683Manager() throws IOException, I2CFactory.UnsupportedBusNumberException {
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
            System.out.println("Done Set GPIO Provider");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //initialize the GPIOPINS in PCA9685 to be output pwm
    public void initGpioPins()
    {


        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_00, "Volt X");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_01, "Amp X");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_02, "Volt Y");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_03, "Amp Y");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_04, "VOLT Z");
        gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_05, "Amp Z");

        System.out.println("Done initialising GPIOs");

    }
    @Override
    public void setPwm(PinGroup pinGroup, int percentage) {

        switch (pinGroup){
            case X:
                System.out.println("Setting PWM Value X");
                    settingPWM_XVoltage(percentage);
                    settingPWM_XCurrent(percentage);
                    break;

            case Y:
                System.out.println("Setting PWM Value Y");
                setPwm(PCA9685Pin.PWM_02,(int)YVoltage.getOutput(percentage));
                setPwm(PCA9685Pin.PWM_03,(int)YCurrent.getOutput(percentage));
                break;
            case Z:
                System.out.println("Setting PWM Value Z");
                setPwm(PCA9685Pin.PWM_04,(int)ZVoltage.getOutput(percentage));
                setPwm(PCA9685Pin.PWM_05,(int)ZCurrent.getOutput(percentage));
                break;
            default:
                System.out.println("ERROR Group is not Valid");

        }
    }

    //step = gradient*percentage + stepValueWhenZeroPercentage.
    //https://revisionmaths.com/gcse-maths-revision/algebra/gradients-and-graphs
    private int stepValue(int zeroPercentageValue,int maxPercentageValue, int cValue,int gradient){

        int step = 0;


        return step;

    }

    private void settingPWM_XVoltage(int percentage){
        if(percentage < 20){
            if(percentage >= 4 && percentage <7){
                setPwm(PCA9685Pin.PWM_00,(int)XVoltage_20Percentage.getOutput(percentage) - 2);
            }
            else if(percentage >= 7&& percentage <=14){
                setPwm(PCA9685Pin.PWM_00,(int) XVoltage_20Percentage.getOutput(percentage-1));

            }else if(percentage >=16 && percentage <=18){
                setPwm(PCA9685Pin.PWM_00, (int) XVoltage_20Percentage.getOutput(percentage)+5);

            }else if(percentage >= 19){
                setPwm(PCA9685Pin.PWM_00, (int) XVoltage_20Percentage.getOutput(percentage)+9);

            }
            else{
                setPwm(PCA9685Pin.PWM_00, (int) XVoltage_20Percentage.getOutput(percentage));

            }
        }else{
            if(percentage <=20){
                setPwm(PCA9685Pin.PWM_00,(int)XVoltage_20till100.getOutput(percentage-20)+3);

            }
            System.out.println("Using Value X more or equal 20");
            setPwm(PCA9685Pin.PWM_00,(int)XVoltage_20till100.getOutput(percentage-20));
        }
    }

    private void settingPWM_XCurrent(int percentage){
        if(percentage <= 2){
            System.out.println("Less then 2 Amp percentage");
            setPwm(PCA9685Pin.PWM_01,(int)XCurrent.getOutput(percentage));
        }else if(percentage > 2 && percentage <=4){
            System.out.println("2 -4 ");
            setPwm(PCA9685Pin.PWM_01,(int)XCurrent.getOutput(percentage));

        }else{
            System.out.println("4 and above");
            setPwm(PCA9685Pin.PWM_01,(int)XCurrent.getOutput(percentage));
        }
    }

    private void settingPWM_YVoltage(int percentage){

    }

    private void settingPWM_YCurrent(int percentage){

    }

    private void settingPWM_ZVoltage(int percentage){

    }

    private void settingPWM_ZCurrent(int percentage){

    }


    private void setPwm(Pin pin, int duration) {

        gpioProvider.setPwm(pin,duration);

    }



    public boolean shutDownGpio() {
        return false;
    }

}
