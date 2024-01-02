package software.ulpgc;

import java.util.Map;

public class MockHistogramDisplay implements HistogramDisplay{
    private final Map<String, Integer> histogram;

    public MockHistogramDisplay(Map<String, Integer> histogram) {
        this.histogram = histogram;
    }

    @Override
    public void display() {
        System.out.println(this.histogram);
    }
}
