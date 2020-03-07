package com.example.mentalgyaan;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryFragment extends Fragment {

    private View mView;
    private DatabaseReference Ref;
    private EditText diaryText;
    private Spinner diaryDate;
    private Button submitButton;



    public DiaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_diary, container, false);

        Init();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateData = formatter.format(date);

        List<String> dates = new ArrayList<String>();
        dates.add(dateData);




        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, dates);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        diaryDate.setAdapter(dataAdapter);





        return mView;
    }

    private void Init() {
        diaryText = (EditText)mView.findViewById(R.id.diary_text);
        diaryDate = (Spinner)mView.findViewById(R.id.diary_date);
        submitButton = (Button)mView.findViewById(R.id.submit_button);
    }

}
