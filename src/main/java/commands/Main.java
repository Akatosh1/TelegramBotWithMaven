package commands;

import commands.BalanceCommands.AddBalanceCommand;
import commands.BalanceCommands.DecreaseBalanceCommand;
import commands.BalanceCommands.ResetBalanceCommand;
import commands.BalanceCommands.ShowBalanceCommand;
import commands.ThingsListCommands.AddThingCommand;
import commands.ThingsListCommands.ClearListCommand;
import commands.ThingsListCommands.DeleteThingCommand;
import commands.ThingsListCommands.ShowListCommand;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main extends TelegramLongPollingBot {

    public static Map<String, Command> commandDict = new HashMap<>();
    public String condition = "";
    public int balance = 0;
    public ArrayList<String> thingsList = new ArrayList<>();

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Main());
        } catch (TelegramApiException exc) {
            exc.printStackTrace();
        }

        initCommands();
    }

    public static void initCommands(){
        commandDict.put("/help", new HelpCommand());
        commandDict.put("/add", new AddThingCommand());
        commandDict.put("/del", new DeleteThingCommand());
        commandDict.put("/balance", new ShowBalanceCommand());
        commandDict.put("/profit", new AddBalanceCommand());
        commandDict.put("/cost", new DecreaseBalanceCommand());
        commandDict.put("/list", new ShowListCommand());
        commandDict.put("/clearList", new ClearListCommand());
        commandDict.put("/resetBalance", new ResetBalanceCommand());
        commandDict.put("/resetAll", new ResetAllCommand());
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            onMessageReceived(message);
        }
    }

    public void onMessageReceived(Message message){
        String messageText = message.getText();
        if(condition.equals("")) {
            if (commandDict.containsKey(messageText)) {
                commandDict.get(messageText).execute(message, this);
                return;
            }
        }
        if (condition.equals("removeBalance")) {
            balance -= Integer.parseInt(message.getText());
            sendMsg(message, "Баланс уменьшен");
        }
        if (condition.equals("addBalance")) {
            try {
                balance += Integer.parseInt(message.getText());
                sendMsg(message, "Баланс увеличен");
            } catch (Exception exc) {
                sendMsg(message, "Вы ввели не число!");
            }
            condition = "";
        }
        if (condition.equals("addThing")) {
            thingsList.add(message.getText());
            sendMsg(message, "Продукт добавлен в список");
            condition = "";
        }
        if (condition.equals("delThing")) {
            thingsList.remove(message.getText());
            sendMsg(message, "Продукт удален из списка");
            condition = "";
        }
        if (condition.equals("diffBalance")) {
            try {
                balance -= Integer.parseInt(message.getText());
                sendMsg(message, "Баланс уменьшен");
            } catch (Exception exc) {
                sendMsg(message, "Вы ввели не число");
            }
            condition = "";
        }
    }

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "MyCounterBot";
    }

    @Override
    public String getBotToken() {
        return "917038082:AAGqWSN2YVIHGsLQH4dchoKvXRLnlM7I1UM";
    }

}

