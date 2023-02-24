package uz.gita.mytestproject.presentation.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mytestproject.R
import uz.gita.mytestproject.data.response.Offer
import uz.gita.mytestproject.databinding.FragmentMainBinding
import uz.gita.mytestproject.presentation.ui.adapter.ProductAdapter
import uz.gita.mytestproject.presentation.viewModel.MainViewModel
import uz.gita.mytestproject.presentation.viewModel.viewmodelImpl.MainViewModelImpl

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val adapter = ProductAdapter()
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getData()
        viewModel.newsLiveData.observe(viewLifecycleOwner,newsDataObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner,errorObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner,progressLiveDataObserver)
    }

    private val newsDataObserver = Observer<List<Offer>>{
         adapter.submitList(it)
    }
    private val errorObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }
    private val progressLiveDataObserver = Observer<Boolean>{
        if (it){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }

}