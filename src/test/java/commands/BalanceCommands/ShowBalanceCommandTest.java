package commands.BalanceCommands;


import org.junit.Assert;
import org.junit.Test;

public class ShowBalanceCommandTest {

    @Test
    public void getDescription() {
        ShowBalanceCommand showBalanceCommand = new ShowBalanceCommand();
        String actual = showBalanceCommand.getDescription();
        String expected = "показать остаток на счете";
        Assert.assertEquals(expected, actual);
    }
}