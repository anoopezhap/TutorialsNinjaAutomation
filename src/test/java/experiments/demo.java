package experiments;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorialsninja.base.TestBase;
import netscape.javascript.JSObject;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class demo{
    @Test
    public void demo() throws IOException {

        String filePath = "C:\\Users\\anoop\\IdeaProjects\\QAGURU\\TutorialsNinjaProject\\src\\main\\java\\com\\tutorialsninja\\testData\\registerData.json";
        File file = new File(filePath);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data= mapper.readValue(file, new TypeReference<List<HashMap<String,String>>>() {});
        System.out.println(data);
        System.out.println(data.get(0).get("email"));
    }

    @Test
    public void exceldata() throws IOException {
        String filePath = "C:\\Users\\anoop\\IdeaProjects\\QAGURU\\TutorialsNinjaProject\\LoginData.xlsx";
        DataFormatter formatter = new DataFormatter();
        int noOfRows = 0;
        int noOfColumns = 0;
        XSSFSheet sheet = null;
        XSSFWorkbook workBook = new XSSFWorkbook(filePath);
        int noOfSheets = workBook.getNumberOfSheets();
        for(int i=0;i<noOfSheets;i++)
        {
            if(workBook.getSheetName(i).equalsIgnoreCase("Sheet1"))
            {
                sheet = workBook.getSheetAt(i);
                noOfRows = sheet.getPhysicalNumberOfRows();
                noOfColumns =sheet.getRow(0).getLastCellNum();
            }
        }
        String login[][] = new String[noOfRows-1][noOfColumns];
        System.out.println("r :" + noOfRows + "c :" + noOfColumns);

        for(int j=0;j<noOfRows-1;j++)
        {
            XSSFRow row = sheet.getRow(j + 1);
            for (int k = 0; k < noOfColumns; k++)
            {
                String value = formatter.formatCellValue(row.getCell(k));
                login[j][k] = value;

            }

        }
        System.out.println(" ");
    }

    @Test
    public void prop()
    {
        //System.getProperties().list(System.out);

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.version"));
    }
    @Test
    public void screenshot()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "C:\\Users\\anoop\\IdeaProjects\\QAGURU\\TutorialsNinjaProject\\screenshot\\anoop.png";
        try {
            FileUtils.copyFile(screenshot,new File(screenshotPath));
        } catch (Exception e) {
            System.out.println("Takes Screenshot is null");
            e.printStackTrace();
        }
        System.out.println("screenshot taken");
    }

}
