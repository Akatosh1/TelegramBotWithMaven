package commands.BalanceCommands;

import commands.Main;
import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.junit.Assert.*;

public class ShowBalanceCommandTest {

    @Test
    public void getDescription() {
        ShowBalanceCommand showBalanceCommand = new ShowBalanceCommand();
        String actual = showBalanceCommand.getDescription();
        String expected = "показать остаток на счете";
        Assert.assertEquals(expected, actual);
    }
}