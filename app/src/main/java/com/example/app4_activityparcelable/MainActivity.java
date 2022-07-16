package com.example.app4_activityparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app4_activityparcelable.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.txtnombre.getText().toString().length() > 0) {
                    if (binding.txtclave.getText().toString().length() < 5) {
                        binding.txtConfirmacion.setText("Clave minimo 5 digitos");
                    } else {
                        if (binding.txtclave.getText().toString().equals(binding.txtclave2.getText().toString())) {
                            abrir(binding.txtnombre.getText().toString(), binding.txtclave.getText().toString());
                        } else {
                            binding.txtConfirmacion.setText("Contraseñas no coinciden");
                        }
                    }
                } else {
                    binding.txtConfirmacion.setText("Llene todos los campos");
                }
            }
        });
    }

    private void abrir(String user, String clave){
        Intent intent = new Intent(this,asdf.class);
        Usuarios sitio = new Usuarios(user,user,clave);

        intent.putExtra(asdf.users_key,sitio);
        startActivity(intent);
    }
}