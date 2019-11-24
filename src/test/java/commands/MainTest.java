package commands;

import org.junit.Assert;
import org.junit.Test;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;

public class MainTest {

    @Test
    public void initCommands() {
        Main main = new Main();
        main.commandDict = new HashMap<>();
        main.initCommands();
        Assert.assertEquals(main.commandDict.size(), 10);
    }

    @Test
    public void onMessageReceived() {
        Main main = new Main();
        Message balanceMessage = new Message(){
            @Override
            public String getText() { return "123"; }
            @Override
            public Long getChatId() { return 0L; }
        };
        main.condition = "diffBalance";
        main.onMessageReceived(balanceMessage);
        Assert.assertEquals(-123, main.balance);
        main.condition = "addBalance";
        main.onMessageReceived(balanceMessage);
        Assert.assertEquals(0, main.balance);
        Message thingMessage = new Message(){
            @Override
            public String getText() { return "thing"; }
            @Override
            public Long getChatId() { return 0L; }
        };
        main.condition = "addThing";
        main.onMessageReceived(thingMessage);
        Assert.assertEquals("thing", main.thingsList.get(0));
        main.condition = "delThing";
        main.onMessageReceived(thingMessage);
        Assert.assertEquals(0, main.thingsList.size());
    }

    @Test
    public void getBotUsername() {
        Main main = new Main();
        Assert.assertEquals(main.getBotUsername(), "MyCounterBot");
    }
}