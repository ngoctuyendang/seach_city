package com.example.search_city
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var adapter: Adapter? = null
    private var moviewList: Array<String>? = null
    internal var textlength = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviewList = arrayOf(
            "Ben Tre",
            "Tra Vinh",
            "My Tho",
            "Da Nang",
            "Bao Loc",
            "Bac Kan",
            "Binh Duong",
            "Tam Ky",
            "Thai Binh",
            "Ha Tien",
            "Hue",
            "Kon Tum",
            "Lao Cai",
            "Long Xuyen",
            "Nha Trang",
            "Dong Thap",
            "Son La",
            "Vinh",
            "Vinh Long",
            "Vung Tau"

        )
        movieNamesArrayList = populateList()
        adapter = Adapter(this, movieNamesArrayList)
        rvCity.adapter = adapter
        rvCity.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        array_sort = populateList()
        search(edtSearch)

    }

    private fun populateList(): ArrayList<City> {

        val list = ArrayList<City>()

        for (element in moviewList!!) {
            val imageModel = City()
            imageModel.setCity(element)
            list.add(imageModel)
        }

        return list
    }
    fun search (edtSearch: EditText){
        edtSearch.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textlength = edtSearch.text.length
                array_sort.clear()
                for( i in movieNamesArrayList.indices){
                    if( textlength<= movieNamesArrayList[i].getCity().length){
                        if(movieNamesArrayList[i].getCity().toLowerCase().trim().contains(
                                edtSearch.text.toString().toLowerCase().trim(){
                                    it<=' '})
                        ){
                            array_sort.add(movieNamesArrayList[i])
                        }
                    }
                }
                adapter = Adapter(this@MainActivity, array_sort)
                rvCity.adapter = adapter
                rvCity!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            }

        })
    }

    companion object {
        lateinit var movieNamesArrayList: ArrayList<City>
        lateinit var array_sort: ArrayList<City>
    }
}