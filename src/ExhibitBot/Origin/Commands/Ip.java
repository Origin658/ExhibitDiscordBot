package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static ExhibitBot.Origin.Other.Constants.SERVER_IP;

/**
 * Created by josep on 10/06/2017.
 */
public class Ip extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();

        if (message.startsWith("!ip") && !(e.getAuthor().isBot())) {
            e.getTextChannel().sendMessage("The server IP is " + SERVER_IP).queue();


            Logging.CLog(e.getGuild().getName(), e.getAuthor().getName(), message);
        }



    }

}
