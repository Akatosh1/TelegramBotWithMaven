package company.commands.BalanceCommands;

import company.Main;
import company.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ResetBalanceCommand implements Command {
    @Override
    public String getDescription() {
        return "сбросить баланс";
    }

    @Override
    public void execute(Message message, Main telegram) {
        telegram.balance = 0;
        telegram.sendMsg(message, "баланс сброшен");
    }
}
