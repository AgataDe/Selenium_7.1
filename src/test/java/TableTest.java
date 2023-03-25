import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RowPage;
import pages.TablePage;

@Slf4j
public class TableTest extends BaseTest {

    TablePage tablePage;

    @Test
    @DisplayName("Tables")
    @Tag("Basic")
    public void shouldWorkOnTable() {
        driver.get("http://www.seleniumui.moderntester.pl/table.php");
        tablePage = new TablePage(driver);
        log.info("The page has been opened");

        for (RowPage mountain : tablePage.getMountains()) {
            mountain.printInfo();
        }


    }
}
