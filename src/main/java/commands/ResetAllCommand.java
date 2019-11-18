package commands;

import commands.Main;
import commands.BalanceCommands.ResetBalanceCommand;
import commands.ThingsListCommands.ClearListCommand;
import org.telegram.telegrambots.meta.api.objects.Message;

import commands.Command;

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
