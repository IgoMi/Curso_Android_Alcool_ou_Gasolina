package alcoolougasolina.cursoandroid.com.lcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //criação das váriaveis
    private Button botao;
    private EditText alcool;
    private EditText gasolina;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associa as váriasveis aos seus respectivos IDs.
        botao = (Button) findViewById(R.id.botaId);
        alcool = (EditText) findViewById(R.id.alcoolId);
        gasolina = (EditText) findViewById(R.id.gasolinaId);
        result = (TextView) findViewById(R.id.resultadoId);

        //Cria o evento de click.
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Atribui os dados fornecidos a uma String
                String valorAlc = alcool.getText().toString();
                String valorGas = gasolina.getText().toString();

                //Teste se os campos foram preenchidos e em caso negativo exibe uma mensagem de erro.
                if ( valorAlc.isEmpty()) {
                    alcool.setError("Campo obrigatório.");
                } else if (valorGas.isEmpty()){
                    gasolina.setError("Campo obrigatório.");
                } else {
                    //Atribui os valores recebidos a uma variavel Double.
                    Double valorAlcool = Double.parseDouble(valorAlc);
                    Double valorGasolina = Double.parseDouble(valorGas);

                    //Realiza o calculo para descobrir o combustivel mais viavel.
                    Double resultado = valorAlcool / valorGasolina;


                    //Testa qual a melhor opção e envia a resposta ao usuario.
                    if (resultado >= 0.7){
                        result.setText("É melhor usar Gasolina.");
                    } else {
                        result.setText("É melhor usar Álcool.");
                    }
                }
            }
        });
    }
}
