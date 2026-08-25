package it.belloworld.mercurygram.ui;

import android.view.View;
import java.util.ArrayList;

import org.telegram.messenger.R;
import org.telegram.ui.Components.UItem;
import org.telegram.ui.Components.UniversalAdapter;
import org.telegram.ui.Components.UniversalFragment;

import it.belloworld.mercurygram.hallagram.HallagramConfig;

public class HallagramGeneralSettingsActivity extends UniversalFragment {

    private static final int ID_UPLOAD_BOOST = 1;
    private static final int ID_ALLOW_FORWARDING = 2;
    private static final int ID_ALLOW_SCREENSHOTS = 3;

    @Override
    protected CharSequence getTitle() {
        return "General";
    }

    @Override
    protected void fillItems(ArrayList<UItem> items, UniversalAdapter adapter) {
        HallagramConfig.loadConfig();

        // Download & Upload Speed Boost
        items.add(UItem.asHeader("Download & Upload Speed"));
        items.add(UItem.asSlideView(new String[]{"Off", "Fast", "Ultra"}, HallagramConfig.downloadSpeedBoost, chosen -> {
            HallagramConfig.setDownloadSpeedBoost(chosen);
        }));
        items.add(UItem.asCheck(ID_UPLOAD_BOOST, "Upload Speed Boost")
                .setChecked(HallagramConfig.uploadSpeedBoost));
        items.add(UItem.asShadow("Ultra Boost maximizes parallel connections. May increase memory and data usage."));

        // Content Restrictions & Screenshots
        items.add(UItem.asHeader("Content Restrictions"));
        items.add(UItem.asCheck(ID_ALLOW_FORWARDING, "Allow Forwarding & Saving Content")
                .setChecked(HallagramConfig.allowForwardingProtectedContent));
        items.add(UItem.asShadow("Bypasses \"restrict saving content\" in private channels and groups, allowing forwarding, copying, and saving media."));

        items.add(UItem.asCheck(ID_ALLOW_SCREENSHOTS, "Allow Screenshots Everywhere")
                .setChecked(HallagramConfig.allowScreenshots));
        items.add(UItem.asShadow("Disables Android screenshot and screen recording blocking in secret chats and protected media."));

        items.add(UItem.asShadow(null));
    }

    @Override
    protected void onClick(UItem item, View view, int position, float x, float y) {
        switch (item.id) {
            case ID_UPLOAD_BOOST:
                HallagramConfig.setUploadSpeedBoost(!HallagramConfig.uploadSpeedBoost);
                if (listView != null && listView.adapter != null) {
                    listView.adapter.update(true);
                }
                break;
            case ID_ALLOW_FORWARDING:
                HallagramConfig.setAllowForwardingProtectedContent(!HallagramConfig.allowForwardingProtectedContent);
                if (listView != null && listView.adapter != null) {
                    listView.adapter.update(true);
                }
                break;
            case ID_ALLOW_SCREENSHOTS:
                HallagramConfig.setAllowScreenshots(!HallagramConfig.allowScreenshots);
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
