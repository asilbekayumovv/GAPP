package uz.itschool.myapplication11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SecondActivity : AppCompatActivity() {

    private lateinit var img: ImageView
    private lateinit var btnBack: ImageView
    private lateinit var btnForward: ImageView

    private var index = 0

    private var list: MutableList<Int> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Views()
        List()

        index = intent.getIntExtra("picture", 3)

        for (i in 0 until list.size) {
            if (index == i) {
                img.setImageResource(list[i])
            }
        }

        btnBack.setOnClickListener {
            if (index == 0)
                index = list.size
            index--
            img.setImageResource(list[index])
        }

        btnForward.setOnClickListener {
            if (index < list.size - 1) {
                index++
            } else {
                index = 0
            }
            img.setImageResource(list[index])
        }


    }

    private fun Views() {
        img = findViewById(R.id.extended)
        btnBack = findViewById(R.id.back)
        btnForward = findViewById(R.id.forward)
    }

    private fun List() {
        list.add(R.drawable.`img1.png`)
        list.add(R.drawable.img2)
        list.add(R.drawable.img3)
        list.add(R.drawable.img4)
        list.add(R.drawable.img5)
        list.add(R.drawable.img6)
    }
}