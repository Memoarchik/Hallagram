package it.belloworld.mercurygram.ui;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.Components.UItem;
import org.telegram.ui.Components.UniversalAdapter;
import org.telegram.ui.Components.UniversalFragment;

public class HallagramSettingsActivity extends UniversalFragment {

    private static final int ID_GHOST_MODE = 1;
    private static final int ID_GENERAL = 2;
    private static final int ID_ABOUT = 10;

    @Override
    protected CharSequence getTitle() {
        return "Hallagram";
    }

    @Override
    protected void fillItems(ArrayList<UItem> items, UniversalAdapter adapter) {
        Context context = getContext();
        if (context != null) {
            LinearLayout topLayout = new LinearLayout(context);
            topLayout.setOrientation(LinearLayout.VERTICAL);
            topLayout.setGravity(Gravity.CENTER_HORIZONTAL);
            topLayout.setPadding(0, AndroidUtilities.dp(20), 0, AndroidUtilities.dp(16));

            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.mipmap.ic_launcher);
            topLayout.addView(imageView, LayoutHelper.createLinear(72, 72, Gravity.CENTER_HORIZONTAL, 0, 0, 0, 8));

            TextView titleView = new TextView(context);
            titleView.setText("Hallagram");
            titleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            titleView.setTypeface(AndroidUtilities.bold());
            titleView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            topLayout.addView(titleView, LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL, 0, 0, 0, 2));

            TextView subtitleView = new TextView(context);
            subtitleView.setText("v1.4");
            subtitleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
            subtitleView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
            topLayout.addView(subtitleView, LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL));

            items.add(UItem.asCustom(topLayout));
        }

        // Categories
        items.add(UItem.asHeader("Categories"));
        items.add(UItem.asSettingsCell(ID_GHOST_MODE, R.drawable.ghost, "Ghost Mode"));
        items.add(UItem.asSettingsCell(ID_GENERAL, R.drawable.msg_settings, "General"));
        items.add(UItem.asShadow(null));

        // Links / Info
        items.add(UItem.asHeader("About"));
        items.add(UItem.asSettingsCell(ID_ABOUT, R.drawable.msg_help, "Version", "v1.4 (ARM64)"));
        items.add(UItem.asShadow(null));
    }

    @Override
    protected void onClick(UItem item, View view, int position, float x, float y) {
        if (item.id == ID_GHOST_MODE) {
            presentFragment(new HallagramGhostSettingsActivity());
        } else if (item.id == ID_GENERAL) {
            presentFragment(new HallagramGeneralSettingsActivity());
        }
    }

    @Override
    protected boolean onLongClick(UItem item, View view, int position, float x, float y) {
        return false;
    }
}
