package com.e.mytaskapp.Activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.mytaskapp.App;
import com.e.mytaskapp.R;
import com.e.mytaskapp.models.Task;

public class FormActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText descriptionEditText;
    Button buttonSize;
    Task task;
    AlertDialog alertDialog;
    CharSequence[] values = {"20sp", "30sp", "40sp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        titleEditText = findViewById(R.id.edit_title);
        descriptionEditText = findViewById(R.id.edit_description);
        buttonSize = findViewById(R.id.text_size);

        task = (Task) getIntent().getSerializableExtra("task");

        if (task != null) {
            titleEditText.setText(task.getTitle());
            descriptionEditText.setText(task.getDescription());
        }
        buttonSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialogWarning();

            }
        });
    }

    public void onClickCancel(View view) {

        finish();
    }

    public void OnClickSave(View view) {

        String title = titleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        if (task != null) {
            task.setTitle(title);
            task.setDescription(description);
            App.getInstance().getDatabase().taskDao().update(task);
        } else {
            Task task = new Task();
            task.setTitle(title);
            task.setDescription(description);
            App.getInstance().getDatabase().taskDao().insert(task);


        }
        if (title.matches("")) {
            Toast.makeText(this, "Вы забыли сделать запись!", Toast.LENGTH_SHORT).show();
            return;
        }
        finish();


    }

    public void AlertDialogWarning() {
        AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
        builder.setTitle("Выберите размер текста");
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        titleEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                        descriptionEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                        break;
                    case 1:
                        titleEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                        descriptionEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                        break;
                    case 2:
                        titleEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                        descriptionEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                        break;
                }
                alertDialog.dismiss();

            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

}

