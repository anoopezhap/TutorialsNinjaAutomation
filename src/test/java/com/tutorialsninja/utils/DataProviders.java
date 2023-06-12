package com.tutorialsninja.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataProviders {

    //Reading from JSON File
    @DataProvider(name="Register Data")
    public Object[][] validData() throws IOException
    {
        String filePath = "C:\\Users\\anoop\\IdeaProjects\\QAGURU\\TutorialsNinjaProject\\src\\main\\java\\com\\tutorialsninja\\testData\\registerData.json";
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(file, new TypeReference<List<HashMap<String,String>>>() {});
        Object login[][] = {{data.get(0)},{data.get(1)}};
        return login;
    }

    //Reading data from EXCEl file
    @DataProvider(name = "Valid LogIn Data")
    public String[][] data() throws IOException
    {
        ExcelUtility excel = new ExcelUtility("C:\\Users\\anoop\\IdeaProjects\\QAGURU\\TutorialsNinjaProject\\LoginData.xlsx");
        int rowCount = excel.getRowCount("Sheet1");
        int colCount = excel.getCellCount("Sheet1",0);
        String data[][] = new String[rowCount][colCount];
        for(int i=1;i<=rowCount;i++)
        {
            for(int j=0;j<colCount;j++)
            {
                data[i-1][j] = excel.getCellData("Sheet1",i,j);
            }
        }
        return data;
    }
}
