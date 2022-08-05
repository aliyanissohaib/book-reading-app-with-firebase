package com.demo.myfirestore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;
    Button logout;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        RelativeLayout relativeLayout = findViewById(R.id.rl);
        logout=findViewById(R.id.button);
        relativeLayout.startAnimation(animation);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fAuth = FirebaseAuth.getInstance();


        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "C\n",
                        60000,
                        R.drawable.img,
                        "https://firebasestorage.googleapis.com/v0/b/fir-practice-a880a.appspot.com/o/c.pdf?alt=media&token=2fee110e-82b7-449a-87c4-b3511d6b7451"

                ));

        productList.add(
                new Product(
                        1,
                        " C# \n",

                        60000,
                        R.drawable.android,
                        "https://firebasestorage.googleapis.com/v0/b/fir-practice-a880a.appspot.com/o/cc.pdf?alt=media&token=a4dee975-4323-475f-b24f-7a65d7368e7f "
                                            ));

        productList.add(
                new Product(
                        1,
                        "Kotlin ",


                        60000,
                        R.drawable.kotlin,
                        "https://firebasestorage.googleapis.com/v0/b/fir-practice-a880a.appspot.com/o/kotlin.pdf?alt=media&token=8666280c-5afd-4a62-87d8-076ccb33e566  "
                ));

        productList.add(
                new Product(
                        1,
                        "Java",
                        60000,
                        R.drawable.img_1,
                        "https://firebasestorage.googleapis.com/v0/b/fir-practice-a880a.appspot.com/o/java.pdf?alt=media&token=68e2f6ff-3ae0-40e7-9d92-3745f362b320 "
                ));
        productList.add(
                new Product(
                        1,
                        "PHP",
                        60000,
                        R.drawable.php,
                        "https://firebasestorage.googleapis.com/v0/b/fir-practice-a880a.appspot.com/o/php.pdf?alt=media&token=c2c4cc18-48a3-47b8-a97d-2e7e5becd312  "
                ));
        productList.add(
                new Product(
                        1,
                        " PYTHON",
                        60000,
                        R.drawable.pthyonb,
                        "https://firebasestorage.googleapis.com/v0/b/fir-practice-a880a.appspot.com/o/python.pdf?alt=media&token=480ea28e-4fd1-4d1f-9f00-4ff457a35eb4"
                ));
        productList.add(
                new Product(
                        1,
                        "SQL",
                        60000,
                        R.drawable.sql,
                        "https://firebasestorage.googleapis.com/v0/b/fir-practice-a880a.appspot.com/o/sql.pdf?alt=media&token=fc007919-4dd2-45e3-80c4-396bac803ea5"
                ));
        productList.add(
                new Product(
                        1,
                        "Web",
                        60000,
                        R.drawable.webb,
                        "https://firebasestorage.googleapis.com/v0/b/fir-practice-a880a.appspot.com/o/web.pdf?alt=media&token=f8aabd01-2469-48d8-9138-ca7c21bf4acd "
                ));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });





        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

}
