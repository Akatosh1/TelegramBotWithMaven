package java.commands;

import  java.Main;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.commands.Command;

public class HelpCommand implements Command {

    @Override
    public String getDescription() {
        return "список команд";
    }

    @Override
    public void execute(Message message, Main telegram) {
        Main.commandDict.forEach((key, v) -> telegram.sendMsg(message, key + " - " + v.getDescription()));
    }
}
