package com.adventurer.springserialport.connector;

import com.adventurer.springserialport.connector.SpringSerialPortConnector;
import com.adventurer.springserialport.connector.properties.SerialPortProperties;
import gnu.io.NRSerialPort;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPortEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TooManyListenersException;

/**
 * @Author Claudia López
 * @Author Diego Sepúlveda
 */
public abstract class AbstractSpringSerialPortConnector implements SpringSerialPortConnector {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private BufferedReader input;

    private NRSerialPort serial;

    @Autowired
    private SerialPortProperties serialPortProperties;


    @PostConstruct
    public void connect() throws TooManyListenersException, NoSuchPortException {
        log.info("ArduinoConnection PostConstruct callback: connecting to Arduino...");

        serial = new NRSerialPort(serialPortProperties.getPortName(), serialPortProperties.getBaudRate());
        serial.connect();

        if (serial.isConnected()) {
            log.info("Arduino connection opened!");
        } else {
            throw new RuntimeException("Is not possible to open connection in " + serialPortProperties.getPortName() + " port");
        }
        serial.addEventListener(this);
        serial.notifyOnDataAvailable(true);
        input = new BufferedReader(new InputStreamReader(serial.getInputStream()));
    }

    @PreDestroy
    public void disconnect() {

        log.info("ArduinoConnection PreDestroy callback: disconnecting from Arduino...");

        if (serial != null && serial.isConnected()) {
            serial.disconnect();

            if (!serial.isConnected()) {
                log.info("Arduino connection closed!");
            }
        }
    }


    @Override
    public void sendMessage(String message) throws IOException {
        DataOutputStream stream = new DataOutputStream(serial.getOutputStream());
        stream.write(message.getBytes());
        log.info("Enviando a arduino: {} ", message);
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        log.info("Leyendo");

        if (serialPortEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            log.info("Datos disponibles");
            try {
                if (input.ready()) {
                    processData(input.readLine());
                }

            } catch (Exception e) {
                log.error("Error ", e);
            }
        }
    }

    protected abstract void processData(String line);
}
