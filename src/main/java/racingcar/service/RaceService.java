package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceService {
    public List<String> findRaceWinner(List<String> carNamesInOrder, List<Long> raceResult) {
        final long maxDistance = raceResult.stream().max(Long::compare).orElse(0L);
        List<String> winnerInOrder = new ArrayList<>();
        for (int currentCarIndex = 0; currentCarIndex < raceResult.size(); currentCarIndex++) {
            if(raceResult.get(currentCarIndex) == maxDistance){
                winnerInOrder.add(carNamesInOrder.get(currentCarIndex));
            }
        }
        return winnerInOrder;
    }

    public void attemptMoveForwardAllCars(List<Long> raceResult) {
        for (int currentCarIndex = 0; currentCarIndex < raceResult.size(); currentCarIndex++) {
            attemptMoveForwardOneCar(raceResult, currentCarIndex);
        }
    }

    private void attemptMoveForwardOneCar(List<Long> raceResult, int currentCarIndex) {
        if(Randoms.pickNumberInRange(1, 8) >= 4){
            raceResult.set(currentCarIndex, raceResult.get(currentCarIndex) + 1);
        }
    }
}
