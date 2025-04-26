package org.example.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {

    private String trainId;
    private String trainNo;
    private List<String>stations;
    private List<List<Integer>>seats;
    private Map<String, String>stationsTime;

    public Train(String trainId, String trainNo, List<String> stations, List<List<Integer>> seats, Map<String, String> stationsTime) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.stations = stations;
        this.seats = seats;
        this.stationsTime = stationsTime;
    }

    public Train() {
    }


    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public Map<String, String> getStationsTime() {
        return stationsTime;
    }

    public void setStationsTime(Map<String, String> stationsTime) {
        this.stationsTime = stationsTime;
    }

    public String trainInfo(){
        return String.format("Train ID: %s Train No: %s", trainId, trainNo);
    }
}
