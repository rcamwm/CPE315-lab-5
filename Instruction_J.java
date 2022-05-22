/*
Cameron McGiffert 
CPE315 Section 1
Lab 5
 */

public class Instruction_J extends Instruction
{
    private int op;
    private int address;

    public Instruction_J(int op, int address)
    {
        this.op = op;
        this.address = address;
    }

    public boolean isBranchInstruction()
    {
        return false;
    }

    public int executeInstruction(int pc, int[] registers, int[] memory)
    {
        if (this.op == 3)
            jal(pc, registers);
        return this.address; // j
    }

    private void jal(int pc, int[] registers)
    {
        registers[Registers.registerTable.get("$ra")] = pc + 1;
    }

    public void printBinary()
    {
        System.out.print(String.format("%6s", Integer.toBinaryString(this.op)).replace(" ", "0") + " ");
        System.out.println(String.format("%26s", Integer.toBinaryString(this.address)).replace(" ", "0"));
    }

   
}