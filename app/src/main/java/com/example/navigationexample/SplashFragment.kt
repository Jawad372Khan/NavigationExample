package com.example.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navigationexample.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private lateinit var binding : FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            withArgsFragmentBtn.setOnClickListener {
                val name = "Jawad"
                val counter = 14
                val action = SplashFragmentDirections.navigateToArgsFragment(name,counter)
                findNavController().navigate(action)

            }
            withoutArgsFragmentBtn.setOnClickListener {
                Navigation.findNavController(root).navigate(R.id.navigateToWithoutArgsFragment)
            }
            bundlesFragmentBtn.setOnClickListener {
                val bundle =
                    Bundle().apply {
                        putString("name","Jawad")
                        putInt("counter",14)
                    }
                Navigation.findNavController(root).navigate(R.id.navigateToBundleFragment,bundle)
            }

        }
    }
}