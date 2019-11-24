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
        Assert.assertEquals(message.getText(), "/resetAll");
        main.thingsList.add("thing");
        main.balance = 1;
        main.condition = "something";
        resetAllCommand.execute(message, main);
        Assert.assertEquals(main.thingsList.size(), 0);
        Assert.assertEquals(main.balance, 0);
        Assert.assertEquals(main.condition, "");
    }
}