package y3;

import y3.players.Monster;
import y3.players.Warrior;
import y3.players.Wizard;
import y3.playground.Board;

public class testPlay {
    public static void main(String[] args) {
        Board board = new Board();

        board.addPlayer(new Monster(board, "Monster 1"));
        board.addPlayer(new Warrior(board, "Warrior 1"));
        board.addPlayer(new Wizard(board, "Wizard 1"));

        board.play();
    }
}
