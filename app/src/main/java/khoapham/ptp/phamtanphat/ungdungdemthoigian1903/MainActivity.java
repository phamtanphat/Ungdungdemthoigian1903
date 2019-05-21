package khoapham.ptp.phamtanphat.ungdungdemthoigian1903;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtNgaybatdau, edtNgayketthuc;
    Button btnTinhngay;
    TextView txtTongngay;
    Calendar calendarBatdau, calendarKetthuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Singleton
//        Calendar calendar = Calendar.getInstance();
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
//        long millisecond = calendar.getTimeInMillis();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Log.d("BBB",simpleDateFormat.format(millisecond));

        edtNgaybatdau = findViewById(R.id.edittextNgaymin);
        edtNgayketthuc = findViewById(R.id.edittextNgaymax);
        btnTinhngay = findViewById(R.id.buttonDem);
        txtTongngay = findViewById(R.id.textviewNgay);
        calendarBatdau = Calendar.getInstance();
        calendarKetthuc = Calendar.getInstance();


        edtNgaybatdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendarBatdau.set(year, month, dayOfMonth);
                        edtNgaybatdau.setText(calendarBatdau.get(Calendar.DATE) + "/" + (calendarBatdau.get(Calendar.MONTH) + 1) + "/" + calendarBatdau.get(Calendar.YEAR));

                        calendarKetthuc.setTimeInMillis(calendarBatdau.getTimeInMillis() + (1000 * 60 * 60 * 24));
                        edtNgayketthuc.setText(calendarKetthuc.get(Calendar.DATE) + "/" + (calendarKetthuc.get(Calendar.MONTH) + 1) + "/" + calendarKetthuc.get(Calendar.YEAR));
                    }
                }, calendarBatdau.get(Calendar.YEAR), calendarBatdau.get(Calendar.MONTH), calendarBatdau.get(Calendar.DATE));
                datePickerDialog.getDatePicker().setMinDate(calendarBatdau.getTimeInMillis());
                datePickerDialog.show();
            }
        });
        edtNgayketthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendarKetthuc.set(year, month, dayOfMonth);
                        edtNgayketthuc.setText(calendarKetthuc.get(Calendar.DATE) + "/" + (calendarKetthuc.get(Calendar.MONTH) + 1) + "/" + calendarKetthuc.get(Calendar.YEAR));
                    }
                }, calendarKetthuc.get(Calendar.YEAR), calendarKetthuc.get(Calendar.MONTH), calendarKetthuc.get(Calendar.DATE));
                datePickerDialog.getDatePicker().setMinDate(calendarBatdau.getTimeInMillis() + (1000 * 60 * 60 * 24));
                datePickerDialog.show();
            }
        });

        btnTinhngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calendarKetthuc.getTimeInMillis() - calendarBatdau.getTimeInMillis() > 0){
                    long valueTime = calendarKetthuc.getTimeInMillis() - calendarBatdau.getTimeInMillis();
                    int ngay = (int) (valueTime / (1000 * 60 * 60 * 24));
                    txtTongngay.setText(ngay + "");
                }
            }
        });
    }
}
