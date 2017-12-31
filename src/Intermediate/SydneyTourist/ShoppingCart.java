package Intermediate.SydneyTourist;

public class ShoppingCart {
	private int OH,BC,SK;
	private int GetFree =3, Giveaway, Bulk = 110;
	
	
ShoppingCart() {
	OH = 0;
	BC = 0;
	SK = 0;
}
void add(String product){
	switch (product) {
	case "OH":
		OH++;
		break;
	case "BC":
		BC++;
		break;
	case "SK":
		SK++;
		break;
		default:
	}
	
}
int total() {
	if(BC>4) {
		Bulk -=20;
	}
	int sum = OH*300 + BC*Bulk + SK*30;
	int discount = (OH/GetFree)*300;
	discount += OH*30;
	sum -= discount;
	return sum;
}
}
