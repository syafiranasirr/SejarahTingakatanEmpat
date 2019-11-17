package com.spm.sejarahtingkatanempat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class uploadPDFTeacher extends AppCompatActivity {

    EditText editPdfName;
    Button btnuploadFile;

    private StorageReference mStorageRef;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pdfteacher);

    }
}

     /*
        editPdfName = (EditText) findViewById(R.id.txt_pdfName);
        btnuploadFile = (Button) findViewById(R.id.btnFileUpload);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("extraNotes");

        btnuploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectPDFFile();
            }

            private void selectPDFFile() {

                Intent intent = new Intent();
                intent.setType("application/pdf");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select PDF File"), 1);
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode,Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

                    uploadPDFFile(data.getData());

                }
            }

            private void uploadPDFFile(Uri data) {

                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Uploading....");
                progressDialog.show();

                StorageReference reference = mStorageRef.child("extrNotes"+System.currentTimeMillis()+".pdf");
                reference.putFile(data)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                Task<Uri> uri =taskSnapshot.getStorage().getDownloadUrl();
                                while(!uri.isComplete());
                                Uri url =uri.getResult();

                                uploadPdfFile uploadPdfFile = new uploadPdfFile(editPdfName.getText().toString(),url.toString());
                                databaseReference.child(databaseReference.push().getKey().setValue(uploadPdfFile));
                                Toast.makeText(uploadPDFTeacher.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();

                            }
                        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                        double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();

                        progressDialog.setMessage("Uploaded:"+(int)progress+"%");

                    }
                });
            }
        });
    }


}*/
