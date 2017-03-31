import bean.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.DataFromExcelGetter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Maria on 31.03.2017.
 */
public class ProductsTest {

    @DataProvider(name = "products")
    public Object[][] getData() throws Exception {

        DataFromExcelGetter data = new DataFromExcelGetter();
        ArrayList<Product> productList = data.parse();
        Object [][] products = new Object[productList.size()][1];

        for(int i = 0; i < productList.size(); i++) {
            products[i] = new Product[] { productList.get(i) };
        }
        return products;
    }

    @Test (dataProvider = "products")
    public void test(Product product) {
        //TODO take into account that tests are ignored if cell in excel is empty. that's very-very bad :(
        assertTrue(!product.hasEmptyFields());
    }
}
