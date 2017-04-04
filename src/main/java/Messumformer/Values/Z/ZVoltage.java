package Messumformer.Values.Z;

/**
 * Created by udlab on 03.04.17.
 */
public class ZVoltage {

    int duration;
    private static ZVoltage ourInstance = new ZVoltage();

    public static ZVoltage getInstance() {
        return ourInstance;
    }

    private ZVoltage() {
        this.duration = 35;
    }

    public int getDuration(int percentage){
        durationForPercentage(percentage);
        return duration;
    }

    private void durationForPercentage(int percentage) {

        switch (percentage) {
            case 0:
                duration = 36;
                break;
            case 1:
                duration = 42;
                break;
            case 2:
                duration = 45;
                break;
            case 3:
                duration = 48;
                break;
            case 4:
                duration = 52;
                break;
            case 5:
                duration = 55;
                break;
            case 6:
                duration = 57;
                break;
            case 7:
                duration = 60;
                break;
            case 8:
                duration = 63;
                break;
            case 9:
                duration = 65;
                break;
            case 10:
                duration = 69;
                break;
            case 11:
                duration = 73;
                break;
            case 12:
                duration = 75;
                break;
            case 13:
                duration = 79;
                break;
            case 14:
                duration = 83;
                break;
            case 15:
                duration = 87;
                break;
            case 16:
                duration = 90;
                break;
            case 17:
                duration = 96;
                break;
            case 18:
                duration = 104;
                break;
            case 19:
                duration = 109;
                break;
            case 20:
                duration = 114;
                break;
            case 21:
                duration = 120;
                break;
            case 22:
                duration = 125;
                break;
            case 23:
                duration = 131;
                break;
            case 24:
                duration = 138;
                break;
            case 25:
                duration = 143;
                break;
            case 26:
                duration = 149;
                break;
            case 27:
                duration = 155;
                break;
            case 28:
                duration = 160;
                break;
            case 29:
                duration = 166;
                break;
            case 30:
                duration = 174;
                break;
            case 31:
                duration = 180;
                break;
            case 32:
                duration = 185;
                break;
            case 33:
                duration = 191;
                break;
            case 34:
                duration = 197;
                break;
            case 35:
                duration = 205;
                break;
            case 36:
                duration = 210;
                break;
            case 37:
                duration = 217;
                break;
            case 38:
                duration = 223;
                break;
            case 39:
                duration = 230;
                break;
            case 40:
                duration = 235;
                break;
            case 41:
                duration = 241;
                break;
            case 42:
                duration = 246;
                break;
            case 43:
                duration = 253;
                break;
            case 44:
                duration = 256;
                break;
            case 45:
                duration = 264;
                break;
            case 46:
                duration = 270;
                break;
            case 47:
                duration = 276;
                break;
            case 48:
                duration = 282;
                break;
            case 49:
                duration = 287;
                break;
            case 50:
                duration = 293;
                break;
            case 51:
                duration = 299;
                break;
            case 52:
                duration = 305;
                break;
            case 53:
                duration = 312;
                break;
            case 54:
                duration = 318;
                break;
            case 55:
                duration = 325;
                break;
            case 56:
                duration = 331;
                break;
            case 57:
                duration = 337;
                break;
            case 58:
                duration = 344;
                break;
            case 59:
                duration = 349;
                break;
            case 60:
                duration = 356;
                break;
            case 61:
                duration = 361;
                break;
            case 62:
                duration = 362;
                break;
            case 63:
                duration = 375;
                break;
            case 64:
                duration = 377;
                break;
            case 65:
                duration = 382;
                break;
            case 66:
                duration = 392;
                break;
            case 67:
                duration = 396;
                break;
            case 68:
                duration = 402;
                break;
            case 69:
                duration = 409;
                break;
            case 70:
                duration = 415;
                break;
            case 71:
                duration = 422;
                break;
            case 72:
                duration = 427;
                break;
            case 73:
                duration = 435;
                break;
            case 74:
                duration = 440;
                break;
            case 75:
                duration = 447;
                break;
            case 76:
                duration = 456;
                break;
            case 77:
                duration = 459;
                break;
            case 78:
                duration = 468;
                break;
            case 79:
                duration = 474;
                break;
            case 80:
                duration = 478;
                break;
            case 81:
                duration = 484;
                break;
            case 82:
                duration = 489;
                break;
            case 83:
                duration = 497;
                break;
            case 84:
                duration = 504;
                break;
            case 85:
                duration = 508;
                break;
            case 86:
                duration = 514;
                break;
            case 87:
                duration = 518;
                break;
            case 88:
                duration = 527;
                break;
            case 89:
                duration = 533;
                break;
            case 90:
                duration = 539;
                break;
            case 91:
                duration = 547;
                break;
            case 92:
                duration = 552;
                break;
            case 93:
                duration = 557;
                break;
            case 94:
                duration = 564;
                break;
            case 95:
                duration = 579;
                break;
            case 96:
                duration = 576;
                break;
            case 97:
                duration = 582;
                break;
            case 98:
                duration = 590;
                break;
            case 99:
                duration = 595;
                break;
            case 100:
                duration = 600;
                break;


        }
    }
}
