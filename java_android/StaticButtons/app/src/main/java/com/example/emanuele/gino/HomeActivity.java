package com.example.emanuele.gino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
   // private EditText size;
    private Button prosegui;
    private TextView testohome;
    private String roni_size;
    private int choose;
    private RadioGroup homegroup;
    private RadioButton choosesize3,choosesize4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


       // size = (EditText) findViewById(R.id.size);
        homegroup = (RadioGroup) findViewById(R.id.homegroup);






            testohome = (TextView) findViewById(R.id.testohome);

            prosegui = (Button) findViewById(R.id.prosegui);
            prosegui.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                choosesize3= (RadioButton) findViewById(homegroup.getCheckedRadioButtonId());
                                                choosesize4= (RadioButton) findViewById(homegroup.getCheckedRadioButtonId());


                                                if(choosesize3.isChecked()){
                                                    Intent size_three_intent = new Intent(getApplicationContext(), Size_three.class); // <----- START "SEARCH" ACTIVITY
                                                    startActivityForResult(size_three_intent, 0);
                                                }

                                                    if(choosesize4.isChecked())
                                                    {
                                                        Intent Size_four_intent = new Intent(HomeActivity.this, Size_four.class); // <----- START "TYPE ENTRIES OUT" ACTIVITY
                                                        startActivity(Size_four_intent);
                                                        finish();
                                                    }
                                            }
                                            /*
            });
                                                try {
                                                    choose=Integer.parseInt(homechoose.getText().toString());
                                                    }
                                                catch (NumberFormatException e) {
                                                    Log.i("", choose + " is not a number");
                                                }
                                                switch(choose) {
                                                    case 3:

                                                        break;
                                                    case 4:
                                                        Intent Size_four_intent = new Intent(HomeActivity.this, Size_four.class);
                                                        startActivity(Size_four_intent);
                                                        finish();
                                                        break;
                                                }

                                            }
                                            */
                                        });


        }


}

