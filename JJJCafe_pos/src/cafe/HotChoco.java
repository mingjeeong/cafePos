package cafe;

public class HotChoco extends Menu {
	static int count = 0;
	private int total;

	public HotChoco() {
		// TODO Auto-generated constructor stub
	}

	public HotChoco(String name, int price, int total) {
		super(name, price);

		this.total = count * price;

	}

	@Override
	public String toString() {
		return String.format(" %19s %13d %18d %19d", super.getName(), super.getPrice(), count,
				super.getPrice() * count);
	}
}
