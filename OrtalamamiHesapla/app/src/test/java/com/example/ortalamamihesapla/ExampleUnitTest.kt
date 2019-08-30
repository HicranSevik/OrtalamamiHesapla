package com.example.ortalamamihesapla

import android.app.Activity
//import android.support.test.rule.ActivityTestRule
//import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.widget.Spinner
import org.junit.Test
import com.example.ortalamamihesapla.MainActivity
import com.example.ortalamamihesapla.R.id.spinner_kredi
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.Rule
import org.mockito.Mockito
import java.lang.Exception

//@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    //@Rule
    //var rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkSpinnerCredit(){
        var credit="1.5 Kredi"
        var credit_value=3.0
        var delta=0.1

        //var activity:MainActivity=rule.activity
        //val spinner_for_credit= activity.findViewById<Spinner>(R.id.spinner_kredi)
        var spinner_for_credit= spinner_kredi as Spinner
        assertNotNull(spinner_for_credit)
        spinner_for_credit.performClick()

        val obj_for_credit=MainActivity()
        var output_for_credit=obj_for_credit.spinnerIndexiBul(spinner_for_credit ,credit) as Double
        assertEquals(credit_value,output_for_credit,delta)
    }

    @Test
    fun aaExamScore(){
        var deger="AA"
        var sayisal_deger=4.0
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }

    @Test
    fun baExamScore(){
        var deger="BA"
        var sayisal_deger=3.5
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }

    @Test
    fun examScore(){
        var deger="BB"
        var sayisal_deger=3.0
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }

    @Test
    fun cdExamScore(){
        var deger="CB"
        var sayisal_deger=2.5
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }

    @Test
    fun ccExamScore(){
        var deger="CC"
        var sayisal_deger=2.0
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }

    @Test
    fun dcExamScore(){
        var deger="DC"
        var sayisal_deger=1.5
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }

    @Test
    fun ddExamScore(){
        var deger="DD"
        var sayisal_deger=1.0
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }

    @Test
    fun ffExamScore(){
        var deger="FF"
        var sayisal_deger=0.0
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }
    @Test
    fun hhExamScore(){
        var deger="HH"
        var sayisal_deger=0.0
        var delta=0.1

        val obj=MainActivity()
        var output=obj.harfi_nota_cevir(deger)
        assertEquals(sayisal_deger,output,delta)
    }

}
