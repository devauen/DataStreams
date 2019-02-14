package com.proartz;

import java.io.*;

public class DataStreams {
    public static final String dataName = "data.txt";

    public static final double[] prizes = {9.99, 10.23, 5.20, 6.40};
    public static final int[] units = {12, 8, 4, 5,};
    public static final String descriptions[] = {
            "Java T-Shirt",
            "Java Mug",
            "Java Book",
            "Java Development Kit"};

    public static void main(String[] args) throws IOException{
//        DataOutputStream output = null;
//        try {
//            output = new DataOutputStream(new BufferedOutputStream(
//                        new FileOutputStream(dataName)));
//
//            for(int i = 0; i < prizes.length; i++) {
//                output.writeDouble(prizes[i]);
//                output.writeInt(units[i]);
//                output.writeUTF(descriptions[i]);
//            }
//        } finally {
//            if(output != null) {
//                output.close();
//            }
//        }

        DataInputStream input = null;

        double prize;
        int unit;
        String description;
        double total = 0;

        try{
            input = new DataInputStream(new BufferedInputStream(new FileInputStream(dataName)));

            while(true) {
                prize = input.readDouble();
                unit = input.readInt();
                description = input.readUTF();
                System.out.format("You bought %d units of %s for %.2f.%n", unit, description, prize);

                total += prize * unit;
            }
        } catch(EOFException e) {

        }
        System.out.format("Total: %.2f", total);
    }
}
