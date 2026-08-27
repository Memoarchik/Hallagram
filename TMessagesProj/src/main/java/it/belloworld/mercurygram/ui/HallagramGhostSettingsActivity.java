package it.belloworld.mercurygram.ui;

import android.view.View;
import java.util.ArrayList;

import org.telegram.messenger.R;
import org.telegram.ui.Components.UItem;
import org.telegram.ui.Components.UniversalAdapter;
import org.telegram.ui.Components.UniversalFragment;

import it.belloworld.mercurygram.hallagram.HallagramConfig;

public class HallagramGhostSettingsActivity extends UniversalFragment {

    private static final int ID_GHOST_MODE = 1;
    private static final int ID_DONT_SEND_READ = 2;
    private static final int ID_DONT_SEND_ONLINE = 3;
    private static final int ID_DONT_SEND_TYPING = 4;
    private static final int ID_DONT_READ_STORIES = 5;
    private static final int ID_READ_ON_INTERACT = 6;

    @Override
    protected CharSequence getTitle() {
        return "Ghost Mode";
    }

    @Override
    protected void fillItems(ArrayList<UItem> items, UniversalAdapter adapter) {
        HallagramConfig.loadConfig();

        items.add(UItem.asHeader("Ghost essentials"));
        items.add(UItem.asCheck(ID_GHOST_MODE, "Ghost Mode")
                .setChecked(HallagramConfig.ghostMode));
        items.add(UItem.asShadow("Master switch for ghost mode. When turned off, standard Telegram behavior applies."));

        if (HallagramConfig.ghostMode) {
            items.add(UItem.asCheck(ID_DONT_SEND_READ, "Don't mark messages as read")
                    .setChecked(HallagramConfig.dontSendRead));
            items.add(UItem.asShadow("Opening chats will not send read receipts (double checkmarks)."));

            items.add(UItem.asCheck(ID_READ_ON_INTERACT, "Read on interact")
                    .setChecked(HallagramConfig.readOnInteract));
            items.add(UItem.asShadow("Automatically mark messages as read when you send a message, media, or emoji reaction."));

            items.add(UItem.asCheck(ID_DONT_SEND_ONLINE, "Hide Online status")
                    .setChecked(HallagramConfig.dontSendOnline));
            items.add(UItem.asShadow("Prevents broadcasting your online presence when using the app."));

            items.add(UItem.asCheck(ID_DONT_SEND_TYPING, "Hide Typing indicator")
                    .setChecked(HallagramConfig.dontSendTyping));
            items.add(UItem.asShadow("Prevents sending \"typing...\", audio recording, or uploading status."));

            items.add(UItem.asCheck(ID_DONT_READ_STORIES, "Anonymous Story viewing")
                    .setChecked(HallagramConfig.dontReadStories));
            items.add(UItem.asShadow("View stories without appearing in the author's viewer list."));
        }

        items.add(UItem.asShadow(null));
    }

    @Override
    protected void onClick(UItem item, View view, int position, float x, float y) {
        switch (item.id) {
            case ID_GHOST_MODE:
                HallagramConfig.setGhostMode(!HallagramConfig.ghostMode);
                if (listView != null && listView.adapter != null) {
                    listView.adapter.update(true);
                }
                break;
            case ID_DONT_SEND_READ:
                HallagramConfig.setDontSendRead(!HallagramConfig.dontSendRead);
                if (listView != null && listView.adapter != null) {
                    listView.adapter.update(true);
                }
                break;
            case ID_READ_ON_INTERACT:
                HallagramConfig.setReadOnInteract(!HallagramConfig.readOnInteract);
                if (listView != null && listView.adapter != null) {
                    listView.adapter.update(true);
                }
                break;
            case ID_DONT_SEND_ONLINE:
                HallagramConfig.setDontSendOnline(!HallagramConfig.dontSendOnline);
                if (listView != null && listView.adapter != null) {
                    listView.adapter.update(true);
                }
                break;
            case ID_DONT_SEND_TYPING:
                HallagramConfig.setDontSendTyping(!HallagramConfig.dontSendTyping);
                if (listView != null && listView.adapter != null) {
                    listView.adapter.update(true);
                }
                break;
            case ID_DONT_READ_STORIES:
                HallagramConfig.setDontReadStories(!HallagramConfig.dontReadStories);
                if (listView != null && listView.adapter != null) {
                    listView.adapter.update(true);
                }
                break;
        }
    }

    @Override
    protected boolean onLongClick(UItem item, View view, int position, float x, float y) {
        return false;
    }
}
