package MongoBango.com.MongoInstanceConnection.customerDao;

public class Customer {
	private String address;
	private String name;
	private String cpr;

	public Customer() {

	}

	public Customer(String address, String name, String cpr) {

		this.address = address;
		this.name = name;
		this.cpr = cpr;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	@Override
	public String toString() {
		return "Customer [address=" + address + ", name=" + name + ", cpr=" + cpr + "]";
	}

}
