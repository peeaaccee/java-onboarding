package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, List<String>> relation = makeFriendsRelation(user, friends, visitors);

        getRelationScore(relation, userFriends);

    }

    private static Map makeFriendsRelation(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> temp = new HashMap<>();
        temp.put(user, new ArrayList<>());

        for (List info : friends) {
            for (Object person : info) {
                if (!temp.containsKey((String)person)) {
                    List<String> defaultScore = new ArrayList<>();
                    defaultScore.add("0");
                    temp.put((String)person, defaultScore);
                }
            }

            if (temp.containsKey(info.get(0))) {
                List<String> friendsList = temp.get(info.get(0));
                friendsList.add((String)info.get(1));
            }

            if (temp.containsKey(info.get(1))) {
                List<String> friendsList = temp.get(info.get(1));
                friendsList.add((String)info.get(0));
            }

            for (String visitor : visitors) {
                if (!temp.containsKey(visitor)) {
                    List<String> defaultScore = new ArrayList<>();
                    defaultScore.add("0");
                    temp.put(visitor, defaultScore);
                }
            }
        }
        return temp;
    }
    private static void getRelationScore(Map<String, List<String>> relation, List<String> userFriends) {
        for (String name : userFriends) {
            for (String person : relation.keySet()) {
                if (relation.get(person).contains(name)) {
                    relation.get(person).set(0, String.valueOf(Integer.parseInt(relation.get(person).get(0)) + 10));
                }
            }
        }
    }
}
