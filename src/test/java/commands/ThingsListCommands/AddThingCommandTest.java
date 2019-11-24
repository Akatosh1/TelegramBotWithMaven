package commands.ThingsListCommands;

import commands.Main;
import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

public class AddThingCommandTest {

    @Test
    public void getDescription() {
        AddThingCommand addThingCommand = new AddThingCommand();
        String actual = addThingCommand.getDescription();
        String expected = "добавить вещь в список покупок";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void execute() {
        AddThingCommand addThingCommand = new AddThingCommand();
        Main main = new Main();
        Message message = new Message(){
            @Override
            public String getText() {
                return "/add";
            }
            @Override
            public Long getChatId() {
                return 0L;
            }
        };
        addThingCommand.execute(message, main);
        Assert.assertEquals("addThing", main.condition);
    }
}