package com.example.studentlist_navgraph.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.studentlist_navgraph.ui.home.model.Model;
import com.example.studentlist_navgraph.ui.home.model.Student;
import com.example.studentlist_navgraph.R;


public class StudentDetailsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_details, container, false);

        TextView name = view.findViewById(R.id.details_name_tv);
        TextView id = view.findViewById(R.id.details_id_tv);
        CheckBox cb = view.findViewById(R.id.details_cb);


        String studentId = StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentid();
        String studPos = StudentDetailsFragmentArgs.fromBundle(getArguments()).getPosition();

        Student student = Model.instance.getStudentById(studentId);


        id.setText(student.getId());
        name.setText(student.getName());

        if (student.isFlag()) {
            cb.setChecked(true);
            cb.setText("checked");
        } else {
            cb.setChecked(false);
            cb.setText("unchecked");
        }

        View viewById = view.findViewById(R.id.edit_button);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Navigation.findNavController(v).navigate(StudentDetailsFragmentDirections.actionStudentDetailsFragmentToEditStudentFragment2(studentId,studPos));
            }
        });

        View backbttn = view.findViewById(R.id.back_button);
        backbttn.setOnClickListener((v)->{
            Navigation.findNavController(v).navigateUp();
        });


        return view;
    }


}