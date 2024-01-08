package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {


        String bootstrapServers = "0.tcp.sa.ngrok.io:17096";

        // create Producer properties
        Properties props=new Properties();
        props.put("bootstrap.servers",bootstrapServers);
        props.put("acks","1");
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        // create the producer
        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer<>(props);
        //KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // create a producer record
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("topic-sample", "hildebrando");

        // send data - asynchronous
        producer.send(producerRecord);

        // flush data - synchronous
        producer.flush();
        // flush and close producer
        producer.close();
    }
}