package com.github.codefoxut.protobuf;

import example.simple.Simple;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.util.Arrays;

public class ProtoToJSONMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        System.out.println("Hello World!");

        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();
        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();

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

        // print this as a JSON
        String jsonString = JsonFormat.printer()
                .includingDefaultValueFields()
                .print(builder2);
        System.out.println(jsonString);

        // parse JSON to protobuf
        Simple.SimpleMessage.Builder builder3 = Simple.SimpleMessage.newBuilder();

        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder3);

        System.out.println(builder3.build());
    }

}
