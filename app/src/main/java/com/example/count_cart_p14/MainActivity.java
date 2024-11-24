package com.example.count_cart_p14;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1; // Variabel untuk menyimpan jumlah produk
    private TextView tvQuantity; // TextView untuk menampilkan jumlah

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Mengatur padding untuk elemen tata letak
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi elemen UI
        tvQuantity = findViewById(R.id.tv_quantity);
        Button btnUp = findViewById(R.id.btn_up);
        Button btnDown = findViewById(R.id.btn_down);
        Button btnAddToCart = findViewById(R.id.btn_add_to_cart);

        // Logika tombol UP untuk menambah jumlah produk
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                tvQuantity.setText(String.valueOf(quantity)); // Perbarui jumlah pada TextView
            }
        });

        // Logika tombol DOWN untuk mengurangi jumlah produk
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) {
                    quantity--;
                    tvQuantity.setText(String.valueOf(quantity)); // Perbarui jumlah pada TextView
                } else {
                    Toast.makeText(MainActivity.this, "Jumlah minimal adalah 1", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Logika tombol Add to Cart untuk menyimpan jumlah produk
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Produk berhasil ditambahkan ke keranjang: " + quantity;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                // Tambahkan logika tambahan di sini jika ingin menyimpan jumlah ke database atau lainnya
            }
        });
    }
}
