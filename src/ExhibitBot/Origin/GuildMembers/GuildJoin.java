package ExhibitBot.Origin.GuildMembers;

import ExhibitBot.Origin.Other.Logging;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by josep on 14/06/2017.
 */
public class GuildJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e){
        Logging.DataLog( e.getGuild().getName(), e.getMember().getUser().getName() , "joined the discord server! Total members - " +
                e.getGuild().getMembers().size(), true, e.getGuild());
    }
}
