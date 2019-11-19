import java.io.FileReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String> instructions = initializeInstructionMap();
        HashMap<String, String> registers = initializeRegisterMap();

        BufferedReader reader;
        String line;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            line = reader.readLine();
            while(line != null){
                System.out.println(instructionToBinary(line));
                line = reader.readLine();

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //TODO
        //Input okundu, output a çevirilecek (outputBinary.txt e yazılacak).
        //Outut.txt deki binary'yi satır satır hex e çevir, outputHex.txt e yaz.

    }

    //Hashmaplerin oluşturulması için daha kısa kod yaz.
        /*
        //Initialize the Register for Instructions
        HashMap<String, String> registers = new HashMap<>();
        for (int i = 0; i < 16; i++) {
            String value = Integer.toBinaryString(i);
            registers.put("R" + i, i);
        }
        */

    public static HashMap<String, String> initializeInstructionMap(){
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
        return instructions;
    }

    public static HashMap<String, String> initializeRegisterMap(){
        //Initialize the Hashmap for Registers
        HashMap<String, String> registers = new HashMap<>();
        registers.put("R0", "0000");
        registers.put("R1", "0001");
        registers.put("R2", "0010");
        registers.put("R3", "0011");
        registers.put("R4", "0100");
        registers.put("R5", "0101");
        registers.put("R6", "0110");
        registers.put("R7", "0111");
        registers.put("R8", "1000");
        registers.put("R9", "1001");
        registers.put("R10", "1010");
        registers.put("R11", "1011");
        registers.put("R12", "1100");
        registers.put("R13", "1101");
        registers.put("R14", "1110");
        registers.put("R15", "1111");
        return registers;
    }


    public static String instructionToBinary(String line){
        HashMap<String, String> instructions = initializeInstructionMap();
        HashMap<String, String> registers = initializeRegisterMap();
        String binary;
        String opcode[];
        String dataElement[];
        opcode = line.split(" ");

        binary = instructions.get(opcode[0]);
        dataElement = opcode[1].split(",");

        if(opcode[0].compareTo("ADD") == 0 || opcode[0].compareTo("AND") == 0 || opcode[0].compareTo("OR") == 0 ||opcode[0].compareTo("XOR") == 0) {
            binary += registers.get(dataElement[0]);
            binary += registers.get(dataElement[1]);
            binary += registers.get(dataElement[2]);
            binary +="00";
        } else if(opcode[0].compareTo("ADDI") == 0 || opcode[0].compareTo("ANDI") == 0 || opcode[0].compareTo("ORI") == 0 ||opcode[0].compareTo("XORI") == 0){
            binary += registers.get(dataElement[0]);
            binary += registers.get(dataElement[1]);
            binary += Converter.decToBin(dataElement[2], 6);
        } else if(opcode[0].compareTo("JUMP") == 0) {
            binary += Converter.decToBin(dataElement[0], 14);
       } else if(opcode[0].compareTo("LD") == 0 || opcode[0].compareTo("ST") == 0) {
            binary += registers.get(dataElement[0]);
            binary += Converter.decToBin(dataElement[1], 10);
       } else if(opcode[0].compareTo("BEQ") == 0) {
            binary += registers.get(dataElement[0]);
            binary += registers.get(dataElement[1]);
            binary += Converter.decToBin(dataElement[2], 3);
            binary += "010";
        } else if(opcode[0].compareTo("BLT") == 0) {
            binary += registers.get(dataElement[0]);
            binary += registers.get(dataElement[1]);
            binary += Converter.decToBin(dataElement[2], 3);
            binary += "100";
        } else if(opcode[0].compareTo("BGT") == 0) {
            binary += registers.get(dataElement[0]);
            binary += registers.get(dataElement[1]);
            binary += Converter.decToBin(dataElement[2], 3);
            binary += "001";
        } else if(opcode[0].compareTo("BLE") == 0) {
            binary += registers.get(dataElement[0]);
            binary += registers.get(dataElement[1]);
            binary += Converter.decToBin(dataElement[2], 3);
            binary += "110";
        } else if(opcode[0].compareTo("BGE") == 0) {
            binary += registers.get(dataElement[0]);
            binary += registers.get(dataElement[1]);
            binary += Converter.decToBin(dataElement[2], 3);
            binary += "011";
       }


        return binary;
    }
}
