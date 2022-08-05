package kz.btokmyrza.cryptomarket.presentation.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.FragmentLoginBinding
import kz.btokmyrza.cryptomarket.util.Constants.CURRENT_USER
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val loginViewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        loginViewModel.successful.observe(viewLifecycleOwner) { successful ->
            if (successful) {
                Toast.makeText(requireContext(), "Login was successful!", Toast.LENGTH_SHORT)
                    .show()
                findNavController().navigate(R.id.action_loginFragment_to_tabsFragment)
            } else {
                Snackbar.make(
                    binding.root,
                    "Wrong credentials!",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.tilEmail.editText?.text.toString()
            val password = binding.tilPassword.editText?.text.toString()

            if (email.isBlank() || password.isBlank()) {
                Snackbar.make(
                    binding.root,
                    "Some of the fields are empty!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            val editor = requireContext().getSharedPreferences(
                CURRENT_USER,
                AppCompatActivity.MODE_PRIVATE
            ).edit()
            editor.putString("email", email)
            editor.apply()

            viewLifecycleOwner.lifecycleScope.launch {
                loginViewModel.login(email, password)
            }
        }

        return binding.root
    }

}