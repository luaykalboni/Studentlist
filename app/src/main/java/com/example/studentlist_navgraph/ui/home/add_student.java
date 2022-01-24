package com.example.studentlist_navgraph.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentlist_navgraph.R;
import com.example.studentlist_navgraph.ui.home.model.Model;
import com.example.studentlist_navgraph.ui.home.model.Student;


public class add_student extends Fragment {

    public static add_student newInstance() {

        add_student fragment = new add_student();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_student, container, false);



        view.findViewById(R.id.main_save_btn).setOnClickListener(v -> {
            TextView newName = (TextView) view.findViewById(R.id.main_name_et);
            TextView newId = (TextView) view.findViewById(R.id.main_id_et);
            CheckBox newCb = (CheckBox) view.findViewById(R.id.main_cb);

            Model.instance.addStudent(new Student(
                    newName.getText().toString(),
                    newId.getText().toString(),
                    newCb.isChecked()
            ));




            Navigation.findNavController(view).navigateUp();
        });


        view.findViewById(R.id.main_cancel_btn).setOnClickListener(v -> {


            Navigation.findNavController(view).navigateUp();

        });

        return view;
    }
}