/*
Cameron McGiffert 
CPE315 Section 1
Lab 5
 */

import java.lang.Math;
import java.util.Arrays;

public class Predictor 
{
    private int bits;
    private int globalHistoryRegister;
    private int[] twoBitPredictorTable;

    private int correctPredictions;
    private int totalPredictions;

    public Predictor(int ghrSize)
    {
        this.bits = ghrSize;
        this.globalHistoryRegister = 0;
        this.twoBitPredictorTable = new int[(int)Math.pow(2, ghrSize)];
        Arrays.fill(this.twoBitPredictorTable, 0);

        this.correctPredictions = 0;
        this.totalPredictions = 0;
    }

    public void prediction(boolean wasBranchTaken)
    {
        boolean willTakeBranch = this.twoBitPredictorTable[this.globalHistoryRegister] > 1;
        if (willTakeBranch == wasBranchTaken)
            this.correctPredictions++;
        incrementPredictorTable(wasBranchTaken);
        incrementGhr(wasBranchTaken);
        this.totalPredictions++;
    }

    private void incrementPredictorTable(boolean wasBranchTaken)
    {
        int predictor = this.twoBitPredictorTable[this.globalHistoryRegister];
        if (wasBranchTaken)
            this.twoBitPredictorTable[this.globalHistoryRegister] = (predictor == 3) ? 3 : predictor + 1;
        else
            this.twoBitPredictorTable[this.globalHistoryRegister] = (predictor == 0) ? 0 : predictor - 1;
    }

    private void incrementGhr(boolean wasBranchTaken)
    {
        this.globalHistoryRegister <<= 1;
        this.globalHistoryRegister = (this.globalHistoryRegister & ~(1 << this.bits));
        if (wasBranchTaken)
            this.globalHistoryRegister++;
    }

    public void printResults()
    {
        double accuracy = (double)this.correctPredictions / (double)this.totalPredictions;
        System.out.print("\naccuracy ");
        System.out.print(String.format("%.2f", accuracy * 100) + "% ");
        System.out.print("(" + this.correctPredictions + " correct predictions, ");
        System.out.println(this.totalPredictions + " predictions) \n");
    }
}
