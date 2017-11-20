package netmind.es.passportproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by A8Alumno on 20/11/2017.
 */

public class ListActivity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        initList();
    }

    private void initList(){

        ListView listView = findViewById(R.id.listView);

        /*Crear un adapter con datos*/

        ListAdapter listAdapter = new ListAdapter(getPersonas(),this);

        /* Setear ese adapter a mi lista*/

        listView.setAdapter(listAdapter);
    }


    private ArrayList<Persona> getPersonas(){

        ArrayList<Persona> array = new ArrayList<>();

        Persona persona1 = new Persona(1,"Preso 1","apellido 1", 0,false,R.drawable.preso1,R.drawable.preso1);
        Persona persona2 = new Persona(1,"Preso 2","apellido 2", 1,false,R.drawable.preso2,R.drawable.preso2);

        for (int i =0; i<100;i++){
            array.add(persona1);
         //   array.add(persona2);

        }

        return array;
    }
}
