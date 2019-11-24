package commands;

import org.junit.Assert;
import org.junit.Test;

public class HelpCommandTest {

    @Test
    public void getDescription() {
        HelpCommand helpCommand = new HelpCommand();
        String actual = helpCommand.getDescription();
        String expected = "список команд";
        Assert.assertEquals(expected, actual);
    }
}