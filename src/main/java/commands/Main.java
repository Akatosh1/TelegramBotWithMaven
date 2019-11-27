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
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main extends TelegramLongPollingBot {

    public static Map<String, Command> commandDict = new HashMap<>();
    public String condition = "";
    public int balance = 0;
    public boolean hasKeyboard = false;
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
            if (message.getText().equals("Hello")){
                hasKeyboard = true;
            }
            if (hasKeyboard){
                try {
                    execute(sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }else if(update.hasCallbackQuery()) {
            SendMessage sendMessage = new SendMessage().setText(
                    update.getCallbackQuery().getData())
                    .setChatId(update.getCallbackQuery().getMessage().getChatId());
            Message callbackMessage = update.getCallbackQuery().getMessage();
            String messageText = sendMessage.getText();
            commandDict.get(messageText).execute(callbackMessage, this);
            if (hasKeyboard){
                try {
                    execute(sendInlineKeyBoardMessage(update.getCallbackQuery().getMessage().getChatId()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
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
        if (condition.equals("addBalance")) {
            try {
                balance += Math.abs(Integer.parseInt(message.getText()));
                sendMsg(message, "Баланс увеличен");
            } catch (Exception exc) {
                sendMsg(message, "Вы ввели не число!");
            }
            condition = "";
            hasKeyboard = true;
        }
        if (condition.equals("addThing")) {
            thingsList.add(message.getText());
            sendMsg(message, "Продукт добавлен в список");
            condition = "";
            hasKeyboard = true;
        }
        if (condition.equals("delThing")) {
            thingsList.remove(message.getText());
            sendMsg(message, "Продукт удален из списка");
            condition = "";
            hasKeyboard = true;
        }
        if (condition.equals("diffBalance")) {
            try {
                balance -= Math.abs(Integer.parseInt(message.getText()));
                sendMsg(message, "Баланс уменьшен");
            } catch (Exception exc) {
                sendMsg(message, "Вы ввели не число");
            }
            condition = "";
            hasKeyboard = true;
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

    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("/add");
        inlineKeyboardButton2.setText("/del");
        inlineKeyboardButton3.setText("/profit");
        inlineKeyboardButton4.setText("/cost");
        inlineKeyboardButton5.setText("/list");
        inlineKeyboardButton6.setText("/balance");
        inlineKeyboardButton1.setCallbackData("/add");
        inlineKeyboardButton2.setCallbackData("/del");
        inlineKeyboardButton3.setCallbackData("/profit");
        inlineKeyboardButton4.setCallbackData("/cost");
        inlineKeyboardButton5.setCallbackData("/list");
        inlineKeyboardButton6.setCallbackData("/balance");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow5 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow6 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        keyboardButtonsRow4.add(inlineKeyboardButton4);
        keyboardButtonsRow5.add(inlineKeyboardButton5);
        keyboardButtonsRow6.add(inlineKeyboardButton6);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);
        rowList.add(keyboardButtonsRow5);
        rowList.add(keyboardButtonsRow6);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("Команды").setReplyMarkup(inlineKeyboardMarkup);
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

