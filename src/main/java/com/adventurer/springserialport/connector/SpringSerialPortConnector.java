package com.adventurer.springserialport.connector;

import gnu.io.SerialPortEventListener;

import java.io.IOException;
/**
 * @author Claudia López
 * @author Diego Sepúlveda
 */
public interface SpringSerialPortConnector extends SerialPortEventListener {

    void sendMessage(String message) throws IOException;
}
