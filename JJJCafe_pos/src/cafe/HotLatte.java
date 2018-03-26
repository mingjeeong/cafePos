package cafe;

public class HotLatte extends Menu {
	static int count = 0;
	private int total;

	public HotLatte() {
		// TODO Auto-generated constructor stub
	}

	public HotLatte(String name, int price, int total) {
		super(name, price);

		this.total = count * price;

	}

	@Override
	public String toString() {
		return String.format(" %17s %10d %18d %19d", super.getName(), super.getPrice(), count,
				super.getPrice() * count);
	}
}
