package com.grooze.drone.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DebugLog {

    static class LogEntry{
        public String message;

        public long cooldown; // Tempo di cooldown in millisecondi

        public LogEntry(long cooldown, String message) {
            this.message = message;
            this.cooldown = cooldown;
        }

        public LogEntry(LogEntry entry) {
            this(entry.cooldown, entry.message);
        }
    }

    private static final Map<Integer,LogEntry> messages = new HashMap<>();

    public static void print(int id, String message){
        int cooldown = 100;// 20 * 5


        LogEntry entry = messages.get(id);

        if (entry == null){
            messages.put(id,new LogEntry(cooldown, message));
            System.out.println(message);
            return;
        }
        entry.cooldown--;
        if(entry.cooldown <= 0){
            entry.cooldown = cooldown;
            messages.put(id, entry);
            System.out.println(message);
            return;
        }
        if(!entry.message.equals(message)){
            entry.message = message;
            entry.cooldown = cooldown;
            messages.put(id, entry);
            System.out.println(message);

        }



    }
}
