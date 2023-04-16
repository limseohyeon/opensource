package com.example.challenge09;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomerFragment extends Fragment {
    EditText edtName;
    EditText edtAge;
    Button edtDate;


    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener setDate= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,dayofmonth);
            dateString();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment,container,false);

        edtName = rootView.findViewById(R.id.edtName);
        edtAge = rootView.findViewById(R.id.edtAge);
        edtDate = rootView.findViewById(R.id.edtDate);
        Date currentTime = Calendar.getInstance().getTime();
        edtDate.setText(new SimpleDateFormat("YYYY/MM/dd",Locale.getDefault()).format(currentTime));



        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), setDate, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        Button btnSave = rootView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //눌렀을 때 이름이 뜨게
                String name = edtName.getText().toString();
                String age = edtAge.getText().toString();
                String date = edtDate.getText().toString();

                    Toast.makeText(getContext(), name +"/"+ age +"/"+ date, Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }

    public void dateString(){
        String format = "YYYY/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
        edtDate.setText(simpleDateFormat.format(calendar.getTime()));
    }
}
