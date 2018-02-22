package rhythmots.tempcalculator;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private Spinner sSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner sSpinner = (Spinner)findViewById(R.id.spinner);
        Button myButton = (Button)findViewById(R.id.calButton);
        final EditText tempInput = (EditText)findViewById(R.id.myEditText);
        final TextView cText = (TextView)findViewById(R.id.cText); cText.setText(".............");
        final TextView fText = (TextView)findViewById(R.id.fText); fText.setText(".............");
        final TextView kText = (TextView)findViewById(R.id.kText); kText.setText(".............");
        final TextView rText = (TextView)findViewById(R.id.rText); rText.setText(".............");
    //underline textview
//        SpannableString content = new SpannableString("          ");
//        content.setSpan(new UnderlineSpan(),0,content.length(),0);
//        cText.setText(content);
//        fText.setText(content);
//        kText.setText(content);
//        rText.setText(content);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.UnitofTemp));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sSpinner.setAdapter(myAdapter);



        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int temp = Integer.parseInt(tempInput.getText().toString());
                //Resources res = getResources();
                String[] unitTemp = getResources().getStringArray(R.array.UnitofTemp);



                    String getSpinner = sSpinner.getSelectedItem().toString();
                Log.d("ADebugtaG","temp : "+ getSpinner);
                Log.d("ADebugtaG","unitTemp : "+ unitTemp[0]);


                if(getSpinner.equals(unitTemp[0])){
                    cText.setText(String.valueOf(temp));
                    fText.setText(String.valueOf(temp*1.8+32));
                    kText.setText(String.valueOf(temp+273));
                    rText.setText(String.valueOf(temp*0.8));
                }

                else if(getSpinner.equals(unitTemp[1])){
                    cText.setText(String.valueOf((temp-32)*5/9));
                    fText.setText(String.valueOf(temp));
                    kText.setText(String.valueOf((temp+459.67)/1.8));
                    rText.setText(String.valueOf(((temp-32)*(5/9))*0.8 ));
                }

                else if(getSpinner.equals(unitTemp[2])){
                    cText.setText(String.valueOf(temp-273.15));
                    fText.setText(String.valueOf(temp*1.8-459.67));
                    kText.setText(String.valueOf(temp));
                    rText.setText(String.valueOf((temp-273.15)*0.8 ));
                }

                else if(getSpinner.equals(unitTemp[3])){
                    cText.setText(String.valueOf((temp*0.8)));
                    fText.setText(String.valueOf((temp*0.8)*18+32));
                    kText.setText(String.valueOf(temp*0.8)+273);
                    rText.setText(String.valueOf(temp));

                }

                }

        });



        }

    }








