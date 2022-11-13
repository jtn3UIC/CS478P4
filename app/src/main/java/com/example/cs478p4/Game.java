package com.example.cs478p4;

import android.graphics.Color;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class Game extends AppCompatActivity {
    TableLayout layout;
    HashSet<Integer> p1;
    HashSet<Integer> p2;
    Game(TableLayout layout) {
        this.layout = layout;//(TableLayout) findViewById(R.id.board);
        p1 = new HashSet<>();
        p2 = new HashSet<>();
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
    public void movePiece(int start, int end,String p) {

        removePiece(start,p);
        addPiece(end,p);
    }
    public void addPiece(int end,String p) {
        int col = end % 3;
        TableRow row = (TableRow) layout.getChildAt(end/3);
        TextView view = (TextView) row.getChildAt(col);
        if (p.equals("p1")) {
            view.setBackgroundColor(Color.RED);
            p1.add(end);
        } else {
            view.setBackgroundColor(Color.BLUE);
            p2.add(end);
        }
    }
    public void removePiece(int start,String p) {
        int col = start % 3;
        TableRow row = (TableRow) layout.getChildAt(start/3);
        TextView view = (TextView) row.getChildAt(col);
        if (p.equals("p1")) {
            view.setBackgroundColor(Color.GRAY);
            p1.remove(start);
        } else {
            view.setBackgroundColor(Color.GRAY);
            p2.remove(start);
        }
    }
}
