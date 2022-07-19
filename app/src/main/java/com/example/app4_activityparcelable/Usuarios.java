package com.example.app4_activityparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuarios implements Parcelable {
    private String rol;
    private String usuario;
    private String clave;
    private String correo;

    public Usuarios(String rol, String usuario, String clave, String correo) {
        this.rol = rol;
        this.usuario = usuario;
        this.clave = clave;
        this.correo = correo;
    }

    protected Usuarios(Parcel in) {
        rol = in.readString();
        usuario = in.readString();
        clave = in.readString();
        correo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rol);
        dest.writeString(usuario);
        dest.writeString(clave);
        dest.writeString(correo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Usuarios> CREATOR = new Creator<Usuarios>() {
        @Override
        public Usuarios createFromParcel(Parcel in) {
            return new Usuarios(in);
        }

        @Override
        public Usuarios[] newArray(int size) {
            return new Usuarios[size];
        }
    };

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
