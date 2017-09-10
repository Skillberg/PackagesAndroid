package com.test.packages;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Activity для выбора APK-файла
 */
public class FilePickerActivity extends AppCompatActivity {

    private static final String TAG = "FilePickerActivity";

    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_file_picker);

        initFileManager();
    }

    /**
     * Этот метод будет вызван, когда пользователь предоставит разрешения, или откажет в них
     *
     * @param requestCode  Код, который мы передали при запросе
     * @param permissions  Список разрешений
     * @param grantResults Список результатов
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "Permission granted!");

                initFileManager();
            } else {
                Log.i(TAG, "Permission denied");

                requestPermissions(); // Запрашиваем ещё раз
            }
        }
    }

    /**
     * Запрашиваем разрешение
     */
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE
        );
    }

    /**
     * Инициализируем менеджер файлов, проверяем разрешение
     */
    private void initFileManager() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            // Разрешение предоставлено
        } else {
            requestPermissions();
        }
    }
}
