package com.example.gameez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.gameez.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    val question= arrayOf("Apa Yang Kamu Minum Jika Ingin Rilex?",
                          "Biasanya Jika Kedinginana Kamu Minum Apa?",
                          "Pagi Hari Biasanya Kamu Lebih Meminum?")

    var coffe_scor = 0
    var tea_scor   = 0
    var questres   = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Quizz Blow"

        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        binding.question.text=question[questres]

        binding.btnKopi.setOnClickListener {
            coffe_scor++
            nextQuestion(binding)
        }
        binding.btnTea.setOnClickListener {
            tea_scor++
            nextQuestion(binding)
        }
        return binding.root
    }

    fun nextQuestion(binding: FragmentGameBinding){
        questres++

        if (questres < question.size){
            binding.question.text =question[questres]
            Toast.makeText(context, "berhasil " + coffe_scor + " / tea " + tea_scor, Toast.LENGTH_SHORT).show()
        }else{
            var result = ""
            if (coffe_scor >= 1 && tea_scor >= 1 ){
                result = "Kamu suka dua duanya"
            }else if (coffe_scor < 1){
                result = "Kamu suka teh"
            }else {
                result = "Kamu suka kopi"
            }
            view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentToEndFragment(result))
        }
        }
    }
