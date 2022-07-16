package com.example.app4_activityparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuarios implements Parcelable {
    private String nick;
    private String usuario;
    private String clave;


    public Usuarios(String nick, String usuario, String clave) {
        this.nick = nick;
        this.usuario = usuario;
        this.clave = clave;
    }

    protected Usuarios(Parcel in) {
        nick = in.readString();
        usuario = in.readString();
        clave = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nick);
        dest.writeString(usuario);
        dest.writeString(clave);
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
}
