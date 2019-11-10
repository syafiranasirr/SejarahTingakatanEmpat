package com.spm.sejarahtingkatan4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.spm.sejarahtingkatanempat.R;
import com.spm.sejarahtingkatanempat.uploadPdfFile;

import java.util.List;

public class viewPdfFile extends AppCompatActivity {

    ListView pdflistview;
    DatabaseReference databaseReference;

    List<uploadPdfFile> uploadPDFS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf_file);

        pdflistview = (ListView) findViewById(R.id.pdflistview);


        viewAllFile();


        pdflistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                uploadPdfFile Upload =uploadPDFS.get(position);

                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uploadPdfFile.getUrl()));
                startActivity(intent);
            }
        });


    }

    private void viewAllFile() {

        databaseReference = FirebaseDatabase.getInstance().getReference("extraNotes");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
             public View getView(int position,View convertView, ViewGroup parent);
             {
                 View view = super.getView(position,convertView,parent);

                 TextView myText =(TextView) view.findViewById(android.R.id.text1);
                 myText.setTextColor(Color.BLACK);

                 //return super.getView(position,convertView,parent);

                 return view;

             };
             pdflistview.setAdapter(adapter);

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    uploadPdfFile Upload = postSnapshot.getValue(com.spm.sejarahtingkatanempat.uploadPdfFile.class);
                    uploadPDFS.add(Upload);
                }

                String[] uploads = new String[uploadPDFS.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadPDFS.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);


            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }


        });
    }


}
