/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;



/**
 *
 * @author Menna
 */
public class Product {

     
    private int Product_ID;
    private String Type;
    private String Manufacturer;
    private String Production_Date;
    private String Expiry_Date;


    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int Product_ID) {
        this.Product_ID = Product_ID;
       
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
       
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
                

    }

    public String getProduction_Date() {
        return Production_Date;
    }

    public void setProduction_Date(String Production_Date) {
        this.Production_Date = Production_Date;
                

        
    }

    public String getExpiry_Date() {
        return Expiry_Date;
    }

    public void setExpiry_Date(String Expiry_Date) {
        this.Expiry_Date = Expiry_Date;

    }

    
}
