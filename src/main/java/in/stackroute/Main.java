package in.stackroute;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        QueryExtractor queryExtractor = new QueryExtractor();
        try {
            queryExtractor.extractQuery(
                    "SELECT MatchID, Date FROM ipl.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}