package com.javaworm.SpringCloudStream;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaworm.SpringCloudStreamApplication;
import com.javaworm.model.CustomProcessor;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringCloudStreamApplication.class)
@DirtiesContext
@SpringBootTest
public class SpringCloudStreamApplicationTests {

    @Autowired
    private Processor pipe;
    
    @Autowired
    private CustomProcessor cPipe;
 
    @Autowired
    private MessageCollector messageCollector;
 
    @Test
    public void whenSendMessage_thenResponseShouldUpdateText() {
        pipe.input()
          .send(MessageBuilder.withPayload("This is my message")
          .build());
 
        Object payload = messageCollector.forChannel(pipe.output())
          .poll()
          .getPayload();
 
        assertEquals("Converted Message: This is my message", payload.toString());
    }
    
    @Test
    public void whenSendThroughCustomChannel_expetedConditionalOutput() {
        cPipe.myInput().send(MessageBuilder.withPayload(21).build());
        Object payload = messageCollector.forChannel(cPipe.firstOutput()).poll().getPayload();
        assertEquals("Value is greated than 20", payload.toString());
    }
}
