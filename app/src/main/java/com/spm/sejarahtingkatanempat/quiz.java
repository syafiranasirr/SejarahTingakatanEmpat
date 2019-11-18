package com.spm.sejarahtingkatanempat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.objectweb.asm.Handle;
import org.w3c.dom.Text;

public class quiz extends AppCompatActivity
{

    Button b1, b2, b3,b4;
    TextView t1_question,timerTxt;
    int total=0;
    int correct =0;
    int wrong =0;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);

        t1_question= (TextView) findViewById (R.id.questionTxt);
        timerTxt = (TextView) findViewById(R.id.timerTxt);


        updateQuestion();
        reverseTimer(30,timerTxt);


    }

    private void updateQuestion()
    {
        total++;

        if (total > 2 )
        {
            Intent i = new Intent (quiz.this,ResultActivity.class);
            i.putExtra("total",String.valueOf(total));
            i.putExtra("correct",String.valueOf(correct));
            i.putExtra("incorrect",String.valueOf(wrong));
            startActivity(i);
        }
        else
        {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("kuiz").child("bab1").child(String.valueOf(total));
            databaseReference.addValueEventListener(new ValueEventListener()
            {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                {

                    final kuiz question =dataSnapshot.getValue(kuiz.class);

                    t1_question.setText(question.getQuestion()) ;
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());

                    b1.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view)
                        {

                            if (b1.getText().toString().equals(question.answer))
                            {
                                Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
                                b1.setBackgroundColor(Color.GREEN);
                                correct = correct + 1;
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        correct++;

                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            }
                            else
                            {
                                //if answer is wrong we will find the correct answer and make it green
                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                wrong = wrong + 1;

                                b1.setBackgroundColor(Color.RED);

                                if (b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if (b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if (b4.getText().toString().equals(question.getAnswer()))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                }




                              /*  Handler handler = new Handler();
                                handler.postDelayed()
                                {
                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                },1500); */

                            }
                        }


                    });
                    b2.setOnClickListener(new View.OnClickListener()
                             {
                                 @Override
                                 public void onClick(View view)
                                 {

                                     if (b2.getText().toString().equals(question.answer))
                                     {
                                         Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
                                         b2.setBackgroundColor(Color.GREEN);
                                         correct = correct + 1;
                                         Handler handler = new Handler();

                                         handler.postDelayed(new Runnable()
                                         {
                                             @Override
                                             public void run()
                                             {
                                                 correct++;

                                                 b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                                 updateQuestion();

                                             }
                                         }, 1500);
                                     }
                                     else
                                     {
                                         //if answer is wrong we will find the correct answer and make it green
                                         Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                         wrong = wrong + 1;

                                         b2.setBackgroundColor(Color.RED);

                                         if (b1.getText().toString().equals(question.getAnswer()))
                                         {
                                             b1.setBackgroundColor(Color.GREEN);
                                         }
                                         else if (b3.getText().toString().equals(question.getAnswer()))
                                         {
                                             b3.setBackgroundColor(Color.GREEN);
                                         }
                                         else if (b4.getText().toString().equals(question.getAnswer()))
                                         {
                                             b4.setBackgroundColor(Color.GREEN);
                                         }

                                  /*  Handler handler = new Handler();
                                    handler.postDelayed(()
                                {
                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                },1500); */

                          }

                       }

                     });

                    b3.setOnClickListener(new View.OnClickListener()
                    {
                       @Override
                       public void onClick(View view)
                       {
                           if (b3.getText().toString().equals(question.answer))
                           {
                               Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
                               b3.setBackgroundColor(Color.GREEN);
                               correct = correct + 1;
                               Handler handler = new Handler();

                               handler.postDelayed(new Runnable()
                               {
                                   @Override
                                   public void run()
                                   {
                                       correct++;

                                       b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                       updateQuestion();

                                   }
                               }, 1500);
                           }
                           else
                           {
                               //if answer is wrong we will find the correct answer and make it green
                               Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                               wrong = wrong + 1;

                               b3.setBackgroundColor(Color.RED);

                               if (b1.getText().toString().equals(question.getAnswer()))
                               {
                                   b1.setBackgroundColor(Color.GREEN);
                               }
                               else if (b2.getText().toString().equals(question.getAnswer()))
                               {
                                   b2.setBackgroundColor(Color.GREEN);
                               }
                               else if (b4.getText().toString().equals(question.getAnswer()))
                               {
                                   b4.setBackgroundColor(Color.GREEN);
                               }

                                  /*  Handler handler = new Handler();
                                    handler.postDelayed(()
                                {
                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                },1500); */

                           }

                       }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (b4.getText().toString().equals(question.answer))
                            {
                                Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
                                b4.setBackgroundColor(Color.GREEN);
                                correct = correct + 1;
                                Handler handler = new Handler();

                                handler.postDelayed(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        correct++;

                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            }
                                     else
                            {
                                //if answer is wrong we will find the correct answer and make it green
                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                                wrong = wrong + 1;

                                b4.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if (b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if (b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }

                                  /*  Handler handler = new Handler();
                                    handler.postDelayed(()
                                {
                                    b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                },1500); */

                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError)
                {

                }


            });
        }
    }

    public void reverseTimer (final int seconds, final TextView tv)
    {
        new CountDownTimer(seconds * 1000 + 1000,1000 )
        {
            public void onTick (long milisUntilFinished)
            {
                int seconds = (int) (milisUntilFinished/1000);
                int minutes = seconds /60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d",minutes)
                        + ":" + String.format("%02d",seconds));

            }

            @Override
            public void onFinish()
            {
                tv.setText("Completed");
                Intent myIntent = new Intent (quiz.this,ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myIntent);
            }

        }.start();


    }
}
