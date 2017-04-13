package Messumformer.Values.X;

/**
 * Created by udlab on 03.04.17.
 */
public class XVoltage {

    int duration;
    private static XVoltage ourInstance = new XVoltage();

    public static XVoltage getInstance() {
        return ourInstance;
    }

    private XVoltage() {
        this.duration = 35;
    }

    public int getDuration(int percentage){
        durationForPercentage(percentage);
        return duration;
    }

    private void durationForPercentage(int percentage) {

        switch (percentage) {
            case 0:
                duration = 10;
                break;
            case 1:
                duration = 40;
                break;
            case 2:
                duration = 44;
                break;
            case 3:
                duration = 49;
                break;
            case 4:
                duration = 52;
                break;
            case 5:
                duration = 54;
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
                duration = 66;
                break;
            case 10:
                duration = 70;
                break;
            case 11:
                duration = 73;
                break;
            case 12:
                duration = 76;
                break;
            case 13:
                duration = 80;
                break;
            case 14:
                duration = 83;
                break;
            case 15:
                duration = 87;
                break;
            case 16:
                duration = 91;
                break;
            case 17:
                duration = 98;
                break;
            case 18:
                duration = 103;
                break;
            case 19:
                duration = 109;
                break;
            case 20:
                duration = 115;
                break;
            case 21:
                duration = 119;
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
                duration = 149;
                break;
            case 27:
                duration = 154;
                break;
            case 28:
                duration = 160;
                break;
            case 29:
                duration = 166;
                break;
            case 30:
                duration = 172;
                break;
            case 31:
                duration = 179;
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
                duration = 204;
                break;
            case 36:
                duration = 211;
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
                duration = 236;
                break;
            case 41:
                duration = 242;
                break;
            case 42:
                duration = 247;
                break;
            case 43:
                duration = 253;
                break;
            case 44:
                duration = 259;
                break;
            case 45:
                duration = 265;
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
                duration = 288;
                break;
            case 50:
                duration = 294;
                break;
            case 51:
                duration = 299;
                break;
            case 52:
                duration = 306;
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
                duration = 332;
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
                duration = 362;
                break;
            case 62:
                duration = 368;
                break;
            case 63:
                duration = 373;
                break;
            case 64:
                duration = 379;
                break;
            case 65:
                duration = 385;
                break;
            case 66:
                duration = 391;
                break;
            case 67:
                duration = 397;
                break;
            case 68:
                duration = 402;
                break;
            case 69:
                duration = 409;
                break;
            case 70:
                duration = 416;
                break;
            case 71:
                duration = 421;
                break;
            case 72:
                duration = 428;
                break;
            case 73:
                duration = 434;
                break;
            case 74:
                duration = 441;
                break;
            case 75:
                duration = 447;
                break;
            case 76:
                duration = 454;
                break;
            case 77:
                duration = 460;
                break;
            case 78:
                duration = 467;
                break;
            case 79:
                duration = 473;
                break;
            case 80:
                duration = 480;
                break;
            case 81:
                duration = 485;
                break;
            case 82:
                duration = 491;
                break;
            case 83:
                duration = 497;
                break;
            case 84:
                duration = 503;
                break;
            case 85:
                duration = 509;
                break;
            case 86:
                duration = 515;
                break;
            case 87:
                duration = 520;
                break;
            case 88:
                duration = 527;
                break;
            case 89:
                duration = 532;
                break;
            case 90:
                duration = 538;
                break;
            case 91:
                duration = 545;
                break;
            case 92:
                duration = 551;
                break;
            case 93:
                duration = 557;
                break;
            case 94:
                duration = 563;
                break;
            case 95:
                duration = 569;
                break;
            case 96:
                duration = 576;
                break;
            case 97:
                duration = 581;
                break;
            case 98:
                duration = 588;
                break;
            case 99:
                duration = 594;
                break;
            case 100:
                duration = 620;
                break;


        }
    }
}
