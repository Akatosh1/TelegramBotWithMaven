package commands.BalanceCommands;

import commands.Main;
import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.junit.Assert.*;

public class DecreaseBalanceCommandTest {

    @Test
    public void getDescription() {
        DecreaseBalanceCommand decreaseBalanceCommand = new DecreaseBalanceCommand();
        String actual = decreaseBalanceCommand.getDescription();
        String expected = "снять деньги с баланса";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void execute() {
        DecreaseBalanceCommand decreaseBalanceCommand = new DecreaseBalanceCommand();
        Main main = new Main();
        Message message = new Message(){
            @Override
            public String getText() {
                return "/cost";
            }
            @Override
            public Long getChatId() {
                return 0L;
            }
        };
        Assert.assertEquals(message.getText(), "/cost");
        decreaseBalanceCommand.execute(message, main);
        Assert.assertEquals(main.condition, "diffBalance");
    }
}