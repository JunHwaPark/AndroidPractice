package com.junhwa.doitmission09;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegistrationFragment extends Fragment {
    EditText editName, editAge, editBirth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_registration, container, false);

        editName = rootView.findViewById(R.id.editText);
        editAge = rootView.findViewById(R.id.editText2);
        editBirth = rootView.findViewById(R.id.editText3);

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        final Date date = new Date();
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        editBirth.setText(simpleDateFormat.format(date));

        editBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                DatePickerDialog dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editBirth.setText(i + "/" + (i1 + 1) + "/" + i2);
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                if (editBirth.hasFocus())
                    dpd.show();
                editBirth.clearFocus();
            }
        });

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                if(editName.getText().toString().length() == 0 ||
                editBirth.getText().toString().length() == 0) {
                    Snackbar.make(rootView, "이름, 나이, 생년월일을 입력해주세요", Snackbar.LENGTH_LONG).show();
                    return;
                }
                try {
                    mainActivity.onSaveButtonClicked(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), editBirth.getText().toString());
                } catch (NumberFormatException e) {
                    Snackbar.make(rootView, "정확한 정보를 입력해주세요", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        return rootView;
    }
}
