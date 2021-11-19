package cz.educanet.lights.out.data;

import com.google.gson.Gson;

import java.io.*;

public class Data {
    public void saveData(boolean[][] field) {
        try {
            Gson gson = new Gson();
            BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
            bw.write(gson.toJson(field));
            bw.close();
        } catch (IOException e) {}

    }

    public boolean[][] loadData() {
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));
            String f = br.readLine();
            br.close();
            return gson.fromJson(f, boolean[][].class);
        } catch (IOException e) {}
        return null;
    }
}
