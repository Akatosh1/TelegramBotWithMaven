package commands.BalanceCommands;

import commands.Main;
import commands.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class AddBalanceCommand implements Command {

    @Override
    public String getDescription() {
        return "добавить денег на баланс";
    }

    @Override
    public void execute(Message message, Main telegram) {
        if (telegram.condition.equals("")) {
            telegram.sendMsg(message,"введите сумму которую хотите добавить");
            telegram.condition = "addBalance";
        }
    }
}
