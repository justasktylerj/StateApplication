package activity.ctec.stateapplication.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import ctec.stateapplication.model.AndroidSaveState;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import activity.ctec.stateapplication.R;

public class backPageActivity extends ActionBarActivity
{
    private void (Button) BackButton;
    private void (TextView) UserText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_page);

        saveState = (AndroidSaveState) getApplication();
        backButton = (Button) findViewById(R.id.backButton);
        userText = (TextView) findViewById(R.id.backPageText);

        loadContent();

        setuplisteners();
    }

    private void loadContent()
    {
        userText.setText(saveState.getUserName() + " is " + saveState.getAge()
        + " years old and their tired status is" + saveState.getIsTired());
    }

    private void setuplisteners()
    {
        backButton.setOnClickListener(new View.OnClickListener)
        {
            
        }

    }

}
