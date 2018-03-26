package cafe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.*;

public class Pos implements ActionListener {

	Pos[] orderlist = new Pos[5];
	private String name;
	private int price, count, total, change; // 상품가격, 추가된 상품 개수, 상품항목당 금액, 거스름돈

	ArrayList<IceAmericano> ia = new ArrayList<IceAmericano>();
	
	
	JFrame f;

	// menu btn
	JButton[] menuBtn;

	// 결제btn
	JButton cashBtn;
	JButton cardBtn;

	// 총금액계산 btn
	JButton sumBtn;

	// 초기화 btn
	JButton resetBtn;

	// orderList title label
	JLabel lNo, lName, lPrice, lCount, lTotal;

	// orderList label 5개
	JLabel lorder0, lorder1, lorder2, lorder3, lorder4;

	// order label lists
	JLabel[] olls;

	// 총금액 받은돈 거스름돈 label
	JLabel lTotal1, lTotal2, lMoney1, lMoney2, lChange1, lChange2;

	public Pos() {
		Calendar c = Calendar.getInstance();
		String today = String.valueOf(c.get(Calendar.YEAR));
		today += "년 " + String.valueOf(c.get(Calendar.MONTH) + 1);
		today += "월 " + String.valueOf(c.get(Calendar.DATE)) + "일 ";
		today += "JJJ CafeTeria";
		f = new JFrame(today);
		
		// 음료 메뉴
		String[] drinkMenu = { "Ice아메리카노", "Hot아메리카노", "Ice카페라떼", "Hot카페라떼", "Ice초코", "Hot초코", "Ice마끼아또", "Hot마끼아또" };
		menuBtn = new JButton[drinkMenu.length];

		// 메뉴버튼에 지정
		for (int i = 0; i < drinkMenu.length; i++) {
			menuBtn[i] = new JButton(drinkMenu[i]);
			menuBtn[i].setFont(new Font("",Font.BOLD,15));
		}

		cashBtn = new JButton("현금결제");
		cashBtn.setFont(new Font("",Font.BOLD,20));
		cardBtn = new JButton("카드결제");
		cardBtn.setFont(new Font("",Font.BOLD,20));
		sumBtn = new JButton("총금액계산");
		sumBtn.setFont(new Font("",Font.BOLD,20));
		resetBtn = new JButton("초기화");
		resetBtn.setFont(new Font("",Font.BOLD,20));

		// orderList label
		lorder0 = new JLabel("");
		lorder0.setFont(new Font("", Font.BOLD, 20));
		lorder1 = new JLabel("");
		lorder1.setFont(new Font("", Font.BOLD, 20));
		lorder2 = new JLabel("");
		lorder2.setFont(new Font("", Font.BOLD, 20));
		lorder3 = new JLabel("");
		lorder3.setFont(new Font("", Font.BOLD, 20));
		lorder4 = new JLabel("");
		lorder4.setFont(new Font("", Font.BOLD, 20));

		olls = new JLabel[] { lorder0, lorder1, lorder2, lorder3, lorder4 };

		// JLabel lNo,lName,lPrice,lCount,lTotal;
		lNo = new JLabel("번호");
		lNo.setFont(new Font("", Font.BOLD, 20));
		lName = new JLabel("품명");
		lName.setFont(new Font("", Font.BOLD, 20));
		lPrice = new JLabel("단가");
		lPrice.setFont(new Font("", Font.BOLD, 20));
		lCount = new JLabel("갯수");
		lCount.setFont(new Font("", Font.BOLD, 20));
		lTotal = new JLabel("금액");
		lTotal.setFont(new Font("", Font.BOLD, 20));

		// lTotal1,lTotal2,lMoney1,lMoney2,lChange1,lChange2;
		lTotal1 = new JLabel("  총금액");
		lTotal1.setFont(new Font("", Font.BOLD, 40));
		lTotal2 = new JLabel("");
		lTotal2.setFont(new Font("", Font.BOLD, 40));
		lMoney1 = new JLabel("  받은금액");
		lMoney1.setFont(new Font("", Font.BOLD, 40));
		lMoney2 = new JLabel("");
		lMoney2.setFont(new Font("", Font.BOLD, 40));
		lMoney2.setForeground(Color.BLUE);
		lChange1 = new JLabel("  거스름돈");
		lChange1.setFont(new Font("", Font.BOLD, 40));
		lChange2 = new JLabel("");
		lChange2.setFont(new Font("", Font.BOLD, 40));
		lChange2.setForeground(Color.RED);
	}

