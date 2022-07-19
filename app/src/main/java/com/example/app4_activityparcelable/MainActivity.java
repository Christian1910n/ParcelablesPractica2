package com.example.app4_activityparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app4_activityparcelable.databinding.ActivityMainBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                if (binding.txtnombre.getText().toString().length() > 0) {
                    if (binding.txtcorreo.getText().toString().equalsIgnoreCase(binding.txtcorreo2.getText().toString())) {
                        Matcher mather = pattern.matcher(binding.txtcorreo.getText().toString());
                        if(mather.find() == true) {
                            if (binding.txtclave.getText().toString().length() < 5) {
                                binding.txtConfirmacion.setText("Clave minimo 5 digitos");
                            } else {
                                if (binding.txtclave.getText().toString().equals(binding.txtclave2.getText().toString())) {
                                    if (binding.txtrol.getText().toString().equalsIgnoreCase("admin") || binding.txtrol.getText().toString().equalsIgnoreCase("invitado")) {
                                        abrir(binding.txtrol.getText().toString(), binding.txtnombre.getText().toString(), binding.txtclave.getText().toString(), binding.txtcorreo.getText().toString());
                                    } else {
                                        binding.txtConfirmacion.setText("Rol Incorrecto");
                                    }
                                } else {
                                    binding.txtConfirmacion.setText("Contraseñas no coinciden");
                                }
                            }
                        }else{
                            binding.txtConfirmacion.setText("Correo invalido");
                        }
                    } else{
                        binding.txtConfirmacion.setText("Correos no coinciden");
                    }
                }else {
                    binding.txtConfirmacion.setText("Llene todos los campos");
                }
            }
        });
    }

    private void abrir(String rol, String user, String clave, String correo){
        Intent intent = new Intent(this,asdf.class);
        Usuarios sitio = new Usuarios(rol,user,clave,correo);

        intent.putExtra(asdf.users_key,sitio);
        startActivity(intent);
    }


}