package com.example.fantasypuzzlegame.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleAdapter extends BaseAdapter {
    private Context mContext;
    private List<Bitmap> puzzlePieces; // Use a list of Bitmaps for the image pieces

    // Constructor
    public PuzzleAdapter(Context c, List<Bitmap> puzzlePieces) {
        mContext = c;
        this.puzzlePieces = puzzlePieces;
    }

    @Override
    public int getCount() {
        return puzzlePieces.size(); // Size of the list
    }

    @Override
    public Object getItem(int position) {
        return puzzlePieces.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    parent.getHeight() / 4)); // Adjust height to be 1/4 of GridView height for square cells
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(puzzlePieces.get(position));
        return imageView;
    }

    // ... (other parts of your FatherActivity)

    // Method to split the image into pieces
    private List<Bitmap> splitImage(Bitmap image, int rows, int cols) {
        List<Bitmap> pieces = new ArrayList<>(rows * cols);

        int pieceWidth = image.getWidth() / cols;
        int pieceHeight = image.getHeight() / rows;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                int xCoord = x * pieceWidth;
                int yCoord = y * pieceHeight;
                pieces.add(Bitmap.createBitmap(image, xCoord, yCoord, pieceWidth, pieceHeight));
            }
        }
        return pieces;
    }


}





//package com.example.fantasypuzzlegame.activities;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.GridView;
//
//public class PuzzleAdapter extends BaseAdapter {
//    private Context mContext;
//    private Integer[] puzzlePieces; // Array to hold the puzzle pieces
//
//    // Constructor
//    public PuzzleAdapter(Context c, Integer[] puzzlePieces) {
//        mContext = c;
//        this.puzzlePieces = puzzlePieces;
//    }
//
//    @Override
//    public int getCount() {
//        return 16; // For a 4x4 grid
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null; // Can be customized based on your puzzle logic
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0; // Can be customized based on your puzzle logic
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Button button;
//        if (convertView == null) {
//            // Initialize a new Button for each item
//            button = new Button(mContext);
//            button.setLayoutParams(new GridView.LayoutParams(85, 85));
//            button.setPadding(8, 8, 8, 8);
//        } else {
//            button = (Button) convertView;
//        }
//
//        button.setText(String.valueOf(puzzlePieces[position])); // Set the number/text for each puzzle piece
//        // Additional customization for the button can be done here
//
//        return button;
//    }
//}
