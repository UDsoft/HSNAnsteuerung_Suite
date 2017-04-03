package Messumformer;

/**
 * Created by udlab on 30.03.17.
 */
public class HSNAusgang implements Output{

    /*Y = mx + b
    Y = Output
    x = Input
    m = Gradient
    b = Y-Intercept ( where the line crosses the Y-axis where x Value is Zero)
    */

    private double gradient;
    private double firstPercentage ;
    private double lastPercentage ;

    private double firstStep;
    private double lastStep;

    private double input = 0;

    private double yIntercept;
    private double correction = 0;

    public HSNAusgang(int firstPercentage, int lastPercentage, int firstStep, int lastStep, int yIntercept) {
        this.firstPercentage = (double)firstPercentage;
        this.lastPercentage = (double)lastPercentage;
        this.firstStep = (double)firstStep;
        this.lastStep = (double)lastStep;
        this.yIntercept = (double)yIntercept;
        gradient = linearGradient(this.firstPercentage, this.lastPercentage,this.firstStep,this.lastStep);
    }

    public HSNAusgang(int firstStep, int lastStep, int yIntercept) {
        this.firstPercentage = 0;
        this.lastPercentage = 100;
        this.firstStep = (double)firstStep;
        this.lastStep = (double)lastStep;
        this.yIntercept = (double)yIntercept;
        gradient = linearGradient(firstPercentage,lastPercentage, this.firstStep,this.lastStep);
    }


    public HSNAusgang(int firstPercentage, int lastPercentage, int firstStep, int lastStep, int yIntercept, int correction) {
        this.firstPercentage = (double)firstPercentage;
        this.lastPercentage = (double)lastPercentage;
        this.firstStep = (double)firstStep;
        this.lastStep = (double)lastStep;
        this.yIntercept = (double)yIntercept;
        this.correction = (double)correction;
        gradient = linearGradient(this.firstPercentage,this.lastPercentage, this.firstStep,this.lastStep);

    }

    public HSNAusgang(int firstStep, int lastStep, int yIntercept, int correction) {
        this.firstPercentage = 0;
        this.lastPercentage = 100;
        this.firstStep = (double)firstStep;
        this.lastStep = (double)lastStep;
        this.yIntercept = (double)yIntercept;
        this.correction = (double)correction;
        gradient = linearGradient(firstPercentage,lastPercentage, this.firstStep,this.lastStep);

    }






    @Override
    public double getOutput(int input) {

        this.input = (double)input;
        double output = 0;


            //Y = mx + b
            output = (gradient * input) + yIntercept + correction;
            System.out.println("OUTPUT VALUE : " + output);
            System.out.println("The Value of Gradient is : " + gradient);
            System.out.println("The Value for Y Intercept is : " + yIntercept);
            System.out.println("The Value for the correction is " + correction);


        return output;
    }

    @Override
    public double getOutput() {
        double output = 0;
        //Y = mx + b
        output = (gradient*input)+yIntercept + correction;
        System.out.println("The Value of Gradient is : " + gradient);
        System.out.println("The Value for Y Intercept is : " + yIntercept);
        System.out.println("The Value for the correction is " + correction);

        return output;
    }

    @Override
    public void setInput(int input) {
        this.input = (double)input;
    }

    @Override
    public void correctionEstimation(int correction) {
        this.correction = correction;
    }

    @Override
    public double linearGradient(double x1, double x2, double y1, double y2) {
        gradient = (y2-y1)/(x2-x1);
        return gradient;
    }
}
