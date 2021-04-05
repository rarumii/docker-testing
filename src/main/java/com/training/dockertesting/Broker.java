package com.training.dockertesting;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Broker {

    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory factory = getDockerConnectionFactory();

// 		Create a connection
        return factory.newConnection();
    }

    private static ConnectionFactory getDockerConnectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();

        //docker run -d -p 15672:15672 -p 5672:5672 --name rabbit-test rabbitmq:3-management

        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        return factory;
    }

}
