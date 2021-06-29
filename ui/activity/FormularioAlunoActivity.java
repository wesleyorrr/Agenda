package usuario.android.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import usuario.android.agenda.R;
import usuario.android.agenda.ui.activity.model.Aluno;
import usuario.android.agenda.ui.dao.AlunoDAO;

public class FormularioAlunoActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    final AlunoDAO dao = new AlunoDAO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

       setTitle("Cadastrar");
       inicializacaoDosCampos();
       configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criaAluno(campoNome, campoTelefone, campoEmail);
                salva(alunoCriado, dao);


            }
        });
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salva(Aluno alunoCriado, AlunoDAO dao) {
        dao.salva(alunoCriado);
        finish();
    }
    @NonNull
    private Aluno criaAluno(EditText campoNome, EditText campoTelefone, EditText campoEmail) {
        String nome = campoNome.getText().toString();
        String telfone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();


        return new Aluno(nome,telfone,email);
    }
}
