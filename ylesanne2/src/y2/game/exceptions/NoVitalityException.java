package y2.game.exceptions;

public class NoVitalityException extends GameException {
	private static final long serialVersionUID = 4679618962982715677L;

	public NoVitalityException() {
		super("I am too tired to move");
	}
}
