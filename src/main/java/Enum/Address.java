package Enum;

import java.io.InputStream;
import java.util.Properties;

public enum Address{

    ADDRESS("address");

    String address;
    Address(String address){
         try (
            InputStream input = Address.class.getClassLoader().getResourceAsStream("resource.properties")) {
            Properties prop = new Properties();
            prop.load(input);

           this.address = prop.getProperty(address);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAddress(){
        return this.address;
    }

}
