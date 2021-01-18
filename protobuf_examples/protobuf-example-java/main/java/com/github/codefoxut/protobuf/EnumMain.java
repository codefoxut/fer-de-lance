package com.github.codefoxut.protobuf;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {

    public static void main(String[] args) {

        System.out.println("Example for Enums");

        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(15);

        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY);

        EnumMessage msg = builder.build();

        System.out.println(msg);
    }
}
