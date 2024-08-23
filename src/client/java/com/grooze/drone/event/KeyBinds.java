package com.grooze.drone.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {

    public static KeyBinding
            droneUP = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.fabricmod.droneup", // Identificatore del binding
            InputUtil.Type.KEYSYM, // Tipo di input
            GLFW.GLFW_KEY_SPACE, // Tasto associato (G in questo caso)
            "category.fabricmod.drone" // Categoria nelle impostazioni
    )),
            droneDown = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.fabricmod.dronedown", // Identificatore del binding
            InputUtil.Type.KEYSYM, // Tipo di input
            GLFW.GLFW_KEY_LEFT_CONTROL, // Tasto associato (G in questo caso)
            "category.fabricmod.drone" // Categoria nelle impostazioni
    ));

    public static void init(){}


}