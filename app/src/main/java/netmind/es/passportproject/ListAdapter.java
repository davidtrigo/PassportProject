package netmind.es.passportproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by A8Alumno on 20/11/2017.
 */

public class ListAdapter extends BaseAdapter {

    private ArrayList<Persona> arrayListPersonas;
    private Context context;

    public ListAdapter(ArrayList<Persona> arrayList, Context context) {
        this.arrayListPersonas = arrayList;
        this.context = context;
    }


    private class ViewHolder {

        ImageView imageList;
        TextView lblList;
    }


    // count elements
    @Override
    public int getCount() {

        Log.d(ListAdapter.class.getSimpleName(), "getCount= " + arrayListPersonas.size());
        return arrayListPersonas.size();
    }

    //return an element from the list
    @Override
    public Object getItem(int position) {
        return arrayListPersonas.get(position);
    }


    // devuelve elemento id del listado
    @Override
    public long getItemId(int position) {
        return arrayListPersonas.get(position).getId();
    }

    // dibuja en lista el elemento
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Log de la clase con la posicion de getView
        Log.d(ListAdapter.class.getSimpleName(), "getView= " + position);

        ViewHolder viewHolder;
        // fila que nunca se ha publicado
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.item_personas, null);

            Log.d(ListAdapter.class.getSimpleName(), "getView Se está instanciando ImageView/TextView  " + position);
            viewHolder = new ViewHolder();
            viewHolder.imageList = convertView.findViewById(R.id.imgList);
            viewHolder.lblList = convertView.findViewById(R.id.lblList);
            convertView.setTag(viewHolder);


        }  //fila reciclada
        else {

            viewHolder = (ViewHolder) convertView.getTag();
        }


        Persona persona = arrayListPersonas.get(position);
        viewHolder.lblList.setText(persona.getName());
        viewHolder.imageList.setImageResource(persona.getImageFront());


        return convertView;
    }


    // getView para Lista no recliclada

  /*
   @Override
  public View getView(int position, View convertView, ViewGroup parent) {

        //Log de la clase con la posicion de getView
        Log.d(ListAdapter.class.getSimpleName(),"getView= "+position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(R.layout.item_personas,null);
        Log.d(ListAdapter.class.getSimpleName(),"getView Se está instanciando ImageView/TextView  "+position);
        ImageView imageView = convertView.findViewById(R.id.imgList);
        TextView lblList = convertView.findViewById(R.id.lblList);

        Persona persona  = arrayListPersonas.get(position);
        lblList.setText(persona.getName());
        imageView.setImageResource(persona.getImageFront());


        return convertView;
    }*/
}
