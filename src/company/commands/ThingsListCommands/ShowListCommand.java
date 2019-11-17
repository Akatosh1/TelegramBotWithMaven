package company.commands.ThingsListCommands;

import company.Main;
import company.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ShowListCommand implements Command {
    @Override
    public String getDescription() {
        return "вывести список покупок";
    }

    @Override
    public void execute(Message message, Main telegram) {
        if (telegram.thingsList.size() != 0)
            telegram.thingsList.forEach((item) -> telegram.sendMsg(message,(telegram.thingsList.indexOf(item)+1) +")" + item));
        else
            telegram.sendMsg(message, "список пуст");
    }
}
