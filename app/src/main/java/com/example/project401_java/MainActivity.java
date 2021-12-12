package com.example.project401_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Category;
import com.amplifyframework.datastore.generated.model.User;

public class MainActivity extends AppCompatActivity {
Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        logOut = findViewById(R.id.logoutuser);

        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());
            Log.i("MyAmplifyApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }
        Amplify.Auth.fetchAuthSession(
                result -> Log.i("AmplifyQuickstart", result.toString()),
                error -> Log.e("AmplifyQuickstart", error.toString())
        );







//
//
//        Category c1 = Category.builder()
//                .name("electric")
//                .build();
//
//        Amplify.API.mutate(ModelMutation.create(c1),
//                response -> Log.i("MyAmplifyApp", "Todo with id: " + response.getData().getId()),
//                error -> Log.e("MyAmplifyApp", "Create failed", error)
//        );
//
//        Category c2 = Category.builder()
//                .name("street")
//                .build();
//
//        Amplify.API.mutate(ModelMutation.create(c2),
//                response -> Log.i("MyAmplifyApp", "Todo with id: " + response.getData().getId()),
//                error -> Log.e("MyAmplifyApp", "Create failed", error)
//        );
//        Category c3 = Category.builder()
//                .name("water")
//                .build();
//
//        Amplify.API.mutate(ModelMutation.create(c3),
//                response -> Log.i("MyAmplifyApp", "Todo with id: " + response.getData().getId()),
//                error -> Log.e("MyAmplifyApp", "Create failed", error)
//        );
//        Category c4 = Category.builder()
//                .name("others")
//                .build();
//
//        Amplify.API.mutate(ModelMutation.create(c4),
//                response -> Log.i("MyAmplifyApp", "Todo with id: " + response.getData().getId()),
//                error -> Log.e("MyAmplifyApp", "Create failed", error)
//        );


//        logOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Amplify.Auth.signOut(
//                        AuthSignOutOptions.builder().globalSignOut(true).build(),
//                        () -> Log.i("AuthQuickstart", "Signed out globally"),
//                        error -> Log.e("AuthQuickstart", error.toString())
//                );
//            }
//        });
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class);
               startActivity(intent);
            }
        });
//        Button category = (Button) findViewById(R.id.category);
//        category.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Category.class);
//                startActivity(intent);
//            }
//        });
        Button city = (Button) findViewById(R.id.city);
        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,City.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my:
                Intent setting = new Intent(MainActivity.this, Profile.class);
                startActivity(setting);
                return true;
            case R.id.logoutmenu:
                Amplify.Auth.signOut(
                        AuthSignOutOptions.builder().globalSignOut(true).build(),
                        () -> Log.i("AuthQuickstart", "Signed out globally"),
                        error -> Log.e("AuthQuickstart", error.toString())
                );
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}