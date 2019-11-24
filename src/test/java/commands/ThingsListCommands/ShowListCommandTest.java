package commands.ThingsListCommands;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShowListCommandTest {

    @Test
    public void getDescription() {
        ShowListCommand showListCommand = new ShowListCommand();
        String actual = showListCommand.getDescription();
        String expected = "вывести список покупок";
        Assert.assertEquals(expected, actual);
    }
}