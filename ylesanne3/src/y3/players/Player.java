package y3.players;

import y3.moods.Mood;
import y3.playground.Board;
import y3.playground.Tile;
import y3.utils.SL;
import y3.utils.Timeout;

public class Player implements Runnable {
    protected int level = 1;
    protected int maxLevel = 4;
    protected Tile location;
    protected Board board;
    private int fightLoss = 0;
    private int fightWin = 0;
    private String name = "";
    public boolean isDead = false;

    protected Mood mood = new Mood(this);

    public Player(Board board, String name) {
        this.name = name;
        this.board = board;
    }

    public void dead() {
        isDead = true;
        SL.info(this + " is dead!");
    }

    @Override
    public void run() {
        while (true) {
            actOnLocation();
            if (!isDead) {
            move();
            }
            if (isDead) {
                break;
            }
            try {
                Timeout.onPlayerMove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void actOnLocation() {

    }

    @Override
    public String toString() {
        return name;
    }

    public void move() {

        Tile tile = this.location.getRandomTile();

        if (tile.canEnter(this)) {
            move(tile);
        } else {
            onNoMove();
            SL.info("Ei lubatud");
        }
    }

    public void move(Tile tile) {
        SL.info("Move to " + tile.getName());
        location.removePlayer(this);
        location = tile;
        location.addPlayer(this);
        onEnter();
    }

    protected void train() {
        addLevel();
        onTrain();
    }

    private void addLevel() {
        if (level < maxLevel) {
            SL.message("Level up!");
            level++;
        }
    }

    public boolean isStronger(Player opponent) {
        return (level >= opponent.getLevel());
    }

    public void fight(Player opponent) {
        SL.message(this.toString() + " fights with " + opponent);
        if (isStronger(opponent)) {
            addLevel();
            addFightWin();
            opponent.addFightLoss();
        } else {
            addFightLoss();
            opponent.addFightWin();
        }
    }

    public void addFightLoss() {
        fightLoss++;
        if (level == 1) {
            board.reSpawn(this);
            return;
        }
        level--;
    }

    public void addFightWin() {
        fightWin++;
    }

    private int getLevel() {
        return level;
    }

    public Tile getLocation() {
        return location;
    }

    public void setLocation(Tile tile) {
        location = tile;
    }

    /// Events
    protected void onTrain() {
    }
    protected void onEnter() {
    }
    protected void onNoMove() {
    }

}
