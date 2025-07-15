package commonsense.optimise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerMatcher {
    public List<String> findPlayer(List<Player> playerA, List<Player> playerB) {
        return new ArrayList<>();
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
                    Objects.equals(lastName, player.lastName) &&
                    Objects.equals(teamName, player.teamName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, teamName);
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
}
