package com.mystore.dataprovider;

import com.mystore.utility.NewExcelLibrary;
import org.testng.annotations.DataProvider;

public class DataProviders {
        NewExcelLibrary obj = new NewExcelLibrary();

        @DataProvider(name="Credentials")
        public Object[][] getEmailData(){
            int rows = obj.getrowcount("Credentials");
            int columns = obj.getcolumncount("Credentials");

            int actrows = rows-1;
            Object[][] data = new Object[actrows][columns];

            for(int i=0;i<actrows;i++){
                for(int j=0;j<columns;j++){
                    //data[i][i] =obj.
                }
            }


            return data;
        }
}
