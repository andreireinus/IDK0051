package y3.playground;

import y3.players.Player;

public class WhiteTile extends Tile {
    public WhiteTile(String name) {
        super(name);
    }

    @Override
    public boolean canEnter(Player player) {
        if (getPlayers().size() >= 2) {
            return false;
        }

        return true;
    }
}
