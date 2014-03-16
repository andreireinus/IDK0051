package y3.players;

import y3.playground.Board;
import y3.playground.RedTile;
import y3.playground.WhiteTile;

public class Warrior extends Player {
    public Warrior(Board board, String name) {
        super(board, name);
    }

    @Override
    protected void actOnLocation() {
        if (location instanceof WhiteTile) {
            train();
        } else if (location instanceof RedTile) {
            // Kui monster on siis l2heb kismaks
        }
    }

    @Override
    public boolean isStronger(Player opponent) {
        if (mood.isGood()) {
            return true;
        }

        return super.isStronger(opponent);
    }

    @Override
    protected void onTrain() {
        mood.increase();
        super.onTrain();
    }
}
