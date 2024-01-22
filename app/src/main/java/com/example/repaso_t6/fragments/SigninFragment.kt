package com.example.repaso_t6.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.repaso_t6.R
import com.example.repaso_t6.databinding.FragmentSigninBinding
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
    private lateinit var auth: FirebaseAuth
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
        binding.botonSignlogIn.setOnClickListener {
            auth.signInWithEmailAndPassword(binding.editCorreoSigin.text.toString(),
                binding.editPassSigin.text.toString())
                    .addOnCompleteListener {
                    if (it.isSuccessful){
                        val bundle = Bundle()
                        bundle.putString("nombre",binding.editNombreSigin.text.toString())
                        findNavController().navigate(R.id.action_signinFragment_to_mainFragment)
                    }else{
                        Snackbar.make(binding.root,"Datos incorrectos",Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
        binding.botonSignIn.setOnClickListener {
            auth.createUserWithEmailAndPassword(binding.editCorreoSigin.text.toString(),
                binding.editPassSigin.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Snackbar.make(binding.root,"cuenta creada con exito", Snackbar.LENGTH_SHORT).show()
                        val referencia = database.getReference("usuarios").child(auth.currentUser!!.uid)
                        referencia.child("nombre").setValue(binding.editNombreSigin.text.toString())
                        referencia.child("correo").setValue(binding.editCorreoSigin.text.toString())
                    }else{
                        Snackbar.make(binding.root,"Fallo en la creación de usuario",Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}