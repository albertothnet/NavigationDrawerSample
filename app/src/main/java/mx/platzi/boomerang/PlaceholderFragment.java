package mx.platzi.boomerang;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Fragment for the main content
 */
public class PlaceholderFragment extends DialogFragment implements OnClickListener {
    /**
     * This argument represents the title for each section
     */
    public static final String ARG_SECTION_TITLE = "section_number";


    /**
     * Crea una instancia prefabricada de {@link PlaceholderFragment}
     *
     * @param sectionTitle Título usado en el contenido
     * @return Instancia dle fragmento
     */
    public static PlaceholderFragment newInstance(String sectionTitle) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Ubicar argumento en el text view de section_fragment.xml
        String title = getArguments().getString(ARG_SECTION_TITLE);
        Button opButton;
        View view = null;
        if (title.equals("Nueva Operación")) {
            view = inflater.inflate(R.layout.section_fragment, container, false);
            opButton = (Button) view.findViewById(R.id.button);
            opButton.setOnClickListener(this);

        }
        if (title.equals("Inicio")) {
            view = inflater.inflate(R.layout.activity_main, container, false);

        }
        //TextView titulo = (TextView) view.findViewById(R.id.title);
        //titulo.setText(title);
        return view;
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        //switch (v.getId())
         android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);



    }

}
