package com.example.mimascota;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;

        import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbCat;
    private RadioButton rbDog;
    private EditText namepet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio();

    }
    private void inicio(){
        rbCat = findViewById(R.id.rbGatito);
        rbDog = findViewById(R.id.rbPerrito);
        namepet = findViewById(R.id.etNombre);
    }
    public void totalPago(View view){
        String tipo =(rbCat.isChecked()==true )? "gato" : "perro" ;
        Mascota mascota = new Mascota(namepet.getText().toString(),tipo);
        double resultadoPago= mascota.getCalculoPago();
        irResultado(resultadoPago,mascota);
    }

    public void irResultado(double pago, Mascota mascota){
        Intent resultado = new Intent(this, Resultado.class);
        resultado.putExtra("result",(Serializable) mascota);
        resultado.putExtra("pago",pago);
        startActivity(resultado);






    }
}