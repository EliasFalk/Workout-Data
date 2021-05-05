import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        List<List<String>> data = ReadData.ReadFile("src/resources/data.csv");


        FormatData formatData = new FormatData();
        formatData.setData(data);

//        HashMap<String, List<String>> sortedData = formatData.getWorkoutsByDate();
//        for(Map.Entry<String, List<String>> workout : sortedData.entrySet()) {
//            System.out.println(workout);
//        }

        List<List<String>> sortedData = formatData.getExerciseData("Bench Press (Barbell)");
        for(List<String> row : sortedData) {
            System.out.println(row);
        }

    }

}
