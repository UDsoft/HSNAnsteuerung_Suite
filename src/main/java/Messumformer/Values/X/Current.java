package Messumformer.Values.X;

import java.util.Map;

/**
 * Created by udlab on 03.04.17.
 */
public class Current {
    int duration;
    private static Current ourInstance = new Current();

    public static Current getInstance() {
        return ourInstance;
    }

    private Current() {
        this.duration = 35;
    }

    private void valueForPercentage(int percentage){

        switch (percentage){
            case 1:
                duration = 40;
                break;
            case 2:break;
            case 3:break;
            case 4:break;
            case 5:break;
            case 6:break;
            case 7:break;
            case 8:break;
            case 9:break;
            case 10:break;
            case 11:break;
            case 12:break;
            case 13:break;
            case 14:break;
            case 15:break;
            case 16:break;
            case 17:break;
            case 18:break;
            case 19:break;
            case 20:break;
            case 21:break;
            case 4:break;
            case 4:break;
            case 4:break;
            case 4:break;
            case 4:break;
            case 4:break;
            case 4:break;
            case 4:break;
            case 4:break;
            case 4:break;




        }
    }
}
