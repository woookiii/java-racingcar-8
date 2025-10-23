package racingcar.view;

import java.util.List;

import static racingcar.util.StringBuildUtil.makeResultBar;
import static racingcar.util.StringBuildUtil.makeWinnerString;

public class RaceView {

    public void printRaceResult(List<String> carNamesInOrder, List<Long> raceResult) {
        for (int currentCarIndex = 0; currentCarIndex < raceResult.size(); currentCarIndex++) {
            final StringBuilder bar = new StringBuilder();
            makeResultBar(raceResult, currentCarIndex, bar);
            System.out.format("%s : %s%n", carNamesInOrder.get(currentCarIndex), bar);
        }
        System.out.println();
    }

    public void announceWinner(List<String> raceWinnerInOrder) {
        final StringBuilder winnerString = new StringBuilder();
        makeWinnerString(raceWinnerInOrder, winnerString);

        System.out.format("최종 우승자 : %s", winnerString);
    }
}
