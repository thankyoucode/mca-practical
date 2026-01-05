// Develop a program to create Hash Map for “Customer” class objects references. Customer class
// has Bill_no, cust_mobile_no, Array of item_name, Array of item_unit_price, Array of
// item_count, total_price. Calculate total_price for all customers of Hash Map. Display Hash
// Map and also search particular customer’s bill based on customer mobile no.
// Key is mobile no.

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

class Customer {
  int bill_no;
  int mobile_no;
  int total_price;
  int items_count;
  HashMap<String, Integer> items;

  public Customer(int mobile_no, int bill_no, HashMap<String, Integer> items) {
    this.mobile_no = mobile_no;
    this.bill_no = bill_no;
    this.items = items;
  }

  public int totalPrice() {
    Collection<Integer> prices = items.values();
    total_price = 0;
    for (int price : prices) {
      total_price += price;
    }
    return total_price;
  }

  public int totalCount() {
    items_count = items.size();
    return items_count;    
  }

  @Override
    public String toString() {
        return "Bill No: " + bill_no + ", Mobile: " + mobile_no + ", Items: " + items +
                ", Total Price: " + totalPrice();
    }
}


public class Collection_3_HashMap {
  public static void main(String[] args) {
    HashMap<Number, Customer> customers = new HashMap<>();
    // Create some sample customers
        HashMap<String, Integer> items1 = new HashMap<>();
        items1.put("Milk", 50);
        items1.put("Bread", 30);
        items1.put("Eggs", 60);
        Customer c1 = new Customer(1234567890, 1, items1);

        HashMap<String, Integer> items2 = new HashMap<>();
        items2.put("Butter", 40);
        items2.put("Cheese", 100);
        Customer c2 = new Customer(987654321, 2, items2);

        HashMap<String, Integer> items3 = new HashMap<>();
        items3.put("Juice", 70);
        items3.put("Chips", 30);
        Customer c3 = new Customer(555666777, 3, items3);

        // Add customers to the HashMap using mobile number as key
        customers.put(c1.mobile_no, c1);
        customers.put(c2.mobile_no, c2);
        customers.put(c3.mobile_no, c3);

        // Display all customers and their total price
        System.out.println("All Customers:");
        for (Entry<Number, Customer> entry : customers.entrySet()) {
            System.out.println(entry.getValue());
        }

        // Calculate total price for all customers
        int totalAllCustomers = 0;
        for (Customer c : customers.values()) {
            totalAllCustomers += c.totalPrice();
        }
        System.out.println("\nTotal price of all customers: " + totalAllCustomers);

        // Search for a particular customer's bill using mobile number
        int searchMobile = 987654321;  // mobile number to search
        System.out.println("\nSearching for customer with mobile: " + searchMobile);
        if (customers.containsKey(searchMobile)) {
            System.out.println(customers.get(searchMobile));
        } else {
            System.out.println("Customer not found.");
        }
  }
}
