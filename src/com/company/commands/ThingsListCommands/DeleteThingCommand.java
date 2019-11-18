package com.company.commands.ThingsListCommands;

import com.company.Main;
import com.company.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class DeleteThingCommand implements Command {
    @Override
    public String getDescription() {
        return "удалить вещь из списка покупок";
    }

    @Override
    public void execute(Message message, Main telegram) {
        if (telegram.condition.equals("")) {
            telegram.sendMsg(message, "введите название продукта");
        }
    }
}
