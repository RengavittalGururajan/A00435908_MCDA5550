package ibm.com.workshop.ui.login.confirmationScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ibm.com.workshop.R;

public class ConfirmationScreenFragment extends Fragment {

    String firstName;
    String lastName;

    private List<FoodsModel> foodList = new ArrayList<>();
    private RecyclerViewVerticalListAdapter foodsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.confirmation_screen, container, false);
        firstName = ConfirmationScreenFragmentArgs.fromBundle(getArguments()).getFirstName();
        lastName = ConfirmationScreenFragmentArgs.fromBundle(getArguments()).getLastName();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateHeader(view);
        populateRecyclerView(view);
    }

    public void populateHeader(View view){
        TextView headerTextView = view.findViewById(R.id.confirmation_text_view);
        headerTextView.setText("Welcome " + firstName  + " " + lastName + ", following is the list of food items linked to your account");
    }

    public void populateRecyclerView(View view){
        RecyclerView foodsRecyclerView = view.findViewById(R.id.foods_recyclerview);

        //Define the layout manager and Adapter
        foodsAdapter = new RecyclerViewVerticalListAdapter(foodList, getActivity());
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        //add a divider Line after each item
        foodsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));

        //Set the layout Manager and Adapter
        foodsRecyclerView.setAdapter(foodsAdapter);
        foodsRecyclerView.setLayoutManager(verticalLayoutManager);

        //populate the list to be passed to the adapter
        populatefoodList();
    }

    public void populatefoodList(){
        FoodsModel food1= new FoodsModel(R.drawable.paneertikka, "Paneer Tikka");
        FoodsModel food2= new FoodsModel(R.drawable.samosas, "Samosas");
        FoodsModel food3= new FoodsModel(R.drawable.aloogobi, "Aloo Gobi");
        FoodsModel food4= new FoodsModel(R.drawable.naan, "Naan");
        FoodsModel food5= new FoodsModel(R.drawable.mattarpaneer, "Matar Paneer");
        FoodsModel food6= new FoodsModel(R.drawable.channaaloocurry, "Channa Aloo Curry");
        FoodsModel food7= new FoodsModel(R.drawable.malaikofta, "Malai Kofta");
        FoodsModel food8= new FoodsModel(R.drawable.palakpaneer, "Palak Paneer");
        FoodsModel food9= new FoodsModel(R.drawable.papdichat, "Papdi Chat");
        FoodsModel food10= new FoodsModel(R.drawable.tomatosoup, "Tomato Soup");
        FoodsModel food11= new FoodsModel(R.drawable.masalachai, "Masala Chai");

        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);
        foodList.add(food6);
        foodList.add(food7);
        foodList.add(food8);
        foodList.add(food9);
        foodList.add(food10);
        foodList.add(food11);
    }
}
