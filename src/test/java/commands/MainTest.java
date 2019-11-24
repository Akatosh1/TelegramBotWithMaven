package commands;

import org.junit.Assert;
import org.junit.Test;

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
    public void onUpdateReceived() {
    }

    @Test
    public void onMessageReceived() {
    }

    @Test
    public void sendMsg() {
    }

    @Test
    public void getBotUsername() {
    }

    @Test
    public void getBotToken() {
    }
}