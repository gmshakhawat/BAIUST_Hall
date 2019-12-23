package com.example.baiust_hall.ui.seat_allotment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.baiust_hall.R;

public class SeatAllotment extends Fragment {

    private SeatAllotmentViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SeatAllotmentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_seat_allotment, container, false);


        final EditText currentSeat=root.findViewById(R.id.cseat);
        final EditText requestedSeat=root.findViewById(R.id.rseat);
        Button request=root.findViewById(R.id.request);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cseat=currentSeat.getText().toString();
                String rseat=requestedSeat.getText().toString();

                if(!cseat.equals("") && !rseat.equals("")){
                    Toast.makeText(getContext(),"Your Seat request is successfull !!!",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getContext(),"Please enter Current seat number and Requested Seat Number !!!",Toast.LENGTH_LONG).show();

                }
            }
        });

        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}