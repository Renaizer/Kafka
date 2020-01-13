//To load,start and run the Landoop Kafka cluster cluster use command  
//docker run -e ADV_HOST=127.0.0.1 -e EULA="https://dl.lenses.io/d/?id=62e83071-ef7f-46b5-8874-XXXXXXXXXXX" --rm -p  3030:3030 -p 9092:9092 lensesio/box

package simpleConsumer;

import java.time.Duration;
import java.util.*;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class Consumer {

    public static void main(String[] args) throws Exception {

        String topicName = "sea_vessel_position_reports";
        

        Properties props = new Properties();
        props.put("bootstrap.servers", "PLAINTEXT://127.0.0.1:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer  = null;
        Duration pollingDuration = Duration.ofMillis(1000);
        
        try {
	        consumer = new KafkaConsumer<>(props);
	        consumer.subscribe(Arrays.asList(topicName));
	        
	//        ConsumerRecords<String, String> records1 = consumer.poll(10);
	        
	        while (true){
	            ConsumerRecords<String, String> records1 = consumer.poll(pollingDuration);
	            System.out.println("Number of msg recieved = "+records1.count());
	            for (ConsumerRecord<String, String> record: records1) {
	                System.out.println("Supplier id= " + record.toString());
	            }
	        }
        }
        catch (Exception e) {

        }
        finally {
        	consumer.close();
		}
    }
}
    


