package commands.BalanceCommands;

import org.junit.Assert;
import org.junit.Test;
import commands.Main;
import org.telegram.telegrambots.meta.api.objects.Message;


public class AddBalanceCommandTest {

    @Test
    public void getDescription() {
        AddBalanceCommand addBalanceCommand = new AddBalanceCommand();
        String actual = addBalanceCommand.getDescription();
        String expected = "добавить денег на баланс";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void execute() {
        AddBalanceCommand addBalanceCommand = new AddBalanceCommand();
        Main main = new Main();
        Message message = new Message(){
            @Override
            public String getText() { return "/profit"; }
            @Override
            public Long getChatId() { return 0L; }
        };
        addBalanceCommand.execute(message, main);
        Assert.assertEquals(main.condition, "addBalance");
    }
}