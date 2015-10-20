package activity.ctec.stateapplication.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Application;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.view.View;
import android.content.Intent;
import activity.ctec.stateapplication.model.AndroidSaveState;
import activity.ctec.stateapplication.controller.backPageActivity;
import android.app.Activity;
import activity.ctec.stateapplication.R;

public class FrontActivity extends Activity
{
    private Button sendToOtherScreenButton;
    private EditText nameText;
    private EditText ageText;
    private CheckBox tiredBox;
    private Application saveState;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        saveState = (AndroidSaveState) getApplication();

        sendToOtherScreenButton = (Button) findViewById(R.id.submitButton);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = (EditText) findViewById(R.id.ageText);
        tiredBox = (CheckBox) findViewById(R.id.isTiredBox);

        setupListeners();
    }


    private void grabInput()
    {
        String name = nameText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());
        boolean isTired = tiredBox.isChecked();

        saveState.setUserName(name);
        saveState.setAge(age);
        saveState.setIsTired(isTired);

    }
    private void setupListeners()
    {
        sendToOtherScreenButton.setOnCLickListener(new View.OnCLickListener()
        {
            public void onCLick(View clickView)
            {
                String name = nameText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                boolean tired = tiredBox.isChecked();

                //save user input to the other screen
                saveState.setAge(age);
                saveState.setUserName(name);
                saveState.setIsTired(tired);

                nameText.setText("");
                ageText.setText("");
                tiredBox.setChecked(false);

                Intent newScreenIntent = new Intent(clickView.getContext(), backPageActivity.class);
                startActivityForResult(newScreenIntent, 0);

            }
        });
    }
}

