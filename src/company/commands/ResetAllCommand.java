package company.commands;

import company.Main;
import company.commands.BalanceCommands.ResetBalanceCommand;
import company.commands.ThingsListCommands.ClearListCommand;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ResetAllCommand implements Command {
    @Override
    public String getDescription() {
        return "откатывает все данные к исходным";
    }

    @Override
    public void execute(Message message, Main telegram) {
        telegram.condition = "";
        new ClearListCommand().execute(message, telegram);
        new ResetBalanceCommand().execute(message, telegram);
    }
}
