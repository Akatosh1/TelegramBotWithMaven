package java.commands;

import java.Main;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Command {
    String getDescription();
    void execute(Message message, Main telegram);
}
