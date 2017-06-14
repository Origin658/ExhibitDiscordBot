package ExhibitBot.Origin;

import ExhibitBot.Origin.Commands.*;

import ExhibitBot.Origin.GuildMembers.GuildJoin;
import ExhibitBot.Origin.GuildMembers.GuildLeave;
import ExhibitBot.Origin.GuildMembers.NickChange;
import ExhibitBot.Origin.GuildVoice.VoiceJoin;

import ExhibitBot.Origin.GuildVoice.VoiceLeave;
import ExhibitBot.Origin.GuildVoice.VoiceMove;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

import static ExhibitBot.Origin.Other.Constants.BOT_TOKEN;

/**
 * Created by josep on 10/06/2017.
 */
public class Main {

    public static JDABuilder discord;
    public static JDA jda;

    public static void main(String[] args){


        //Establishes connection with discord

        discord = new JDABuilder(AccountType.BOT);
        discord.setToken(BOT_TOKEN);
        discord.setAudioEnabled(true);
        discord.setAutoReconnect(true);


        try {
            jda = discord.buildBlocking();
        } catch (LoginException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
        }




        registerCommands();
        registerGuildVoiceEvents();
        registerGuildMemberEvents();


    }

    private static void registerCommands(){
        jda.addEventListener(new Commands());
        jda.addEventListener(new Ip());
        jda.addEventListener(new Hello());
        jda.addEventListener(new Website());
        jda.addEventListener(new Vote());
        jda.addEventListener(new Flipcoin());
        jda.addEventListener(new Diceroll());
        jda.addEventListener(new Serverplayercount());
        jda.addEventListener(new TotalMembers());
    }

    private static void registerGuildVoiceEvents(){
        jda.addEventListener(new VoiceJoin());
        jda.addEventListener(new VoiceLeave());
        jda.addEventListener(new VoiceMove());
    }

    private static void registerGuildMemberEvents(){
        jda.addEventListener(new NickChange());
        jda.addEventListener(new GuildJoin());
        jda.addEventListener(new GuildLeave());
    }
}
