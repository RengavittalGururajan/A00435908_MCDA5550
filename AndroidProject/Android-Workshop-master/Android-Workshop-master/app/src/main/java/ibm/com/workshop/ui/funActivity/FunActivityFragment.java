package ibm.com.workshop.ui.funActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import ibm.com.workshop.R;
import ibm.com.workshop.ui.login.LoginFragmentDirections;

public class FunActivityFragment extends Fragment {

    private FunActivityViewModel funActivityViewModel;
    private static  final String TAG="FunActivityFragment";
    private TextView DisplayDate;
    private DatePickerDialog.OnDateSetListener DateSetListener;
    TextInputLayout lastNameLayout;
    RadioGroup radioGenderGroup;
    TextInputEditText firstName,lastName,email,password;
    RadioButton maleRadioButton, femaleRadioButton, radioGenderButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        funActivityViewModel =
                ViewModelProviders.of(this).get(FunActivityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fun, container, false);

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
        Button submitButton = view.findViewById(R.id.submit_button);

        //TextView of Date
        DisplayDate = view.findViewById(R.id.date_text_input_edit_text);
        //Date Click Action
        DisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        getActivity(),android.R.style.Theme_Holo_Light_Dialog_MinWidth,DateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        DateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                String date = month + "/" + dayOfMonth + "/" + year;
                DisplayDate.setText(date);
            }
        };

        //Submit Button Action
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToConfirmationScreen(view);
            }
        });

    }

    private void goToConfirmationScreen(View view){
        NavDirections action= FunActivityFragmentDirections.actionNavigationFunActivityToNavigationConfirmation(firstName.getText().toString(),lastName.getText().toString());
        Navigation.findNavController(view).navigate(action);
    }
}