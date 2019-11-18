package java.commands;

import java.Main;
import java.commands.BalanceCommands.ResetBalanceCommand;
import java.commands.ThingsListCommands.ClearListCommand;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.commands.Command;

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
