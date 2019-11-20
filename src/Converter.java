import java.math.BigInteger;

public class Converter {
    //hex to binary
    public static String hexToBin(String s) {
        return new BigInteger(s, 16).toString(2);
    }

    //binary to hex
    public static String binToHex(String s) {
        int decimal  = Integer.parseInt(s, 2);
        String hexStr = Integer.toString(decimal, 16);

        if(hexStr.length() < 5) {
            int len = hexStr.length();
            for(int i = 0; i < 5 - len; i++){
                hexStr = "0" + hexStr;
            }

        }
        return hexStr.toUpperCase();
    }

    //decimal to binary
    public static String decToBin(String d, int bitCount) {
        int decimal = Integer.parseInt(d);
        String bin = Integer.toBinaryString(decimal);
        if(decimal >= 0){
            int len = bin.length();
            for(int i = 0; i < bitCount - len; i++) {
                bin = "0" + bin;
            }
        } else {
            bin = bin.substring(bin.length()-bitCount);
        }
        return bin;
    }

}
