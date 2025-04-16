package pages.SuperAdmin;

import baseTest.baseClass;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortUser extends baseClass {
    static String clickAscendSort = "//table/thead/tr/th[1]/a/descendant::p";
    static String getNamePath1 = "//table/tbody/tr[";
    static String getGetNamePath2 = "]/td[1]";
    static String clickOnPagination = "";
    static String listOfPagination = "//table/ancestor::div[1]/following-sibling::div/descendant::div[4]/child::nav/ul/li";
    static List<String> actualAscendingSortedName = new ArrayList<>();
    static int i = 2;
    //table/ancestor::div[1]/following-sibling::div/descendant::div[4]/child::nav/ul/li[]

    public static void clickOnSortToAscend() throws InterruptedException {
        findByXpath(clickAscendSort).click();
        Thread.sleep(timeout);
    }

    public static void navigateToNextPage() throws InterruptedException {
        findByXpath(clickOnPagination).click();
        Thread.sleep(3000);
    }

    public static void verifyNoOfOfPages() throws InterruptedException {
        List<WebElement> noOfPagination = findByXpath(listOfPagination, "true");
        int paginationSize = noOfPagination.size();
        while (i < paginationSize) {
            clickOnPagination = listOfPagination + "[" + i + "]";
            navigateToNextPage();
            i++;
        }
    }

    public static void verifyListInAscendingOrder() throws InterruptedException {
        List<WebElement> noOfPagination = findByXpath(listOfPagination, "true");
        int paginationSize = noOfPagination.size();
        System.out.println("paginationSize: "+paginationSize);
        List<WebElement> rowData = findByXpath(adminStaff.tablePath, "true");
        int rowSize = rowData.size();
        do {
            for (int j = 1; j <= rowSize; j++) {
                WebElement ele = findByXpath(getNamePath1 + j + getGetNamePath2);
                actualAscendingSortedName.add(ele.getText());
            }
            i++;
            clickOnPagination = listOfPagination + "[" + i + "]";
            navigateToNextPage();
        } while (i < paginationSize-1);

        System.out.println("Actual Result: " + actualAscendingSortedName);
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
        System.out.println("List Size: "+actualAscendingSortedName.size());
        Collections.sort(actualAscendingSortedName, String::compareTo);
        System.out.println("Expected Result: " + actualAscendingSortedName);
    }
}
