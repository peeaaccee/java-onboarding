package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static int countMoney(int money, int won) {
        return money / won;
    }
    private static int balanceMoney(int money, int won) {
        return money % won;
    }
}
