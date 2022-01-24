package com.example.studentlist_navgraph.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.studentlist_navgraph.R;
import com.example.studentlist_navgraph.ui.home.model.Model;
import com.example.studentlist_navgraph.ui.home.model.Student;

public class editStudent_Fragment extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_student, container, false);


        TextView name = view.findViewById(R.id.main_name_et);
        TextView id = view.findViewById(R.id.main_id_et);
        CheckBox cb = view.findViewById(R.id.main_cb);


        String studentId = editStudent_FragmentArgs.fromBundle(getArguments()).getStudentid();
        String position = editStudent_FragmentArgs.fromBundle(getArguments()).getPosition();

        Student student = Model.instance.getStudentById(studentId);

        id.setText(student.getId());
        name.setText(student.getName());

        if (student.isFlag()) {
            cb.setChecked(true);
        } else {
            cb.setChecked(false);
            cb.setText("unchecked");
        }

        view.findViewById(R.id.main_save_btn).setOnClickListener(v -> {
            Model.instance.editStudent(new Student(
                    ((TextView) view.findViewById(R.id.main_name_et)).getText().toString(),
                    ((TextView) view.findViewById(R.id.main_id_et)).getText().toString(),
                    ((CheckBox) view.findViewById(R.id.main_cb)).isChecked()
            ), Integer.parseInt(position));




            Navigation.findNavController(view).navigateUp();
        });

        view.findViewById(R.id.main_cancel_btn).setOnClickListener(v -> {


            Navigation.findNavController(view).navigateUp();

        });


        view.findViewById(R.id.delete_buttn).setOnClickListener(v -> {

            Model.instance.removeStudent(studentId);

            Navigation.findNavController(view).navigate(editStudent_FragmentDirections.actionEditStudentFragmentToNavHome());

        });

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb.isChecked()) {
                    cb.setChecked(true);
                    cb.setText("checked");
                } else {
                    cb.setChecked(false);
                    cb.setText("unchecked");
                }
            }
        });

        return view;
    }
}