package br.ulbra.aula6calculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    EditText edValor11, edValor21;

    Button btSoma, btSubtrai, btMultiplica, btDivide;

    public void mostrarResultado(String titulo,String mensagem,String botao)
    {
        AlertDialog.Builder resultado = new AlertDialog.Builder(MainActivity.this);
        resultado.setTitle(titulo);
        resultado.setMessage(mensagem);
        resultado.setNeutralButton(botao,null);
        resultado.show();
    }

    public double calcular(int op, double valor1, double valor2)
    {
        double res = 0;

        if (op == 1)
        {
            res = valor1 + valor2;
        }
        else if (op == 2)
        {
            res = valor1 - valor2;
        }
        else if (op == 3)
        {
            res = valor1 * valor2;
        }
        else
        {
            try
            {
                res = valor1 / valor2;
            }
            catch (ArithmeticException e)
            {
                Toast.makeText(getApplicationContext(),"Divisão por zero", Toast.LENGTH_LONG);
            }
        }

        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edValor11 = findViewById(R.id.edValor1);
        edValor21 = findViewById(R.id.edValor2);

        btSoma = findViewById(R.id.btSomar);
        btSubtrai = findViewById(R.id.btSubtrair);
        btMultiplica = findViewById(R.id.btMultiplicar);
        btDivide = findViewById(R.id.btDividir);

        btSoma.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int op = 1;
                double valor1 = Double.parseDouble(edValor11.getText().toString());
                double valor2 = Double.parseDouble(edValor21.getText().toString());

                if(!edValor11.getText().toString().equals(null) && !edValor21.getText().toString().equals(null))
                {
                    mostrarResultado("Resultados da calculadora","O resultado da soma: " + calcular(op,valor1, valor2),"Ok");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Campo em branco", Toast.LENGTH_LONG);
                }
            }
        });

        btSubtrai.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int op = 2;
                double valor1 = Double.parseDouble(edValor11.getText().toString());
                double valor2 = Double.parseDouble(edValor21.getText().toString());

                mostrarResultado("Resultados da calculadora","O resultado da subtração: " + calcular(op,valor1, valor2),"Ok");
            }
        });

        btMultiplica.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int op = 3;
                double valor1 = Double.parseDouble(edValor11.getText().toString());
                double valor2 = Double.parseDouble(edValor21.getText().toString());

                mostrarResultado("Resultados da calculadora","O resultado da multiplicação: " + calcular(op,valor1, valor2),"Ok");
            }
        });

        btDivide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int op = 4;
                double valor1 = Double.parseDouble(edValor11.getText().toString());
                double valor2 = Double.parseDouble(edValor21.getText().toString());


                mostrarResultado("Resultados da calculadora","O resultado da divisão: " + calcular(op,valor1, valor2),"Ok");
            }
        });

    }
}