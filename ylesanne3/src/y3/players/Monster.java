package y3.players;

import y3.playground.Board;
import y3.playground.RedTile;
import y3.playground.WhiteTile;
import y3.utils.SL;

import java.util.List;

public class Monster extends Player {

    public Monster(Board board, String name) {
        super(board, name);
    }

    @Override
    protected void onNoMove() {
        mood.decrease();
        super.onNoMove();
    }

    @Override
    protected void actOnLocation() {
        if (location instanceof WhiteTile) {
            if (mood.isGood()) {
                SL.info("Laulab");
            } else {
                SL.info("Magab");
            }
        } else if (location instanceof RedTile) {
            List<Player> players = location.getPlayers();
            if (players.size() == 0) {
                if (mood.isGood()) {
                    SL.info("Laulab");
                }
            } else {
                for (Player player : players) {
                    if (player.equals(this)) {
                        // Endaga ei saa tyli norida, kuigi v6iks
                        continue;
                    }
                    if (player instanceof Monster && mood.isGood()) {
                        // Head tuju noh ja ei nori tyli
                        continue;
                    }
                    this.fight(player);
                    break;
                }
            }
        }
    }

    @Override
    public boolean isStronger(Player opponent) {
        if (mood.isAngry()) {
            return true;
        }
        return super.isStronger(opponent);
    }
}
