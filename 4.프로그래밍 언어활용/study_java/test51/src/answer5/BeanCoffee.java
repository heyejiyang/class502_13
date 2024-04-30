package answer5;

public class BeanCoffee {

	int money;
	
	public String brewing(int money) {
	
		this.money += money;
		if(money == Menu.BEANAMERICANO) {
			return "콩다방 아메리카노 구입";
		}
		else if(money == Menu.BEANLATTE) {
			return "콩다방 라떼 구입";
		}
		else {
			return null;
		}
	}
}
