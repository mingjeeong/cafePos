package cafe;

public class HotAmericano extends Menu {
	static int count = 0;
	private int total;

	public HotAmericano() {
		// TODO Auto-generated constructor stub
	}

	public HotAmericano(String name, int price, int total) {
		super(name, price);

		this.total = count * price;

	}

	@Override
	public String toString() {
		return String.format(" %17s %8d %17d %20d", super.getName(), super.getPrice(), count,
				super.getPrice() * count);
	}
}
