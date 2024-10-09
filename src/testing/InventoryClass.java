package testing;

class Inventory<T extends Item> {
   private T item;
   public void addItem(T item)
   {
       this.item = item;
   }
   public T removeItem()
   {
       T temp = item;
       item = null;
       return temp;
   }
   public void displayItems()
   {
       if(item==null)
       {
       	System.out.println("No items in inventory.");       
       }
       else
       {
       	System.out.println(item);
       }
   }
}
abstract class Item {
   protected String name;
   protected String details;
   public void setName(String name) {
       this.name = name;
   }
   public void setDetails(String details) {
       this.details = details;
   }
   @Override
   public String toString() {
       return "Item{name='" + name + "', details='" + details + "'}";
   }
}
abstract class PerishableItem extends Item {
   protected int expiryDate;
   PerishableItem(int date) {
       this.expiryDate = date;
   }
   @Override
   public String toString() {
       return super.toString() + ", expiryDate=" + expiryDate;
   }
}
abstract class NonPerishableItem extends Item {
   NonPerishableItem() {
       // No expiry date for non-perishable items
   }
}
abstract class ElectronicItem extends Item {
   protected int warranty;
   ElectronicItem(int war) {
       this.warranty = war;
   }
   @Override
   public String toString() {
       return super.toString() + ", warranty=" + warranty;
   }
}
class Food extends PerishableItem {
   Food(String n, int date) {
       super(date);
       setName(n);
   }
   @Override
   public String toString() {
       return "Food{" + super.toString() + "}";
   }
}
class Medicine extends PerishableItem {
   Medicine(String n, int date) {
       super(date);
       setName(n);
   }
   @Override
   public String toString() {
       return "Medicine{" + super.toString() + "}";
   }
}
class Furniture extends NonPerishableItem {
   private String material;
   Furniture(String name, String material) {
       setName(name);
       this.material = material;
   }
   @Override
   public String toString() {
       return "Furniture{" + super.toString() + ", material='" + material + "'}";
   }
}
class Laptop extends ElectronicItem {
   private String model;
   Laptop(String n, String m, int war) {
       super(war);
       setName(n);
       this.model = m;
   }
   @Override
   public String toString() {
       return "Laptop{" + super.toString() + ", model='" + model + "'}";
   }
}
public class InventoryClass {
   public static void main(String[] args) {
       Inventory<PerishableItem> pItems = new Inventory<>();
       pItems.addItem(new Food("Pizza", 2024));
       pItems.addItem(new Medicine("Panadol", 2027));
       pItems.displayItems();
      
       Inventory<ElectronicItem> eItems = new Inventory<>();
       eItems.addItem(new Laptop("HP", "latest", 5));
       eItems.displayItems();
   }
}