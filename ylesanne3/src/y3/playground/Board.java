package y3.playground;

import y3.players.Monster;
import y3.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Board {
    List<Thread> threads = new ArrayList<Thread>();
    private List<Tile> tiles = new ArrayList<Tile>();
    private List<Player> players = new ArrayList<Player>();
    private Tile startTile;


    public Board() {
        startTile = new StartTile("start");

        Tile a1 = new WhiteTile("a1");
        Tile a2 = new RedTile("a2");
        Tile b1 = new RedTile("b1");
        Tile b2 = new WhiteTile("b2");

        a1.setEast(b1);
        b1.setWest(a1);

        a1.setSouth(a2);
        a2.setNorth(a1);

        b1.setSouth(b2);
        b2.setNorth(b1);

        a2.setEast(b2);
        b2.setWest(a2);

        tiles.add(a1);
        tiles.add(a2);
        tiles.add(b1);
        tiles.add(b2);

        startTile.setWest(b2);
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setLocation(startTile);
    }

    public void play() {
        for (Player player : players) {
            Thread thread = new Thread(player, player.toString());
            thread.start();

            threads.add(thread);
        }

        while (true) {
            try {
                boolean allFinished = true;
                for (Thread thread : threads) {
                    if (thread.isAlive()) {
                        allFinished = false;
                        break;
                    }
                }

                if (!allFinished) {
                    allFinished = true;
                    boolean monsterAlive = false;
                    boolean playerAlive = false;
                    for (Player player : players) {
                        if (!player.isDead) {
                            if (player instanceof Monster) {
                                monsterAlive = true;
                            } else {
                                playerAlive = true;
                            }
                        }
                    }
                    if (!monsterAlive) {
                        allFinished = true;
                    }
//                    if (monsterAlive && playerAlive) {
//                        allFinished = false;
//                    }
                }

                if (allFinished) {
                    break;
                }
                TimeUnit.MILLISECONDS.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void reSpawn(Player player) {
        player.dead();
        player.getLocation().removePlayer(player);
        player.setLocation(startTile);
    }
}
