package com.adventurer.springserialport.connector;

import gnu.io.SerialPortEventListener;

import java.io.IOException;
/**
 * @Author Claudia López
 * @Author Diego Sepúlveda
 */
public interface SpringSerialPortConnector extends SerialPortEventListener {

    void sendMessage(String message) throws IOException;
}
