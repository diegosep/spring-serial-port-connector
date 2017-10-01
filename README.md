# Spring Serial Port Connector

Is a Spring library to read/write a serial/usb port in your Spring App. Based on 
- Spring Boot
- NeuronRobotic Library https://github.com/NeuronRobotics/nrjavaserial

## Maven Dependency

```
<dependency>
    <groupId>com.adventurer.springserialport</groupId>
    <artifactId>spring-serial-port-connector</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
## How to use it
This library needs two properties

```
springSerialPortConnector.portName= #Serial port name, depends on your operative system
springSerialPortConnector.baudRate= #Baud serial rate transmition 
```

### Example

For a Linux System
```
springSerialPortConnector.portName=/dev/ttyACM0
springSerialPortConnector.baudRate=9600
```

## Authors
@diego522
@lopita

