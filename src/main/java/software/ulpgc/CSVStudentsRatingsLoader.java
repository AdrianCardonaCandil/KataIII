package software.ulpgc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CSVStudentsRatingsLoader implements StudentsRatingsLoader{
    private final Set<StudentRating> studentRatings = new HashSet<>();
    @Override
    public Set<StudentRating> loadStudentsRatings() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Notas-PreACTA_ORDINARIA_2021-2022_v2.csv"))){
            readFile(bufferedReader);
        } catch (IOException e){
            System.out.println("Error while processing file");
        }
        return this.studentRatings;
    }

    private void readFile(BufferedReader bufferedReader) throws IOException {
        String line;
        while((line = bufferedReader.readLine()) != null){
            this.studentRatings.add(studentRatingFromLine(line.split(",")));
        }
    }

    private StudentRating studentRatingFromLine(String[] split) {
        return new StudentRating(split[0], Double.parseDouble(split[1]));
    }
}
