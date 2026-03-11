package fullstack.train.service;

import fullstack.train.model.Ticket;
import fullstack.train.model.Train;
import fullstack.train.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private List<Train> trains = new ArrayList<>();

    private List<Ticket> tickets =  new ArrayList<>();

    private  TrainService trainService = new TrainService();

public BookingService(){
    trains.add(new Train(1, "Train 1", "Agra", "Delhi", LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1), 100 ));
    trains.add(new Train(2, "Train 2", "Mumbai", "Bangalore", LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1), 100));
    trains.add(new Train(3, "Train 3", "Kolkata", "Chennai", LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1), 100));
    trains.add(new Train(4, "Train 4", "Mumbai", "Bangalore", LocalDateTime.now().minusHours(2), LocalDateTime.now().plusHours(2), 300));
    trains.add(new Train(5, "Train 5", "Kolkata", "Chennai", LocalDateTime.now().minusHours(2), LocalDateTime.now().plusHours(2), 500));

    tickets.add(new Ticket(trains.get(0), new User("Raj", "raj@gmail.com", "password1", "9876543210", "Agra", "Male"), 2, 100.0));
    tickets.add(new Ticket(trains.get(1), new User("Shyam", "shyam@gmail.com", "password2", "9876543211", "Mumbai", "Male"), 3, 300.0));
    tickets.add(new Ticket(trains.get(2), new User("Akshay", "akshay@gmail.com", "password3", "9876543212", "Kolkata", "Male"), 5, 500.0));
}

public List<Train> searchTrain(String source , String destination){

   List<Train> searchedTrain = new ArrayList<>();

    trains.forEach(train->{
        // principle of expert train know that route is available or not
      if(train.isRouteAvailable(source,destination)){

          // lamda we can do intialization for local variable
          // ( final or effectively final )
          //😎 BUT modification we can do
         searchedTrain.add(train);
      }
    });

    if(trains.isEmpty()){
        throw new RuntimeException("No train found");
    }
    return searchedTrain;


}

public  void bookTicket(Integer trainId, Integer numberOfSeats){

}

public  List<Train> searchTrainByDate(LocalDateTime date , String source , String destination){

    List<Train> searchedTrain = new ArrayList<>();
    List<Train> foundTrain = searchTrain(source, destination);

    foundTrain.forEach(train->{
        if(train.getDepartureTime().isAfter(date)){
            searchedTrain.add(train);
        } else if (train.getDestination().equals(destination)) {
            searchedTrain.add(train);
        }
    });
    if(searchedTrain.isEmpty()){
        throw new RuntimeException("No train found");
    }
    return searchedTrain;

}

public  void bookTicket(User user , Integer trainId , Integer noOfSeats){

    trains.forEach(t->{
       if ( t.getTrainId().equals(trainId)){

           t.bookSeat(noOfSeats);
           tickets.add(new Ticket(t, user, noOfSeats, noOfSeats * 100.0));
       return;
       }
    });
    System.out.println("Ticket not booked found");
}

public void cancelTicket(Integer trainId, Integer numberOfSeats){

    trains.forEach(t->{
        if(t.getTrainId().equals(trainId)){
            System.out.println("Ticket cancelled successfully");
            t.cancelSeat(numberOfSeats);
            // remove ticket from tickets list ( based on the predicate )
            tickets.removeIf(ticket -> ticket.getTrain().getTrainId().equals(trainId));
        }
    });
}

public void showAllTickets(){
    tickets.forEach(System.out::println);
}

public  void showAllUserTicket(String username){
    tickets.forEach(ticket->{
        if(ticket.getUser().getUsername().equalsIgnoreCase(username)){
            System.out.println(ticket);
        }
    });
}

public void cancelTicket(Integer ticketId , User user){
    tickets.forEach(t->{
        if(t.getTicketId().equals(ticketId) && user.equals(t.getUser())){
            System.out.println("Ticket cancelled successfully");
            t.getTrain().cancelSeat(t.getBookedSeats());
            tickets.removeIf(ticket -> ticket.getTicketId().equals(ticketId));
        }
    });
}
public  void showAllTrains(){
    trains.forEach(System.out::println);
}

}
