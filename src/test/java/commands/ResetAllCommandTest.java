package commands;

import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ResetAllCommandTest {

    @Test
    public void getDescription() {
        ResetAllCommand resetAllCommand = new ResetAllCommand();
        String actual = resetAllCommand.getDescription();
        String expected = "откатывает все данные к исходным";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void execute() {
        ResetAllCommand resetAllCommand = new ResetAllCommand();
        Main main = new Main();
        Message message = new Message(){
            @Override
            public String getText() {
                return "/resetAll";
            }
            @Override
            public Long getChatId() {
                return 0L;
            }
        };
        Assert.assertEquals("/resetAll", message.getText());
        main.thingsList.add("thing");
        main.balance = 1;
        main.condition = "something";
        resetAllCommand.execute(message, main);
        Assert.assertEquals(0, main.thingsList.size());
        Assert.assertEquals(0, main.balance);
        Assert.assertEquals("", main.condition);
    }
}