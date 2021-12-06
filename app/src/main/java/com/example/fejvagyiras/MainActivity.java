package com.example.fejvagyiras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button Button1, Button2;
    private TextView TextView1, TextView2, TextView3;
    private ImageView ImageView1, ImageView2;
    private int tipp, dobas, dobasok, gyozelem, vereseg, jatek;
    Random rnd = new Random();

    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        tippeles();




    }

    public void init() {
        Button1 = findViewById(R.id.Button1);
        Button2 = findViewById(R.id.Button2);
        TextView1 = findViewById(R.id.TextView1);
        TextView2 = findViewById(R.id.TextView2);
        TextView3 = findViewById(R.id.TextView3);
        ImageView1 = findViewById(R.id.ImageView1);
        tipp = 2;
        dobasok = 0;
        gyozelem =0;
        vereseg = 0;

    }
    public void tippeles(){


            Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dobas = rnd.nextInt(2);
                tipp = 0;
                if(dobas ==0){
                    ImageView1.setImageResource(R.drawable.heads);
                    if(tipp == dobas){
                        gyozelem++;
                        TextView2.setText(String.valueOf("Győzelem: "+gyozelem));
                        Toast.makeText(MainActivity.this, "Fej! Nyertél!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        vereseg++;
                        TextView3.setText(String.valueOf("Vereség: " +vereseg));
                        Toast.makeText(MainActivity.this, "Fej! Vesztettél!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    ImageView1.setImageResource(R.drawable.tails);
                    if(tipp == dobas){
                        gyozelem++;
                        TextView2.setText(String.valueOf("Győzelem: "+gyozelem));
                        Toast.makeText(MainActivity.this, "Írás! Nyertél!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        vereseg++;
                        TextView3.setText(String.valueOf("Vereség: " +vereseg));
                        Toast.makeText(MainActivity.this, "Írás! Vesztettél!", Toast.LENGTH_SHORT).show();
                    }
                }

            dobasok++;
            TextView1.setText(String.valueOf("Dobások: "+dobasok));
            if(dobasok>3&&gyozelem!=vereseg){
                if(gyozelem<vereseg){
                AlertDialogCreate();
                alertDialog.setTitle("Vesztettél");
                alertDialog.show();}
                else{AlertDialogCreate();
                    alertDialog.setTitle("Nyertél");
                    alertDialog.show();}
                }

            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 1;
                dobas = rnd.nextInt(2);
                if(dobas ==0){
                    ImageView1.setImageResource(R.drawable.heads);
                    if(tipp == dobas){
                        gyozelem++;
                        TextView2.setText(String.valueOf("Győzelem: " +gyozelem));
                        Toast.makeText(MainActivity.this, "Fej! Nyertél!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        vereseg++;
                        TextView3.setText(String.valueOf("Vereség: "+vereseg));
                        Toast.makeText(MainActivity.this, "Fej! Vesztettél!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    ImageView1.setImageResource(R.drawable.tails);
                    if(tipp == dobas){
                        gyozelem++;
                        TextView2.setText(String.valueOf("Győzelem: " +gyozelem));
                        Toast.makeText(MainActivity.this, "Írás! Nyertél!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        vereseg++;
                        TextView3.setText(String.valueOf("Vereség: "+vereseg));
                        Toast.makeText(MainActivity.this, "Írás! Vesztettél!", Toast.LENGTH_SHORT).show();
                    }
                }

                dobasok++;
                TextView1.setText(String.valueOf("Dobások: "+dobasok));
                if(dobasok>3&&gyozelem!=vereseg){
                    if(gyozelem<vereseg){
                        AlertDialogCreate();
                        alertDialog.setTitle("Vesztettél");
                        alertDialog.show();}
                    else{AlertDialogCreate();
                        alertDialog.setTitle("Nyertél");
                        alertDialog.show();}
                }

            }
        });




    }
    public void AlertDialogCreate() {
        alertDialog= new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Szeretnél e új játékot?");
        alertDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetGame();
            }
        });
        alertDialog.create();
    }


    public void resetGame(){
            dobas=0;
            TextView1.setText(String.valueOf("Dobások: " +dobas));
            gyozelem=0;
            TextView2.setText(String.valueOf("Győzelem: " +gyozelem));
            vereseg = 0;
            TextView3.setText(String.valueOf("Vereség: " +vereseg));
            ImageView1.setImageResource(R.drawable.heads);
            dobasok =0;


    }

}