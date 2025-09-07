import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Ecommerce {
    public static void main (String[]args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String [] productNedded = {"Tomato","Brinjal"};
        List<WebElement> allProducts = driver.findElements(By.xpath("//h4[@class='product-name']"));
        int count = 0;


        for(int i=0;i<allProducts.size();i++){
            String productName = allProducts.get(i).getText().split("-")[0].trim();
            List prdoductList = Arrays.asList(productNedded);
            if(prdoductList.contains(productName)){
                count++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
            }
            if(count==productNedded.length){
                break;
            }
        }

        List<WebElement> cartData = driver.findElements(By.xpath("//div[@class='cart-info']//strong"));
        if (cartData.size() == 2) {
            String items = cartData.get(0).getText();
            String price = cartData.get(1).getText();
            System.out.println("عدد العناصر: " + items);
            System.out.println("السعر: " + price);
        }

    }
}
