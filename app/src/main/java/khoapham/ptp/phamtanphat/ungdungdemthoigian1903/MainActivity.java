package khoapham.ptp.phamtanphat.ungdungdemthoigian1903;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Singleton
        Calendar calendar = Calendar.getInstance();
//        int ngay = calendar.get(Calendar.DATE);
//        // thang : gia tri thang hien tai - 1
//        int thang = calendar.get(Calendar.MONTH);
//        int nam = calendar.get(Calendar.YEAR);
//        int gio = calendar.get(Calendar.HOUR_OF_DAY);
//        int phut = calendar.get(Calendar.MINUTE);
//        int giay = calendar.get(Calendar.SECOND);

        //Lay tgian hien tai trong thiet bi
        //moc tgian se tinh : 1 - 1 - 1970 => hien tai
//        long millisecond = System.currentTimeMillis();
        long millisecond = calendar.getTimeInMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Log.d("BBB",simpleDateFormat.format(millisecond));



    }
}
