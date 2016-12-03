package com.example.apple.menunavigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BmiFragment extends Fragment {

    private TextView txtBmi, txtResult;
    private EditText editWeight, editHeight;
    private Button calButton;
    private String weightString, heightString, bmiResult;


    public BmiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup bmi = (ViewGroup) inflater.inflate(R.layout.fragment_bmi, container, false);
        editHeight = (EditText) bmi.findViewById(R.id.editText);
        editWeight = (EditText) bmi.findViewById(R.id.editText2);
        calButton = (Button) bmi.findViewById(R.id.button);
        txtBmi = (TextView) bmi.findViewById(R.id.textView3);
        txtResult = (TextView) bmi.findViewById(R.id.textView4);

        // Inflate the layout for this fragment

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightString = editWeight.getText().toString().trim();
                heightString = editHeight.getText().toString().trim();

                if (weightString.length() < 1) {
                    MsgAlert alert = new MsgAlert();
                    alert.myDialog(getActivity(), R.drawable.doremon48, "กรอกข้อมูลไม่ครบ", "กรุณากรอกน้ำหนัก");
                    return;
                }
                if (heightString.length() < 1) {
                    MsgAlert alert = new MsgAlert();
                    alert.myDialog(getActivity(), R.drawable.doremon48, "กรอกข้อมูลไม่ครบ", "กรุณากรอกส่วนสูง");
                    return;
                }

                float weight = Float.valueOf(weightString);
                float height = Float.valueOf(heightString);
                float BMI = weight / (height * height) * 10000;

                txtBmi.setText(String.valueOf(BMI));
                txtResult.setText(String.valueOf(bmiResult));

                if (BMI < 18.5) {
                    bmiResult = "ต่ำกว่ามาตรฐาน";
                } else if (BMI < 25) {
                    bmiResult = "ปกติ";
                } else if (BMI < 30) {
                    bmiResult = "อ้วน";
                } else {
                    bmiResult = "อ้วนมาก";
                }
            }
        });

        return bmi;
    }

}
