package ibm.com.workshop.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import ibm.com.workshop.R;

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    TextInputLayout lastNameLayout;
    RadioGroup radioGenderGroup;
    TextInputEditText firstName,lastName,email,password;
    RadioButton maleRadioButton, femaleRadioButton, radioGenderButton;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsWithActions(view);
    }

    private void initViewsWithActions(View view) {

        //Input Edit Text
        firstName = view.findViewById(R.id.first_name_text_input_edit_text);
        lastNameLayout = view.findViewById(R.id.last_name_text_input_layout);
        lastName = view.findViewById(R.id.last_name_text_input_edit_text);
        email = view.findViewById(R.id.email_text_input_edit_text);
        password = view.findViewById(R.id.password_text_input_edit_text);

        // Radio Buttons
        radioGenderGroup = view.findViewById(R.id.radio_group);
        maleRadioButton = view.findViewById(R.id.male_radio_button);
        femaleRadioButton = view.findViewById(R.id.female_radio_button);

        //Check Box
        CheckBox collectInfoCheckBox = view.findViewById(R.id.collect_info_check_box);
        boolean checkedValue = collectInfoCheckBox.isChecked();

        //Buttons
        Button hideButton = view.findViewById(R.id.hide_button);
        Button toastButton = view.findViewById(R.id.toast_button);
        Button submitButton = view.findViewById(R.id.submit_button);


        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideLastNameLayout();
            }
        });

        //Toast Button Action
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGenderGroup.getCheckedRadioButtonId() != -1)
                {
                    getValuesFromRadioButton();
                }
            }
        });

        //Submit Button Action
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToConfirmationScreen(view);
            }
        });

    }

    private void hideLastNameLayout() {
        lastNameLayout.setVisibility(View.GONE);
    }

    private void getValuesFromRadioButton() {
        // get selected radio button from radioGroup
        int selectedId = radioGenderGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioGenderButton = radioGenderGroup.findViewById(selectedId);
        showGenderToast();

    }

    private void showGenderToast() {
        Toast.makeText(getActivity(), "You selected " + radioGenderButton.getText(), Toast.LENGTH_SHORT).show();
    }

    private void goToConfirmationScreen(View view){
        NavDirections action=LoginFragmentDirections.actionNavigationLoginToNavigationConfirmation(firstName.getText().toString(),lastName.getText().toString());
        Navigation.findNavController(view).navigate(action);
    }
}