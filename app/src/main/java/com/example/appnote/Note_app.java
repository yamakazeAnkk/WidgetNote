package com.example.appnote;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Shader;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class Note_app extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
            int appWidgetId) {


        SharedPreferences preferences = context.getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
        String noteTitle = preferences.getString("note_Title","");
        String noteText = preferences.getString("note_Text","");

        RemoteViews view = new RemoteViews(context.getPackageName(),R.layout.note_app);
        view.setTextViewText(R.id.appwidget_title,noteTitle);
        view.setTextViewText(R.id.appwidget_text,noteText);
        appWidgetManager.updateAppWidget(appWidgetId,view);
    }
}