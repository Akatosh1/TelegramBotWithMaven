package commands.ThingsListCommands;

import commands.Main;
import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

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
        main.thingsList.add("thing");
        clearListCommand.execute(message, main);
        Assert.assertEquals(0, main.thingsList.size());
    }
}