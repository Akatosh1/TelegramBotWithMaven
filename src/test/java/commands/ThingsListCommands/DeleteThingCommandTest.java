package commands.ThingsListCommands;

import commands.Main;
import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

public class DeleteThingCommandTest {

    @Test
    public void getDescription() {
        DeleteThingCommand deleteThingCommand = new DeleteThingCommand();
        String actual = deleteThingCommand.getDescription();
        String expected = "удалить вещь из списка покупок";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void execute() {
        DeleteThingCommand deleteThingCommand = new DeleteThingCommand();
        Main main = new Main();
        Message message = new Message(){
            @Override
            public String getText() {
                return "/del";
            }
            @Override
            public Long getChatId() {
                return 0L;
            }
        };
        deleteThingCommand.execute(message, main);
        Assert.assertEquals("delThing", main.condition);
    }
}