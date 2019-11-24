package commands.ThingsListCommands;

import commands.Main;
import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.junit.Assert.*;

public class ClearListCommandTest {

    @Test
    public void getDescription() {
        ClearListCommand clearListCommand = new ClearListCommand();
        String actual = clearListCommand.getDescription();
        String expected = "очищает список покупок";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void execute() {
        ClearListCommand clearListCommand = new ClearListCommand();
        Main main = new Main();
        Message message = new Message(){
            @Override
            public String getText() {
                return "/clearList";
            }
            @Override
            public Long getChatId() {
                return 0L;
            }
        };
        Assert.assertEquals(message.getText(), "/clearList");
        main.thingsList.add("thing");
        Assert.assertEquals(main.thingsList.size(), 1);
        clearListCommand.execute(message, main);
        Assert.assertEquals(main.thingsList.size(), 0);
    }
}