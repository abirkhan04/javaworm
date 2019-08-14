package springbootwithkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@SpringBootApplication
@EnableKafka
public class KafkaProducerApplication implements ApplicationRunner{

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
         
    public void sendMessage(String msg) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("javaworm", msg);
        
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
     
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + msg + 
                  "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                  + msg + "] due to : " + ex.getMessage());
            }
        });
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		sendMessage("This is a test message to Kafka");
	}
}
