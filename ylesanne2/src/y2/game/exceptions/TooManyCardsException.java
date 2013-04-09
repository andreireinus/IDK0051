package y2.game.exceptions;

public class TooManyCardsException extends GameException {
	private static final long serialVersionUID = -4281055990924122386L;

	public TooManyCardsException() {
		super("Too Many Cards in stash");
	}
}
