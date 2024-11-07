package edu.temple.funwithintents

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This view contains the text to share
        val editText = findViewById<EditText>(R.id.editTextText)

        // When the user clicks this button, share the text if not empty
        findViewById<ImageButton>(R.id.shareImageButton).setOnClickListener {
            val textToShare = editText.text.toString()

            if (textToShare.isNotEmpty()) {
                val shareIntent = Intent().apply {
                    //indicates that the intenets is for sharing data
                    action = Intent.ACTION_SEND
                    // Adds the text from editText as the content to be shared.
                    putExtra(Intent.EXTRA_TEXT, textToShare)
                    type = "text/plain"
                }
                //Opens a chooser dialog
                startActivity(Intent.createChooser(shareIntent, "Share text via"))
            }
        }
    }
}
