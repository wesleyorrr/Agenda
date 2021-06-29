package usuario.android.agenda.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import usuario.android.agenda.R;
import usuario.android.agenda.ui.dao.AlunoDAO;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        setTitle("Lista Simples");

        FloatingActionButton botaoNovoAluno = findViewById(R.id.floatingActionButton2);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FormularioAlunoActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        AlunoDAO dao = new AlunoDAO();
        ListView listaDealunos =findViewById(R.id.Activity_main_lista_de_alunos);
        listaDealunos.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dao.todos()));

    }
}

