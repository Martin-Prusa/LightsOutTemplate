package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.data.Data;
import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {
    private int movesCount;
    private boolean[][] field;
    private Data data;

    public Game(int size) {
        this.data = new Data();
        this.movesCount = 0;
        this.field = new boolean[size][size];
        Random random = new Random();
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                this.field[i][j] = random.nextBoolean();
            }
        }
    }

    @Override
    public int getMoveCount() {
        return movesCount;
    }

    @Override
    public boolean isGameOver() {
        for (boolean[] booleans : this.field) {
            for (boolean aBoolean : booleans) {
                if(aBoolean) return false;
            }
        }
        return true;
    }

    @Override
    public boolean[][] getGrid() {
        return this.field;
    }

    @Override
    public void makeMove(int x, int y) {
        this.field[x][y] = !this.field[x][y];
        for (int i = -1; i <= 1; i++) {
            if(i==0) continue;
            if(isInField(x,y+i)) this.field[x][y+i] = !this.field[x][y+i];
            if(isInField(x+i,y)) this.field[x+i][y] = !this.field[x+i][y];
        }


        this.movesCount++;
    }

    @Override
    public void saveGame() {
        this.data.saveData(this.field);
    }

    @Override
    public void loadGame() {
        boolean[][] loadedField = this.data.loadData();
        if(loadedField != null) this.field = loadedField;
    }

    private boolean isInField(int x, int y) {
        return x >= 0 && y >= 0 && y < this.field.length && x < this.field[0].length;
    }
}
