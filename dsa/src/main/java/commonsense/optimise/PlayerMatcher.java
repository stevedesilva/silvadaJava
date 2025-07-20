package commonsense.optimise;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerMatcher {
    public static List<String> findPlayer(List<Player> playerA, List<Player> playerB) {
        Set<Player> setA = new HashSet<>(playerA);
        Set<Player> setB = new HashSet<>(playerB);
        return setA.stream()
                .filter(setB::contains)
                .map(Player::toString)
                .collect(Collectors.toList());
    }

    // class with firstName, lastName, teamName
    public static class Player {
        private String firstName;
        private String lastName;
        private String teamName;

        public Player(String firstName, String lastName, String teamName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.teamName = teamName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getTeamName() {
            return teamName;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Player player = (Player) obj;
            return Objects.equals(firstName, player.firstName) &&
                    Objects.equals(lastName, player.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
}
