package com.github.codefoxut.protobuf;

import example.complex.Complex;
import example.complex.Complex.*;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {

        System.out.println("Complex Example.");
        DummyMessage.Builder builder = DummyMessage.newBuilder();

        DummyMessage msg = builder.setId(22).setName("first dummy").build();

        DummyMessage msg2 = newDummyMessage(23, "second dummy");

        ComplexMessage.Builder complex_builder = ComplexMessage.newBuilder();
        complex_builder.setOneDummy(msg).addMultipleDummy(msg2);
        complex_builder.addAllMultipleDummy(Arrays.asList(
                newDummyMessage(56, "third"),
                newDummyMessage(67, "fourth")
        ));


        ComplexMessage msg3 = complex_builder.build();

        System.out.println(msg3);


    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder builder = DummyMessage.newBuilder();

        return builder.setId(id).setName(name).build();
    }
}
