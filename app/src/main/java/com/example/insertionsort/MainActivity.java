package com.example.insertionsort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView tv_result;
    EditText array;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result=findViewById(R.id.tv_result);
        submit=findViewById(R.id.submit);
        array=findViewById(R.id.array);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] val=array.getText().toString().split(",");
                int arr[] = new int[val.length];
                for (int i=0;i<val.length;i++)
                {
                    arr[i]=Integer.valueOf(val[i]);

                }
                sort(arr);
                printArray(arr);
            }
        });

    }
    public static void sort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            tv_result.append(arr[i] + " ");
        tv_result.append("\n");

    }
}
