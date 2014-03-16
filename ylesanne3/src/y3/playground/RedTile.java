package y3.playground;

import y3.players.Monster;
import y3.players.Player;
import y3.players.Warrior;
import y3.players.Wizard;
import y3.utils.SL;

public class RedTile extends Tile {
    public RedTile(String name) {
        super(name);
    }

    @Override
    public boolean canEnter(Player player) {
        if (getPlayers().size() >= 4) {
            SL.message("V2ljak t2is: " + getPlayers().size());
            return false;
        }

        if (player instanceof Wizard) {
            int monsterCount = 0;
            int playerCount = 0;
            for (Player p : getPlayers()) {
                if (p instanceof Monster) {
                    monsterCount++;
                } else if (p instanceof Wizard || p instanceof Warrior) {
                    playerCount++;
                }
            }
            if (monsterCount > playerCount) {
                SL.message("Monstereid rohkem kui m2ngijaid");
                return false;
            }
        }
        return true;
    }
}
