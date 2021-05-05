import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FormatData {

    private static List<List<String>> data;

    public static void setData(List<List<String>> data) {
        FormatData.data = data;
    }

    private boolean dataIsSet() {
        if(!this.data.isEmpty()) {
            return true;
        }
        return false;
    }
    public HashMap<String, List<String>> getWorkoutsByDate() {
        if(dataIsSet()) {
            //TODO return empty data set
        }

        HashMap<String, List<String>> sortedData = new HashMap<String, List<String>>();
        int currentWorkoutNumber = 1;



        List<String> lastRow = data.get(1);
        for(List<String> row : data) {
            if(row.get(0).equals(lastRow.get(0))) { // has same date
                sortedData.put("Workout_"+currentWorkoutNumber, row);
            } else {
                currentWorkoutNumber++;
                sortedData.put("Workout_"+currentWorkoutNumber, row);
            }
            lastRow = row;
        }
        return sortedData;
    }


    public List<List<String>> getExerciseData(String exercise) {

        if(dataIsSet()) {
            //TODO return empty data set
        }

        // create empty List<List<String>> which contains the heaviest set of each day
        List<List<String>> exercises = new LinkedList<>();


        // loop through each row
        List<String> currentStrongestSet = data.get(1);
        String currentDate = "";
        for(List<String> row : data) {
            if(row.get(2).equals(exercise)) {
                // if same date and exercise then should compare the sets which is stronger and set the largest current set for that workout
                if(row.get(0).equals(currentDate)) {
                    if(Double.parseDouble(row.get(4)) > Double.parseDouble(currentStrongestSet.get(4))) {
                        currentStrongestSet = row;
                    }
                } else { // if not same date but same exercise then should add the last strongest set to exercises list, and set the current strongest set to this set.
                    currentDate = row.get(0);
                    exercises.add(currentStrongestSet);
                    currentStrongestSet = row;
                }
            }
        }

        return exercises;
    }
}
