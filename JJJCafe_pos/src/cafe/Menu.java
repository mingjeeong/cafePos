package cafe;

public class Menu {
	public static int index = 1;
	Menu[] orderlist = new Menu[5];
	private String name = "메뉴";
	private int price, change; // 상품가격, 추가된 상품 개수, 상품항목당 금액, 거스름돈

	String list = "";

	public Menu() {
		super();
	}

	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	int total() {
		return 0;
	}

	void realCreate() {
	}

	public static void main(String[] args) {

		Menu p = new Menu();
		p.realCreate();
		// p.create();

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
