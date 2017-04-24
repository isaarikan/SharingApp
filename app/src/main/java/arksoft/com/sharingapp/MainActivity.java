package arksoft.com.sharingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView)findViewById(R.id.textView);
        btn=(Button)findViewById(R.id.button);

        //When button is clicked we share textview's message
        //Butona tıklanıldığında textview mesajını paylaşacağız
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence message=txt.getText();
                mesajPaylas(message);
            }


        });

    }

    private void mesajPaylas(CharSequence message) {

        Intent share=new Intent(Intent.ACTION_SEND);
        //Metin ifadesi paylaşmak için ona uygun parametre gönderiyoruz
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,message);

        //Paylaşma özelliği için 2 parametre alan createChooser metodunu çagırırız. Aldığı parametreler 1-intent nesnemiz 2-Herhangi bir mesaj
        startActivity(Intent.createChooser(share,"Bu uygulamayı Paylaşın"));
    }
}
