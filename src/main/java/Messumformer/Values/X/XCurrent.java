package Messumformer.Values.X;

/**
 * Created by udlab on 03.04.17.
 */
public class XCurrent {
    int duration;
    boolean isOffsetZero;
    private static XCurrent ourInstance = new XCurrent();

    public static XCurrent getInstance() {
        return ourInstance;
    }

    private XCurrent() {
        this.duration = 35;
    }

    public int getDuration(int percentage, boolean isOffsetZero){
        this.isOffsetZero = isOffsetZero;
        durationForPercentage(percentage);
        return duration;
    }

    private void durationForPercentage(int percentage) {

        switch (percentage) {
            case 0:
                duration = 10;
                break;
            case 1:
                duration = 29;
                break;
            case 2:
                duration = 37;
                System.out.println("2 percentage");
                break;
            case 3:
                duration = 42;
                break;
            case 4:
                duration = 47;
                break;
            case 5:
                duration = 50;
                break;
            case 6:
                duration = 54;
                break;
            case 7:
                duration = 57;
                break;
            case 8:
                duration = 60;
                break;
            case 9:
                duration = 63;
                break;
            case 10:
                duration = 67;
                break;
            case 11:
                duration = 70;
                break;
            case 12:
                duration = 74;
                break;
            case 13:
                duration = 77;
                break;
            case 14:
                duration = 81;
                break;
            case 15:
                duration = 85;
                break;
            case 16:
                duration = 88;
                break;
            case 17:
                duration = 93;
                break;
            case 18:
                duration = 99;
                break;
            case 19:
                duration = 106;
                break;
            case 20:
                duration = 113;
                break;
            case 21:
                duration = 118;
                break;
            case 22:
                duration = 126;
                break;
            case 23:
                duration = 131;
                break;
            case 24:
                duration = 137;
                break;
            case 25:
                duration = 144;
                break;
            case 26:
                duration = 151;
                break;
            case 27:
                duration = 157;
                break;
            case 28:
                duration = 164;
                break;
            case 29:
                duration = 170;
                break;
            case 30:
                duration = 177;
                break;
            case 31:
                duration = 183;
                break;
            case 32:
                duration = 190;
                break;
            case 33:
                duration = 196;
                break;
            case 34:
                duration = 203;
                break;
            case 35:
                duration = 210;
                break;
            case 36:
                duration = 216;
                break;
            case 37:
                duration = 222;
                break;
            case 38:
                duration = 229;
                break;
            case 39:
                duration = 235;
                break;
            case 40:
                duration = 242;
                break;
            case 41:
                duration = 249;
                break;
            case 42:
                duration = 255;
                break;
            case 43:
                duration = 262;
                break;
            case 44:
                duration = 268;
                break;
            case 45:
                duration = 275;
                break;
            case 46:
                duration = 281;
                break;
            case 47:
                duration = 288;
                break;
            case 48:
                duration = 294;
                break;
            case 49:
                duration = 301;
                break;
            case 50:
                duration = 308;
                break;
            case 51:
                duration = 314;
                break;
            case 52:
                duration = 321;
                break;
            case 53:
                duration = 327;
                break;
            case 54:
                duration = 334;
                break;
            case 55:
                duration = 341;
                break;
            case 56:
                duration = 347;
                break;
            case 57:
                duration = 354;
                break;
            case 58:
                duration = 360;
                break;
            case 59:
                duration = 367;
                break;
            case 60:
                duration = 374;
                break;
            case 61:
                duration = 380;
                break;
            case 62:
                duration = 387;
                break;
            case 63:
                duration = 393;
                break;
            case 64:
                duration = 400;
                break;
            case 65:
                duration = 407;
                break;
            case 66:
                duration = 413;
                break;
            case 67:
                duration = 420;
                break;
            case 68:
                duration = 427;
                break;
            case 69:
                duration = 433;
                break;
            case 70:
                duration = 440;
                break;
            case 71:
                duration = 446;
                break;
            case 72:
                duration = 453;
                break;
            case 73:
                duration = 460;
                break;
            case 74:
                duration = 466;
                break;
            case 75:
                duration = 473;
                break;
            case 76:
                duration = 480;
                break;
            case 77:
                duration = 486;
                break;
            case 78:
                duration = 493;
                break;
            case 79:
                duration = 500;
                break;
            case 80:
                duration = 506;
                break;
            case 81:
                duration = 506;
                break;
            case 82:
                duration = 513;
                break;
            case 83:
                duration = 526;
                break;
            case 84:
                duration = 533;
                break;
            case 85:
                duration = 539;
                break;
            case 86:
                duration = 547;
                break;
            case 87:
                duration = 553;
                break;
            case 88:
                duration = 559;
                break;
            case 89:
                duration = 566;
                break;
            case 90:
                duration = 573;
                break;
            case 91:
                duration = 579;
                break;
            case 92:
                duration = 586;
                break;
            case 93:
                duration = 593;
                break;
            case 94:
                duration = 600;
                break;
            case 95:
                duration = 604;
                break;
            case 96:
                duration = 613;
                break;
            case 97:
                duration = 620;
                break;
            case 98:
                duration = 627;
                break;
            case 99:
                duration = 633;
                break;
            case 100:
                duration = 640;
                break;


        }
    }
}
