package com.adventurer.springserialport.connector.impl;

import com.adventurer.springserialport.connector.AbstractSpringSerialPortConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Claudia López
 * @Author Diego Sepúlveda
 */
@Component
public class DefaultSpringSerialPortConnectorImpl extends AbstractSpringSerialPortConnector {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void processData(String line) {
        log.info(line);
    }
}
