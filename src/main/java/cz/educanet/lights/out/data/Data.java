package cz.educanet.lights.out.data;

import com.google.gson.Gson;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Data {
    public void saveData(boolean[][] field) {
        try {
            FileChooser chooser = new FileChooser();
            File file = chooser.showSaveDialog(new Stage());
            Gson gson = new Gson();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(gson.toJson(field));
            bw.close();
        } catch (IOException e) {}

    }

    public boolean[][] loadData() {
        try {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(new Stage());
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String f = br.readLine();
            br.close();
            return gson.fromJson(f, boolean[][].class);
        } catch (IOException e) {}
        return null;
    }
}
