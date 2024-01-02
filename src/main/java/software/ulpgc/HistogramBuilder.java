package software.ulpgc;

import java.util.Map;

public interface HistogramBuilder {
    public abstract Map<String, Integer> loadHistogram();
}
