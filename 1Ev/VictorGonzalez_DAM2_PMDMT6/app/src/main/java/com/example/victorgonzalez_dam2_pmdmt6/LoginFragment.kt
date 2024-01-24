package com.example.victorgonzalez_dam2_pmdmt6

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.victorgonzalez_dam2_pmdmt6.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {



    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonSignin.setOnClickListener {
            if (binding.editNombre.text.toString() != "" && binding.editCorreo.text.toString() != "" && binding.editPass.text.toString() != ""){
                auth.createUserWithEmailAndPassword(binding.editCorreo.text.toString(),binding.editPass.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            binding.editNombre.setText("")
                            binding.editCorreo.setText("")
                            binding.editPass.setText("")
                            Snackbar.make(binding.root,"Usuario creado con éxito",Snackbar.LENGTH_SHORT).show()
                        }else{
                            Snackbar.make(binding.root,"fallo en la creacion del usuario",Snackbar.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Snackbar.make(binding.root,"Se han introducido datos vacios",Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.botonLogin.setOnClickListener {
            if (binding.editNombre.text.toString() != "" && binding.editCorreo.text.toString() != "" && binding.editPass.text.toString() != ""){

                auth.signInWithEmailAndPassword(binding.editCorreo.text.toString(),binding.editPass.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            binding.editNombre.setText("")
                            binding.editCorreo.setText("")
                            binding.editPass.setText("")
                            Snackbar.make(binding.root,"Usuario logueado con éxito",Snackbar.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                        }else{
                            Snackbar.make(binding.root,"Usuario o contraseña incorrectos",Snackbar.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Snackbar.make(binding.root,"Se han introducido datos vacios",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}