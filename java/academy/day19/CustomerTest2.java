package day19;

public class CustomerTest2 {

	public static void main(String[] args) {
		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerID(10020);
		customerKim.setCustomerName("±Ë¿ØΩ≈");
		customerKim.bonusPoint = 10000;
		customerKim.showCustomerInfo();
	}

}
