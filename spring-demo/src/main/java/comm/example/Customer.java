package comm.example;

public class Customer {
	public Customer(int customerId, String customerName, String customeraddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customeraddress = customeraddress;
	}
	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	public Customer() {
		super();
	}
	
	private int customerId;
	private String customerName;
	private String customeraddress;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customeraddress="
				+ customeraddress + "]";
	}

}
