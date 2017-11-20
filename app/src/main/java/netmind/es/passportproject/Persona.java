package netmind.es.passportproject;

/**
 * Created by A8Alumno on 20/11/2017.
 */

public class Persona {

    private int id;
    private  String name;
    private String surname;
    private int spinnerPosition;
    private boolean checkboxState;
    private int imageFront, imagePerfil;


    public Persona(int id, String name, String surname, int spinnerPosition, boolean checkboxState, int imageFront, int imagePerfil) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.spinnerPosition = spinnerPosition;
        this.checkboxState = checkboxState;
        this.imageFront = imageFront;
        this.imagePerfil = imagePerfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSpinnerPosition() {
        return spinnerPosition;
    }

    public void setSpinnerPosition(int spinnerPosition) {
        this.spinnerPosition = spinnerPosition;
    }

    public boolean isCheckboxState() {
        return checkboxState;
    }

    public void setCheckboxState(boolean checkboxState) {
        this.checkboxState = checkboxState;
    }

    public int getImageFront() {
        return imageFront;
    }

    public void setImageFront(int imageFront) {
        this.imageFront = imageFront;
    }

    public int getImagePerfil() {
        return imagePerfil;
    }

    public void setImagePerfil(int imagePerfil) {
        this.imagePerfil = imagePerfil;
    }
}
