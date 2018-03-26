package cafe;

public class IceAmericano extends Menu {
	static int count = 0;
	private int total;

	public IceAmericano() {
		// TODO Auto-generated constructor stub
	}

	public IceAmericano(String name, int price, int total) {
		super(name, price);

		this.total = price * count;

	}

	@Override
	public String toString() {
		return String.format(" %18s %8d %17d %20d", super.getName(), super.getPrice(), count,
				super.getPrice() * count);
	}
}
