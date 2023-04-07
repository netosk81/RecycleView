package com.example.recycleview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recycleview.R;
import com.example.recycleview.activity.RecyclerItemClickListener;
import com.example.recycleview.activity.adapter.Adapter;
import com.example.recycleview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); //otimizador para recyclerView(colocando um tamanho fixo)
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter );

        //evento click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Toast.makeText(MainActivity.this, "Clique curto", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Toast.makeText(MainActivity.this, "Clique longo", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )
        );


    }


    public void criarFilmes(){

        Filme filme = new Filme("titulo", "genero","2023");
        this.listaFilmes.add(filme);

        filme = new Filme("Piratas do vale do silicio", "ficçao","1987");
        this.listaFilmes.add(filme);

        filme = new Filme("A rede Social", "ficçao","2019");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "ficçao","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A Coisa ", "Drama / Terror","2017");
        this.listaFilmes.add(filme);



    }


}