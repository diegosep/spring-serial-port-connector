package com.adventurer.springserialport.connector.properties;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @Author Claudia López
 * @Author Diego Sepúlveda
 */

@Component
@ConfigurationProperties(prefix = "springSerialPortConnector")
public @Data
class SerialPortProperties {

    /**
     * Port used in the application
     */
    @NonNull
    private String portName;

    /**
     * This is the baudRate to use for read and write data in the serial port
     */
    @NonNull
    private int baudRate;
}
