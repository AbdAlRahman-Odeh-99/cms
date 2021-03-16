import requests

def sendUserRequest(userId,name,email,phone,address,carMake,carModel,carYear):
    #url = 'http://192.168.101.72:3000/send-user-information'
    url = 'http://192.168.43.36:3000/send-user-information'
    data = {"userId":userId,"name":name,"phone":phone,"address":address,"email":email,
            "carMake":carMake,"carModel":carModel,"carYear":carYear}
    try:
        res = requests.post(url,data)
        return ("User request sent successfully.     "+res);
    except:
        return ("Error with sending user request.")

def sendLocationRequest(userId,lon,lat):
    #url = 'http://192.168.101.72:3000/send-location-information'
    url = 'http://192.168.43.36:3000/send-location-information'
    data = {"userId":userId,"lon": lon, "lat": lat}
    try:
        res = requests.post(url,data)
        return ("Location request sent successfully. "+res);
    except:
        return ("Error with sending location request.")


def sendCarStatsRequest(userId,speed,rpm,engineTemp,fuelLevel,oilTemp):
    #url = 'http://192.168.101.72:3000/send-car-stats'
    url = 'http://192.168.43.36:3000/send-car-stats'
    data = {"userId":userId,"speed": speed, "engineTemp": engineTemp, "oilTemp": oilTemp, "rpm": rpm, "fuelLevel": fuelLevel}
    try:
        res = requests.post(url, data)
        return ("Car stats request sent successfully. "+res);
    except:
        return ("Error with sending car stats request.")