	public Pos(String name, int price) {
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	void addLayout() {
		// 메뉴
		JPanel pMenuList = new JPanel();
		pMenuList.setLayout(new GridLayout(2, 4));
		for (int i = 0; i < menuBtn.length; i++) {
			pMenuList.add(menuBtn[i]);
		}

		// 주문목록있는 panel
		JPanel pOderList = new JPanel();
		pOderList.setLayout(new BorderLayout());

		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1, 5));
		pNorth.add(lNo);
		pNorth.add(lName);
		pNorth.add(lPrice);
		pNorth.add(lCount);
		pNorth.add(lTotal);

		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(5, 1));
		pCenter.add(lorder0);
		pCenter.add(lorder1);
		pCenter.add(lorder2);
		pCenter.add(lorder3);
		pCenter.add(lorder4);
		pCenter.setBackground(new Color(255, 178, 217));

		pOderList.add(pNorth, new BorderLayout().NORTH);
		pOderList.add(pCenter, new BorderLayout().CENTER);

		// 결제총금액 panel
		JPanel pTotal = new JPanel();
		pTotal.setLayout(new GridLayout(3, 2));
		pTotal.add(lTotal1);
		pTotal.add(lTotal2);
		pTotal.add(lMoney1);
		pTotal.add(lMoney2);
		pTotal.add(lChange1);
		pTotal.add(lChange2);

		// 결제 버튼 panel
		JPanel pPayment = new JPanel();
		pPayment.setLayout(new GridLayout(2, 2));
		pPayment.add(sumBtn);
		pPayment.add(resetBtn);
		pPayment.add(cashBtn);
		pPayment.add(cardBtn);

		// 전체 영역 붙이기 panel
		f.setLayout(new GridLayout(2, 2));
		f.add(pOderList);
		f.add(pMenuList);
		f.add(pTotal);
		f.add(pPayment);

		// 화면출력
		f.setSize(1600, 900);
		f.setVisible(true);
	}

	void realCreate() {
		for (int i = 0; i < orderlist.length; i++) {
			orderlist[i] = new Pos("메뉴" + i, 0);
		}
	}

	void eventProc() {
		for (int i = 0; i < menuBtn.length; i++) {
			menuBtn[i].addActionListener(this);
		}
		sumBtn.addActionListener(this);
		cardBtn.addActionListener(this);
		cashBtn.addActionListener(this);
		resetBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton ev = (JButton) e.getSource();

		// Ice아메리카노 btn event
		if (ev == menuBtn[0]) {
			IceAmericano p = new IceAmericano("Ice아메리카노", 3000, 0);
			LIST: for (int i = 0; i < olls.length; i++) {
				IceAmericano.count++;
				if (!(olls[i].getText().equals(""))) {
					if (olls[i].getText().contains("Ice아메리카노")) {
						olls[i].setText("  " + (i + 1) + p.toString());
						lTotal2.setText("");
						break LIST;
					} else {
						continue LIST;
					}
				} else {
					Menu.index++;
					olls[i].setText("  " + (i + 1) + p.toString());
					break;
				}
			}
		}
		// Hot아메리카노 btn event
		if (ev == menuBtn[1]) {
			HotAmericano p = new HotAmericano("Hot아메리카노", 3000, 0);
			HotAmericano.count++;
			LIST: for (int i = 0; i < olls.length; i++) {
				if (!(olls[i].getText().equals(""))) {
					if (olls[i].getText().contains("Hot아메리카노")) {
						olls[i].setText("  " + (i + 1) + p.toString());
						break LIST;
					} else {
						continue LIST;
					}
				} else {
					olls[i].setText("  " + (i + 1) + p.toString());
					break;
				}
			}
		}
		// Ice카페라떼 btn event
		if (ev == menuBtn[2]) {
			IceLatte p = new IceLatte("Ice카페라떼", 4000, 0);
			IceLatte.count++;
			LIST: for (int i = 0; i < olls.length; i++) {
				if (!(olls[i].getText().equals(""))) {
					if (olls[i].getText().contains("Ice카페라떼")) {
						olls[i].setText("  " + (i + 1) + p.toString());
						break LIST;
					} else {
						continue LIST;
					}
				} else {
					olls[i].setText("  " + (i + 1) + p.toString());
					break;
				}
			}
		}
		// Hot카페라떼 btn event
		if (ev == menuBtn[3]) {
			HotLatte p = new HotLatte("Hot카페라떼", 4000, 0);
			HotLatte.count++;
			LIST: for (int i = 0; i < olls.length; i++) {
				if (!(olls[i].getText().equals(""))) {
					if (olls[i].getText().contains("Hot카페라떼")) {
						olls[i].setText("  " + (i + 1) + p.toString());
						break LIST;
					} else {

						continue LIST;
					}
				} else {
					olls[i].setText("  " + (i + 1) + p.toString());
					break;
				}
			}
		}
		// Ice초코 btn event
		if (ev == menuBtn[4]) {
			IceChoco p = new IceChoco("Ice초코", 5000, 0);
			IceChoco.count++;
			LIST: for (int i = 0; i < olls.length; i++) {
				if (!(olls[i].getText().equals(""))) {
					if (olls[i].getText().contains("Ice초코")) {
						olls[i].setText("  " + (i + 1) + p.toString());
						break LIST;
					} else {
						continue LIST;
					}
				} else {
					olls[i].setText("  " + (i + 1) + p.toString());
					break;
				}
			}
		}
		// Hot초코 btn event
		if (ev == menuBtn[5]) {
			HotChoco p = new HotChoco("Hot초코", 5000, 0);
			HotChoco.count++;
			LIST: for (int i = 0; i < olls.length; i++) {
				if (!(olls[i].getText().equals(""))) {
					if (olls[i].getText().contains("Hot초코")) {
						olls[i].setText("  " + (i + 1) + p.toString());
						break LIST;
					} else {
						continue LIST;
					}
				} else {
					olls[i].setText("  " + (i + 1) + p.toString());
					break;
				}
			}
		}
		// Ice마끼야또 btn event
		if (ev == menuBtn[6]) {
			IceMacchi p = new IceMacchi("Ice마끼야또", 4500, 0);
			IceMacchi.count++;
			LIST: for (int i = 0; i < olls.length; i++) {
				if (!(olls[i].getText().equals(""))) {
					if (olls[i].getText().contains("Ice마끼야또")) {
						olls[i].setText("  " + (i + 1) + p.toString());
						break LIST;
					} else {
						continue LIST;
					}
				} else {
					olls[i].setText("  " + (i + 1) + p.toString());
					break;
				}
			}
		}
		// Hot마끼야또 btn event
		if (ev == menuBtn[7]) {
			HotMacchi p = new HotMacchi("Hot마끼야또", 4500, 0);
			HotMacchi.count++;
			LIST: for (int i = 0; i < olls.length; i++) {
				if (!(olls[i].getText().equals(""))) {
					if (olls[i].getText().contains("Hot마끼야또")) {
						olls[i].setText("  " + (i + 1) + p.toString());
						break LIST;
					} else {
						continue LIST;
					}
				} else {
					olls[i].setText("  " + (i + 1) + p.toString());
					break;
				}
			}
		} // if btn7 종료

		// 현금결제 버튼 event
		if (ev == cashBtn) {
			if (lTotal2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "총금액을 계산해주세요.");
				return;
			}
			String getMoney = JOptionPane.showInputDialog(null, "받은금액을 입력하세요.");
			int m = Integer.parseInt(getMoney);
			lMoney2.setText(getMoney);
			if (m - (Integer.parseInt(lTotal2.getText())) < 0) {
				JOptionPane.showMessageDialog(null, "결제금액이 부족합니다.");
				return;
			}
			lChange2.setText(Integer.toString(m - (Integer.parseInt(lTotal2.getText()))));

			
			if (getMoney != null) {
				JOptionPane.showMessageDialog(null, "결제완료되었습니다");
				for (int i = 0; i < olls.length; i++) {
					olls[i].setText("");
				}
				lTotal2.setText("");
				lChange2.setText("");
				lMoney2.setText("");

			}

		}
		// 카드결제 버튼 event
		if (ev == cardBtn) {
			if (lTotal2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "총금액을 계산해주세요.");
				
				return;
			}
			
			int result = JOptionPane.showConfirmDialog(null, "결제 하시겠습니까?");
			if (result == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(null, "결제완료되었습니다");
				for (int i = 0; i < olls.length; i++) {
					olls[i].setText("");
				}

				lTotal2.setText("");
				lChange2.setText("");
				lMoney2.setText("");
			}
		}

		// 메뉴초기화 event
		if (ev == resetBtn) {
			for (int i = 0; i < olls.length; i++) {
				olls[i].setText("");
			}
			lTotal2.setText("");
			lChange2.setText("");
			lMoney2.setText("");
			IceAmericano.count = 0;
			IceChoco.count = 0;
			IceLatte.count = 0;
			IceMacchi.count = 0;
			HotAmericano.count = 0;
			HotChoco.count = 0;
			HotLatte.count = 0;
			HotMacchi.count = 0;
		}

		// 총금액 계산 event
		if (ev == sumBtn) {
			int reci = 0;
			String tempt = "";
			String[] temp;
			for (int i = 0; i < olls.length; i++) {
				if (!(olls[i].getText().equals(""))) {
					reci++;
				}
			}
			temp = new String[reci * 5];
			reci = 0;
			for (int i = 0; i < olls.length; i++) {
				if (olls[i].getText().equals("")) {
					break;
				}
				tempt += olls[i].getText();
			}
			StringTokenizer st = new StringTokenizer(tempt, " ");
			int i = 0;
			while (st.hasMoreTokens()) {
				temp[i] = st.nextToken();
				i++;
			}
			for (int j = 4; j < temp.length; j = j + 5)
				reci += Integer.parseInt(temp[j]);
			lTotal2.setText(Integer.toString(reci));

		}

	}// ActionListener

	public static void main(String[] args) {
		Pos p = new Pos();
		p.realCreate();
		p.addLayout();
		p.eventProc();
	}
}
