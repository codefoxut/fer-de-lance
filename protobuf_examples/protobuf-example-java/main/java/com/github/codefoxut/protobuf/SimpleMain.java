package com.github.codefoxut.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args){
        System.out.println("Hello World!");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();
        SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();

        builder.setId(1);
        builder.setName("this is first");
        builder.setIsSimple(false);

        builder.addSampleList(1);
        builder.addSampleList(3);
        builder.addSampleList(5);

        builder2.setId(10)
                .setIsSimple(true)
                .setName("This is simple");

        builder2.addAllSampleList(Arrays.asList(4, 8, 16));

        System.out.println(builder.toString());
        System.out.println(builder2.toString());


        SimpleMessage message = builder.build();

        try {
            FileOutputStream os = new FileOutputStream("simple_message.bin");
            message.writeTo(os);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // send as bytes array
        byte[] bytes = message.toByteArray();


        System.out.println("Reading from file...");
        try {
            FileInputStream is = new FileInputStream("simple_message.bin");
            SimpleMessage msg = SimpleMessage.parseFrom(is);
            System.out.println(msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
