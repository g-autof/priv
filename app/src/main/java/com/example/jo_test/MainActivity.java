package com.example.jo_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    int money=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void money_add_click(View view) {
        TextView money_line = (TextView) findViewById(R.id.out_umoney);
        money++;
        money_line.setText("Your money: " + money);

    }

    public void but_1(View view){

        autobuy_one myThread = new autobuy_one();
        myThread.start();

    }

    public class autobuy_one extends Thread{
        public void run()
        {
            try {

                ProgressBar prog_1 = (ProgressBar) findViewById(R.id.prgr_cycl_one);
                TextView money_line = (TextView) findViewById(R.id.out_umoney);

                int i = 0;
                while ( i <= 100)
                {
                    i++;
                    prog_1.setProgress(i);
                    Thread.sleep(10);
                    if (i == 100)
                        {
                            money++;
                            i = 0;
                            updateUI();
                        }
                }

            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
        public void updateUI(){
            TextView money_line = (TextView) findViewById(R.id.out_umoney);
            money_line.setText("Your money: " + money);}


}


