package com.amazon.data;

import org.testng.annotations.DataProvider;

public class DataProvidersForTest {

    @DataProvider(name = "getDataForSearchTest")
    public Object [][] getDataForSearchTest(){

        return new Object[][] { {"Java Books"}, {"Selenium Books"}};
    }

    @DataProvider(name = "getUserForCreateAccountTest")
    public Object [][] getUserForCreateAccountTest(){

        return new Object[][] {
                {"testusername" ,"testemail@gmail.com", "testpass",},
                {"testusername2","testemail2@gmail.com","testpass2"}
        };
    }
}
