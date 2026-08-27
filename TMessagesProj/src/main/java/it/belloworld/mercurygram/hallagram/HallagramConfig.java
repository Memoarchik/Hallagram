package it.belloworld.mercurygram.hallagram;

import android.content.Context;
import android.content.SharedPreferences;

import org.telegram.messenger.ApplicationLoader;

public class HallagramConfig {

    private static final String PREFS_NAME = "hallagram_config";

    // Ghost Mode
    public static boolean ghostMode = false;
    public static boolean dontSendRead = true;
    public static boolean dontSendOnline = true;
    public static boolean dontSendTyping = true;
    public static boolean dontReadStories = true;
    public static boolean readOnInteract = true;

    public static volatile long lastInteractedDialogId = 0;
    public static volatile long lastInteractTime = 0;

    public static void onUserInteract(long dialogId) {
        lastInteractedDialogId = dialogId;
        lastInteractTime = System.currentTimeMillis();
    }

    // Speed Boost
    public static int downloadSpeedBoost = 0; // 0 = Off, 1 = Fast, 2 = Ultra
    public static boolean uploadSpeedBoost = false;

    // Content Protection & Restrictions Bypass
    public static boolean allowForwardingProtectedContent = true;
    public static boolean allowScreenshots = true;

    private static boolean loaded = false;

    public static void loadConfig() {
        if (loaded) return;
        SharedPreferences prefs = getPreferences();
        if (prefs == null) return;
        ghostMode = prefs.getBoolean("ghostMode", false);
        dontSendRead = prefs.getBoolean("dontSendRead", true);
        dontSendOnline = prefs.getBoolean("dontSendOnline", true);
        dontSendTyping = prefs.getBoolean("dontSendTyping", true);
        dontReadStories = prefs.getBoolean("dontReadStories", true);
        readOnInteract = prefs.getBoolean("readOnInteract", true);

        downloadSpeedBoost = prefs.getInt("downloadSpeedBoost", 0);
        uploadSpeedBoost = prefs.getBoolean("uploadSpeedBoost", false);

        allowForwardingProtectedContent = prefs.getBoolean("allowForwardingProtectedContent", true);
        allowScreenshots = prefs.getBoolean("allowScreenshots", true);
        loaded = true;
    }

    public static void saveConfig() {
        SharedPreferences prefs = getPreferences();
        if (prefs == null) return;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("ghostMode", ghostMode);
        editor.putBoolean("dontSendRead", dontSendRead);
        editor.putBoolean("dontSendOnline", dontSendOnline);
        editor.putBoolean("dontSendTyping", dontSendTyping);
        editor.putBoolean("dontReadStories", dontReadStories);
        editor.putBoolean("readOnInteract", readOnInteract);

        editor.putInt("downloadSpeedBoost", downloadSpeedBoost);
        editor.putBoolean("uploadSpeedBoost", uploadSpeedBoost);

        editor.putBoolean("allowForwardingProtectedContent", allowForwardingProtectedContent);
        editor.putBoolean("allowScreenshots", allowScreenshots);
        editor.apply();
    }

    public static void setGhostMode(boolean value) {
        ghostMode = value;
        saveConfig();
    }

    public static void setDontSendRead(boolean value) {
        dontSendRead = value;
        saveConfig();
    }

    public static void setDontSendOnline(boolean value) {
        dontSendOnline = value;
        saveConfig();
    }

    public static void setDontSendTyping(boolean value) {
        dontSendTyping = value;
        saveConfig();
    }

    public static void setDontReadStories(boolean value) {
        dontReadStories = value;
        saveConfig();
    }

    public static void setReadOnInteract(boolean value) {
        readOnInteract = value;
        saveConfig();
    }

    public static void setDownloadSpeedBoost(int value) {
        downloadSpeedBoost = value;
        saveConfig();
    }

    public static void setUploadSpeedBoost(boolean value) {
        uploadSpeedBoost = value;
        saveConfig();
    }

    public static void setAllowForwardingProtectedContent(boolean value) {
        allowForwardingProtectedContent = value;
        saveConfig();
    }

    public static void setAllowScreenshots(boolean value) {
        allowScreenshots = value;
        saveConfig();
    }

    private static SharedPreferences getPreferences() {
        if (ApplicationLoader.applicationContext == null) return null;
        return ApplicationLoader.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
}
