package com.example.sistema_pedido;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //TELA ACTIVITY MAIN;
    Button btnLanche, btnHotdog, btnRefrigerante;

    //TELA LANCHE
    Button btnVoltar, btnProximo;
    RadioButton rb1hb, rb2hb, rb3hb;
    RadioGroup rgHamburguer;
    CheckBox chkpresunto, chkbatata, chksalada, chkqueijo, chkbacon, chkovo;
    String pedido, tipo;

    //TELA HOTDOG
    RadioButton rbt1salsicha, rbt2salsicha;
    RadioGroup rgSalsicha;
    CheckBox chkMilho, chkErvilha, chkCatchup, chkMaionese;

    //TELA REFRIGERANTE
    Button btnPedido;
    CheckBox chkCoca, chkSprite, chkPepsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarregarTelaPrincipal();

    }

    private void CarregarTelaPrincipal() {
        tipo = " ";

        setContentView(R.layout.activity_main);

        btnLanche       = findViewById(R.id.btnLanche);
        btnHotdog       = findViewById(R.id.btnHotdog);
        btnRefrigerante = findViewById(R.id.btnRefrigerante);

        btnLanche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaLanche();
            }
        });

        btnHotdog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaHotdog();
            }
        });

        btnRefrigerante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaRefrigerante();
            }
        });

    }

    public void CarregarTelaLanche()
    {

        setContentView(R.layout.lanche);

        rgHamburguer = (RadioGroup) findViewById(R.id.rgHaburguer);
        rb1hb = (RadioButton) findViewById(R.id.rb1hb);
        rb2hb = (RadioButton) findViewById(R.id.rb2hb);
        rb3hb = (RadioButton) findViewById(R.id.rb3hb);
        chkpresunto = (CheckBox) findViewById(R.id.chkpresunto);
        chkbatata = (CheckBox) findViewById(R.id.chkbatata);
        chksalada = (CheckBox) findViewById(R.id.chksalada);
        chkqueijo = (CheckBox) findViewById(R.id.chkqueijo);
        chkbacon = (CheckBox) findViewById(R.id.chkbacon);
        chkovo = (CheckBox) findViewById(R.id.chkovo);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Atenção");
                alert.setMessage("Seu pedido foi zerado!");
                alert.setNeutralButton("Fechar",null);
                alert.show();

                pedido = "";
                CarregarTelaPrincipal();

            }
        });

        btnProximo = findViewById(R.id.btnProximo);
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tipo  = "Lanche";

                int op = rgHamburguer.getCheckedRadioButtonId();
                if(op == R.id.rb1hb)
                {
                    pedido += "\nCom 1 Hamburguer";
                }
                if(op == R.id.rb2hb)
                {
                    pedido += "\nCom 2 Hamburguer";
                }
                if(op == R.id.rb3hb)
                {
                    pedido += "\nCom 3 Hamburguer";
                }
                if(chkpresunto.isChecked())
                {
                    pedido += "\nPresunto";
                }
                if(chkbatata.isChecked())
                {
                    pedido += "\nBatata Frita";
                }
                if(chksalada.isChecked())
                {
                    pedido += "\nSalada";
                }
                if(chkqueijo.isChecked())
                {
                    pedido += "\nQueijo";
                }
                if(chkbacon.isChecked())
                {
                    pedido += "\nBacon";
                }
                if(chkovo.isChecked())
                {
                    pedido += "\nOvo";
                }

                CarregarTelaRefrigerante();

            }
        });


    }

    public void CarregarTelaHotdog()
    {
        setContentView(R.layout.hotdog);

        rgSalsicha = (RadioGroup) findViewById(R.id.rgSalsicha);
        rbt1salsicha = (RadioButton) findViewById(R.id.rbt1salsicha);
        rbt2salsicha = (RadioButton) findViewById(R.id.rbt2salsichas);
        chkMilho = (CheckBox) findViewById(R.id.chkMilho);
        chkErvilha = (CheckBox)findViewById(R.id.chkErvilha);
        chkCatchup = (CheckBox)findViewById(R.id.chkCatchup);
        chkMaionese = (CheckBox)findViewById(R.id.chkMaionese);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Atenção!");
                alert.setMessage("Seu pedido foi zerado!");
                alert.setNeutralButton("Fechar",null);
                alert.show();

                pedido = " ";
                CarregarTelaPrincipal();

            }
        });

        btnProximo = findViewById(R.id.btnProximo);
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipo  = "Hotdog";

                int op = rgSalsicha.getCheckedRadioButtonId();

                if(op == R.id.rbt1salsicha)
                {
                    pedido += "\nCom 1 Salsicha";
                }
                if(op == R.id.rbt2salsichas)
                {
                    pedido += "\nCom 2 Salsichas";
                }
                if(chkMilho.isChecked())
                {
                    pedido += "\ncom Milho";
                }
                if(chkErvilha.isChecked())
                {
                    pedido += "\nErvilha";
                }
                if(chkCatchup.isChecked())
                {
                    pedido += "\nCatchup";
                }
                if(chkMaionese.isChecked())
                {
                    pedido += "\nMaionese";
                }
                CarregarTelaRefrigerante();
            }
        });

    }

    public void CarregarTelaRefrigerante()
    {
        setContentView(R.layout.refrigerante);

        chkCoca = (CheckBox) findViewById(R.id.chkCoca);
        chkPepsi = (CheckBox) findViewById(R.id.chkPepsi);
        chkSprite = (CheckBox) findViewById(R.id.chkSprite);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tipo == "Lanche")
                {
                    pedido = " ";
                    CarregarTelaLanche();
                }
                if(tipo == "Hotdog")
                {
                    pedido = " ";
                    CarregarTelaHotdog();
                }
                if(tipo == " ")
                {
                    tipo = " ";
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Atenção!");
                    alert.setMessage("Seu pedido foi zerado!");
                    alert.setNeutralButton("Fechar",null);
                    alert.show();
                    pedido = " ";
                    CarregarTelaPrincipal();
                }
            }

        });

        btnPedido = findViewById(R.id.btnPedido);
        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(chkCoca.isChecked())
                {
                    pedido += "\n1 Coca-Cola";
                }
                if(chkPepsi.isChecked())
                {
                    pedido += "\n1 Pepsi";
                }
                if(chkSprite.isChecked())
                {
                    pedido += "\n1 Sprite";
                }
                if(tipo == "")
                {
                    tipo = "Refrigerante";
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("O seu " + tipo + " está sendo preparado");
                alert.setMessage(pedido);
                alert.setNeutralButton("Fechar",null);
                alert.show();

                CarregarTelaPrincipal();

                pedido = "";
                tipo = "";
            }
        });
    }
}