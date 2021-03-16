const express = require('express');
const bodyParser = require('body-parser');
const kafka = require('kafkajs');
const dateTime = require('date-time');
 
const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));
const PORT = 3000;

var kafkaProducer;

async function setUpProducer()
{
    const kafkaClient = new kafka.Kafka({
        clientId: 'BackendServer',
        brokers: ['localhost:9092']
      });
    kafkaProducer = kafkaClient.producer();
    await kafkaProducer.connect();
}

async function sendData(topic,messages)
{
    await kafkaProducer.send({
        topic:topic,
        messages:messages,
      });  
}

setUpProducer().then(result=>console.log("CREATED PRODUCER")).catch(err =>console.log("ERROR WITH CREATING PRODUCER"));


app.post('/send-user-information',(req,res) => {
    
    console.log("Recieved request /send-user-information");
    userId = req.body.userId; 
    name = req.body.name; email = req.body.email; phone = req.body.phone;  address = req.body.address;
    carMake= req.body.carMake; carModel= req.body.carModel; carYear=req.body.carYear;
    
    topic = "kafkaJS-user-test1";
    messages = [{
        key: userId,
        //value: JSON.stringify
        value: JSON.stringify({ userId:userId , 
                      name:name , email:email , phone:phone , address:address ,
                      carModel:carModel , carMake:carMake , carYear:carYear,
                      time:dateTime()
               }),
    }];
    sendData(topic,messages).then(result=>res.send("User information sent successfully")).catch(err =>res.send("Error with sending user information"));

});

app.post('/send-location-information',(req,res) => {
    
    console.log("Recieved request /send-location-information");
    userId = req.body.userId; lat = req.body.lat; lon = req.body.lon;
    
    topic = "kafkaJS-location-test1";
    messages = [{
        key: userId,
        value: JSON.stringify({ lat:lat , lon:lon , time:dateTime() }),
    }];
    sendData(topic,messages).then(result=>res.send("Location information sent successfully")).catch(err =>res.send("Error with sending location information"));

});


app.post('/send-car-stats',(req,res) => {
    
    console.log("Recieved request /send-car-stats");
    userId = req.body.userId; 
    speed = req.body.speed;     fuelLevel = req.body.fuelLevel;     engineTemp = req.body.engineTemp;
    oilTemp = req.body.oilTemp;     rpm = req.body.rpm;
    
    topic = "kafkaJS-car-stats-test1";
    messages = [{
        key: userId,
        value: JSON.stringify({ speed:speed , engineTemp:engineTemp , oilTemp:oilTemp , rpm:rpm , fuelLevel:fuelLevel , time:dateTime()}),
    }];
    sendData(topic,messages).then(result=>res.send("Car stats sent successfully")).catch(err =>res.send("Error with sending Car stats"));
    
});


app.listen(PORT,()=>console.log("Listening to PORT:"+PORT));