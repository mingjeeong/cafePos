package cafe;

public class IceChoco extends Menu {
	static int count = 0;
	private int total;

	public IceChoco() {
		// TODO Auto-generated constructor stub
	}

	public IceChoco(String name, int price, int total) {
		super(name, price);

		this.total = count * price;

	}

	@Override
	public String toString() {
		return String.format(" %19s %14d %18d %19d", super.getName(), super.getPrice(), count,
				super.getPrice() * count);
	}
}
