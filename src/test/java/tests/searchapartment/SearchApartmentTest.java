package tests.searchapartment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.UrlsToBrowse.OLX_REAL_ESTATE_PAGE;

public class SearchApartmentTest extends BaseTest {

    @Test
    public void check2flatApartment(){
        basePage.open(OLX_REAL_ESTATE_PAGE);

        olxHomePage
                .enterCountRooms()
                .clickToFind()
                .checkCountCards();
    }


}
