package customers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Address {
	String street;

	String city;

	String zip;

	public Address(String street, String city, String zip) {
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address{" +
				"street='" + street + '\'' +
				", city='" + city + '\'' +
				", zip='" + zip + '\'' +
				'}';
	}
}