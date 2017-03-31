package util;

import bean.Product;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Maria on 31.03.2017.
 */
public class DataFromExcelGetter {

    public static ArrayList<Product> parse() {
    //TODO take into account that parser stops working if cell's empty. find another way for parsing

        ArrayList<Product> products = new ArrayList<Product>();
        InputStream in;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream("./data.xls");
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Product product = new Product();
            Iterator<Cell> cells = row.iterator();
            product.setId((int)(row.getCell(0).getNumericCellValue()));
            product.setName(row.getCell(1).getStringCellValue());
            product.setPrice(row.getCell(2).getNumericCellValue());
            products.add(product);
            }

        return products;
    }
}
