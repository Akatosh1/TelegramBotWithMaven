package commands.BalanceCommands;

import commands.Main;
import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ResetBalanceCommandTest {

    @Test
    public void getDescription() {
        ResetBalanceCommand resetBalanceCommand = new ResetBalanceCommand();
        String actual = resetBalanceCommand.getDescription();
        String expected = "сбросить баланс";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void execute() {
        ResetBalanceCommand resetBalanceCommand = new ResetBalanceCommand();
        Main main = new Main();
        Message message = new Message(){
            @Override
            public String getText() {
                return "/resetBalance";
            }
            @Override
            public Long getChatId() {
                return 0L;
            }
        };
        main.balance = 1;
        resetBalanceCommand.execute(message, main);
        Assert.assertEquals(main.balance, 0);
    }
}