package com.example.cs478p4;

import android.graphics.Color;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {
    TableLayout layout;
    Game(TableLayout layout) {
        this.layout = layout;//(TableLayout) findViewById(R.id.board);
    }
    public void resetBoard() {
        for (int i = 0; i < layout.getChildCount(); i++) {
            System.out.println(i);
            View child = layout.getChildAt(i);

            if (child instanceof TableRow) {
                TableRow row = (TableRow) child;

                for (int x = 0; x < row.getChildCount(); x++) {
                    TextView view = (TextView) row.getChildAt(x);
                    //view.setEnabled(false);
                    view.setBackgroundColor(Color.GRAY);
                }
            }
        }
    }
}
