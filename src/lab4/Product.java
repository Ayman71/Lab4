/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author Mariam
 */
public class Product {
    private  String ProductID, ProductName, ManufacturerName, SupplierName;
   private int Quantity;
   private float Price ;
   
   public Product(String ProductID, String ProductName, String ManufacturerName, String SupplierName, int Quantity, float Price)
   {
       this.ProductID =ProductID;
       this.ProductName=ProductName;
       this.ManufacturerName=ManufacturerName;
       this.SupplierName=SupplierName;
        this.Quantity=Quantity;
       this.Price=Price;
      
       
   }
    public String getProductID()
     {
         return ProductID ;
     }
     public String getProductName()
     {
         return ProductName ;
     }
      public String getManufacturerName()
     {
         return ManufacturerName ;
     }
       public String getSupplierName()
     {
         return SupplierName;
     }
     public float getPrice()
     {
         return Price ;
     }
    public int getQuantity()
    {       
        return Quantity;
        
    }
   public void setQuantity(int Quantity) {
      Quantity--;   //Take
           if (Quantity == 0) {
      System.out.println("All units have been sold.");
}
     Quantity++;   //RETURN
           if (Quantity > 0) {
      System.out.println("Units are available again.");
}

}
   
   public String lineRepresentation() {
        return ProductID+","+ProductName+","+ManufacturerName+","+SupplierName+","+Quantity+","+Price;
    }

   
    public String getSearchKey() {
        return ProductID;
    }
}
