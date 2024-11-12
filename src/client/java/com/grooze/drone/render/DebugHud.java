package com.grooze.drone.render;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class DebugHud {

    private static final int  BUFFER_SIZE = 4;
    public static String[] logMessages = new String[BUFFER_SIZE];
    private static final int[] logTimers = new int [BUFFER_SIZE];

    public static void addLogMessage(Object message) {

        // Scorri i log per fare spazio al nuovo log
        for (int i = logMessages.length - 1; i > 0; i--) {
            logMessages[i] = logMessages[i - 1];
            logTimers[i] = logTimers[i - 1]; // Sposta anche i timer
        }
        logMessages[0] = message.toString(); // Aggiungi il nuovo log
        logTimers[0] = 20000; // Imposta un timer di 200 tick (~10 secondi)

    }
    public static void init(){


        HudRenderCallback.EVENT.register((drawContext, renderTickCounter) -> {
            // Chiama il metodo per disegnare l'HUD
            MinecraftClient client = MinecraftClient.getInstance();
            int x = 10;  // Posizione x (angolo in alto a sinistra)
            int y = 10;  // Posizione y (puoi variare per ogni log)


            // Font renderer per disegnare il testo
            for (int i = 0; i < logMessages.length; i++) {
                if (logMessages[i] != null && logTimers[i] > 0) {
                    // Disegna il log solo se il timer è ancora positivo
                    drawContext.drawText(client.textRenderer, logMessages[i], x,  y + (i * 10), 0xFFFFFF, true);
                    logTimers[i]--; // Decrementa il timer
                } else {
                    logMessages[i] = null; // Rimuovi il log quando il timer scade
                }
            }
        });


    }
}
