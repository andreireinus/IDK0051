package y3.moods;

import y3.players.Monster;
import y3.players.Player;
import y3.players.Wizard;

public class Mood {
    private static int angry = 0;
    private static int neutral = 1;
    private static int good = 2;

    private static int minMood = angry;
    private static int maxMood = good;

    private Player player;
    public Mood(Player player) {
        this.player = player;
    }

    private int current = neutral;

    private boolean isMood(int mood) {
        return (mood == current);
    }
    public boolean isAngry() {
        return isMood(angry);
    }
    public boolean isNeutral() {
        return isMood(neutral);
    }
    public boolean isGood() {
        return isMood(good);
    }

    public void increase() {
        if (player instanceof Wizard) {
            return;
        }
        current = Math.min(current + 1, maxMood);
    }
    public void decrease() {
        if (player instanceof Wizard) {
            return;
        }

        if (player instanceof Monster) {
            current = Math.max(current - 1, minMood);
        } else {
            current = Math.max(current - 1, neutral);
        }
    }

}
