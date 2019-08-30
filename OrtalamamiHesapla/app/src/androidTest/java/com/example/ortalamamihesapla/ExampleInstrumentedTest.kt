package com.example.ortalamamihesapla

import android.support.test.InstrumentationRegistry
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.Spinner

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@MediumTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    var rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.ortalamamihesapla", appContext.packageName)
    }

    @Test
    fun testSpinner(){
        var credit="1.5 Kredi"
        var credit_value=3.0
        var delta=0.1

        var activity:MainActivity=rule.activity
        val spinner_for_credit= activity.findViewById<Spinner>(R.id.spinner_kredi)
        assertNotNull(spinner_for_credit)
        /*spinner_for_credit.performClick()
        val obj_for_credit=MainActivity()
        var output_for_credit=obj_for_credit.spinnerIndexiBul(spinner_for_credit ,credit) as Double

        assertEquals(credit_value,output_for_credit,delta)*/
    }
}
