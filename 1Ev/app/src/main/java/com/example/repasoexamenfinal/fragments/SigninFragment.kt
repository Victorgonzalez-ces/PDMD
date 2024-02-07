package com.example.repasoexamenfinal.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.repasoexamenfinal.R
import com.example.repasoexamenfinal.databinding.FragmentSigninBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SigninFragment : Fragment() {

    private lateinit var binding: FragmentSigninBinding

    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
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

        binding.botonLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(binding.editCorreo.text.toString(),binding.editPass.text.toString()).addOnCompleteListener {
                if (it.isSuccessful){
                    val bundle = Bundle()
                    bundle.putString("uid",auth.currentUser!!.uid)
                    findNavController().navigate(R.id.action_signinFragment_to_mainFragment,bundle)
                }else{
                    Snackbar.make(binding.root,"Datos de inicio de sesión incorrectos",Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        binding.botonSignin.setOnClickListener {
            auth.createUserWithEmailAndPassword(binding.editCorreo.text.toString(),binding.editPass.text.toString()).addOnCompleteListener {
                if (it.isSuccessful){
                    Snackbar.make(binding.root,"Usuario creado correctamente, por favor inicie sesión para continuar...",Snackbar.LENGTH_SHORT).show()
                }else{
                    Snackbar.make(binding.root, "Fallo en la creacion del usuario", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}