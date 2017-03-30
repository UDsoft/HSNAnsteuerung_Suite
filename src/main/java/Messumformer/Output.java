package Messumformer;

/**
 * Created by udlab on 30.03.17.
 */
public interface Output {

    public double getOutput(int input);
    public double getOutput();
    public void setInput(int input);
    public void correctionEstimation(int correction);

    //Search for linear gradient with the given points
    //1. (x1,y1)
    //2. (y1,y2)
    // m = (y2-y1)/(x2-x1)
    public double linearGradient(double x1,double x2,double y1,double y2);

}
