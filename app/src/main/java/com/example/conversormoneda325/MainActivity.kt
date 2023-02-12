package com.example.conversormoneda325

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.conversormoneda325.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Referenciar los spinners y el array de divisas
        val sp1 = binding.sp1
        val sp2 = binding.sp2
        val lista = resources.getStringArray(R.array.divisas)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista)

        // Variables para almacenar la posición seleccionada en los spinners
        var posicionSP1 = ""
        var posicionSP2 = ""

        // Referenciar la entrada de texto para la cantidad y el text view para el resultado
        val cantidad = binding.etCantidad
        val resultado = binding.tvResultado

        // Variable para almacenar el resultado
        var total = 0.0

        val btnClear = binding.btnClear
        val btnFinish = binding.btnFinish


        // Establecer el adaptador para los spinners
        sp1.adapter = adapter
        sp2.adapter = adapter

        // Establecer el listener para el primer spinner
        sp1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                posicionSP1= lista[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity,"Error al traer las monedas!!",Toast.LENGTH_LONG)
                    .show()
            }
        }
        // Establecer el listener para el segundo spinner
        sp2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                posicionSP2= lista[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity,"Error al traer las monedas!!",Toast.LENGTH_LONG)
                    .show()
            }
        }


        binding.btnEnviar.setOnClickListener{
            if(cantidad.text.isNotEmpty()){
                when(posicionSP1){

//                    Cambios
                    "Bolivianos"->{
                        when(posicionSP2){
                            "Bolivianos"->{
                                resultado.text = cantidad.text
                            }
                            "Dolares"->{
                                total = cantidad.text.toString().toFloat() * .14
                                resultado.text = total.toString()
                            }
                            "Euros"->{
                                total = cantidad.text.toString().toFloat() * .14
                                resultado.text = total.toString()
                            }
                            "Soles"->{
                                total = cantidad.text.toString().toFloat() * .56
                                resultado.text = total.toString()
                            }
                        }
                    }

//                    ------Cambio-----

                    "Dolares"->{
                        when(posicionSP2){
                            "Bolivianos"->{
                                total = cantidad.text.toString().toFloat() * 6.91
                                resultado.text = total.toString()
                            }
                            "Dolares"->{
                                resultado.text = cantidad.text
                            }
                            "Euros"->{
                                total = cantidad.text.toString().toFloat() * .93
                                resultado.text = total.toString()
                            }
                            "Soles"->{
                                total = cantidad.text.toString().toFloat() * 3.86
                                resultado.text = total.toString()
                            }
                        }
                    }
//                    ------Cambio-----

                    "Euros"->{
                        when(posicionSP2){
                            "Bolivianos"->{
                                total = cantidad.text.toString().toFloat() * 7.39
                                resultado.text = total.toString()
                            }
                            "Dolares"->{
                                total = cantidad.text.toString().toFloat() * 1.07
                                resultado.text = total.toString()
                            }
                            "Euros"->{
                                resultado.text = cantidad.text
                            }
                            "Soles"->{
                                total = cantidad.text.toString().toFloat() * 4.13
                                resultado.text = total.toString()
                            }
                        }
                    }
//                    ------Cambio-----

                    "Soles"->{
                        when(posicionSP2){
                            "Bolivianos"->{
                                total = cantidad.text.toString().toFloat() * 1.79
                                resultado.text = total.toString()
                            }
                            "Dolares"->{
                                total = cantidad.text.toString().toFloat() * .26
                                resultado.text = total.toString()
                            }
                            "Euros"->{
                                total = cantidad.text.toString().toFloat() * .24
                                resultado.text = total.toString()
                            }
                            "Soles"->{
                                resultado.text = cantidad.text
                            }
                        }
                    }
                }
            }else{
                Toast.makeText(this@MainActivity,"Ingrese una cantidad!!",Toast.LENGTH_LONG)
                    .show()
            }
        }

        btnClear.setOnClickListener {
            cantidad.text.clear()
            resultado.text = ""
        }

        btnFinish.setOnClickListener {
            finish()
        }


    }
}
