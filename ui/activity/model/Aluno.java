package usuario.android.agenda.ui.activity.model;

import androidx.annotation.NonNull;

public class Aluno{
    private final String nome;
    private final String telefone;
    private final String email;



    public Aluno(String nome, String telfone, String email) {
    this.nome = nome;
    this.telefone = telfone;
    this.email = email;

    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
