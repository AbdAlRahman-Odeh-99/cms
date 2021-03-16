import random
import time
from SendRequest import sendCarStatsRequest

def generate():
    while (1):
        speed = round(random.uniform(0, 240), 2)
        engineTemp = round(random.uniform(75, 105), 2)
        oilTemp = round(random.uniform(85, 95), 2)
        rpm = random.randrange(0, 7000, 1000)
        fuel_level_values = ['low','mid','high']
        fuelLevel = random.choice(fuel_level_values)
        sendCarStatsRequest("122900",speed,engineTemp,oilTemp,rpm,fuelLevel)
        print(('speed: {} Kph \n coolant temperature: {} C \n oil temperature: {} C \n rpm: {} rad/s \n fuel: {}')
              .format(speed, engineTemp, oilTemp, rpm, fuelLevel))
        print("-------------------------------------------")
        time.sleep(1)

generate()


