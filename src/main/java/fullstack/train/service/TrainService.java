package fullstack.train.service;

import fullstack.train.model.Train;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TrainService {




    Map<Integer, Train> trains = new HashMap<>();

    private void createTrain(Integer trainId, String name,
                 String source, String destination,
                 Integer totalSeats,
                 Integer availableSeats,
                 LocalDateTime arrivalTime,
                 LocalDateTime departureTime

    ){
        Train train = new Train(trainId, name, source, destination, arrivalTime , departureTime, totalSeats );
        trains.put(trainId, train);

    }

    public void bookTicket(Integer trainId, Integer numberOfSeats) {
        if(!trains.containsKey(trainId)){
            throw new RuntimeException("Train not found");
        }
        Train train = trains.get(trainId);
      if(train.isSeatAvailable(numberOfSeats)){
          train.bookSeat(numberOfSeats);
      }
    }

    public  void cancelTicket(Integer numberOfSeats , Integer trainId){
       var train =  foundTrain(trainId);
       train.cancelSeat(numberOfSeats);

    }

    public Train foundTrain(Integer trainId){
        if(!trains.containsKey(trainId)){
            throw new RuntimeException("Train not found");
        }
        return trains.get(trainId);
    }
}
