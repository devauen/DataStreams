package com.proartz;

import java.io.*;
import java.math.BigDecimal;

public class DataStreams {
    public static final String dataName = "data.dat";

    public static final BigDecimal[] prizes = {
            new BigDecimal(9.99),
            new BigDecimal(10.23),
            new BigDecimal(5.20),
            new BigDecimal(6.40)};
    public static final int[] units = {12, 8, 4, 5,};
    public static final String descriptions[] = {
            "Java T-Shirt",
            "Java Mug",
            "Java Book",
            "Java Development Kit"};

    public static void main(String[] args) throws IOException, ClassNotFoundException{
//        ObjectOutputStream output = null;
//        try {
//            output = new ObjectOutputStream(new BufferedOutputStream(
//                        new FileOutputStream(dataName)));
//
//            for(int i = 0; i < prizes.length; i++) {
//                output.writeObject(prizes[i]);
//                output.writeInt(units[i]);
//                output.writeUTF(descriptions[i]);
//            }
//        } finally {
//            if(output != null) {
//                output.close();
//            }
//        }

        ObjectInputStream input = null;

        BigDecimal price;
        int unit;
        String description;
        BigDecimal total = new BigDecimal(0);

        try{
            input = new ObjectInputStream(new BufferedInputStream(
                        new FileInputStream(dataName)));

            while(true) {
                price = (BigDecimal)input.readObject();
                unit = input.readInt();
                description = input.readUTF();
                System.out.format("You bought %d units of %s for %.2f.%n",
                        unit, description, price);

                total = total.add(price.multiply(new BigDecimal(unit)));
            }
        } catch(EOFException e) {

        }
        System.out.format("Total: %.2f", total);
    }
}
