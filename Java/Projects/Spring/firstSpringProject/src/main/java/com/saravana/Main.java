package com.saravana;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorldXml = (HelloWorld) xmlContext.getBean("helloWorld");
        // Override the message defined in XML by setting a new one in code
        helloWorldXml.setMessage("Hello from Main.java!");
        helloWorldXml.printMessage();
    }
}