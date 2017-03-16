package com.example.firebasenotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    ArrayList<Person> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   textView=(TextView)findViewById(R.id.textv);
        Firebase.setAndroidContext(this);
        Firebase firebase=new Firebase(Config.FIREBASE_URL);
        listView=(ListView)findViewById(R.id.list1);


        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

      //  DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        //Storing values to firebase

        Person  person =new Person();
        person.setName("Ravin");
        person.setFirstname("Jasoliya");

        firebase.child("name").setValue(person);

        person =new Person();
        person.setName("mamta");
        person.setFirstname("patel");

        firebase.child("name1").setValue(person);

        person =new Person();
        person.setName("jaydeep");
        person.setFirstname("desai");

        firebase.child("name2").setValue(person);

        person =new Person();
        person.setName("julee");
        person.setFirstname("patel");

        firebase.child("name3").setValue(person);

      /*  person =new Person();
        person.setName("Jaydev");
        person.setFirstname("Chudasama");

        //Storing values to firebase
       firebase.child("name").setValue(person);
        person =new Person();
        person.setName("keyur");
        person.setFirstname("jasoliya");
*/
        //Storing values to firebase
     //  firebase.child("id:ravin,mo:8460,add:tarasamiya,id:bhavin,mo:9033,add:tarasamiya").setValue("0");


        /*DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("mamta").addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                for (com.google.firebase.database.DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //Getting the data from snapshot
                    Person person = postSnapshot.getValue(Person.class);

                    //Adding it to a string
                    String string = "Name: "+person.getName()+"\nAddress: "+person.getFirstname()+"\n\n";

                    //Displaying it on textview
                    textView.setText(string);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

    //    Firebase firebase1=new Firebase("https://fir-notification-bff9a.firebaseio.com/name");

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayList=new ArrayList<Person>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Log.e("r=",dataSnapshot.getValue()+"");

                   // Person person=new Person();
                   Person person = child.getValue(Person.class);
                    arrayList.add(person);


               /*     try {
                 /*       JSONArray jsonArray = new JSONArray(dataSnapshot.getValue().toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            arrayList.add(jsonObject.getString("id"));
                            Toast.makeText(MainActivity.this, ""+jsonObject.getString("id"), Toast.LENGTH_SHORT).show();

                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }*/


                    //  ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);


                 //   textView.setText(dataSnapshot.child("name").getValue().toString());
                   /* for (DataSnapshot childd : child.getChildren()) {
                        //This might work but it retrieves all the data
                        Log.e("r=",childd.getKey()+"");
                    }*/
                    adpt arrayAdapter=new adpt(MainActivity.this,arrayList);

                    arrayAdapter.notifyDataSetChanged();
                    listView.setAdapter(arrayAdapter);

                }

              //  listView.setAdapter(arrayAdapter);
                myfun();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    public void myfun()
    {


    }
}
