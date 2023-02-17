package com.example.conversormoneda325

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.conversormoneda325.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater) // infla la vista de la actividad en el objeto `binding`
        setContentView(binding.root) // establece la vista de la actividad en la vista inflada por `binding`

        val sp1 = binding.sp1 // obtiene el Spinner de la vista a través de `binding`

        val lista = resources.getStringArray(R.array.divisas) // obtiene una lista de cadenas de recursos de la aplicación
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista) // crea un adaptador para el Spinner usando la lista de cadenas

        var posicionSP1 = "" // inicializa una variable para la posición del elemento seleccionado en el Spinner

        val cantidad = binding.etCantidad // obtiene el EditText para la cantidad a convertir de la vista a través de `binding`

        // obtiene los TextView para mostrar los resultados de la conversión
        val resultadoBoliviano = binding.tvResultadoBoliviano
        val resultadoChile = binding.tvResultadoPeso
        val resultadoEuro = binding.tvResultadoEuros
        val resultadoReal = binding.tvResultadoReales
        val resultadoSoles = binding.tvResultadoSoles
        val resultadoYen = binding.tvResultadoYen
        val resultadoYuan = binding.tvResultadoYuan
        val resultadoDolar = binding.tvResultadoDolares

        // inicializa variables para los totales de la conversión para cada moneda
        var totalBolivianos = 0.0
        var totalChile = 0.0
        var totalEuro = 0.0
        var totalReal = 0.0
        var totalSoles = 0.0
        var totalYen = 0.0
        var totalYuan = 0.0
        var totalDolar = 0.0

        val btnClear = binding.btnClear // obtiene el botón "Clear" de la vista a través de `binding`
        val btnFinish = binding.btnFinish // obtiene el botón "Finish" de la vista a través de `binding`

        sp1.adapter = adapter // establece el adaptador creado anteriormente para el Spinner

        sp1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{ // establece un Listener para el Spinner
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                posicionSP1= lista[position] // obtiene la posición del elemento seleccionado en el Spinner y la guarda en `posicionSP1`
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity,"Error al traer las monedas!!",Toast.LENGTH_LONG) // muestra un mensaje Toast si no se selecciona nada en el Spinner
                    .show()
            }
        }


        // Aquí se establece el listener del botón "enviar"
        binding.btnEnviar.setOnClickListener{

            // Se comprueba que el campo de cantidad no esté vacío
            if(cantidad.text.isNotEmpty()){

                // Se utiliza la estructura "when" para comparar la variable posicionSP1 con cada caso posible
                when(posicionSP1){

                    "Bolivianos"->{
                                resultadoBoliviano.text = cantidad.text

                        totalDolar = cantidad.text.toString().toFloat() * 0.144
                        resultadoDolar.text = String.format("%.2f", totalDolar)

                        totalReal = cantidad.text.toString().toFloat() * 0.75
                        resultadoReal.text = String.format("%.2f", totalReal)

                        totalEuro = cantidad.text.toString().toFloat() * 0.14
                        resultadoEuro.text = String.format("%.2f", totalEuro)

                        totalSoles = cantidad.text.toString().toFloat() * 0.56
                        resultadoSoles.text = String.format("%.2f", totalSoles)

                        totalChile = cantidad.text.toString().toFloat() * 114.45
                        resultadoChile.text = String.format("%.2f", totalChile)

                        totalYen = cantidad.text.toString().toFloat() * 19.37
                        resultadoYen.text = String.format("%.2f", totalYen)

                        totalYuan = cantidad.text.toString().toFloat() * 0.99
                        resultadoYuan.text = String.format("%.2f", totalYuan)
                            }




                    "Dolares"-> {
                    resultadoDolar.text = cantidad.text

                    totalBolivianos = cantidad.text.toString().toFloat() * 6.96
                    resultadoBoliviano.text = totalBolivianos.toString()

                    totalReal = cantidad.text.toString().toFloat() * 4.43
                    resultadoReal.text = totalReal.toString()

                    totalEuro = cantidad.text.toString().toFloat() * 0.82
                    resultadoEuro.text = totalEuro.toString()

                    totalSoles = cantidad.text.toString().toFloat() * 3.29
                    resultadoSoles.text = totalSoles.toString()

                    totalChile = cantidad.text.toString().toFloat() * 672.44
                    resultadoChile.text = totalChile.toString()

                    totalYen = cantidad.text.toString().toFloat() * 113.41
                    resultadoYen.text = totalYen.toString()

                    totalYuan = cantidad.text.toString().toFloat() * 6.14
                    resultadoYuan.text = totalYuan.toString()

                    }

                    "Euros"-> {
                        resultadoEuro.text = cantidad.text

                        totalBolivianos = cantidad.text.toString().toFloat() * 7.29
                        resultadoBoliviano.text = String.format("%.2f", totalBolivianos)

                        totalReal = cantidad.text.toString().toFloat() * 5.36
                        resultadoReal.text = String.format("%.2f", totalReal)

                        totalDolar = cantidad.text.toString().toFloat() * 1.22
                        resultadoDolar.text = String.format("%.2f", totalDolar)

                        totalSoles = cantidad.text.toString().toFloat() * 3.98
                        resultadoSoles.text = String.format("%.2f", totalSoles)

                        totalChile = cantidad.text.toString().toFloat() * 817.26
                        resultadoChile.text = String.format("%.2f", totalChile)

                        totalYen = cantidad.text.toString().toFloat() * 137.85
                        resultadoYen.text = String.format("%.2f", totalYen)

                        totalYuan = cantidad.text.toString().toFloat() * 7.48
                        resultadoYuan.text = totalYuan.roundToInt().toString()


                    }

                    "Soles"-> {
                        resultadoSoles.text = cantidad.text

                        totalBolivianos = cantidad.text.toString().toFloat() * 1.78
                        resultadoBoliviano.text = String.format("%.2f", totalBolivianos)

                        totalReal = cantidad.text.toString().toFloat() * 1.34
                        resultadoReal.text = String.format("%.2f", totalReal)

                        totalDolar = cantidad.text.toString().toFloat() * 0.30
                        resultadoDolar.text = String.format("%.2f", totalDolar)

                        totalEuro = cantidad.text.toString().toFloat() * 0.25
                        resultadoEuro.text = String.format("%.2f", totalEuro)

                        totalChile = cantidad.text.toString().toFloat() * 204.34
                        resultadoChile.text = String.format("%.2f", totalChile)

                        totalYen = cantidad.text.toString().toFloat() * 34.52
                        resultadoYen.text = String.format("%.2f", totalYen)

                        totalYuan = cantidad.text.toString().toFloat() * 1.87
                        resultadoYuan.text = String.format("%.2f", totalYuan)


                    }

                    "Reales"-> {
                        resultadoReal.text = cantidad.text

                        totalBolivianos = cantidad.text.toString().toFloat() * 1.33
                        resultadoBoliviano.text = String.format("%.2f", totalBolivianos)

                        totalSoles = cantidad.text.toString().toFloat() * 0.75
                        resultadoSoles.text = String.format("%.2f", totalSoles)

                        totalDolar = cantidad.text.toString().toFloat() * 0.23
                        resultadoDolar.text = String.format("%.2f", totalDolar)

                        totalEuro = cantidad.text.toString().toFloat() * 0.19
                        resultadoEuro.text = String.format("%.2f", totalEuro)

                        totalChile = cantidad.text.toString().toFloat() * 152.39
                        resultadoChile.text = String.format("%.2f", totalChile)

                        totalYen = cantidad.text.toString().toFloat() * 25.76
                        resultadoYen.text = String.format("%.2f", totalYen)

                        totalYuan = cantidad.text.toString().toFloat() * 1.39
                        resultadoYuan.text = String.format("%.2f", totalYuan)


                    }

                    "Peso Chilenos"-> {
                        resultadoChile.text = cantidad.text

                        totalBolivianos = cantidad.text.toString().toFloat() * 0.0087
                        resultadoBoliviano.text = String.format("%.2f", totalBolivianos)

                        totalSoles = cantidad.text.toString().toFloat() * 0.0049
                        resultadoSoles.text = String.format("%.2f", totalSoles)

                        totalDolar = cantidad.text.toString().toFloat() * 0.0015
                        resultadoDolar.text = String.format("%.2f", totalDolar)

                        totalEuro = cantidad.text.toString().toFloat() * 0.0012
                        resultadoEuro.text = String.format("%.2f", totalEuro)

                        totalReal = cantidad.text.toString().toFloat() * 0.0066
                        resultadoReal.text = String.format("%.2f", totalReal)

                        totalYen = cantidad.text.toString().toFloat() * 0.17
                        resultadoYen.text = String.format("%.2f", totalYen)

                        totalYuan = cantidad.text.toString().toFloat() * 0.0093
                        resultadoYuan.text = String.format("%.2f", totalYuan)

                    }

                    "Yen Japones"-> {
                        resultadoYen.text = cantidad.text

                        totalBolivianos = cantidad.text.toString().toFloat() * 7.29
                        resultadoBoliviano.text = String.format("%.2f", totalBolivianos)

                        totalReal = cantidad.text.toString().toFloat() * 5.36
                        resultadoReal.text = String.format("%.2f", totalReal)

                        totalDolar = cantidad.text.toString().toFloat() * 1.22
                        resultadoDolar.text = String.format("%.2f", totalDolar)

                        totalSoles = cantidad.text.toString().toFloat() * 3.98
                        resultadoSoles.text = String.format("%.2f", totalSoles)

                        totalChile = cantidad.text.toString().toFloat() * 817.26
                        resultadoChile.text = String.format("%.2f", totalChile)

                        totalEuro = cantidad.text.toString().toFloat() * 137.85
                        resultadoEuro.text = String.format("%.2f", totalEuro)

                        totalYuan = cantidad.text.toString().toFloat() * 7.48
                        resultadoYuan.text = String.format("%.2f", totalYuan)

                    }

                    "Yuan China"-> {
                        resultadoYuan.text = cantidad.text

                        totalBolivianos = cantidad.text.toString().toFloat() * 1.01
                        resultadoBoliviano.text = "{:.2f}".format(totalBolivianos)

                        totalSoles = cantidad.text.toString().toFloat() * 0.52
                        resultadoSoles.text = "{:.2f}".format(totalSoles)

                        totalDolar = cantidad.text.toString().toFloat() * 0.16
                        resultadoDolar.text = "{:.2f}".format(totalDolar)

                        totalEuro = cantidad.text.toString().toFloat() * 0.13
                        resultadoEuro.text = "{:.2f}".format(totalEuro)

                        totalReal = cantidad.text.toString().toFloat() * 0.69
                        resultadoReal.text = "{:.2f}".format(totalReal)

                        totalChile = cantidad.text.toString().toFloat() * 105.7
                        resultadoChile.text = "{:.2f}".format(totalChile)

                        totalYen = cantidad.text.toString().toFloat() * 19.33
                        resultadoYen.text = "{:.2f}".format(totalYen)

                    }


                }

            }else{
                Toast.makeText(this@MainActivity,"Ingrese una cantidad!!",Toast.LENGTH_LONG)
                    .show()
            }
        }

        btnClear.setOnClickListener {
            cantidad.text.clear()
            resultadoBoliviano.text = ""
            resultadoChile.text = ""
            resultadoEuro.text = ""
            resultadoReal.text = ""
            resultadoSoles.text = ""
            resultadoYen.text = ""
            resultadoYuan.text = ""
            resultadoDolar.text = ""
        }
        btnFinish.setOnClickListener {
            finish()
        }


    }
}
