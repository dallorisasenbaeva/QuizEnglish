package com.example.englishquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textQuestionNumber, textScore, textImage, textQuestion, textInfo;
    ImageView image;
    RadioGroup radioGroup;
    RadioButton radio1, radio2, radio3, radio4;
    Button buttonSubmit;
    int questionIndex = 0;
    int score = 0;
    DataSource dataSource = new DataSource();
    List<QuizData> quizDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadView();
        quizDataList.addAll(dataSource.getQuestions());
        setActiveQuestion(questionIndex);
        buttonSubmit.setOnClickListener(v -> {
            int checkedRadioId = radioGroup.getCheckedRadioButtonId();
            if (checkedRadioId == -1) {
                Toast.makeText(this, "Plese select one answer...", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedRadio = findViewById(checkedRadioId);
                String text = selectedRadio.getText().toString();
                if (text.equals(quizDataList.get(questionIndex).getAnswer())) {
                    showInfo(true);
                    textScore.setText("Ball: " + (++score));
                } else {
                    showInfo(false);
                }
                if (questionIndex >= quizDataList.size() - 1) {
                    hideViews();
                    textQuestionNumber.setText("");
                    textScore.setText("");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Oyin tugadi").setMessage("Siz " + (questionIndex + 1) + " savoldan " + (score) + " ta topdingiz").setCancelable(false).setPositiveButton("Qayta boshlash", (dialogInterface, i) -> restartUI()).setNegativeButton("Chiqish", ((dialogInterface, i) -> finish()));
                    Dialog dialog = builder.create();
                    dialog.show();
                } else {
                    radioGroup.clearCheck();
                    setActiveQuestion(++questionIndex);
                }

            }
        });
    }

    private void loadView() {
        textQuestionNumber = findViewById(R.id.text_question_number);
        textScore = findViewById(R.id.text_score);
        textImage = findViewById(R.id.text_image);
        textQuestion = findViewById(R.id.text_question);
        textInfo = findViewById(R.id.text_info);

        image = findViewById(R.id.image);

        radioGroup = findViewById(R.id.radio_group);

        radio1 = findViewById(R.id.option1);
        radio2 = findViewById(R.id.option2);
        radio3 = findViewById(R.id.option3);
        radio4 = findViewById(R.id.option4);

        buttonSubmit = findViewById(R.id.button_tasdiqlash);
    }

    void setActiveQuestion(int index) {
        QuizData currentQuestion = quizDataList.get(index);
        if (currentQuestion.getTextQuestion() == null && currentQuestion.getImage() != 0) {
            textQuestion.setVisibility(View.INVISIBLE);
            textImage.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);

            image.setImageResource(currentQuestion.getImage());
            textImage.setText(currentQuestion.getTextImage());
            textQuestion.setText("");
        } else {
            textImage.setVisibility(View.INVISIBLE);
            image.setVisibility(View.INVISIBLE);
            textQuestion.setVisibility(View.VISIBLE);

            image.setImageResource(0);
            textImage.setText("");

            textQuestion.setText(currentQuestion.getTextQuestion());

        }
        radio1.setText(currentQuestion.getOption1());
        radio2.setText(currentQuestion.getOption2());
        radio3.setText(currentQuestion.getOption3());
        radio4.setText(currentQuestion.getOption4());

        textQuestionNumber.setText("Savol: " + (++index));
    }

    void restartUI() {
        showViews();
        radioGroup.clearCheck();
        questionIndex = 0;
        score = 0;
        Collections.shuffle(quizDataList);
        setActiveQuestion(questionIndex);
        textQuestionNumber.setText("Savol: " + (questionIndex + 1));
        textScore.setText("Ball: " + score);
    }

    void showInfo(boolean isCorrect) {
        if (isCorrect) {
            textInfo.setBackgroundResource(R.drawable.succes_bacground);
            textInfo.setText("Javob tog'ri");
        } else {
            textInfo.setBackgroundResource(R.drawable.fail_bacground);
            textInfo.setText("Javob notog'ri");
        }
        new CountDownTimer(1000, 1000) {

            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {

                textInfo.setText("");
            }
        }.start();
    }

    void hideViews() {
        radioGroup.setVisibility(View.INVISIBLE);
        textScore.setVisibility(View.INVISIBLE);
        textImage.setVisibility(View.INVISIBLE);
        image.setVisibility(View.INVISIBLE);
        textQuestion.setVisibility(View.INVISIBLE);
        buttonSubmit.setVisibility(View.INVISIBLE);
    }

    void showViews() {
        radioGroup.setVisibility(View.VISIBLE);
        textScore.setVisibility(View.VISIBLE);
        textImage.setVisibility(View.VISIBLE);
        image.setVisibility(View.VISIBLE);
        textQuestion.setVisibility(View.VISIBLE);
        buttonSubmit.setVisibility(View.VISIBLE);
    }

}