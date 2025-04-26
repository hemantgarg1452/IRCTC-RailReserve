package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Train;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {
    public List<Train> trainList;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAIN_PATH = "app/src/main/java/org/example/localDb/trains.JSON";

    public TrainService() throws IOException{
        File trains = new File(TRAIN_PATH);
        trainList = objectMapper.readValue(trains, new TypeReference<List<Train>>(){});
    }

    // valid train
    private boolean validTrain(Train train, String source, String destination){
        List<String> stationOrder = train.getStations();

        int sourceIndex = stationOrder.indexOf(source.toLowerCase());
        int destinationIndex = stationOrder.indexOf(destination.toLowerCase());

        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }

    // Search trains
    public List<Train> searchTrains(String source, String destination){
        return trainList.stream().filter(train -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    // add train
    public void addTrain(Train newTrain){
        // check if it's already existed or not
        Optional<Train> existingTrain = trainList.stream()
                .filter(train -> train.getTrainId().equalsIgnoreCase(newTrain.getTrainId()))
                .findFirst();

        if(existingTrain.isPresent()) updateTrain(newTrain);
        else trainList.add(newTrain);
        saveTrainListToFile();
     }


     //update the train data
     public void updateTrain(Train updateTrain){
        // Find the index of the train with ID
         OptionalInt index = IntStream.range(0, trainList.size())
                 .filter(i -> trainList.get(i).getTrainId().equalsIgnoreCase(updateTrain.getTrainId()))
                 .findFirst();

         if(index.isPresent()){
             trainList.set(index.getAsInt(), updateTrain);
             saveTrainListToFile();
         }
         else {
             addTrain(updateTrain);
         }
    }

    // save the train list into DB file
    private void saveTrainListToFile(){
        try {
            objectMapper.writeValue(new File(TRAIN_PATH), trainList);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
