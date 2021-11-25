package com.example.movildevappturismo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListBogotaActivity : AppCompatActivity() {

    private lateinit var listBogota: ArrayList<Bogota>
    private lateinit var bogotaAdapter: BogotaAdapter
    private lateinit var bogotaRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_bogota)

        bogotaRecyclerView = findViewById(R.id.bogota_recycler_view)

        listBogota = createMockBogota()

        bogotaAdapter = BogotaAdapter(listBogota)

       // bogotaRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        bogotaRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = bogotaAdapter
            setHasFixedSize(false)
        }
    }

    private fun createMockBogota(): ArrayList<Bogota> {
        return arrayListOf(
            Bogota(
                nombre = "Monserrate",
                descripCorta = "El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad.",
                puntuacion = "Puntuación: 4.5",
                foto = 1
            ),
            Bogota(
                nombre = "Chorro de Quevedo",
                descripCorta = "Aquí comenzó todo: en la plazoleta del Chorro de Quevedo se cree que se fundó Bogotá el 6 de agosto de 1538.",
                puntuacion = "Puntuación: 4",
                foto = 1
            ),
            Bogota(
                nombre = "Plaza de Bolivar",
                descripCorta = "Ubicada en el centro de Bogotá, la Plaza de Bolívar es la principal plaza de la ciudad, siendo declarada como Monumento Nacional Colombiano.",
                puntuacion = "Puntuación: 4.8",
                foto = 1
            ),
            Bogota(
                nombre = "Parque Simón Bolívar",
                descripCorta = "El Parque Metropolitano Simón Bolívar es el parque urbano más grande e importante de la ciudad de Bogotá.",
                puntuacion = "Puntuación: 3.8",
                foto = 1
            )

        )
    }

    }
