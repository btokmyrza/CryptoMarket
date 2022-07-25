package kz.btokmyrza.cryptomarket.presentation.auth.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.databinding.FragmentSignUpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val signUpViewModel by viewModel<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        signUpViewModel.successful.observe(viewLifecycleOwner) { successful ->
            if (successful) {
                Toast.makeText(requireContext(), "Sign Up was successful!", Toast.LENGTH_LONG)
                    .show()
                findNavController().popBackStack()
            } else {
                Snackbar.make(
                    binding.root,
                    "User with this email already exists!",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        binding.btnSignUp.setOnClickListener {
            val name = binding.tilName.editText?.text.toString()
            val email = binding.tilEmail.editText?.text.toString()
            val password = binding.tilPassword.editText?.text.toString()
            val passwordConfirmation = binding.tilPasswordConfirmation.editText?.text.toString()

            if (name.isBlank() || email.isBlank() || password.isBlank() || passwordConfirmation.isBlank()) {
                Snackbar.make(
                    binding.root,
                    "Some of the fields are empty!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            if (password != passwordConfirmation) {
                Snackbar.make(
                    binding.root,
                    "Passwords do not match!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            viewLifecycleOwner.lifecycleScope.launch {
                signUpViewModel.signUp(name, email, password)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}