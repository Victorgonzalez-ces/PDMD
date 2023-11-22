package com.example.victorgonzalez_t2_pdmd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var textoPeso: EditText
    private lateinit var textoAltura: EditText
    private lateinit var botonHombre: Button
    private lateinit var botonMujer: Button
    private var peso = 0
    private var altura = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        botonHombre.setOnClickListener(this)
        botonMujer.setOnClickListener(this)

    }

    private fun instancias(){
        textoPeso = findViewById(R.id.textoPeso)
        textoAltura = findViewById(R.id.textoAltura)
        botonHombre = findViewById(R.id.botonHombre)
        botonMujer = findViewById(R.id.botonMujer)
    }
    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.botonHombre -> {
                if (textoPeso.equals("") || textoAltura.equals("")) {
                    Snackbar.make(p0, R.string.relllenaDatos, Snackbar.LENGTH_LONG).show()
                } else {
                    peso = textoPeso.text.toString().toInt()
                    altura = textoAltura.text.toString().toInt()
                    Snackbar.make(p0, "Tu estado físico es: ${calcularIMCH(peso, altura)} , ¿quieres ver los datos reales?",Snackbar.LENGTH_LONG)
                        .setAction("OK") {
                            val activity2 = Intent(applicationContext, SecondActivity::class.java)
                            startActivity(activity2)
                        }
                }
            }
            R.id.botonMujer -> {
                if (textoPeso.equals("") || textoAltura.equals("")) {
                    Snackbar.make(p0, R.string.relllenaDatos, Snackbar.LENGTH_LONG).show()
                } else {
                    peso = textoPeso.text.toString().toInt()
                    altura = textoAltura.text.toString().toInt()
                    Snackbar.make(p0, "Tu estado físico es: ${calcularIMCM(peso, altura)} , ¿quieres ver los datos reales?", Snackbar.LENGTH_LONG)
                        .setAction("OK") {
                            val activity2 = Intent(applicationContext, SecondActivity::class.java)
                            startActivity(activity2)
                        }
                }
            }
        }
    }
    private fun calcularIMCH(peso: Int, altura: Int): String{
        if (peso/altura*2<=18.5){
            return "bajo peso"
        }else if (peso/altura*2<=24.9){
            return "peso normal"
        }else if (peso/altura*2<=29.9){
            return "sobre peso"
        }else if (peso/altura*2<=34.9){
            return "obesidad clase 1"
        }else if (peso/altura*2<=39.9){
            return "obesidad clase 2"
        }
        return "obesidad clase 3"
    }

    private fun calcularIMCM(peso: Int, altura: Int): String{
        if (peso/altura*2<=16.5){
            return "bajo peso"
        }else if (peso/altura*2<=22.9){
            return "peso normal"
        }else if (peso/altura*2<=25.9){
            return "sobre peso"
        }else if (peso/altura*2<=30.9){
            return "obesidad clase 1"
        }else if (peso/altura*2<=33.9){
            return "obesidad clase 2"
        }
        return "obesidad clase 3"
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("peso",peso)
        outState.putInt("altura",altura)
    }
}