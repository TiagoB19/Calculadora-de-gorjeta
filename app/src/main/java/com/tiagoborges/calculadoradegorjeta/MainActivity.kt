package com.tiagoborges.calculadoradegorjeta

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar: SeekBar
    private lateinit var textViewValor: TextView
    private lateinit var textViewGorjeta: TextView
    private lateinit var textViewTotal: TextView
    private lateinit var textViewPorcentagem : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekBar)
        textViewValor = findViewById(R.id.txtValor)
        textViewGorjeta = findViewById(R.id.txtGorjeta)
        textViewTotal = findViewById(R.id.txtTotal)
        textViewPorcentagem = findViewById(R.id.txtPorcentagem)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewPorcentagem.text = "$progress % "
                var valor : Double? = textViewValor.text.toString().toDoubleOrNull()
                var total : Double
                if(valor != null){
                    total = valor
                    valor = valor * progress/100
                    textViewGorjeta.text = valor.toString()
                    total += valor
                    textViewTotal.text = total.toString()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
}
