package fullstack.train.model;

// Train Entity Design

import java.time.LocalDateTime;

public class Train {

    private Integer trainId;

    private String name;

    private String source;

    private  String destination;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private Integer totalSeats;

    private Integer availableSeats;
// when a new train is created
    // then available seats = total seats

    public Train(Integer trainId, String name, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Integer totalSeats) {
        this.trainId = trainId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    // check karna hai ki train mai seats hai ya nahi
    // ex ->
    // available seats (3) ya want seat se jayada ho ya equal ho toh book
    public boolean isSeatAvailable(Integer bookingSeats){


        return this.availableSeats >= bookingSeats;
    }

    public void bookSeat(Integer bookingSeats){
        if(isSeatAvailable(bookingSeats)) this.availableSeats -= bookingSeats;
        else throw new RuntimeException("Not enough seats available");
    }

    public boolean isRouteAvailable(String source, String destination){

    return this.getDestination().equalsIgnoreCase(destination) && this.source.equalsIgnoreCase(source);
    }

    public void cancelSeat(Integer cancelSeats){
        this.availableSeats += cancelSeats;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
