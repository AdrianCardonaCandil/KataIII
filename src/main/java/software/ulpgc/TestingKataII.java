package software.ulpgc;

public class TestingKataII {
    public static void main(String[] args) {
        StudentsRatingsLoader loader = new CSVStudentsRatingsLoader();
        HistogramBuilder builder = new StudentsRatingsHistogramBuilder(loader.loadStudentsRatings());
        HistogramDisplay display = new MockHistogramDisplay(builder.loadHistogram());
        display.display();
    }
}
