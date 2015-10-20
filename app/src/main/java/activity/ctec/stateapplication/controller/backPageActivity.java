package activity.ctec.stateapplication.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import activity.ctec.stateapplication.model.AndroidSaveState;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View;
import activity.ctec.stateapplication.R;
import android.content.Intent;
import activity.ctec.stateapplication.controller.FrontActivity;
import android.app.Activity;
import android.widget.EditText;
import android.app.Application;

public class backPageActivity extends android.app.Activity
{
    private Button BackButton;
    private TextView backPageText;
    private Application saveState;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_page);

        saveState = (AndroidSaveState) getApplication();
        BackButton = (Button) findViewById(R.id.backButton);
        backPageText = (TextView) findViewById(R.id.backPageText);

        loadContent();

        setuplisteners();
    }

    private void loadContent()
    {
        backPageText.setText(saveState.getUserName() + " is " + saveState.getAge()
        + " years old and their tired status is" + saveState.getIsTired());
    }

    private void setuplisteners()
    {
        BackButton.setOnClickListener(new View.OnClickListener)
        {
            Intent returnIntent = new Intent(clickView.getContext(), FrontActivity.class);
        }

    }

}
