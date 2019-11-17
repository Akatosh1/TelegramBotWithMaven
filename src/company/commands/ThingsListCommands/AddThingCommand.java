package company.commands.ThingsListCommands;

import company.Main;
import company.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class AddThingCommand implements Command {
    @Override
    public String getDescription() {
        return "добавить вещь в список покупок";
    }

    @Override
    public void execute(Message message, Main telegram) {
        if (telegram.condition.equals("")) {
            telegram.sendMsg(message, "введите название продукта");
            telegram.condition = "addThing";
        }
    }
}
