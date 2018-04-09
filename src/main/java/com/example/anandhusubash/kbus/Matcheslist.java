package com.example.anandhusubash.kbus;



class Matcheslist {
    private String id,time,bus,type,destination,number,via;
    public Matcheslist(String id, String time, String bus,String destination,String number,String via){
        this.id=id;
        this.time=time;
        this.bus=bus;
        this.destination=destination;
        this.number=number;
        this.via=via;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }
}
