package simpleTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {

    @DataProvider(name = "db")
        public static Object[][] dbData(){
        return new Object[][] {
                {"SQL", 1},
                {"NOSQL", 2}

        };
    }
    @Test(groups = {"simple", "regress"}, dataProvider = "db")
    public void test2(String p1, int p2) {
        System.out.println("Test 2 " + p1 + " " + p2);
    }

    @Test(groups = {"newtest"}, dependsOnMethods = "test2", alwaysRun = true, retryAnalyzer = Retry.class)
    public void test21() {
        System.out.println("Test 21");
        Assert.assertEquals(1,2);
    }


}
