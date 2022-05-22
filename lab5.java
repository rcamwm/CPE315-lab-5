/*
Cameron McGiffert 
CPE315 Section 1
Lab 5
 */

public class lab5 {
    public static void main(String[] args)
    {
        final boolean DEBUG = false;
        if (DEBUG)
        {
            String fileName = "lab4_fib20.asm";
            String script = "lab5.script";
            Instruction[] instructions = MipsAssembler.getInstructions(fileName);
            MipsDebugger debugger = new MipsDebugger(instructions, 2);
            debugger.run(script);
        }
        else
        {
            String fileName = args[0];
            Instruction[] instructions = MipsAssembler.getInstructions(fileName);
            int ghrSize = 2;
    
            if (args.length == 1)
            {
                MipsDebugger debugger = new MipsDebugger(instructions, ghrSize);
                debugger.run();
            }
            else
            {
                if (args.length == 3)
                    ghrSize = Integer.parseInt(args[2]);
                MipsDebugger debugger = new MipsDebugger(instructions, ghrSize);
                String script = args[1];
                debugger.run(script);
            }
        }
    }
}
