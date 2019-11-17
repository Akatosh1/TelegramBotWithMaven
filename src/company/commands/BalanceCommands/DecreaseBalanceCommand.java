package company.commands.BalanceCommands;

import company.Main;
import company.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class DecreaseBalanceCommand implements Command {
    @Override
    public String getDescription() {
        return "снять деньги с баланса";
    }

    @Override
    public void execute(Message message, Main telegram) {
        if (telegram.condition.equals("")) {
            telegram.sendMsg(message, "введите сумму которую хотите вычесть");
            telegram.condition = "diffBalance";
        }
    }
}
