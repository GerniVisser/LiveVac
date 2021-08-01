package com.livevac.ui.herd

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.livevac.data.animals.Animal
import com.livevac.data.animals.AnimalViewModel
import com.livevac.databinding.FragmentAddLivestockBinding

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class AddLivestockFragment : Fragment() {
/*
    private val hideHandler = Handler()
*/

    private lateinit var dataAnimalViewModel: AnimalViewModel

   /* FULLSCREEN DELETION
    @Suppress("InlinedApi")
    private val hidePart2Runnable = Runnable {
        // Delayed removal of status and navigation bar

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        val flags =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        activity?.window?.decorView?.systemUiVisibility = flags
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
    }
    private val showPart2Runnable = Runnable {
        // Delayed display of UI elements
        fullscreenContentControls?.visibility = View.VISIBLE
    }
    private var visible: Boolean = false
    private val hideRunnable = Runnable { hide() }

    *//**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     *//*
    private val delayHideTouchListener = View.OnTouchListener { _, _ ->
        if (AUTO_HIDE) {
            delayedHide(AUTO_HIDE_DELAY_MILLIS)
        }
        false
    }

    *//*
    private var dummyButton: Button? = null
     *//*
    private var fullscreenContent: View? = null
    private var fullscreenContentControls: View? = null*/

    private var _binding: FragmentAddLivestockBinding? = null
    private var name : EditText? =null
    private var herd : EditText? =null
    private var type : EditText? = null
    private var breed : EditText? = null
    private var sex : EditText? = null
    private var dob : EditText? = null
    private var saveButton : Button? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private fun insertAnimal(){
        Log.d("Testing","insertAnimal Running")
        herd = binding.edxHerd
        name = binding.edxName
        type = binding.spnType
        breed = binding.spnBreed
        sex = binding.spnSex
        dob = binding.dteDob
        val names = name!!.text.toString()
        Log.d("Testing", name.toString())
        Log.d("Testing", name!!.text.toString())


        if(validateInput(herd!!,name,type,breed,sex,dob)){
            Log.d("Testing", "passed Val")
            val animal = Animal(0,herd!!.text.toString().toInt(),name!!.text.toString(),type!!.text.toString(),breed.toString(),sex!!.text.toString(),dob!!.text.toString().toLong())
            Log.d("Testing", "passed Insert")
            dataAnimalViewModel.addAnimal(animal)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

        }else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG)
                .show()
        }

    }
    private fun validateInput(
        herd: EditText,
        name: EditText?,
        type: EditText?,
        breed: EditText?,
        gender: EditText?,
        dob: EditText?
    ): Boolean{
        val vHerd: Editable? = herd.text
        val vDOB: Editable? = dob?.text

        Log.d("Testing", vHerd.toString())
        Log.d("Testing",vDOB.toString())

        return !(TextUtils.isEmpty(herd.text)&& TextUtils.isEmpty(name?.text) && TextUtils.isEmpty(type?.text) &&
            TextUtils.isEmpty(breed?.text) && TextUtils.isEmpty(gender?.text) && TextUtils.isEmpty(dob?.text))
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentAddLivestockBinding.inflate(inflater, container, false)


        dataAnimalViewModel= ViewModelProvider(this).get(AnimalViewModel::class.java)

        Log.d("Testing","Oncreateview works")
        saveButton = binding.btnSaveLivestock
        saveButton?.setOnClickListener {
            Log.d("Testing","Save Button works")
            insertAnimal()

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Testing","OnViewCreated works")
        /*   FULLSCREEN DELETION
        visible = true*/

        name = binding.edxName
        herd = binding.edxHerd
        type = binding.spnType
        breed = binding.spnBreed
        sex = binding.spnSex
        dob = binding.dteDob

        /*

        fullscreenContent = binding.fullscreenContent
        fullscreenContentControls = binding.fullscreenContentControls
        */
        // Set up the user interaction to manually show or hide the system UI.
       /*   FULLSCREEN DELETION
       fullscreenContent?.setOnClickListener { toggle() }*/

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.

       /*  FULLSCREEN DELETION
       saveButton?.setOnTouchListener(delayHideTouchListener)*/

    }

    override fun onResume() {
        super.onResume()
        /*   FULLSCREEN DELETION
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100)*/
        Log.d("Testing","onResume works")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Testing","OnPause works")
        /*  FULLSCREEN DELETION
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // Clear the systemUiVisibility flag
        activity?.window?.decorView?.systemUiVisibility = 0
        show()*/
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Testing","onPause works")
        /*
        dummyButton = null
        fullscreenContent = null
        fullscreenContentControls = null
        */
        saveButton = null
        name = null
        herd = null
        type = null
        breed = null
        sex = null
        dob = null
    }

   /*   FULLSCREEN DELETION
   private fun toggle() {
        if (visible) {
            hide()
        } else {
            show()
        }
    }*/

    /*   FULLSCREEN DELETION
    private fun hide() {
        // Hide UI first
        fullscreenContentControls?.visibility = View.GONE
        visible = false

        // Schedule a runnable to remove the status and navigation bar after a delay
        hideHandler.removeCallbacks(showPart2Runnable)
        hideHandler.postDelayed(hidePart2Runnable, UI_ANIMATION_DELAY.toLong())
    }*/

    /*    FULLSCREEN DELETION
    @Suppress("InlinedApi")
    private fun show() {
        // Show the system bar
        fullscreenContent?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        visible = true

        // Schedule a runnable to display UI elements after a delay
        hideHandler.removeCallbacks(hidePart2Runnable)
        hideHandler.postDelayed(showPart2Runnable, UI_ANIMATION_DELAY.toLong())
        (activity as? AppCompatActivity)?.supportActionBar?.show()
    }

    *//**
     * Schedules a call to hide() in [delayMillis], canceling any
     * previously scheduled calls.
     *//*
    private fun delayedHide(delayMillis: Int) {
        hideHandler.removeCallbacks(hideRunnable)
        hideHandler.postDelayed(hideRunnable, delayMillis.toLong())
    }*/

    companion object {

        /**
         * Whether or not the system UI should be auto-hidden after
         * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
         */
        private const val AUTO_HIDE = true

        /**
         * If [AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        //private const val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        //private const val UI_ANIMATION_DELAY = 300
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("Testing","OnDestroy View works")
    }
}