package y2.game;

public class Board {
	private Tile start;
	
	public Tile getStart() {
		return start;
	}
	
	public void append(Tile t) {
		if (start == null) {
			start = t;
		} else {
			getLast().setNext(t);
			
		}
		t.setBoard(this);
	}
	
	private Tile getLast() {
		Tile last = start;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		return last;
	}
	
	public String toString() {		
		if (start == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(start.toString());
		
		Tile next = start.getNext();
		while (next != null) {
			sb.append(" ");
			sb.append(next.toString());
			next = next.getNext();
		}
			
		return sb.toString();
	}
}
