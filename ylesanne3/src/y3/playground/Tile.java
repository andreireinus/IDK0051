package y3.playground;

import y3.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tile {
    List<Tile> availableMoves = new ArrayList<Tile>();
    List<Player> players = new ArrayList<Player>();
    Random random = new Random();
    private Tile north;
    private Tile south;
    private Tile west;
    private Tile east;
    private String name;

    public Tile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void removeAvailableMove(Tile tile) {
        if (tile != null) {
            availableMoves.remove(tile);
        }
    }

    private void addAvailableMove(Tile tile) {
        if (tile != null) {
            availableMoves.add(tile);
        }
    }

    public Tile getNorth() {
        return north;
    }

    public void setNorth(Tile tile) {
        removeAvailableMove(this.north);
        addAvailableMove(tile);
        this.north = tile;
    }

    public Tile getSouth() {
        return south;
    }

    public void setSouth(Tile tile) {
        removeAvailableMove(this.south);
        addAvailableMove(tile);
        this.south = tile;
    }

    public Tile getWest() {
        return west;
    }

    public void setWest(Tile tile) {
        removeAvailableMove(this.west);
        addAvailableMove(tile);

        this.west = tile;
    }

    public Tile getEast() {
        return east;
    }

    public void setEast(Tile tile) {
        removeAvailableMove(this.east);
        addAvailableMove(tile);

        this.east = tile;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Tile getRandomTile() {
        int index = random.nextInt(availableMoves.size());
        return availableMoves.get(index);
    }

    public boolean canEnter(Player player) {
        return true;
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
