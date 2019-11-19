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
        return hexStr.toUpperCase();
    }

    //decimal to binary
    public static String decToBin(String d) {
        int decimal = Integer.parseInt(d);
        String bin = Integer.toBinaryString(decimal);
        return bin;
    }
    //binary to decimal

}
