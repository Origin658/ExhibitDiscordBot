package ExhibitBot.Origin.Commands;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static ExhibitBot.Origin.Other.Global_Variables.COMMAND_PREFIX;
import static ExhibitBot.Origin.Other.Global_Variables.WEBSITE;

/**
 * Created by josep on 10/06/2017.
 */
public class Website extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContent();
        if (message.equalsIgnoreCase(COMMAND_PREFIX + "website") && !(e.getAuthor().isBot())) {
            e.getTextChannel().sendMessage("```Check out our website at - " + WEBSITE+ "```").queue();
            try {Logging.DataLog(e.getGuild().getName(), e.getAuthor().getName(), message, true, e.getGuild());} catch (PermissionException er){}
        }
    }





}
