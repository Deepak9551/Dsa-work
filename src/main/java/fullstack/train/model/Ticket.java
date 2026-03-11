package fullstack.train.model;

import lombok.Getter;

public class Ticket {
    private Integer ticketId;
    private Train train;
    private User user;
    private Integer bookedSeats;
    private Double totalPrice;

    @Getter
    private static Integer counter = 10000;

    public Ticket( Train train, User user, Integer bookedSeats, Double totalPrice) {
        this.ticketId = counter++;
        this.train = train;
        this.user = user;
        this.bookedSeats = bookedSeats;
        this.totalPrice = totalPrice;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(Integer bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static void setCounter(Integer counter) {
        Ticket.counter = counter;
    }



    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", train=" + train.getName() +
                ", user=" + user.getUsername() +
                "route "  + train.getSource() + " to " + train.getDestination() +
                ", bookedSeats=" + bookedSeats +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
