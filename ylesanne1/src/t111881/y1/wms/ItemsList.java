package t111881.y1.wms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Struktuur hoidmaks tootega seotud koguseid.
 * 
 * @author Andrei Reinus
 */
public class ItemsList extends HashMap<Item, Integer> {
	// Ei tea milleks seda vaja on aga eclipse oli nıudlik
	private static final long serialVersionUID = -5417109273627063554L;

	/**
	 * Lisab toote struktuuri. Kui toode eksisteerib juba nimekirjas siis
	 * lisatakse kogus juurde
	 * 
	 * @param item
	 *            lisatav toode
	 * @param quantity
	 *            toote kogus
	 * @throws Exception
	 */
	public void add(Item item, Integer quantity) throws Exception {

		if (this.containsKey(item)) {
			addQuantity(item, quantity);
			return;
		}

		put(item, quantity);
	}

	/**
	 * Tagastab iteraatori toodetest
	 * 
	 * @return
	 */
	public Iterator<Entry<Item, Integer>> getIterator() {
		Set<Entry<Item, Integer>> set = entrySet();

		return set.iterator();
	}

	/**
	 * 
	 * @param item
	 * @return
	 */
	public int getQuantity(Item item) {
		return this.get(item);
	}

	/**
	 * Lisab tootet antud yhiku vırra
	 * 
	 * @param item
	 * @param quantity
	 * @throws Exception
	 */
	public void addQuantity(Item item, Integer quantity) throws Exception {
		this.setQuantity(item, getQuantity(item) + quantity);
	}

	/**
	 * M‰rgib toote koguse nimekirjas. Kui koguseks on m‰rgitud 0 siis eemaldab
	 * nimekirjast, et ei j‰‰ks nullkirjeid
	 * 
	 * @param item
	 *            Toode
	 * @param quantity
	 *            Kogus
	 * @throws Exception
	 */
	public void setQuantity(Item item, Integer quantity) throws Exception {
		if (quantity == 0) {
			remove(item);
			return;
		}

		if (quantity < 0) {
			throw new Exception("Negatiivseid numbreid ei tohi kasutada");
		}

		Iterator<Entry<Item, Integer>> iterator = getIterator();

		while (iterator.hasNext()) {
			Entry<Item, Integer> entry = iterator.next();
			if (entry.getKey().equals(item)) {
				entry.setValue(quantity);
				return;
			}
		}

		// Toodet ei leitud
		add(item, quantity);
	}



}
