package java.commands.ThingsListCommands;

import java.Main;
import java.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ClearListCommand implements Command {
    @Override
    public String getDescription() {
        return "очищает список покупок";
    }

    @Override
    public void execute(Message message, Main telegram) {
        if (telegram.thingsList.size() != 0) {
            telegram.thingsList.clear();
            telegram.sendMsg(message, "Список очищен");
        }
        else
            telegram.sendMsg(message, "Список и так пуст");
    }
}
