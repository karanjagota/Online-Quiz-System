package karanjagota.recruiters_test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView idView,result;
    int i,counter=0;
    int question_counter=0,option_counter=0;
    RadioButton choice1,choice2,choice3,choice4;

    // create a new database openhelper class reference ---
    DbHelper dbHandler = new DbHelper(this, null, null, 1);
    String [] questions = {" Which of these selection statements test only for equality? ",
            " Which of these keyword must be used to inherit a class? ",
            "A class member declared protected becomes member of subclass of which type? "};
    String [] answers = {"switch ","extends","private member"};
    String [] options_1 = {"switch","if","if & switch","None of the mentioned"};
    String[] options_2 = {"this","super","extends","none of these"},
            option_3 = {"static member","protected member ","public member","private member"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idView = (TextView) findViewById(R.id.ques_1);
      choice1 = (RadioButton) findViewById(R.id.choice1);
        choice2 = (RadioButton) findViewById(R.id.choice2);
        choice3 = (RadioButton) findViewById(R.id.choice3);
          choice4 = (RadioButton) findViewById(R.id.choice4);


        // loop for putting the questions inside the database ...

     for(i=0;i<questions.length && i<answers.length;i++)
     {
         Questions question_inside_database = new Questions(questions[i], answers[i]);
         dbHandler.addQuestion(question_inside_database);
     }

     if(question_counter==0)
        {
                Questions question =
                          dbHandler.findQuestion(questions[0]);
                if (question != null)
                {
                idView.setText(String.valueOf(question.getQuestionName()));
                choice1.setText(options_1[0]);
                choice2.setText(options_1[1]);
                choice3.setText(options_1[2]);
                choice4.setText(options_1[3]);
                }
        }

    }
   public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.choice1:
                if (checked && option_counter==0)
                    counter++;
                else {

                }

                    break;
            case R.id.choice2:
                if (checked)


                    break;
            case R.id.choice3:
                if (checked && option_counter==1 )
                    counter=counter+1;
                else{

                }

                    break;
            case R.id.choice4:
                if (checked && option_counter==2)
                    counter++;
                else{}


                    break;
        }
    }

    public void submit(View view) {

        question_counter++;
        option_counter++;

        result = (TextView) findViewById(R.id.result);
        result.setText("Your Score is " + counter);
        if(question_counter < 3) {
            Questions question =
                    dbHandler.findQuestion(questions[question_counter]);
            if (question != null) {
                idView.setText(String.valueOf(question.getQuestionName()));


            } else
            {
                idView.setText("End of questions . Your Score is " + counter);
            }
        }
        if (option_counter == 1) {
            choice1.setText(options_2[0]);
            choice2.setText(options_2[1]);
            choice3.setText(options_2[2]);
            choice4.setText(options_2[3]);
        } else if(option_counter==2){

            choice1.setText(option_3[0]);
            choice2.setText(option_3[1]);
            choice3.setText(option_3[2]);
            choice4.setText(option_3[3]);
        }

    }
}
