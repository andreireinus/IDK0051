package t111881.y1.wms;

import t111881.y1.pos.Order;

/**
 * Class milles hoitakse Tootega seotud tehingut.
 * 
 * @author Andrei Reinus
 */
public class Transaction {
	private Item item;
	private Integer quantity;
	private Order order;

	public Transaction(Item item, Integer quantity, Order order) {
		this.item = item;
		this.quantity = quantity;
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Order getOrder() {
		return order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
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
		Transaction other = (Transaction) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
}
