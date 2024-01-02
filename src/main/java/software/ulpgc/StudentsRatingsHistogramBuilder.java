package software.ulpgc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentsRatingsHistogramBuilder implements HistogramBuilder{
    private static final double BIN_SIZE = 2.0;
    private final Set<StudentRating> studentRatings;
    private final Map<String, Integer> histogram = new HashMap<>();

    public StudentsRatingsHistogramBuilder(Set<StudentRating> studentRatings) {
        this.studentRatings = studentRatings;
    }

    @Override
    public Map<String, Integer> loadHistogram() {
        for (StudentRating studentRating : studentRatings){
            histogram.put(studentRatingToBin(studentRating), histogram.getOrDefault(studentRatingToBin(studentRating), 0) + 1);
        }
        return this.histogram;
    }

    private String studentRatingToBin(StudentRating studentRating) {
        return lowerBin(studentRating.getRating()) + "-" + (lowerBin(studentRating.getRating()) + StudentsRatingsHistogramBuilder.BIN_SIZE);
    }

    private double lowerBin(double rating) {
        return (int) (rating / StudentsRatingsHistogramBuilder.BIN_SIZE) * StudentsRatingsHistogramBuilder.BIN_SIZE;
    }
}
