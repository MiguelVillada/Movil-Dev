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

       // listBogota = createMockBogota()
        listBogota = loadMockBogotaFromJson()
        bogotaAdapter = BogotaAdapter(listBogota)

       // bogotaRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        bogotaRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = bogotaAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockBogotaFromJson(): ArrayList<Bogota> {
        var bogotaString: String = applicationContext.assets.open("poibogota.json").bufferedReader().use { it.readText() }

    }

    private fun createMockBogota(): ArrayList<Bogota> {
        return arrayListOf(
            Bogota(
                nombre = "Monserrate",
                descripCorta = "El cerro de Monserrate es el más conocido de los cerros Orientales de Bogotá. Junto a Guadalupe es uno de los cerros tutelares de la ciudad.",
                puntuacion = "Puntuación: 4.5",
                urlpic = "https://monserrate.co/wp-content/uploads/2019/10/cerro-monserrate.jpg"
            ),
            Bogota(
                nombre = "Chorro de Quevedo",
                descripCorta = "Aquí comenzó todo: en la plazoleta del Chorro de Quevedo se cree que se fundó Bogotá el 6 de agosto de 1538.",
                puntuacion = "Puntuación: 4",
                urlpic = "https://www.sitiosturisticosbogota.com/wp-content/uploads/2018/11/chorro-de-quevedo.jpg"
            ),
            Bogota(
                nombre = "Plaza de Bolivar",
                descripCorta = "Ubicada en el centro de Bogotá, la Plaza de Bolívar es la principal plaza de la ciudad, siendo declarada como Monumento Nacional Colombiano.",
                puntuacion = "Puntuación: 4.8",
                urlpic = "https://www.utadeo.edu.co/sites/tadeo/files/node/news/field_images/portada.foto_.hanz_.rippe_.idpc_.plaza_.de_.bolivar_0.jpg"
            ),
            Bogota(
                nombre = "Parque Simón Bolívar",
                descripCorta = "El Parque Metropolitano Simón Bolívar es el parque urbano más grande e importante de la ciudad de Bogotá.",
                puntuacion = "Puntuación: 3.8",
                urlpic = "https://bogota.gov.co/sites/default/files/styles/1050px/public/field/image/simon-bolivar.jpg"
            )

        )
    }

    }
