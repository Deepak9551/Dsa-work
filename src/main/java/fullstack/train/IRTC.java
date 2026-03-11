package fullstack.train;

import fullstack.train.model.User;
import fullstack.train.service.BookingService;
import fullstack.train.service.TrainService;
import fullstack.train.service.UserService;

import java.util.Scanner;

public class IRTC {
    private BookingService bookingService = new BookingService();
    private TrainService trainService = new TrainService();
    private UserService userService = new UserService();




    public void start() {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        while (user == null) {

            System.out.println("Welcome to IRTC");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Search Train");
            System.out.println("4. Book Train");
            System.out.println("5. Cancel Train");
            System.out.println("6. View All Train");
            System.out.println("7 Logout");
            System.out.println("=".repeat(10));
            System.out.println("Enter Your choice");
            System.out.println(" Enter Your choice");

            var choice = scanner.nextInt();


    switch (choice) {
        case 1:
            System.out.println("Enter username");
            String username = scanner.next();
            System.out.println("Enter email");
            String email = scanner.next();
            System.out.println("Enter password");
            String password = scanner.next();
            System.out.println("Enter phone number");
            String phoneNumber = scanner.next();
            System.out.println("Enter address");
            String address = scanner.next();
            System.out.println("Enter gender");
            String gender = scanner.next();

            user = new User(username, email, password, phoneNumber, address, gender);
            userService.registerUser(user);
            System.out.println("User registered successfully");
            System.out.println(" === LOGIN ===");
            System.out.println("Enter username");
            String username1 = scanner.next();
            System.out.println("Enter password");
            String password1 = scanner.next();

            user = userService.loginUser(username1, password1);
            if (user != null) {
                System.out.println("User logged in successfully");
                afterLogin(user);
            } else {
                System.out.println("Invalid username or password");
            }
            break;
        case 2:
            System.out.println("Enter username");
            String username$ = scanner.next();
            System.out.println("Enter password");
            String password$ = scanner.next();

            user = userService.loginUser(username$, password$);
            if (user != null) {
                System.out.println("User logged in successfully");
                afterLogin(user);
            } else {
                System.out.println("Invalid username or password");
            }
            break;


}
        }

    }

    private void afterLogin(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Search Train");
            System.out.println("2. Book Train");
            System.out.println("3. Cancel Train");
            System.out.println("4. View All Train");
            System.out.println("5. Logout");
            System.out.println("=".repeat(10));
            System.out.println("Enter Your choice");


var flag = true;
           while (flag){
               System.out.println("Enter Your choice");
               var choice = scanner.nextInt();

               switch (choice) {
                   case 1:
                       searchTrain(scanner);
                       break;
                   case 2:
                       bookTrain(user, scanner);
                       break;
                   case 3:
                       cancelTrain(scanner,user);
                       break;
                   case 4:
                       viewAllTrain();
                       break;
                   case 5:
                       userService.logoutUser();
                       flag = false;
                       break;
                   default:
                       System.out.println("Invalid choice");
                       flag = false;
               }
           }
        }
    }

    private void searchTrain(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter source");
        var source = scanner.nextLine();
        System.out.println("Enter destination");
        var destination = scanner.nextLine();
        var trainlist = bookingService.searchTrain(source, destination);
        System.out.println(trainlist);
    }
        public void searchTrain () {
            Scanner sc = new Scanner(System.in);
            var source = sc.nextLine();
            var destination = sc.nextLine();

            bookingService.searchTrain(source, destination);
        }

        private void bookTrain (User user , Scanner scanner){
            System.out.println("Enter train id");
            var trainId = scanner.nextInt();
            System.out.println("Enter number of seats");
            var numberOfSeats = scanner.nextInt();

            bookingService.bookTicket(user, trainId, numberOfSeats);
        }

        private void viewAllTrain(){
        bookingService.showAllTrains();
        }

        private void logout(){
            userService.logoutUser();
        }

        private void cancelTrain(Scanner scanner , User user){
        var ticketId = scanner.nextInt();

        bookingService.cancelTicket(ticketId , user);
        }
    public static void main(String[] args) {
        new IRTC().start();
    }
    }
