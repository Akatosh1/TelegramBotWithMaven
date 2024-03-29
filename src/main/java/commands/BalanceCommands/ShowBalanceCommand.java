package commands.BalanceCommands;

import commands.Main;
import commands.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ShowBalanceCommand implements Command {
    @Override
    public String getDescription() {
        return "показать остаток на счете";
    }

    @Override
    public void execute(Message message, Main telegram) {
        telegram.sendMsg(message, String.valueOf(telegram.balance));
    }
}
