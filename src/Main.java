import java.math.BigInteger;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //Initialize the Hashmap for Instructions
        HashMap<String, String> instructions = new HashMap<>();
        instructions.put("ADD", "0000");
        instructions.put("ADDI", "0001");
        instructions.put("AND", "0010");
        instructions.put("ANDI", "0011");
        instructions.put("OR", "0100");
        instructions.put("ORI", "0101");
        instructions.put("XOR", "0110");
        instructions.put("XORI", "0111");
        instructions.put("JUMP", "1000");
        instructions.put("LD", "1001");
        instructions.put("ST", "1010");
        instructions.put("BEQ", "1011");
        instructions.put("BLT", "1100");
        instructions.put("BGT", "1101");
        instructions.put("BLE", "1110");
        instructions.put("BGE", "1111");


        //Initialize the Hashmap for Registers
        HashMap<String, String> registers = new HashMap<>();
        instructions.put("R0", "0000");
        instructions.put("R1", "0001");
        instructions.put("R2", "0010");
        instructions.put("R3", "0011");
        instructions.put("R4", "0100");
        instructions.put("R5", "0101");
        instructions.put("R6", "0110");
        instructions.put("R7", "0111");
        instructions.put("R8", "1000");
        instructions.put("R9", "1001");
        instructions.put("R10", "1010");
        instructions.put("R11", "1011");
        instructions.put("R12", "1100");
        instructions.put("R13", "1101");
        instructions.put("R14", "1110");
        instructions.put("R15", "1111");

        //Hashmaplerin oluşturulması için daha kısa kod yaz.
        /*
        //Initialize the Register for Instructions
        HashMap<String, String> registers = new HashMap<>();
        for (int i = 0; i < 16; i++) {
            String value = Integer.toBinaryString(i);
            registers.put("R" + i, i);
        }
        */

    }
}
