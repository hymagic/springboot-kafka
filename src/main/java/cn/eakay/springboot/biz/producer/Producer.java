package cn.eakay.springboot.biz.producer;

import cn.eakay.springboot.client.Eakay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by magic~ on 2018/4/26.
 */
@Component
@EnableScheduling
public class Producer
{

    @Autowired
    private KafkaTemplate   kafkaTemplate;


    private static int count= 0;

    @Scheduled(fixedDelay=3000)
    public void send(){
        Eakay  eakay=new Eakay();
        eakay.setId(count++);
        eakay.setName("aaa");
        eakay.setTitle("aaa");
        kafkaTemplate.send("kafka-topic",eakay);
        //jmsTopicTemplate.convertAndSend("VirtualTopic.topic","hi,activeMQ( topic )，index="+count++);

    }
}
