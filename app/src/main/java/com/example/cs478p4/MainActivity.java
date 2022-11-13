package com.example.cs478p4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    Button start;
    Game game;
    Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();
        game = new Game((TableLayout) findViewById(R.id.board));
        start = (Button) findViewById(R.id.status);
        //game.addPiece(1,"p1");game.addPiece(5,"p2");game.addPiece(8,"p1");
        //game.movePiece(8,0,"p1");
        Thread t1 = new Thread(new Player1());
        t1.start();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.resetBoard();
            }
        });
    }
    class Player1 implements Runnable {
        String id = "p1";
        @Override
        public void run() {
            synchronized (game) {
                for (Integer i:game.open) {
                    if (game.p2.size() != 3) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                game.addPiece(i,id);
                            }
                        });
                    } else {
                        for (Integer j:game.p1) {
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    game.movePiece(j, i, id);
                                }
                            });
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
