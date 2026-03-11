package fullstack.train.service;

import fullstack.train.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    Map<String, User> users = new HashMap<>();

    private User currentUser ;

    public void registerUser(User user){
        // check username is already exist or not
        if(users.containsKey(user.getUsername())){
            throw new RuntimeException("User already exist  ");
        }
        users.put(user.getUsername(), user);
    }

    public User loginUser(String username, String password){

        // check username(account ) exist or not
        if(users.containsKey(username)){
            // if exist then get current the user object
           var user =  users.get(username);
           if(user.getPassword().equals(password)){
               currentUser = user;
            return user;
           }
           else{
               throw new RuntimeException("Invalid password");
           }
        }else {
            throw new RuntimeException("User not found");
        }
    }

    public User getCurrentUser(){
        if(currentUser == null){
            throw new RuntimeException("User not logged in");
        }
        return currentUser;
    }

    // user log out set currentUser = null
    public void logoutUser(){
        currentUser = null;
        System.out.println("User logged out successfully");
    }


    public boolean isLogIn(){
       return currentUser != null;
    }

    public boolean isLogOut(){
        return currentUser == null;
    }


}
