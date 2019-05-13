import websocket
import json
import pymongo
import datetime
import pprint
import re


try:
    import thread
except ImportError:
    import _thread as thread
import time



def on_message(ws, message):
    # message loaded to json object
    jsonMessage = json.loads(message)
    
    # we re getting 2 same messages -> skip one of them
    # error when no snr, but ignore now
    snr = jsonMessage["snr"]
    if snr is None:
        print("skip")
        return

    # data required for mongo db
    eui = jsonMessage["EUI"] 
    ts = jsonMessage["ts"]
    data = jsonMessage["data"]

    # eui should be connected to room
    # requires SQL connection
    # TO-DO
    #room = "G037"
    # send room id instead of room name
    # RoomId -> 
    # 
    # EUI -> select id from roomlist where EUI = roomlist.EUI 

    # data needs to be parsed since it s in hex format
    split_data = re.findall('.{1,4}', data)
    
    temp = int(split_data[0], 16)
    hum = int(split_data[1], 16)
    co2 = int(split_data[2], 16)

    # change timestamp to date format
    ts_datetime = datetime.datetime.fromtimestamp(ts/1000)

    # insert into mongodb
    # add room
    mydict = { 
                "UIE": eui, 
                "Room" : 1, 
                "Name": "RANDOM_NAME", 
                "Timestamp" : ts_datetime, 
                "CO2" : str(co2), 
                "Humidity" : str(hum/10), 
                "Temperature" : str(temp/10)     
            }

    col.insert_one(mydict)

    # inserted data -> delete later on
    #print(f"EUI {eui} \n timestamp {ts_datetime} \n Temperature {temp} \n Humidity {hum}")
    print("JOB DONE!")

def on_error(ws, error):
    print(error)

def on_close(ws):
    print("### web socket closed ###")

def on_open(ws):
    print("### open web socket ###")


if __name__ == "__main__":

    # mongo connection
    client = pymongo.MongoClient("mongodb+srv://fadi:Fidodido1940@fadi-pwbgj.mongodb.net/Sep4?retryWrites=true")
    db = client['Sep4']
    col = db['EUI']

    # websockets
    websocket.enableTrace(True)
    ws = websocket.WebSocketApp("wss://iotnet.teracom.dk/app?token=vnoRdgAAABFpb3RuZXQudGVyYWNvbS5kawxTf4lxpFpToHDb5b5vLKk=",
                              on_message = on_message,
                              on_error = on_error,
                              on_close = on_close)
    ws.on_open = on_open
    ws.run_forever()
