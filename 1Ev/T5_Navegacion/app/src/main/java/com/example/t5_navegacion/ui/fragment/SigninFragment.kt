package com.example.t5_navegacion.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t5_navegacion.R
import com.example.t5_navegacion.databinding.FragmentSigninBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SigninFragment : Fragment() {



    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentSigninBinding
    private lateinit var auth: FirebaseAuth;
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
        database = FirebaseDatabase.getInstance("https://vgp-ces-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSigninBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonSignin.setOnClickListener {
            if (binding.editPassSignin.text.toString() == binding.editPass2Signin.text.toString()){
                auth.createUserWithEmailAndPassword(binding.editCorreoSignin.text.toString(),binding.editPassSignin.text.toString())
                    .addOnCompleteListener{
                        if (it.isSuccessful){
                            Snackbar.make(binding.root,"Cuenta creada con exito",Snackbar.LENGTH_SHORT).show()
                            val referencia = database.getReference("usuarios").child(auth.currentUser!!.uid)
                            referencia.child("nombre").setValue(binding.editNombreSignin.text.toString())
                            referencia.child("apellido").setValue(binding.editApellidoSignin.text.toString())
                            referencia.child("correo").setValue(binding.editCorreoSignin.text.toString())
                            referencia.child("direccion").setValue(binding.editDireccionSignin.text.toString())
                        }else{
                            Snackbar.make(binding.root,"Fallo en la creación del usuario.",Snackbar.LENGTH_SHORT).show()
                        }
                    }
                findNavController().navigate(R.id.action_signinFragment_to_loginFragment)
            }else{
                Snackbar.make(binding.root,"Fallo a la creación de usuario",Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.botonSigninLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signinFragment_to_mainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}