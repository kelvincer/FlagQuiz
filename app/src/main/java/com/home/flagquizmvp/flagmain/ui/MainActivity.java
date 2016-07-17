package com.home.flagquizmvp.flagmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.home.flagquizmvp.FlagQuizApp;
import com.home.flagquizmvp.R;
import com.home.flagquizmvp.entitites.Flag;
import com.home.flagquizmvp.flagmain.FlagQuizPresenter;
import com.home.flagquizmvp.flagmain.di.FlagQuizComponent;
import com.home.flagquizmvp.lib.ImageLoader;
import com.home.flagquizmvp.lib.di.LibsComponent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FlagQuizView {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.guessTxt)
    TextView guessTxt;
    @BindView(R.id.firstBtn)
    Button firstBtn;
    @BindView(R.id.secondBtn)
    Button secondBtn;
    @BindView(R.id.thirdBtn)
    Button thirdBtn;
    @BindView(R.id.fourthBtn)
    Button fourthBtn;
    @BindView(R.id.answerTxt)
    TextView answerTxt;
    @BindView(R.id.container)
    RelativeLayout container;

    private Flag flag;
    private ImageLoader imageLoader;
    private FlagQuizPresenter presenter;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Glide.with(this).load("http://www.geognos.com/api/en/countries/flag/PE.png").into(image);

        /*GlideImageLoader glideImageLoader = new GlideImageLoader();
        glideImageLoader.setLoaderContext(this);
        glideImageLoader.load(image, "http://www.geognos.com/api/en/countries/flag/PE.png");*/

        /*FlagQuizApp flagQuizApp = (FlagQuizApp) getApplication();
        LibsComponent flagQuizMainComponent = flagQuizApp.getFlagQuizMainComponent(this);
        ImageLoader imageLoader = flagQuizMainComponent.getImageLoader();
        imageLoader.load(image, "http://www.geognos.com/api/en/countries/flag/PE.png");*/

        setupInjection();
        setupImageLoading();

        handler = new Handler();
        presenter.onCreate();
        presenter.getFlag();

        getSupportActionBar().setTitle("Banderas");

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showButtons() {
        enableButtons(true);
    }

    @Override
    public void hideButtons() {

        enableButtons(false);
    }

    @Override
    public void showAnswer() {
        answerTxt.setVisibility(View.VISIBLE);
    }

    @Override
    public void showIncorrectAnswer() {
        answerTxt.setText("Incorrect");
    }

    @Override
    public void setFlag(Flag flag) {

        Log.d("Debug", "Set new flag");
        Log.d("Debug", flag.getFlagName());
        this.flag = flag;
        if(flag.getSourceUrl() == null){


        }else{
            imageLoader.load(image, flag.getSourceUrl());
        }
    }

    @Override
    public void setButtonText(List<String> names) {

        firstBtn.setText(names.get(0));
        secondBtn.setText(names.get(1));
        thirdBtn.setText(names.get(2));
        fourthBtn.setText(names.get(3));
    }


    @Override
    public void onGetFlagError(String error) {

        String msgError = String.format(getString(R.string.flagquiz_error), error);
        Snackbar.make(container, msgError, Snackbar.LENGTH_SHORT).show();
    }

    @OnClick({R.id.firstBtn, R.id.secondBtn, R.id.thirdBtn, R.id.fourthBtn})
    void guessFirst(View view) {

        Button button = (Button) view;
        checkAnswer(button);
    }

    private void checkAnswer(Button button) {

        if(button.getText().toString().equals(flag.getFlagName()))
        {
            answerTxt.setTextColor(ContextCompat.getColor(this, R.color.Correct_answer));
            answerTxt.setText(getResources().getString(R.string.Main_correct_answer));
            answerTxt.setVisibility(View.VISIBLE);
            enableButtons(false);
            setPostDelayed();
        }
        else {
            button.setEnabled(false);
            answerTxt.setTextColor(ContextCompat.getColor(this, R.color.Incorrect_asnwer));
            answerTxt.setText(getResources().getString(R.string.Main_incorrect_answer));
            answerTxt.setVisibility(View.VISIBLE);
        }
    }

    void enableButtons(boolean enable) {

        firstBtn.setEnabled(enable);
        secondBtn.setEnabled(enable);
        thirdBtn.setEnabled(enable);
        fourthBtn.setEnabled(enable);
    }

    private void setupInjection() {

        FlagQuizApp flagQuizApp = (FlagQuizApp) getApplication();
        FlagQuizComponent flagQuizComponent = flagQuizApp.getFlagQuizComponent(this, this);
        presenter = flagQuizComponent.getPresenter();

        LibsComponent libsComponent = flagQuizApp.getLibsComponent(this);
        imageLoader = libsComponent.getImageLoader();
    }
    private void setPostDelayed(){

        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        animate();
                    }
                }, 2000);
    }

    private void resetQuiz() {

        enableButtons(true);
        answerTxt.setVisibility(View.GONE);
    }

    private void animate() {
        // prevent animation into the the UI for the first flag

        // calculate center x and center y
        int centerX = (container.getLeft() +
                container.getRight()) / 2; // calculate center x
        int centerY = (container.getTop() +
                container.getBottom()) / 2; // calculate center y

        // calculate animation radius
        int radius = Math.max(container.getWidth(), container.getHeight());

        Animator animator;

        // if the quizLinearLayout should animate out rather than in
         // if the quizLinearLayout should animate in
        animator = ViewAnimationUtils.createCircularReveal(container, centerX, centerY, 0, radius);
        presenter.getFlag();
        resetQuiz();

        //animator.setDuration(500); // set animation duration to 500 ms
        animator.setDuration(1500L);
        animator.start(); // start the animation
    }

    private void setupImageLoading() {
        imageLoader.setOnFinishedImageLoadingListener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                Snackbar.make(container, e.getMessage(), Snackbar.LENGTH_SHORT).show();
                Log.i("Debug error", e.getLocalizedMessage());
                animate();
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                return false;
            }
        });
    }
}
