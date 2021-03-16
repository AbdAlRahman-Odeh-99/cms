package consumer_test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import org.apache.kafka.connect.json.JsonDeserializer;

public class Consumer implements Runnable {

    //Defining attributes
    private KafkaConsumer consumer;
    private String topic;//Name of the topic of this thread
    private String[] userInformation,carInformation,locationInformation,carStats; //Used to store record's data
    private static HashMap<String,UserPanel> panels = new HashMap<String,UserPanel>(); //Hashmap containing panels 
    private static boolean firstTime = true; //Boolean, to skip reading llocation and stats if it's the user's firs time
    
    //Constructor
    public Consumer (String topic)
    {
        //Sets this thread to the specified topic
        this.topic = topic;
    }
    
    private void init()
    {
        //Creating properties of Consumer
        Properties consumerProps = new Properties();
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "userTestGroup-5");
        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class.getName());
        
        //Check topic to create the right consumer group
        if(this.topic.contains("user"))
        {
            consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "userTestGroup-1");
            consumerProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"false");
        }
        else if (this.topic.contains("location"))
            consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "locationTestGroup-1");
        else if (this.topic.contains("car-stats"))
            consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "carStatsTestGroup-1");
            
        //Creating stream and consumer
        consumer = new KafkaConsumer<String, String>(consumerProps);
       
        //Consuming store
        consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run()
    {
        //Setting up the kafka consumer
        init();
       
        //Loop for reading data from topics
        while (true)
        {
            //Polling records
            ConsumerRecords<String, JsonNode> records = consumer.poll(Duration.ofMillis(100));
            //Going through records
            for (ConsumerRecord<String, JsonNode> record : records)
            {
                //Each topic has a specific buisness accosiated with it
                if(this.topic.contains("kafkaJS-user-test"))
                {
                    //Store userInformation from the record
                    userInformation = new String[] {record.key().toString().replaceAll("\"", ""),
                                                    record.value().get("name").toString().replaceAll("\"", ""),
                                                    record.value().get("email").toString().replaceAll("\"", ""),
                                                    record.value().get("phone").toString().replaceAll("\"", ""),
                                                    record.value().get("address").toString().replaceAll("\"", "")
                    };
                    //Store carInformation from the record
                    carInformation = new String[] {record.value().get("carMake").toString().replaceAll("\"", ""),
                                                   record.value().get("carModel").toString().replaceAll("\"", ""),
                                                   record.value().get("carYear").toString().replaceAll("\"", "")
                    };
                    //Creating a panel to use
                    UserPanel userPanel = new UserPanel();
                    //Check if a anel with the accosiated record key exists
                    if(panels.get(record.key()) == null){
                        //If no panel was found, push the new panel into the map of panels
                        panels.put(record.key(),userPanel);
                        firstTime = false;
                        //Update the information on the created panel
                        userPanel.updateUserInformation(userInformation);
                        userPanel.updateCarInformation(carInformation);
                        //Add the new panel to the tapped menu
                        MainView.addToTappedPanel(userInformation[1],userPanel);
                    }
                    else{
                        //If the panel exists, get and deal with it
                        userPanel = panels.get(record.key());
                        //Update the information on the retreived panel
                        userPanel.updateUserInformation(userInformation);
                        userPanel.updateCarInformation(carInformation);
                    }
                }
                else if(this.topic.contains("kafkaJS-location-test"))
                {
                    //If it's the first time, skip
                    if(!firstTime){
                        //Get the panel for that user
                        UserPanel panel = panels.get(record.key());
                        //Store locationInformation from the record
                        locationInformation = new String [] {record.value().get("lat").toString().replaceAll("\"", ""),
                                                            record.value().get("lon").toString().replaceAll("\"", ""),
                                                            record.value().get("time").toString().replaceAll("\"", "")
                        };
                    
                        try{
                            //Update the information on the retreived panel
                            panel.updatelocationInformation(locationInformation);
                        }catch(NullPointerException e)
                        {
                            System.out.println("Panel inside Location is null.");
                            continue;
                        }
                    }
                }
                else if(this.topic.contains("kafkaJS-car-stats-test"))
                {
                    //If it's the first time, skip
                    if(!firstTime){
                        UserPanel panel = panels.get(record.key());
                        //Store locationInformation from the record
                        carStats = new String [] {record.value().get("speed").toString().replaceAll("\"", ""),
                                                  record.value().get("engineTemp").toString().replaceAll("\"", ""),
                                                  record.value().get("oilTemp").toString().replaceAll("\"", ""),
                                                  record.value().get("rpm").toString().replaceAll("\"", ""),
                                                  record.value().get("fuelLevel").toString().replaceAll("\"", ""),
                                                  record.value().get("time").toString().replaceAll("\"", ""),
                        };
                    
                        try{
                            //Update the information on the retreived panel
                            panel.updateCarStats(carStats);
                        }catch(NullPointerException e)
                        {
                            System.out.println("Panel inside Car Stats is null.");
                            continue;
                        }         
                    }
                }
            }
        }
    }
}
