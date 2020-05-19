package search;


import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchTests extends BaseTests {

    @Test
    public void testSortSearchResults() {
        var search = homePage.searchFor("dress");
        assertEquals(search.getPriceOf(1), "$28.98", "Price is not correct");
        search.sortSearchResults("Price: Lowest first");
        assertEquals(search.getPriceOf(1), "$16.51", "Not sorted");
    }
}