package t111881.y1.wms;

/**
 * Põhiobjekt Toode
 * 
 * @author Andrei Reinus
 */
public class Item {
	private String name;
	private double price;

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	/// ctor ///
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}


	/**
	 * @return String representation of object instance
	 */
	@Override
	public String toString() {
		return name + " (" + price + ")";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}	
}
