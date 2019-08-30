package com.example.ortalamamihesapla

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_yeni.view.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    val DERSLER=arrayOf("Fizik","Kimya","Biyoloji","Matematik","Algoritma")
    private var tum_dersler:ArrayList<Dersler> = ArrayList(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,DERSLER)
        autoCompleteTextView.setAdapter(adapter)

        if(rootLayout.childCount==0){
            btn_hesapla.visibility=View.INVISIBLE
        }else{
            btn_hesapla.visibility=View.VISIBLE
        }

        btn_ekle.setOnClickListener {
            if(!autoCompleteTextView.text.isNullOrEmpty()){
                var inflater = LayoutInflater.from(this)

                var yeni_ders_view = inflater.inflate(R.layout.activity_main_yeni, null)

                var ders_adi= autoCompleteTextView.text.toString()
                var ders_kredi=spinner_kredi.selectedItem.toString()
                var ders_harf=spinner_harf.selectedItem.toString()

                //Toast.makeText(this,"Lütfen ders adı giriniz.",Toast.LENGTH_LONG).show()

                yeni_ders_view.autoCompleteTextViewYeni.setText(ders_adi)
                yeni_ders_view.spinner_kredi_yeni.setSelection(spinnerIndexiBul(spinner_kredi,ders_kredi))
                yeni_ders_view.spinner_harf_yeni.setSelection(spinnerIndexiBul(spinner_harf,ders_harf))



                rootLayout.addView(yeni_ders_view)

                yeni_ders_view.btn_sil.setOnClickListener{
                    rootLayout.removeView(yeni_ders_view)
                    if(rootLayout.childCount==0){
                        btn_hesapla.visibility=View.INVISIBLE
                    }else{
                        btn_hesapla.visibility=View.VISIBLE
                    }
                }
                btn_hesapla.visibility=View.VISIBLE
                sifirla()

            }else{
               Toast.makeText(this,"Lütfen ders adı giriniz.",Toast.LENGTH_LONG).show()
            }


        }
    }
    fun OrtalamaHesapla(v : View){

        var toplam_not=0.0
        var toplam_kredi=0.0

        for(i in 0..rootLayout.childCount-1){
            var teksatir=rootLayout.getChildAt(i)


            var gecici_ders= Dersler(
                teksatir.autoCompleteTextViewYeni.text.toString(),
                ((teksatir.spinner_kredi_yeni.selectedItemPosition) + 0.5).toString(),
                teksatir.spinner_harf_yeni.selectedItem.toString()
            )
            tum_dersler.add(gecici_ders)

        }

        for(o_anki_ders in tum_dersler){
            toplam_not+=harfi_nota_cevir(o_anki_ders.ders_notu)*(o_anki_ders.ders_kredi.toDouble())
            toplam_kredi+=o_anki_ders.ders_kredi.toDouble()
        }
        var ortalamam=toplam_not/toplam_kredi
        var df = DecimalFormat("#.##")
        Toast.makeText(this,"Ortalama: "+ df.format(ortalamam),Toast.LENGTH_LONG).show()
    }

    fun spinnerIndexiBul(spinner: Spinner, aranacakDeger :String) : Int{
        var index=0
        for(i in 0..spinner.count){

            if(spinner.getItemAtPosition(i).toString().equals(aranacakDeger)) {
                index = i
                break
            }
        }
        return index
    }

    fun sifirla(){
        autoCompleteTextView.setText("")
        spinner_kredi.setSelection(0)
        spinner_harf.setSelection(0)
    }

    fun harfi_nota_cevir(gelen_not_degeri:String):Double{
        var deger=0.0

        when(gelen_not_degeri){
            "AA" -> deger = 4.0
            "BA" -> deger = 3.5
            "BB" -> deger = 3.0
            "CB" -> deger = 2.5
            "CC" -> deger = 2.0
            "DC" -> deger = 1.5
            "DD" -> deger = 1.0
            "FF" -> deger = 0.0
        }
        return deger
    }

}
