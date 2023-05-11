package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelecteOption(){
        var dropdownPage = homePage.clickDropdown();
        String option = "Option 1" ;
        dropdownPage.selectFormDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOption();
        assertEquals(selectedOptions.size(),1 , "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option) , "Option not selected");
    }

    @Test
    public void testSelectTwoOptions (){
        var dropdownPage = homePage.clickDropdown();
        List<String> options = new ArrayList<>();
        options.add("Option 1");
        options.add("Option 2");
        List<String> result = dropdownPage.selectTwoOptions(options);
        assertEquals(result , options, "Option not selected");



    }

}
