package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Train;
import org.example.entities.User;
import org.example.utils.userServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserBookingService {

    private User user;

    private List<User> userList;

    /*objectMapper: To serialize and deserialize things.
      WHY: To storing the objects into JSON file (Serialization)
           AND vice versa (De-Serialization)
    */
    private final ObjectMapper objectMapper = new ObjectMapper();

    //We marked this "Final" so that USERs Path will always fix.
    private static final String USERS_PATH= "app/src/main/java/org/example/localDb/users.JSON";

    public UserBookingService (User user) throws IOException {  //constructor 1 (after user login)
        this.user=user;
        loadUserListFromFile();
    }

    public UserBookingService() throws IOException{ //constructor 2 (without user login)
        loadUserListFromFile();
    }

    /*
    File users = new File(USERS_PATH)
    return objectMapper.readValue(users, new TypeReference<List<Users>>() {});
    */
    private void loadUserListFromFile() throws IOException {
        userList = objectMapper.readValue(new File(USERS_PATH), new TypeReference<List<User>>() {});
    }


    // login User
    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && userServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    // SignUP User
    public Boolean signup(User user1){
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException e){
            return Boolean.FALSE;
        }
    }
    private void saveUserListToFile() throws IOException{
        File userFile = new File(USERS_PATH);
        objectMapper.writeValue(userFile, userList);
        //JSON -> Object(User) = Deserialization
    }

    public void fetchBookings(){
        user.printTickets();
    }

    // Cancel ticket
    public Boolean cancelTickets(String ticketId){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Ticket ID:");
        ticketId = sc.next();

        if(ticketId==null || ticketId.isEmpty()){
            System.out.println("Ticket ID cannot be empty or null");
            return Boolean.FALSE;
        }

        String finalTicketId = ticketId;
        user.getBookedTickets().removeIf(Tickets -> Tickets.getTicketId().equals(finalTicketId));

        String finalTicketId1 = ticketId;
        boolean removed = user.getBookedTickets().removeIf(tickets -> tickets.getTicketId().equals(finalTicketId1));

        if(removed){
            System.out.println("Ticket with ID "+ticketId+" has been canceled!");
            return Boolean.TRUE;
        }else{
            System.out.println("No ticket found with ID "+ticketId);
            return Boolean.FALSE;
        }
    }

    // getTrains
    public List<Train> getTrains(String source, String destination){
        try {
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        } catch (IOException e){
            return new ArrayList<>();
        }
    }

    // fetch seats
    public List<List<Integer>> fetchSeats(Train train){
        return train.getSeats();
    }

    // Book train seat
    public Boolean bookTrainSeat(Train train, int row, int seat){
        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();

            if(row>=0 && row<seats.size() &&
               seat>=0 && seat<seats.get(row).size()){
                if(seats.get(row).get(seat)==0){
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);
                    trainService.addTrain(train);
                    return true;
                }else
                    return false;
            } else
                return false;
        } catch(IOException e){
            return Boolean.FALSE;
        }
    }


}
