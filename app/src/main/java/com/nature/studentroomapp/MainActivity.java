package com.nature.studentroomapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText e;
    Button b;
    TextView t;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View connect
         e = findViewById(R.id.E);
         b = findViewById(R.id.B);
         t = findViewById(R.id.T);

        // Room Database create
        db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "student_database"
        ).allowMainThreadQueries().build();

        // Button click
        b.setOnClickListener(v -> {

            // 1. Get name from EditText
            String nameFromUser = e.getText().toString();

            if (!nameFromUser.isEmpty()) {

                // 2. Create Student object
                Student newStudent = new Student(nameFromUser);

                // 3. Insert into database
                db.studentDao().insert(newStudent);

                // 4. Get all students
                List<Student> studentsList = db.studentDao().getAllStudents();

                StringBuilder sb = new StringBuilder();

                for (Student s : studentsList) {
                    sb.append("ID: ")
                            .append(s.getId())
                            .append(" Name: ")
                            .append(s.getName())
                            .append("\n");
                }

                // 5. Display in TextView
                t.setText(sb.toString());

                // 6. Clear EditText
                e.setText("");
            }
        });
    }
}