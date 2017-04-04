package Messumformer.Values.Y;

/**
 * Created by udlab on 03.04.17.
 */
public class YCurrent {
    int duration;
    private static YCurrent ourInstance = new YCurrent();

    public static YCurrent getInstance() {
        return ourInstance;
    }

    private YCurrent() {
        this.duration = 35;
    }

    public int getDuration(int percentage){
        durationForPercentage(percentage);
        return duration;
    }
    private void durationForPercentage(int percentage) {

        switch (percentage) {
            case 0:
                duration = 2;
                break;
            case 1:
                duration = 27;
                break;
            case 2:
                duration = 37;
                System.out.println("2 percentage");
                break;
            case 3:
                duration = 43;
                break;
            case 4:
                duration = 47;
                break;
            case 5:
                duration = 51;
                break;
            case 6:
                duration = 53;
                break;
            case 7:
                duration = 56;
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
                duration = 71;
                break;
            case 12:
                duration = 75;
                break;
            case 13:
                duration = 77;
                break;
            case 14:
                duration = 82;
                break;
            case 15:
                duration = 86;
                break;
            case 16:
                duration = 89;
                break;
            case 17:
                duration = 93;
                break;
            case 18:
                duration = 99;
                break;
            case 19:
                duration = 105;
                break;
            case 20:
                duration = 111;
                break;
            case 21:
                duration = 117;
                break;
            case 22:
                duration = 125;
                break;
            case 23:
                duration = 130;
                break;
            case 24:
                duration = 139;
                break;
            case 25:
                duration = 145;
                break;
            case 26:
                duration = 150;
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
                duration = 180;
                break;
            case 31:
                duration = 184;
                break;
            case 32:
                duration = 190;
                break;
            case 33:
                duration = 195;
                break;
            case 34:
                duration = 202;
                break;
            case 35:
                duration = 209;
                break;
            case 36:
                duration = 215;
                break;
            case 37:
                duration = 221;
                break;
            case 38:
                duration = 229;
                break;
            case 39:
                duration = 235;
                break;
            case 40:
                duration = 241;
                break;
            case 41:
                duration = 249;
                break;
            case 42:
                duration = 255;
                break;
            case 43:
                duration = 261;
                break;
            case 44:
                duration = 270;
                break;
            case 45:
                duration = 275;
                break;
            case 46:
                duration = 280;
                break;
            case 47:
                duration = 286;
                break;
            case 48:
                duration = 295;
                break;
            case 49:
                duration = 301;
                break;
            case 50:
                duration = 310;
                break;
            case 51:
                duration = 315;
                break;
            case 52:
                duration = 320;
                break;
            case 53:
                duration = 327;
                break;
            case 54:
                duration = 335;
                break;
            case 55:
                duration = 340;
                break;
            case 56:
                duration = 345;
                break;
            case 57:
                duration = 353;
                break;
            case 58:
                duration = 360;
                break;
            case 59:
                duration = 365;
                break;
            case 60:
                duration = 371;
                break;
            case 61:
                duration = 379;
                break;
            case 62:
                duration = 385;
                break;
            case 63:
                duration = 395;
                break;
            case 64:
                duration = 405;
                break;
            case 65:
                duration = 410;
                break;
            case 66:
                duration = 417;
                break;
            case 67:
                duration = 423;
                break;
            case 68:
                duration = 433;
                break;
            case 69:
                duration = 437;
                break;
            case 70:
                duration = 445;
                break;
            case 71:
                duration = 454;
                break;
            case 72:
                duration = 456;
                break;
            case 73:
                duration = 460;
                break;
            case 74:
                duration = 466;
                break;
            case 75:
                duration = 474;
                break;
            case 76:
                duration = 483;
                break;
            case 77:
                duration = 488;
                break;
            case 78:
                duration = 500;
                break;
            case 79:
                duration = 507;
                break;
            case 80:
                duration = 511;
                break;
            case 81:
                duration = 515;
                break;
            case 82:
                duration = 520;
                break;
            case 83:
                duration = 527;
                break;
            case 84:
                duration = 535;
                break;
            case 85:
                duration = 540;
                break;
            case 86:
                duration = 550;
                break;
            case 87:
                duration = 555;
                break;
            case 88:
                duration = 563;
                break;
            case 89:
                duration = 570;
                break;
            case 90:
                duration = 575;
                break;
            case 91:
                duration = 582;
                break;
            case 92:
                duration = 590;
                break;
            case 93:
                duration = 595;
                break;
            case 94:
                duration = 602;
                break;
            case 95:
                duration = 610;
                break;
            case 96:
                duration = 615;
                break;
            case 97:
                duration = 623;
                break;
            case 98:
                duration = 627;
                break;
            case 99:
                duration = 634;
                break;
            case 100:
                duration = 640;
                break;


        }
    }

}
