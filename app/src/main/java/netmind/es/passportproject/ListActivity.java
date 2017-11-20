package netmind.es.passportproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by A8Alumno on 20/11/2017.
 */

public class ListActivity extends Activity {

private ArrayList<Persona> arrayDePersonas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        initList();
    }

    private void initList(){

        ListView listView = findViewById(R.id.listView);

        /*Crear un adapter con datos*/

        arrayDePersonas = getPersonas();
        ListAdapter listAdapter = new ListAdapter(arrayDePersonas,this);

        /* Setear ese adapter a mi lista*/

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //cuando se clicka una posicion de la lista
                Persona personaClickada = arrayDePersonas.get(position);
                Intent intentActivityForm = new Intent(ListActivity.this, FormActivity.class);
                intentActivityForm.putExtra("persona", personaClickada);
                startActivity(intentActivityForm);

            }
        });
    }


    private ArrayList<Persona> getPersonas(){

        ArrayList<Persona> array = new ArrayList<>();

        Persona persona1 = new Persona(1,"Preso 1","apellido 1", 0,false,R.drawable.preso1,R.drawable.preso5);
        Persona persona2 = new Persona(1,"Preso 2","apellido 2", 1,false,R.drawable.preso2,R.drawable.preso4);

        for (int i =0; i<100;i++){
            Persona persona = new Persona(1,"Preso "+i,
                    "apellido "+i,
                    0,
                    false,R.drawable.preso1,R.drawable.preso6);

            array.add(persona);
         //   array.add(persona2);

        }

        return array;
    }
}
