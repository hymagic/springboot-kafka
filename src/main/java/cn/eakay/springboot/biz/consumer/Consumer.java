package cn.eakay.springboot.biz.consumer;

import cn.eakay.springboot.client.Eakay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by magic~ on 2018/4/26.
 */
@Component
public class Consumer
{
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    @KafkaListener(topics = {"kafka-topic"})
    public void processMessage(Eakay eakay) {


        logger.info("========"+eakay.getId()+"-"+eakay.getName()+"-"+eakay.getTitle());
    }
/*
    @KafkaListener(topics = {"kafka-topic"})
    public void processMessage(String eakay) {
        logger.info("========"+eakay);
    }*/
}
