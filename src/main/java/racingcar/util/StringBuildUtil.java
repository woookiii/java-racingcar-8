package racingcar.util;

import java.util.List;

public class StringBuildUtil {
    public static void makeWinnerString(List<String> raceWinnerInOrder, StringBuilder winnerString) {
        for (String car : raceWinnerInOrder) {
            winnerString.append(car);
            winnerString.append(", ");
        }
        winnerString.delete(winnerString.length() - 2, winnerString.length());
    }

    public static void makeResultBar(List<Long> raceResult, int currentCarIndex, StringBuilder bar) {
        long currentCarDistance = raceResult.get(currentCarIndex);
        for (long resultBarCount = 0; resultBarCount < currentCarDistance; resultBarCount++) {
            bar.append("-");
        }
    }
}
