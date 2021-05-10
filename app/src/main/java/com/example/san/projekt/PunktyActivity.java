package com.example.san.projekt;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PunktyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punkty);

        GlobalVariables.handler.removeCallbacksAndMessages(null);

        int LPkt = GlobalVariables.CPkt;

        final TextView TPunkty = findViewById(R.id.textView5);
        final TextView Powitanie = findViewById(R.id.textView10);
        Button btnNAG = findViewById(R.id.button3);

        String Witaj = "";


        if (GlobalVariables.current_login != ""){
            Witaj+="Witaj " + GlobalVariables.current_login;
        } else{
            Witaj+="Nie jesteś zalogowany";
        }

        String Info = "Twoja liczba punktów wynosi: " + LPkt + "\n\n";
        Info += "Korzystaj z komunikacji miejskiej by zbierać nagrody";

        TPunkty.setText(Info);
        Powitanie.setText(Witaj);


        btnNAG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new  AlertDialog.Builder(PunktyActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.nagrody2, null);

                /*final TextView LNagrod = mView.findViewById(R.id.textView6);

                String Nagrody = "Lista nagród: \n\n";
                Nagrody+= "200 pkt = jeden bilet normalny \n";
                Nagrody+= "1000 pkt = zniżka na siłownie \n";
                Nagrody += "5000 pkt = doładowanie karty na miesiąc \n";
                Nagrody += "12000 pkt = doładowanie karty na 3 miesiące\n";

                LNagrod.setText(Nagrody);*/

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }
        });


    }
}
