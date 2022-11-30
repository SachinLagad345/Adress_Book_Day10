package com.bridgelabz.day10;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void display() {
		System.out.print("First Name : " + firstName + "\t");
		System.out.print("Last Name : " + lastName + "\t");
		System.out.print("Address : " + address + "\t");
		System.out.print("City : " + city + "\t");
		System.out.print("State : " + state + "\t");
		System.out.print("Zip : " + zip + "\t");
		System.out.print("Email : " + email + "\t");
		System.out.print("Phone : " + phone + "\n");
	}

	public Contact createContact() {
		Contact cs = new Contact();
		Scanner sc = new Scanner(System.in);
		System.out.println("Add new contact");
		System.out.println("Enter first name");
		cs.firstName = sc.next();

		System.out.println("Enter last name");
		cs.lastName = sc.next();

		System.out.println("Enter phone");
		cs.phone = sc.next();

		System.out.println("Enter address");
		cs.address = sc.next();

		System.out.println("Enter city");
		cs.city = sc.next();

		System.out.println("Enter state");
		cs.state = sc.next();

		System.out.println("Enter zip");
		cs.zip = sc.next();

		System.out.println("Enter email");
		cs.email = sc.next();

		return cs;
	}
}

public class AddressBookMain extends Contact {

	public ArrayList<Contact> createAddressBook() {
		ArrayList<Contact> arr = new ArrayList<Contact>();
		return arr;
	}
	
	public static void main(String args[])
	{
		System.out.println("Welcome to address book");
		Hashtable<String, ArrayList<Contact>> ht = new Hashtable<String, ArrayList<Contact>>();

		AddressBookMain adrs = new AddressBookMain();

		Scanner sc1 = new Scanner(System.in);

		int choice = 0;
		int bookchoice = 0;
		int key = 1;

		do {
			System.out.println("1.create Address Book");
			System.out.println("2.select and use Address book");
			System.out.println("3.Display address books");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			bookchoice = sc1.nextInt();

			switch (bookchoice) {
			case 1:
				System.out.println("Enter name of Address Book");
				String bookname = sc1.next();
				ht.put(bookname, adrs.createAddressBook());
				break;
			case 2:
				System.out.println("Enter name of address book to use");
				String bknm = sc1.next();
				if(ht.containsKey(bknm))
				{
				do {
					System.out.println("1.Add contact");
					System.out.println("2.Edit contact");
					System.out.println("3.Delete contact");
					System.out.println("4.Display contacts in address book");
					System.out.println("5.Exit");
					System.out.println("\nEnter your choice");

					choice = sc1.nextInt();

					switch (choice) {
					case 1:
						ht.get(bknm).add(adrs.createContact());
						break;
					case 2:
						if (ht.get(bknm).size() == 0) {
							System.out.println("No data in address book " + bknm + "! Add contacts!");
						} else {
							System.out.println("Enter name of person to edit his details");
							String name = sc1.next();

							for (int i = 0; i < ht.get(bknm).size(); i++) {
								if (ht.get(bknm).get(i).getFirstName().equalsIgnoreCase(name)) {
									System.out.println("Change first name");
									String fname = sc1.next();
									ht.get(bknm).get(i).setFirstName(fname);

									System.out.println("Change last name");
									String lname = sc1.next();
									ht.get(bknm).get(i).setLastName(lname);

									System.out.println("Change address");
									String address = sc1.next();
									ht.get(bknm).get(i).setAddress(address);

									System.out.println("Change city");
									String city = sc1.next();
									ht.get(bknm).get(i).setCity(city);

									System.out.println("Change state");
									String state = sc1.next();
									ht.get(bknm).get(i).setState(state);

									System.out.println("Change zip");
									String zip = sc1.next();
									ht.get(bknm).get(i).setZip(zip);

									System.out.println("Change phone");
									String phone = sc1.next();
									ht.get(bknm).get(i).setPhone(phone);

									System.out.println("Change email");
									String email = sc1.next();
									ht.get(bknm).get(i).setEmail(email);
									break;
								} else if (i == ht.get(bknm).size() - 1)
									System.out.println("Person with given name " + name + " does not exist!");
							}
						}
						break;
					case 3:
						if (ht.get(bknm).size() == 0) {
							System.out.println("AddressBook " + bknm + " is empty! no contact to delete");
						} else {
							System.out.println("Enter first name of person to delete contact");
							String name = sc1.next();
							for (int i = 0; i < ht.get(bknm).size(); i++) {
								if (ht.get(bknm).get(i).getFirstName().equalsIgnoreCase(name)) {
									ht.get(bknm).remove(i);
									break;
								} else if (i == ht.get(bknm).size() - 1) {
									System.out.println(
											"No person exist with name " + name + "in " + bknm + " address book !");
								}
							}
						}
						break;
					case 4:
						System.out.println("Displaying all contacts");
						for (int i = 0; i < ht.get(bknm).size(); i++) {
							ht.get(bknm).get(i).display();
						}
						break;
					default:
						System.out.println("Please enter valid choice");
					}

				} while (choice != 5);
			}
				else
					System.out.println("Address book with name " + bknm + " does not exist!");
				break;
			case 3:
				System.out.println("List of available address books");
				Set<String> booklist = ht.keySet();
				for (String book : booklist) {
					System.out.println(book);
				}
				break;
			case 4:
				break;
			default:
				System.out.println("Please enter valid choice");
			}
		} while (bookchoice != 4);
		sc1.close();
	}

}
