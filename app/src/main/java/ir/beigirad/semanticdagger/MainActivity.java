package ir.beigirad.semanticdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ir.beigirad.semanticdagger.model.CoffeeMaker;
import ir.beigirad.semanticdagger.di.AppComponent;
import ir.beigirad.semanticdagger.di.DaggerAppComponent;

public class MainActivity extends AppCompatActivity {

    AppComponent mAppComponent;

    @Inject
    CoffeeMaker mCoffeeMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppComponent = DaggerAppComponent.builder()
                .build();

        mAppComponent.inject(this);

        mCoffeeMaker.brew();

    }
}
