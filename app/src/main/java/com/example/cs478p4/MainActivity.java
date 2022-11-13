package com.example.cs478p4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Game game = new Game((TableLayout) findViewById(R.id.board));
        start = (Button) findViewById(R.id.status);
        game.addPiece(1);game.addPiece(5);game.addPiece(9);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.resetBoard();
            }
        });
    }
}